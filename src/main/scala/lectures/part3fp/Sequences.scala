package lectures.part3fp

import scala.util.Random

object Sequences extends App {

  // Seq
  val aSequence = Seq(1,3,2,4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence.apply(2)) // gets the value at index 2
  println(aSequence(2)) // same as above apply method
  println(aSequence ++ Seq(5,6,7))
  println(aSequence.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  (1 to 5).foreach(x => println("Hello"))

  // lists
  val aList = List(1,2,3)

  val prepended = 42 :: aList
  println(prepended)
  val prepended2 = 42 +: aList :+ 89
  println(prepended2)

  val apples5 = List.fill(5)("apple") // curried function, adds 5 "apples" to the list
  println(apples5)

  println(aList.mkString("-&&-")) // puts the string in between all the elements

  // arrays
  val numbers = Array(1,2,3,4)

  val threeElements = Array.ofDim[Int](3) // empty Array with space for 3 values
  println(threeElements)
  threeElements.foreach(println) // they have default values of 0 !

  // mutation
  numbers(2) = 0 // update the value at index 2.... syntax sugar for numbers.update(2,0)
  println(numbers.mkString(" "))

  // arrays and sequences
  val numbersSeq: Seq[Int] = numbers // implicit conversion
  println(numbersSeq) // returns a "WrappedArray"

  // vector
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  // vectors vs lists

  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns

  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // keeps refence to tail
  println(getWriteTime(numbersList))
  // depth of tree is small
  println(getWriteTime(numbersVector))






}
