package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) { // val keyword means its a FIELD that can be accessed
    def likes(movie: String): Boolean = movie == favoriteMovie
  //  def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)
    def unary_! : String = s"$name, what the heck?!" // remember the space after :
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie" // () is very important on the method name
    def apply(n: Int):String = s"$name watched $favoriteMovie $n times" // apply method lets you call objects as if they were functions
    def learns(thing: String) = s"$name is learning $thing"
    def learnsScala = this learns "Scala"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation (syntactic sugar)

  // "operators" in scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom)) // same as above

  println(1 + 2)
  println(1.+(2)) // the same ... ALL OPERATORS ARE METHODS

  // prefix notation
  val x = -1 // equivalent with  1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!mary) // same as below
  println(mary.unary_!) // uses the unary above which has been refined

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive) // same as above ... only for methods without parameters

  // apply
  println(mary.apply())
  println(mary()) // this is the same as above .. can all mary as if its a function because we have defined the apply() method in the class, which is a special method

  println((mary + "theRockstar")()) // the () inside the println( ) calls the apply method above
  println((mary + "theRockstar").apply())

  println((+mary).age) // its calling unary_+ above

  println(mary learnsScala)

  println(mary(10)) // calls the apply method, overloaded !

}
