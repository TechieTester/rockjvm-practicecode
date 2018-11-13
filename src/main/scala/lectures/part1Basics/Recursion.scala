package lectures.part1Basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if(n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)

      result
    }

  println(factorial(10))

  // THE ABOVE IS FINE, BUT IF YOU USE A BIG NUMBER YOU WILL GET STACK OVERFLOW

  def anotherFactorial(n: Int): BigInt = {
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // THIS IS USING TAIL RECURSSION - INTELLIJ IDENFITIFES THIS ON THE LEFT
    // To make something tail recurssive... it needs to be the last expression in the call path

    factHelper(n, 1)
  }


  /*
  anotherFactorial(10) = factHelper(10, 1)
  = factHelper(9, 10 * 1)
  = factHelper(8, 9 * 10 * 1)
  = factHelper(7, 8 * 9 * 10 * 1)
  = ...
  = factHelper(1, 1 * 2 * 3 .... * 10)
  = 1 * 2 * 3 .... * 10 (i.e it finally returns the accumlator)
   */

  println(anotherFactorial(200))

    // WHEN YOU NEED LOOPS.... USE TAIL RECURSION


  // EXECISES
  def aRepeatedFunction(aString: String, n:Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  def aRepeatedFunctionWithTailRecursion(aString: String, n: Int): String = {
    def recursionHelper(x: Int, accumulatedString: String): String =
      if (x <= 1) accumulatedString
      else recursionHelper(x - 1, accumulatedString + aString)

    recursionHelper(n, aString)

  }

  println(aRepeatedFunctionWithTailRecursion("hello", 5))

  @tailrec
  def concatenateTailRec(aString: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatenateTailRec(aString, n - 1, accumulator + aString)

  println(concatenateTailRec("hello", 3, ""))

  def isPrime(n: Int): Boolean = {
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if(!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t-1, n % t != 0 && isStillPrime) //isStillPrime is used as the accumulator to store the result... we jump out as soon as it switches to false

    isPrimeTailrec(n/2, true)
  }


  println(isPrime(2003))
  println(isPrime(629))

  def fibonacci(n: Int): Int = {
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if(i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }


}
