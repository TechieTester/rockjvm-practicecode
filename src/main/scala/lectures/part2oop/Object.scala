package lectures.part2oop

object Object {

  // SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY ("static")
  object Person { // type + its only instance
    // "static" / class level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method - it builds persons given some parameters
    def from(mother: Person, father: Person): Person = new Person("Bobbie")

    // but the above method is normally called apply()
    def apply(mother: Person, father: Person): Person = new Person("Bobbie2")
  }

  class Person(val name: String) {
    // instance level functionality
  }
  // COMPANIONS ABOVE

  def main(args: Array[String]): Unit = { // this allows us to get rid of 'extend App' on the object above


    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = SINGLETON INSTANCE
    val mary = Person
    val john = Person
    println(mary == john) // true

    val mary2 = new Person("Mary")
    val john2 = new Person("John")
    println(mary2 == john2) // false

    val bobbie = Person.from(mary2, john2)
    val bobbie2 = Person(mary2, john2) // this is calling the apply() method

    // Scala Applications - Scala object with important method - def main(args: Array[String]): Unit

  }

}
