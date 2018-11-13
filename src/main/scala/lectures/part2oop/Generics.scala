package lectures.part2oop

object Generics extends App {

  class MyList[+A] {
    // use the type A

    // Takes a parameter, type B, which is a SUPER TYPE of A ..... the parameter element is of TYPE B... result type in MyList is also type B
    def add[B >: A](element: B): MyList[B] = ???
    /*
      A = Cat
      B = Dog = Animal

     */
  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  class MyMap[Key, Value] // both key and value are Generic here

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???

  }
  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A] // notice the +A
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // animalList.add(new Dog) ??? HARD QUESTION --- adding the DOG to the list will turn it into a GENERIC list of Animals
  // 2. NO = INVARIANCE
  class InvariantList[A] // notice the A on its own
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell no! CONTRAVARIANCE
  class ContravariantList[-A] // notice the -A
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A) // class Cage only accepts type parameters of A which are SUBTYPES of Animal ... class receives an animal of type A
  val cage = new Cage(new Dog) // this will work

  class Car
//  val newCage = new Cage(new Car) // this will throw error when run ! Not bounded properly


}
