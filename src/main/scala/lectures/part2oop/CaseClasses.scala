package lectures.part2oop

object CaseClasses extends App {

  /*
   equals, hashCode, toString
   */

//  class Person(name: String, age: Int) // with this, can't call the .name field below
  case class Person(name: String, age: Int)

  // 1. class parameters are fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  // println(instance) = println(instance.toString) // syntax sugar
  println(jim.toString) // prints jim, 34
  println(jim) // same thing

  // 3. equals and hashCode implemented OOTB
  val jim2 = new Person("Jim", 34)
  println(jim == jim2) // true ... without the CASE CLASS it would be false though

  // 4. Case Classes have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3) // new instance of Person, with age 45

  // 5. Case Classes have companion objects - Companion Objects make
  val thePerson = Person
  val mary = Person("Mary", 23) // Defaults to the apply() method.... which is the constructor ... apply method makes companion object callable like a function

  // 6. CCs are serializable
  // Akka

  // 7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING


  // also there are case objects
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }



}
