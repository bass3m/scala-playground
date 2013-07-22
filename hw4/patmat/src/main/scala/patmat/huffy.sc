package patmat

import patmat.Huffman._

object huffy {
  val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
                                                  //> t1  : patmat.Huffman.Fork =   /-(b:3)
                                                  //| (ab:5)
                                                  //|   \-(a:2)
  println(t1.weight)                              //> 5
  println(t1.chars)                               //> List(a, b)
  val l1 = List(('c',2),('a',1),('b',42))         //> l1  : List[(Char, Int)] = List((c,2), (a,1), (b,42))
  val em = List(())                               //> em  : List[Unit] = List(())
  l1.find(x=>x._2 == 2) match {
  	case None => Nil
  	case Some(x) => x._2
  }                                               //> res0: Any = 2
  l1.contains(('c',2))                            //> res1: Boolean = true
  l1.head._1 == 'c'                               //> res2: Boolean = true
  l1 map(i=>(i._2 + 1))                           //> res3: List[Int] = List(3, 2, 43)
  l1 find(x=> (x == ('a',1)))                     //> res4: Option[(Char, Int)] = Some((a,1))
  (0 /: l1)(_ + _._2)                             //> res5: Int = 45
  (0 /: l1)((x,y) => x + y._2)                    //> res6: Int = 45
  val l2 = List('a','a','a','b','a','b','c','a')  //> l2  : List[Char] = List(a, a, a, b, a, b, c, a)
  List[(Char,Int)]().isEmpty                      //> res7: Boolean = true
  
  def test(x: Char, pairs: List[(Char,Int)]) : List[(Char,Int)] = pairs match {
  	case List() => List((x,1))// :: pairs
  	case List((c,d)) => if (c == x) List((c,d+1)) else List((c,1))
  }                                               //> test: (x: Char, pairs: List[(Char, Int)])List[(Char, Int)]
  val l3 = l2.map(x=>test(x,List[(Char,Int)]()))  //> l3  : List[List[(Char, Int)]] = List(List((a,1)), List((a,1)), List((a,1)), 
                                                  //| List((b,1)), List((a,1)), List((b,1)), List((c,1)), List((a,1)))
  l3.flatten                                      //> res8: List[(Char, Int)] = List((a,1), (a,1), (a,1), (b,1), (a,1), (b,1), (c,
                                                  //| 1), (a,1))
  //l2.map(x=>test(x,l3.flatten))
  //(List[(Char,Int)]() /: l2)((x,y) => if (y._1 == x) List((y._1,(y._2 + 1))) else y)
  (List[(Char,Int)]() /: l2)((x,y) => if (y == 'a') List(('a',33)) else x)
                                                  //> res9: List[(Char, Int)] = List((a,33))
  (List[(Char,Int)]() /: l2)((x,y) => test(y,x))  //> res10: List[(Char, Int)] = List((a,2))
  val l4 = l2.groupBy(x=>x).toList.map(x=>(x._1,x._2.size))
                                                  //> l4  : List[(Char, Int)] = List((b,2), (a,5), (c,1))
  l4.sortBy(x=>x._2)                              //> res11: List[(Char, Int)] = List((c,1), (b,2), (a,5))
   
  
  val leaflist = List(Leaf('e', 1), Leaf('t', 2),Leaf('x', 4))
                                                  //> leaflist  : List[patmat.Huffman.Leaf] = List((e:1), (t:2), (x:4))
  List(Leaf('b',3))::List(makeCodeTree(Leaf('e', 1), Leaf('t', 2)))
                                                  //> res12: List[Product] = List(List((b:3)),   /-(t:2)
                                                  //| (et:3)
                                                  //|   \-(e:1))
  
  val trees = combine(leaflist)                   //> trees  : List[patmat.Huffman.CodeTree] = List(  /-(t:2)
                                                  //| (et:3)
                                                  //|   \-(e:1), (x:4))
  trees.length                                    //> res13: Int = 2
  val untilS = until(singleton, combine)(trees)   //> untilS  : List[patmat.Huffman.CodeTree] = List(  /-(x:4)
                                                  //| (etx:7)
                                                  //|   |  /-(t:2)
                                                  //|   \-(et:3)
                                                  //|      \-(e:1))
  val chary = List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd')
                                                  //> chary  : List[Char] = List(h, e, l, l, o, ,,  , w, o, r, l, d)
                                                  
  val ly = makeOrderedLeafList(times(chary))      //> ly  : List[patmat.Huffman.Leaf] = List((e:1), ( :1), (,:1), (h:1), (r:1), (
                                                  //| w:1), (d:1), (o:2), (l:3))
                                                  
  val tt = createCodeTree(chary)                  //> tt  : patmat.Huffman.CodeTree =            /-( :1)
                                                  //|         /-( e:2)
                                                  //|         |  \-(e:1)
                                                  //|      /-( ,eh:4)
                                                  //|      |  |  /-(h:1)
                                                  //|      |  \-(,h:2)
                                                  //|      |     \-(,:1)
                                                  //|   /-( ,ehl:7)
                                                  //|   |  \-(l:3)
                                                  //| ( ,dehlorw:12)
                                                  //|   |        /-(w:1)
                                                  //|   |     /-(rw:2)
                                                  //|   |     |  \-(r:1)
                                                  //|   |  /-(drw:3)
                                                  //|   |  |  \-(d:1)
                                                  //|   \-(dorw:5)
                                                  //|      \-(o:2)
  
  val comby = combine(ly)                         //> comby  : List[patmat.Huffman.CodeTree] = List((,:1), (h:1), (r:1), (w:1), (
                                                  //| d:1),   /-( :1)
                                                  //| ( e:2)
                                                  //|   \-(e:1), (o:2), (l:3))
                                                  
   val chl = List('h', 'e', 'l', 'l', 'o')        //> chl  : List[Char] = List(h, e, l, l, o)
   
   createCodeTree(chl)                            //> res14: patmat.Huffman.CodeTree =         /-(h:1)
                                                  //|      /-(eh:2)
                                                  //|      |  \-(e:1)
                                                  //|   /-(eho:3)
                                                  //|   |  \-(o:1)
                                                  //| (ehlo:5)
                                                  //|   \-(l:2)
                                                  
                                                  
   val h1 = makeOrderedLeafList(times(chl))       //> h1  : List[patmat.Huffman.Leaf] = List((e:1), (h:1), (o:1), (l:2))
   
   val comy = combine(h1)                         //> comy  : List[patmat.Huffman.CodeTree] = List((o:1),   /-(h:1)
                                                  //| (eh:2)
                                                  //|   \-(e:1), (l:2))
 
                                                 
                                                  
                                                  
  until(singleton,combine)(ly)                    //> res15: List[patmat.Huffman.CodeTree] = List(           /-( :1)
                                                  //|         /-( e:2)
                                                  //|         |  \-(e:1)
                                                  //|      /-( ,eh:4)
                                                  //|      |  |  /-(h:1)
                                                  //|      |  \-(,h:2)
                                                  //|      |     \-(,:1)
                                                  //|   /-( ,ehl:7)
                                                  //|   |  \-(l:3)
                                                  //| ( ,dehlorw:12)
                                                  //|   |        /-(w:1)
                                                  //|   |     /-(rw:2)
                                                  //|   |     |  \-(r:1)
                                                  //|   |  /-(drw:3)
                                                  //|   |  |  \-(d:1)
                                                  //|   \-(dorw:5)
                                                  //|      \-(o:2))
  
  ly.dropWhile(x=> x.weight < 2)                  //> res16: List[patmat.Huffman.Leaf] = List((o:2), (l:3))
  
  
  var resultTree = createCodeTree( string2Chars("AAAAAAAABBBCDEFGH") )
                                                  //> resultTree  : patmat.Huffman.CodeTree =         /-(B:3)
                                                  //|      /-(BEF:5)
                                                  //|      |  |  /-(F:1)
                                                  //|      |  \-(EF:2)
                                                  //|      |     \-(E:1)
                                                  //|   /-(BCDEFGH:9)
                                                  //|   |  |     /-(C:1)
                                                  //|   |  |  /-(CG:2)
                                                  //|   |  |  |  \-(G:1)
                                                  //|   |  \-(CDGH:4)
                                                  //|   |     |  /-(D:1)
                                                  //|   |     \-(DH:2)
                                                  //|   |        \-(H:1)
                                                  //| (ABCDEFGH:17)
                                                  //|   \-(A:8)
                                                  
                                                  
 val chars = List('a', 'b', 'c')                  //> chars  : List[Char] = List(a, b, c)
 val c3 = makeOrderedLeafList(times(chars))       //> c3  : List[patmat.Huffman.Leaf] = List((b:1), (a:1), (c:1))
 combine(c3)                                      //> res17: List[patmat.Huffman.CodeTree] = List((c:1),   /-(a:1)
                                                  //| (ab:2)
                                                  //|   \-(b:1))
                                                  
 until(singleton,combine)(c3)                     //> res18: List[patmat.Huffman.CodeTree] = List(     /-(a:1)
                                                  //|   /-(ab:2)
                                                  //|   |  \-(b:1)
                                                  //| (abc:3)
                                                  //|   \-(c:1))
                                                  
 val code = createCodeTree(chars)                 //> code  : patmat.Huffman.CodeTree =      /-(a:1)
                                                  //|   /-(ab:2)
                                                  //|   |  \-(b:1)
                                                  //| (abc:3)
                                                  //|   \-(c:1)
 val e1 = code match {
 	case f: Fork => f.chars
 	case l: Leaf => l.char
 }                                                //> e1  : Any = List(c, b, a)
 
 
 decode(code,List(0,0,0,1,1))                     //> res19: List[Char] = List(c, c, c, a)
 encode(code)(List('a', 'b', 'c'))                //> res20: List[patmat.Huffman.Bit] = List(1, 1, 1, 0, 0)
 convert(code)                                    //> res21: patmat.Huffman.CodeTable = List((c,List(0)), (b,List(1, 0)), (a,List
                                                  //| (1, 1)))
 val freqs = times(List('a', 'b', 'a', 'c', 'a', 'a', 'b'))
                                                  //> freqs  : List[(Char, Int)] = List((b,2), (a,4), (c,1))
 decode(t1, encode(t1)("ab".toList))              //> res22: List[Char] = List(a, b)
 //decode(frenchCode, secret)
 
 quickEncode(code)(List('a', 'b', 'c'))           //> res23: List[patmat.Huffman.Bit] = List(1, 1, 1, 0, 0)
 
 lazy val fibs: Stream[Int] = 0 #:: 1 #:: fibs.zip(fibs.tail).map { n => n._1 + n._2 }
                                                  //> fibs: => Stream[Int]
 println((fibs take 8).toList)                    //> List(0, 1, 1, 2, 3, 5, 8, 13)
 
}