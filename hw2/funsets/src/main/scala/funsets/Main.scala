package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
  println(contains(singletonSet(3), 1))
  val s1 = singletonSet(1)
  val s2 = singletonSet(2)
  val s3 = singletonSet(3)
  val s4 = singletonSet(4)
  val s5 = singletonSet(9)
  val s = union(s3,union(s1, s2))
  val sq = union(s5,union(s1, s4))
  
  printSet(map(s5,(x=> x * x)))
  printSet(map(s,(x=> x * x)))
  printSet(s)
}
