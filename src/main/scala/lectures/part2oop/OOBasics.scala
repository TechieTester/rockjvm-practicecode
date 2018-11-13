package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 26) // at every instansiation, all the code in the class block gets evaluated
  println(person.age)
  println(person.x) // 2
  person.greet("Daniel")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expecations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))

  val counter = new Counter
  counter.increase.print
  counter.increase.increase.increase.print
  counter.inc(10).print
}

// constructor
class Person(name: String, val age: Int) {

  val x = 2

  println(1 + 3)

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name") // uses the name when the class is declared for this.name, and the name is Daniel is passed to the method

  //overloading - methods with the same name but different input parameters
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructors
  def this(name: String) = this(name, 0) // calls the master constructor ... constructor must call another constructor
  def this() = this("John Doe") // calls the constructor above
}

// class parameters are NOT FIELDS ... unless you add val before it (e.g. with age above )

class Writer(firstName: String, surname: String, val year: Int) { // look at the val year here
  def fullName: String = firstName + " " + surname
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge = year - author.year // access the parameters of the class author.year thanks to the val above
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}


class Counter(val count: Int = 0) {
  def increase = {
    println("incrementing")
    new Counter(count + 1) // immutability - instances are fixed and can't be modified inside... you have to return a new instance if you want to modify inside
  }

  def decrease = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else increase.inc(n-1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else decrease.dec(n-1)
  }

  def print = println(count)
}