package otherExamples

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object FlatMap3 extends App {

  // https://www.credera.com/blog/technology-insights/mastering-scala-understanding-map-and-flatmap/

  // COLLECTIONS

  val l = List(1,2,3)
  println(l.map { x => x*2 } )
  println(l.map(_*2)) // same as above

  // collection types other than List behave similarly, using their internal iterators to submit elements to the map method
  val a = Array(1,2,3)
  // these don't print out great to console, try them in the REPL instead)
  println(a.map { x => x*2 } )
  println(a.map(_*2)) // same as above

  val s = Set(1,2,2,3)
  println( s.map(_*2) )
  println( s.map { x => x * 2 }) // same as above (Set seems to remove duplicates )

  println( (0 until 5).map(_*2) )

  // The MAP collection also has a .map() method, but it converts each key-value pair into a tuple for submission to the mapping function
  val m = Map("key1" -> 1, "key2" -> 2)
  println(m.map { keyValue: (String, Int) =>
    keyValue match { case (key,value) => (key, value*2) }
  })

  // can also map to other collection types
  println(m.map { case (key, value) => value * 2 } ) // List(2, 4) , loses the keys
  println(m.map { case (key, value) => value * 2 }.toSet ) // Set(2, 4)

  println("Hello".map { _.toUpper} )

  val listOfList = List(List(1,2,3), List(4,5,6))
  println(listOfList.flatten)

  // flatMap methods is shorthard to map a collection, then immediately flatten it
  val x = List(1,4,9)
  println(x.map { x => List(x,x+1) } )
  println(x.flatMap { x => List(x, x+1) } )

  // OPTIONS

  // although Scala Options are not collections, they do support map and flatMap
  // when mapping an Option with an inner Value e.g. Some(1), the mapping function acts on the value
  // but when mapping an Option without a value(None), the mapping function will return just another None

  // eg we have an optional variable cost and we want to add a value fee
  val fee = 1.25
  val cost = Some(4.50)
  val finalCost =
    if (cost.isDefined) Some(cost.get + fee) else None
  println(finalCost)
  // above is ugly, clean it up with a map
  val finalCost2 = cost.map(_+fee)
  println(finalCost2)

  // if cost did not have a value, the mapping function would never execute, and we would get NONE as a result intead
  val cost2:Option[Double] = None
  val finalCost3 = cost2.map(_+fee)
  println(finalCost3)

  // in an Option context, flatten will eliminate nested Options
  println(Some(Some(1)).flatten)
  println(Some(None).flatten)
  println(None.flatten)

  // a flatMap can be useful when we have optional results in a mapping function were already applying to an Option
  println( cost.flatMap { x => if (x < 1.00) None else Some(x+fee) } )

  // flatten a list of Options to elminate NONES and SOMES to their inner value
  println( List(Some(1),Some(2),None,Some(4),None).flatten )

  // where we are optionally mapping element, we can use a flatMap
  println( l.flatMap { x =>
    if (x <= 2) Some(x*2) else None
  } )

  // FUTURES

  // simple method that adds two to a number in an indepedent thread and returns the result as a future
  def addTwo(n:Int):Future[Int] = Future { n + 2 }

  // addTwoAndDouble returns a Future containing a result of adding two to a number and doubling it
  // use map as a chaining mechanism to take the Future provided by a call to addTwo, doublte its results in a callback, and then return the result of that doubling operation as another Future
  def addTwoAndDouble(n:Int):Future[Int] =
    addTwo(n).map { x:Int => x*2 }

  println( addTwoAndDouble(4).onComplete(x => println(x)) )

  // Sometimes we used Nested Futures, when one future submits results to another
  // we can flatten futures to elimate nesting
  // suppose we want to call addTwo and then forward the result of addiing it to another call to addTwo, we can use flatMap to chain the two futures together
  def addTwoAddTwo(n:Int):Future[Int] =
    addTwo(n).flatMap { n2 => addTwo(n2) }

  println( addTwoAddTwo(2).onComplete(x => println(x)) )

  // as a rule of thumb when mapping Futures, use map when processing the result of a single future
  // use flatMap when your nesting another future in your callback



}
