package lectures.part2oop

import java.util.Date
import java.sql.{Date => SqlDate} // also using Aliasing

import playground.{PrinceCharming, Cinderella => Princess} // Cinderalla => Princess is using Aliasing

object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Writer("James", "RockTheJVM", 2018)

  // import the package
  val princess = new Princess // uses Cinderella class, aliased as above
  val princess2 = new playground.Cinderella // fully qualified name

  // packages are in hierarchy
  // matching folder structure

  // package object
  sayHello // this is visible from the package object we created in this package... called part2oop (package.scala)
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

  //1 use FQ names
  val date = new Date
  val sqlDate = new SqlDate(2018, 5, 4) // use aliasing on the date as above

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???



}
