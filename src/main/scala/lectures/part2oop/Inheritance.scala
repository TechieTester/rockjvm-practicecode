package lectures.part2oop

object Inheritance extends App {

  // single class inheritance
  sealed class Animal { // SEAL only protects the class in THIS file .... i.e. for FINAL
    def eat = println("nonmononom") // if I made this PRIVATE, you could only access within this class
    protected def moreEat = println("nommmmmmm")

    val creatureType = "wild"
  }

  class Cat extends Animal {
    def crunch = {
      moreEat // we can call the PROTECTED method inside this method
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.eat
  cat.crunch
  //cat.moreEat // can't do this

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0) // auxillary constructor
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age) // you must pass in this parameters to the constructor


  // overriding
  class Dog(override val creatureType: String) extends Animal {
    override def eat = {
      super.eat // calls the super class version of eat
      println("crunchy crunchy")
    }

//    override val creatureType = "domestic"
  }
  val dog = new Dog("k9") // this overrides the field in the constructor
  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymophism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // overRIDING vs overLOADING

  // super

  // preventing overridges - to prevent overrides, declare a member to be FINAL
  // you can also make a class FINAL
  // or you can SEAL tehc lass = extend classes in THIS File only

}
