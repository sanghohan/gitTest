package test

import java.lang.reflect.Field
import java.io.File

object chapter7 {

   val filesHear = (new java.io.File(".")).listFiles()
    
  def main(args: Array[String])  
  {
	   for( test <- scalaFiles)
	     println("test : " + test)
	     
	   println(f)
	   
	   println(matchtest("1"))
  }
  
  
  def scalaFiles = 
    for{ 
        file <- filesHear 
        if file.isFile()
        //if file.getName().endsWith(".scala")
        
    } yield file.getName().length()

    
  def f(): Int =
    try {1} finally {2}
    
    
    def matchtest(arg: String) : String =
        arg match {
        case "1" => "one"
        case "2" => "two"
        case _ => "what?"  
        
      }
      
    
}