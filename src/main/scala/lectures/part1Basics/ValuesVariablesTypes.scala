package lectures.part1Basics

object ValuesVariablesTypes extends App {

  val x: Int = 42
  println(x)

  val aString: String = "hello"
  val anotherString = "goodbye"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt:Int = x
  val aShort: Short = 4613
  val aLong: Long = 52342342342L // note the capital L at the end
  val aFloat: Float = 2.0f // note the f for float
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4

  aVariable = 5 // side effects

}
