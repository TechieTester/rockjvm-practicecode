package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal { // can also use a trait here, its the same
    def eat: Unit
  }

  // anonymous class - this code does everything in the block below
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahah")
  }

  /*
    class AnonymousClasses$$anon$1 extends Animal {
      override def eat: Unit = println("ahahahahah")
    }
    val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi my name is $name how can i help?")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println("Hi my name is Jim how can I be of service?")
  }

}
