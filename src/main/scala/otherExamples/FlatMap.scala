package otherExamples

object FlatMap extends App {

  // http://www.brunton-spall.co.uk/post/2011/12/02/map-map-and-flatmap-in-scala/

  // Map works by applying a function to each element in the list
  val l = List(1,2,3,4,5)
  val listWithDouble = l.map(x => x* 2)
  println(listWithDouble)

  // Return a sequence or list from the function, for example an Option
  def f(x: Int) = if (x > 2) Some(x) else None
  val listWithSomeOrNone = l.map(x => f(x))
  println(listWithSomeOrNone)

  // Flatmap works applying a function that returns a sequence for each element in the list, flattening the results into the original list
  def g(v: Int) = List(v-1, v, v+1)
  val listWithNormalMap = l.map(x => g(x))
  println(listWithNormalMap)
  val listWithFlatMap = l.flatMap(x => g(x))
  println(listWithFlatMap)


  // This comes in really useful with the build in Option class because an option can be considered a sequence this is either empty or has 1 item
  val listWithOptionFromMap = l.map(x => f(x))
  println(listWithOptionFromMap)
  val listWithOptionFlatMap = l.flatMap(x => f(x))
  println(listWithOptionFlatMap)


  // Now a MAP can be implemented a number of different ways, but regardless of that, it can be thought of as a sequence of tuples
  // Where a tuple is a PAIR of items - the key and the value
  val m = Map(1 -> 2, 2 -> 4, 3 -> 6)
  val mapToList = m.toList
  println(mapToList)

  // We can access a tuple by accessing the inner variables _1 and _2
  val t = (1,2)
  println(t._1)
  println(t._2)


  // so we want to use map and flatMap on our Map.... but because of the way a map works it often doesn't make sense, we probably don't want to apply a function to the tuple,
  // but to the VALUES side of the tuple, leaving the KEY as is
  // so for example we might want to double all the VALUES
  val doubleValueMap = m.mapValues(v => v*2)
  println(doubleValueMap)
  val functionOnMap = m.mapValues(v => f(v))
  println(functionOnMap)


  // in my case I want to to do something more like a flatMap, I want a map to come out that misses out the key 1 because its value is NONE
  // flatMap doesn't work on maps like mapValues, it gets passed the tuple and if it returns a List of single items you get a List back
  // but if you return a tuple, you get a Map back
  val flatMapOnAMapReturnList = m.flatMap(e => List(e._2))
  println(flatMapOnAMapReturnList)
  val flatMapOnAMapReturnMap = m.flatMap(e => List(e))
  println(flatMapOnAMapReturnMap)


  // pretty close to using OPTIONS with flatMap, we need to filter out our Nones, we can do returning a list with just e => (f(e._2)
  // and we get the list of values without the NONEs.... but that isn't really want we want
  // what I need to do is return an OPTION containing a TUPLE, so heres the updated function
  def h(k:Int, v:Int) = if (v > 2) Some(k -> v) else None

  // and heres how to call it
  val flatMapOnTuple = m.flatMap( e => h(e._1, e._2) )
  println(flatMapOnTuple)

  // but the above is ugly. Is there a way of unapplying the tuple into variables
  // this doesn't work:
  //  m.flatMap( (k,v) => h(k,v)

  // UnApply is only executed in a PartialFunction, which in Scala is most easily defined as a case statement
  // Note that we switch to using curly braces, indicating a function block rather than parameters, and the function is a case statement
  // this means the function block we pass to flatMap is a partialFunction this is only invoked for items that match the case statement
  // and in the case statement that unApply method on tuple is called to extract the contents of the tuple into the variables
  val flatMapWithUnApply = m.flatMap { case (k,v) => h(k,v) }
  println(flatMapWithUnApply)

  val filter1 = m.filter( e => f(e._2) != None)
  println(filter1)
  val filter2 = m.filter { case (k,v) => f(v) != None }
  println(filter2)
  val filter3 = m.filter { case (k,v) => f(v).isDefined }
  println(filter3)

}
