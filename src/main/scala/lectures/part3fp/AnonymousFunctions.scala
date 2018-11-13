package lectures.part3fp

object AnonymousFunctions extends App {

  // this is the Object oriented way
  val doubler = new Function1[Int, Int] {
    override def apply(x: Int) = x * 2
  }

  // exact equivalent of above
  // it instansiates a new Function1, with the override def apply, takes an x which is an int and returns x * 2
  // called ANONYMOUS FUNCTION ... or LAMBDA
  val doubler2 = (x: Int) => x * 2

  // same as above, we are declaring the TYPE here... its of TYPE takes an Int, returns an Int
  val doubler3: Int => Int = (x: Int) => x * 2

  // you can remove the declaration that x is an int, you already specified it in the declaration of type
  // the input type is an Int, and the return type is an Int
  val doubler4: Int => Int = x => x * 2

  // multiple params in a lambda
  val adder = (a: Int, b: Int) => a + b

  // if we want to supply the TYPE of adder, we must put the arguments in parentheses
  val adder2: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  // the type of this "parentheses returns Int"
  // this is a no params lambda
  val justDoSomething = () => 3

  // same, this is declaring the type
  val justDoSomething2: () => Int = () => 3

  println(justDoSomething) // this just returns the function!
  println(justDoSomething()) // this CALLS the function.... you must call lambdas with parenthesis

  // curly braces with Lambdas
  // this is common style
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = (x: Int) => x + 1
  val niceIncrementer2: Int => Int = _ + 1 // same as above - underscore is the first param

  val niceAdder: (Int, Int) => Int = (a: Int, b: Int) => a + b
  val niceAdder2: (Int, Int) => Int = _ + _ // same as above, each underscore is a different parameter


  val superAdd = (x: Int) => (y: Int) => x + y // curried function






}
