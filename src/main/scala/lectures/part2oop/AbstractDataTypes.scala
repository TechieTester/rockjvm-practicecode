package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract - class can't be instantiated
  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit // notice we haven't assigned this member - class is abstract so don't have to
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("crunch crunch") // actually don't need the override here
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit // this is abstract
    val preferredMeal: String = "fresh meat" // this is non-abstract
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    def eat: Unit = println("Nom nom nom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and im eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat
  croc.eat(dog)

  // traits vs abstract classes
  // 1 - traits do not have constructor parameters
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits = behavior, abstract class = "type of thing"


}
