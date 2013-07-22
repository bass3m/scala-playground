package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    // Balance tests
    println("Balance: Results should be:")
    print("True:" + balance("(if (zero? x) max (/ 1 x))".toList))
    println()
    print("True: " + 
        balance("I told him (that it's not (yet) done). (But he wasn't listening)".toList))
    println()    
    print("False: " + balance(":-)".toList)) ; println()
    print("False: " + balance("())(".toList)) ; println()
    print("True: " + balance("(just an) example".toList)) ; println()
    
    println("countChange: Results should be:")
    print("Money 4, Denom: 1,2 Res=3: " + countChange(4,List(1,2)))
    println()
    print("Money 100, Denom: 1,5,10,25,50 Res=292: " + countChange(100,List(1,5,10,25,50)))
    
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if ((c == 0) || (c == r))
      1
    else
      pascal(c-1,r-1) + pascal(c,r-1)

  
  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def helper(charList : List[Char], acc : Int) : Boolean =
      if (acc < 0) false
      else charList match {
    	case Nil => (acc == 0)
    	case c::cs => c match {
    	  case '(' => helper(cs,acc+1)
    	  case ')' => helper(cs,acc-1)
    	  case _ => helper(cs,acc)
    	}
      }   
  	helper(chars,0)
    }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int =
    if (money == 0) 1
    else if ((money < 0) || coins.isEmpty) 0
    else countChange(money,coins.tail) + countChange(money - coins.head,coins)
    
}
