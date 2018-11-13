package lectures.part1Basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime()) // returns the same
  calledByName(System.nanoTime()) // returns different

  /*
  The => makes all the difference... it delays the evaluation until the time its actually used... for by Value, the system will calculate it at the start then keep using that value
  But for the CallByName... it will literally execute that System.nanotime() when it the code gets to that point
   */

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  // printFirst(infinite(), 34) .... this will crash with a stack overflow
  printFirst(34, infinite()) // this runs fine... because y never got evaluated , so could never crash !


}
