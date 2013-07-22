package streams

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import Bloxorz._

@RunWith(classOf[JUnitRunner])
class BloxorzSuite extends FunSuite {

  trait SolutionChecker extends GameDef with Solver with StringParserTerrain {
    /**
     * This method applies a list of moves `ls` to the block at position
     * `startPos`. This can be used to verify if a certain list of moves
     * is a valid solution, i.e. leads to the goal.
     */
    def solve(ls: List[Move]): Block =
      ls.foldLeft(startBlock) {
        case (block, move) => move match {
          case Left => block.left
          case Right => block.right
          case Up => block.up
          case Down => block.down
        }
      }
  }

  trait Level1 extends SolutionChecker {
    /* terrain for level 1*/

    val level =
      """ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin

    val optsolution = List(Right, Right, Down, Right, Right, Right, Down)
  }

  test("terrain function level 1") {
    new Level1 {
      assert(terrain(Pos(0, 0)), "0,0")
      assert(!terrain(Pos(4, 11)), "4,11")
    }
  }

  test("findChar level 1") {
    new Level1 {
      assert(startPos == Pos(1, 1))
    }
  }

  test("optimal solution for level 1") {
    new Level1 {
      assert(solve(solution) == Block(goal, goal))
    }
  }

  test("optimal solution length for level 1") {
    new Level1 {
      assert(solution.length == optsolution.length)
    }
  }

  test("isStanding") {
    new Level1 {
      val p = Pos(2, 8)
      val b = Block(p, p)
      assert(b.isStanding)
    }
  }

  test("!isStanding") {
    new Level1 {
      val p1 = Pos(2, 8)
      val p2 = Pos(2, 9)
      val b = Block(p1, p2)
      assert(!b.isStanding)
    }
  }

  test("done") {
    new Level1 {
      val b = Block(goal, goal)
      assert(done(b))
    }
  }

  test("neighbours isStanding") {
    new Level1 {
      val p = Pos(2, 8)
      val pu = Pos(1, 8)
      val puu = Pos(0, 8)
      val pd = Pos(3, 8)
      val pdd = Pos(4, 8)
      val pl = Pos(2, 7)
      val pll = Pos(2, 6)
      val pr = Pos(2, 9)
      val prr = Pos(2, 10)
      val b = Block(p, p)
      val n = List(

        (Block(pll, pl), Left),

        (Block(pr, prr), Right),

        (Block(puu, pu), Up),

        (Block(pd, pdd), Down))
      assert(b.neighbors.toSet === n.toSet)
    }
  }
  test("neighbours !isStanding") {
    new Level1 {
      val pa = Pos(2, 8)
      val pb = Pos(3, 8)
      val pau = Pos(1, 8)
      val pbu = Pos(1, 8)
      val pad = Pos(4, 8)
      val pbd = Pos(4, 8)
      val pal = Pos(2, 7)
      val pbl = Pos(3, 7)
      val par = Pos(2, 9)
      val pbr = Pos(3, 9)
      val b = Block(pa, pb)
      val n = List(

        (Block(pal, pbl), Left),

        (Block(par, pbr), Right),

        (Block(pau, pbu), Up),

        (Block(pad, pbd), Down))
      assert(b.neighbors.toSet === n.toSet)
    }
  }
  test("legalNeighbours isStanding") {
    new Level1 {
      val p = Pos(2, 8)
      val pu = Pos(1, 8)
      val puu = Pos(0, 8)
      val pd = Pos(3, 8)
      val pdd = Pos(4, 8)
      val pl = Pos(2, 7)
      val pll = Pos(2, 6)
      val pr = Pos(2, 9)
      val prr = Pos(2, 10)
      val b = Block(p, p)
      val n = List(

        (Block(pll, pl), Left),

        (Block(pd, pdd), Down))
      assert(b.legalNeighbors.toSet === n.toSet)
    }
  }

  test("legalNeighbours !isStanding") {
    new Level1 {
      val pa = Pos(2, 8)
      val pb = Pos(3, 8)
      val pau = Pos(1, 8)
      val pbu = Pos(1, 8)
      val pad = Pos(4, 8)
      val pbd = Pos(4, 8)
      val pal = Pos(2, 7)
      val pbl = Pos(3, 7)
      val par = Pos(2, 9)
      val pbr = Pos(3, 9)
      val b = Block(pa, pb)
      val n = List(

        (Block(pal, pbl), Left),

        (Block(pad, pbd), Down))
      assert(b.legalNeighbors.toSet === n.toSet)
    }
  }

  test("neighborsWithHistory") {
    new Level1 {
      val n = List(
        (Block(Pos(1, 2), Pos(1, 3)), List(Right, Left, Up)),
        (Block(Pos(2, 1), Pos(3, 1)), List(Down, Left, Up)))

      assert(neighborsWithHistory(Block(Pos(1, 1), Pos(1, 1)), List(Left, Up)).toSet === n.toSet)
    }
  }

  test("newNeighborsOnly") {
    new Level1 {
      val neighbors = Set(
        (Block(Pos(1, 2), Pos(1, 3)), List(Right, Left, Up)),
        (Block(Pos(2, 1), Pos(3, 1)), List(Down, Left, Up))).toStream

      val explored = Set(
        Block(Pos(1, 2), Pos(1, 3)), Block(Pos(1, 1), Pos(1, 1)))

      val newNeighbors = Set((Block(Pos(2, 1), Pos(3, 1)), List(Down, Left, Up)))

      assert(newNeighborsOnly(neighbors, explored).toSet === newNeighbors)
    }
  }

}