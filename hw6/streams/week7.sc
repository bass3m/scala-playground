package streams

object week7 {

  val levelVector = Vector(Vector('S', 'T'), Vector('o', 'o'), Vector('o', 'o'))
                                                  //> levelVector  : scala.collection.immutable.Vector[scala.collection.immutable.
                                                  //| Vector[Char]] = Vector(Vector(S, T), Vector(o, o), Vector(o, o))

  levelVector.isDefinedAt(0) && levelVector(0).isDefinedAt(1) && levelVector(0)(1) != '-'
                                                  //> res0: Boolean = true

  levelVector.indexWhere(x => x.indexOf('T') != -1)
                                                  //> res1: Int = 0

  levelVector(levelVector.indexWhere(x => x.indexOf('T') != -1)).indexOf('T')
                                                  //> res2: Int = 1

  val v = Vector(Vector(1, 2, 3), Vector(4, 5, 6), Vector(7, 8, 9))
                                                  //> v  : scala.collection.immutable.Vector[scala.collection.immutable.Vector[Int
                                                  //| ]] = Vector(Vector(1, 2, 3), Vector(4, 5, 6), Vector(7, 8, 9))
  val num = 4                                     //> num  : Int = 4

  v.map(_ indexOf num)                            //> res3: scala.collection.immutable.Vector[Int] = Vector(-1, 0, -1)
  v.map(_ indexOf num).zipWithIndex               //> res4: scala.collection.immutable.Vector[(Int, Int)] = Vector((-1,0), (0,1), 
                                                  //| (-1,2))
  v.map(_ indexOf num).zipWithIndex.find(_._1 > -1)
                                                  //> res5: Option[(Int, Int)] = Some((0,1))

  val Some((posY, posX)) = v.map(_ indexOf num).zipWithIndex.find(_._1 > -1)
                                                  //> posY  : Int = 0
                                                  //| posX  : Int = 1

val level =
      """ooo-------
        |oSoooo----
        |ooooooooo-
        |-ooooooooo
        |-----ooToo
        |------ooo-""".stripMargin                //> level  : String = ooo-------
                                                  //| oSoooo----
                                                  //| ooooooooo-
                                                  //| -ooooooooo
                                                  //| -----ooToo
                                                  //| ------ooo-
 Vector(level.split("\n").map(str => Vector(str: _*)): _*)
                                                  //> res6: scala.collection.immutable.Vector[scala.collection.immutable.Vector[Ch
                                                  //| ar]] = Vector(Vector(o, o, o, -, -, -, -, -, -, -), Vector(o, S, o, o, o, o,
                                                  //|  -, -, -, -), Vector(o, o, o, o, o, o, o, o, o, -), Vector(-, o, o, o, o, o,
                                                  //|  o, o, o, o), Vector(-, -, -, -, -, o, o, T, o, o), Vector(-, -, -, -, -, -,
                                                  //|  o, o, o, -))
}