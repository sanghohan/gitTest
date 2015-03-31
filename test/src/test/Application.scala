package test


import java.util.{Date, Locale}
import java.text.DateFormat
import java.text.DateFormat._
import scala.collection.mutable.Set
import scala.collection.mutable.Map
import test.CheckSumAccumulator.calculate;

object Test {

  //implicit def test(x: Int) = new Rational(x)
	  
	def main(args: Array[String])
	{
	  
	  //for(arg <- args)
		 // println( arg +": " + calculate("test"))
	  
   /* val zero = new Rational(1,0)
	  val oneHalf = new Rational(1,2)
	  val twoThirds = new Rational(2,3)
	  
    println(zero)
	  println(oneHalf + oneHalf)
	  println(oneHalf * oneHalf)
	  println(2 * oneHalf)
	  */
     
     
   var i=0
   while(i<args.length)
   {
     if(i !=0)
       print(" ")
     print(args(i))
     
     i +=1
   }
   
   println()
     
   
  args.foreach(println)
  
  for(arg <- args)
    println(arg)
   
   
	}
	
}


class Rational(n: Int, d: Int ) {
  require(d !=0)
  
 // private val g = gcd(n.abs, d.abs)
  
  val number = n
  val denom = d
  
  def this(n: Int) = this(n,1)
  
  override def toString = number +","+ denom
  
  def + (that: Rational): Rational =
    new Rational(
    	number + that.number,
    	denom + that.denom 
    )
  
   def * (that: Rational): Rational =
    new Rational(
    	number * that.number, denom * that.denom 
    )
  
  /*private def gcd(a: Int, b: Int): Int =
    if(b == 0) a else gcd(b, a % b)*/
}
