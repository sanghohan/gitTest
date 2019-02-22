package com.study;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by one1000078 on 2019. 2. 22..
 */
public class AsyncFileChannelTest {

    public void asyncFileChannel(Path sourceFilePath, boolean isWrite) throws IOException {

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        try {

            System.err.println("AsynchronousFileChannel 테스트 시작");
            AsynchronousFileChannel asyncFileChannel = AsynchronousFileChannel.open(sourceFilePath,
                    EnumSet.of(StandardOpenOption.READ), executorService);


            long startTime = System.currentTimeMillis();
            long fileSize = asyncFileChannel.size();

            // ByteBuffer 크기를 64로 축소
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(16 * 4096);

            // 반복 회수 관리용 변수
            Long iterations = 0L;
            System.err.println("AsynchronousFileChannel.read() 호출");

            asyncFileChannel.read(
                    byteBuffer, 0, iterations,    // null 대신 iterations 전달
                    new CompletionHandler<Integer, Long>() {    // 타입 파라미터에 Object 대신 Long 전달

                        @Override
                        public void completed(Integer result, Long iterations) {    // 타입 파라미터에 Object 대신 Long
                            if (result == -1) {
                                long endTime = System.currentTimeMillis();
                                System.err.println("비정상 종료 : " + (endTime - startTime) / 1000.0 + " ns elapsed.");

                                //// asyncFileChannel 닫기
                                closeAsyncFileChannel(asyncFileChannel);
                                executorService.shutdown();

                                return;
                            }

                            // 반복 회수 확인
                            System.err.println((iterations + 1) + "회차 반복");

                            byteBuffer.flip();
                            byteBuffer.mark();
                            if (isWrite) System.out.write(byteBuffer.array(), 0, result);
                            byteBuffer.reset();

                            // 읽어들인 바이트수가
                            // 파일사이즈와 같거나(버퍼 크기와 파일 크기가 같은 경우)
                            // 버퍼 사이즈보다 작다면 파일의 끝까지 읽은 것이므로 종료 처리
                            if (result == fileSize || result < byteBuffer.capacity()) {
                                long endTime = System.nanoTime();
                                System.err.println("AsynchronousFileChannel.read() 완료 : " + (endTime - startTime) / 1000.0 + " ns elapsed.");

                                //// asyncFileChannel 닫기
                                closeAsyncFileChannel(asyncFileChannel);
                                executorService.shutdown();

                                return;
                            }
                            // 읽을 내용이 남아있으므로 반복 회수를 증가 시키고 다시 읽는다.
                            iterations++;
                            asyncFileChannel.read(byteBuffer, result * iterations, iterations, this);
                        }

                        @Override
                        public void failed(Throwable exc, Long iterations) {    // 타입 파라미터에 Object 대신 Long
                            exc.printStackTrace();

                            //// asyncFileChannel 닫기
                            closeAsyncFileChannel(asyncFileChannel);

                            executorService.shutdown();
                        }
                    }
            );

            System.err.println("AsyncFileChannel I/O 진행 중에는 다른 작업도 할 수 있지롱");
            System.err.println("그동안 그리스에도 다녀오고");
            System.err.println("크로아티아에도 갔다오자");

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);    //// 상황에 맞는 예외 처리 필요
        }

    }

    //// asyncFileChannel 닫기
    private void closeAsyncFileChannel(AsynchronousFileChannel asyncFileChannel) {

        if (asyncFileChannel != null && asyncFileChannel.isOpen()) {

            try {
                asyncFileChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);    //// 상황에 맞는 예외 처리 필요
            }
        }
    }
}
