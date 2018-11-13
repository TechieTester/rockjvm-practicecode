package lectures.part1Basics

object Expressions extends App {

  val x = 1 + 2 // EXPRESSION
  println(x)

  println(2 + 3 * 4)

  println(1 == x)

  println(!(1 == x))

  var aVariable = 2
  aVariable += 3 // this is a side effect
  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE) - In Scala we think of VALUE

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue) // the IF expression here will give back a value
  println(if(aCondition) 5 else 3)
  println(1 + 3)

  // we use loops in Scala but we DISCOURAGE them
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // NEVER WRITE THIS AGAIN - loops are meant for IMPERATIVE PROGRAMMING like JAVA or PYTHON or C

  // EVERTHING IN SCALA IS AN EXPRESSION
  val aWeirdValue = (aVariable = 3) // Unit === void .... reassigning a variable is a sideeffect, it returns a UNIT
  println(aWeirdValue) // this will printout () , which means Unit .... that while loops above is also a side effect

  // side effects: println(), whiles, reassigning

  // Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  } // this is an expression ... its the type of the last expression, which gets returned, which is a STRING here





}
