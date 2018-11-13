package lectures.part1Basics

object DefaultArgs extends App {

  def trFact(n: Int, acc: Int = 1): Int = // provided a default value here
    if (n <= 1) acc
    else trFact(n-1, n*acc)

  val fact10 = trFact(10) // now there is no need to supply the accumulator
  val fact11 = trFact(11, 2) // but you can still pass it in optionally


  def savePicture(format: String = "jpg", width: Int = 1000, height: Int = 2000): Unit = println("saving picture")
  savePicture("jpg", 800, 600) // original
//  savePicture(800, 600) // won't work, the lead parameter is changed
  savePicture(width = 800) // named parameters ! // can also pass in parameters in a different order


}
