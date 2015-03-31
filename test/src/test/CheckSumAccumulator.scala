 package test
 
import java.util.{Date, Locale}
import java.text.DateFormat
import java.text.DateFormat._
import scala.collection.mutable.Set
import scala.collection.mutable.Map
 
 
 object CheckSumAccumulator {
     
     private val cache = Map[String, Int]()
     
     def calculate(s: String): Int =
       
       if(cache.contains(s))
         cache(s)
       else 
       {
         val acc = new CheckSumAccumulator
         for(c <- s)
           acc.add(c.toByte)
         
         val cs = acc.checksum()
         cache += (s -> cs)
         cs
       }
     
   }
   
   
   class CheckSumAccumulator {
     
     private var sum = 0
     def add(b: Byte): Unit = sum +=b
     def checksum(): Int = ~(sum & 0xFF) + 1
   }