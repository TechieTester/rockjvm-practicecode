package otherExamples

object FlatMap2 extends App {

  // difference between map and flatMap on a Seq[String] (i.e. List)

  // quite a difference. Flatmap flatters the resulting list of strings into a sequence of chars
  val fruits = Seq("apple", "banana", "orange")
  println(fruits.map(_.toUpperCase))
  println(fruits.flatMap(_.toUpperCase))

  // think of flatMap as a combination of map followed by flattern
  // so it first runs MAP on the sequence, then FLATTEN
  val mapResult = fruits.map(_.toUpperCase)
  println(mapResult)
  val flattenResult = mapResult.flatten
  println(flattenResult)

  // following shows more differences between map and flatMap
  def toInt(s: String): Option[Int] = {
    try {
      Some(Integer.parseInt(s.trim))
    } catch {
      case e: Exception => None
    }
  }

  val strings = Seq("1", "2", "foo", "3", "bar")
  println(strings.map(toInt))
  println(strings.flatMap(toInt))
  println(strings.flatMap(toInt).sum)

  // flatMap does a nice job of flattening a list that has SOME and NONE values
  // Again its worth noting that flatMap is equivalent to running map then flatten
  val mapResult2 = strings.map(toInt)
  println(mapResult2)
  val flattenResult2 = mapResult2.flatten
  println(flattenResult2)

  // HACK - think of flatMap as MAP Then FLATTEN

  // Another example
  val list = List(1,2,3,4,5)
  def g(v:Int) = List(v-1, v, v+1)
  println(list.map(x => g(x)))
  println(list.flatMap(x => g(x)))

  // Convert Map values to a sequence with flatMap
  val map = Map(1 -> "one", 2 -> "two", 3 -> "three")
  println(1 to map.size flatMap(map.get))
  println(1 to map.size map(map.get))
  println(1 to map.size flatMap(map.get(_))) // same as the flatmap above


  // Examples from Twitter school
  val chars = 'a' to 'z'
  val perms = chars flatMap { a =>
    chars flatMap { b =>
      if (a != b) Seq("%c%c".format(a,b))
      else Seq()
    }
  }
  println(perms)

  // another example - all 4 print the same result
  val sequenceOfNums = Seq(1,2,3,4)
  println(sequenceOfNums.flatMap(x => Seq(x, -x)))
  println(sequenceOfNums.flatMap { x => Seq(x, -x) } )
  println(sequenceOfNums flatMap(x => Seq(x, -x)))
  println(sequenceOfNums flatMap { x => Seq(x, -x) } )

  // again, easier if you look at MAP then FLATTEN
  val mapResult3 = sequenceOfNums.map { x => Seq(x, -x) }
  println(mapResult3)
  val flattenResult3 = mapResult3.flatten
  println(flattenResult3)

  // another example using sequenceOfNums - both the same again
  println(sequenceOfNums.flatMap { x =>
    if (x%2 == 0) Seq(x)
    else Seq()
  })
  println(sequenceOfNums flatMap(x =>
    if (x%2 == 0) Seq (x)
    else Seq()
    ))


}
