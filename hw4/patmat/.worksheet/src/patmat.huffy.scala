package patmat

import patmat.Huffman._

object huffy {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(115); 
  val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5);System.out.println("""t1  : patmat.Huffman.Fork = """ + $show(t1 ));$skip(21); 
  println(t1.weight);$skip(20); 
  println(t1.chars);$skip(42); 
  val l1 = List(('c',2),('a',1),('b',42));System.out.println("""l1  : List[(Char, Int)] = """ + $show(l1 ));$skip(20); 
  val em = List(());System.out.println("""em  : List[Unit] = """ + $show(em ));$skip(80); val res$0 = 
  l1.find(x=>x._2 == 2) match {
  	case None => Nil
  	case Some(x) => x._2
  };System.out.println("""res0: Any = """ + $show(res$0));$skip(23); val res$1 = 
  l1.contains(('c',2));System.out.println("""res1: Boolean = """ + $show(res$1));$skip(20); val res$2 = 
  l1.head._1 == 'c';System.out.println("""res2: Boolean = """ + $show(res$2));$skip(24); val res$3 = 
  l1 map(i=>(i._2 + 1));System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(30); val res$4 = 
  l1 find(x=> (x == ('a',1)));System.out.println("""res4: Option[(Char, Int)] = """ + $show(res$4));$skip(22); val res$5 = 
  (0 /: l1)(_ + _._2);System.out.println("""res5: Int = """ + $show(res$5));$skip(31); val res$6 = 
  (0 /: l1)((x,y) => x + y._2);System.out.println("""res6: Int = """ + $show(res$6));$skip(49); 
  val l2 = List('a','a','a','b','a','b','c','a');System.out.println("""l2  : List[Char] = """ + $show(l2 ));$skip(29); val res$7 = 
  List[(Char,Int)]().isEmpty;System.out.println("""res7: Boolean = """ + $show(res$7));$skip(194); 
  
  def test(x: Char, pairs: List[(Char,Int)]) : List[(Char,Int)] = pairs match {
  	case List() => List((x,1))// :: pairs
  	case List((c,d)) => if (c == x) List((c,d+1)) else List((c,1))
  };System.out.println("""test: (x: Char, pairs: List[(Char, Int)])List[(Char, Int)]""");$skip(49); 
  val l3 = l2.map(x=>test(x,List[(Char,Int)]()));System.out.println("""l3  : List[List[(Char, Int)]] = """ + $show(l3 ));$skip(13); val res$8 = 
  l3.flatten;System.out.println("""res8: List[(Char, Int)] = """ + $show(res$8));$skip(196); val res$9 = 
  //l2.map(x=>test(x,l3.flatten))
  //(List[(Char,Int)]() /: l2)((x,y) => if (y._1 == x) List((y._1,(y._2 + 1))) else y)
  (List[(Char,Int)]() /: l2)((x,y) => if (y == 'a') List(('a',33)) else x);System.out.println("""res9: List[(Char, Int)] = """ + $show(res$9));$skip(49); val res$10 = 
  (List[(Char,Int)]() /: l2)((x,y) => test(y,x));System.out.println("""res10: List[(Char, Int)] = """ + $show(res$10));$skip(60); 
  val l4 = l2.groupBy(x=>x).toList.map(x=>(x._1,x._2.size));System.out.println("""l4  : List[(Char, Int)] = """ + $show(l4 ));$skip(21); val res$11 = 
  l4.sortBy(x=>x._2);System.out.println("""res11: List[(Char, Int)] = """ + $show(res$11));$skip(70); 
   
  
  val leaflist = List(Leaf('e', 1), Leaf('t', 2),Leaf('x', 4));System.out.println("""leaflist  : List[patmat.Huffman.Leaf] = """ + $show(leaflist ));$skip(68); val res$12 = 
  List(Leaf('b',3))::List(makeCodeTree(Leaf('e', 1), Leaf('t', 2)));System.out.println("""res12: List[Product] = """ + $show(res$12));$skip(35); 
  
  val trees = combine(leaflist);System.out.println("""trees  : List[patmat.Huffman.CodeTree] = """ + $show(trees ));$skip(15); val res$13 = 
  trees.length;System.out.println("""res13: Int = """ + $show(res$13));$skip(48); 
  val untilS = until(singleton, combine)(trees);System.out.println("""untilS  : List[patmat.Huffman.CodeTree] = """ + $show(untilS ));$skip(79); 
  val chary = List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd');System.out.println("""chary  : List[Char] = """ + $show(chary ));$skip(96); 
                                                  
  val ly = makeOrderedLeafList(times(chary));System.out.println("""ly  : List[patmat.Huffman.Leaf] = """ + $show(ly ));$skip(84); 
                                                  
  val tt = createCodeTree(chary);System.out.println("""tt  : patmat.Huffman.CodeTree = """ + $show(tt ));$skip(29); 
  
  val comby = combine(ly);System.out.println("""comby  : List[patmat.Huffman.CodeTree] = """ + $show(comby ));$skip(94); 
                                                  
   val chl = List('h', 'e', 'l', 'l', 'o');System.out.println("""chl  : List[Char] = """ + $show(chl ));$skip(27); val res$14 = 
   
   createCodeTree(chl);System.out.println("""res14: patmat.Huffman.CodeTree = """ + $show(res$14));$skip(146); 
                                                  
                                                  
   val h1 = makeOrderedLeafList(times(chl));System.out.println("""h1  : List[patmat.Huffman.Leaf] = """ + $show(h1 ));$skip(30); 
   
   val comy = combine(h1);System.out.println("""comy  : List[patmat.Huffman.CodeTree] = """ + $show(comy ));$skip(185); val res$15 = 
 
                                                 
                                                  
                                                  
  until(singleton,combine)(ly);System.out.println("""res15: List[patmat.Huffman.CodeTree] = """ + $show(res$15));$skip(36); val res$16 = 
  
  ly.dropWhile(x=> x.weight < 2);System.out.println("""res16: List[patmat.Huffman.Leaf] = """ + $show(res$16));$skip(77); 
  
  
  var resultTree = createCodeTree( string2Chars("AAAAAAAABBBCDEFGH") );System.out.println("""resultTree  : patmat.Huffman.CodeTree = """ + $show(resultTree ));$skip(135); 
                                                  
                                                  
 val chars = List('a', 'b', 'c');System.out.println("""chars  : List[Char] = """ + $show(chars ));$skip(44); 
 val c3 = makeOrderedLeafList(times(chars));System.out.println("""c3  : List[patmat.Huffman.Leaf] = """ + $show(c3 ));$skip(13); val res$17 = 
 combine(c3);System.out.println("""res17: List[patmat.Huffman.CodeTree] = """ + $show(res$17));$skip(81); val res$18 = 
                                                  
 until(singleton,combine)(c3);System.out.println("""res18: List[patmat.Huffman.CodeTree] = """ + $show(res$18));$skip(85); 
                                                  
 val code = createCodeTree(chars);System.out.println("""code  : patmat.Huffman.CodeTree = """ + $show(code ));$skip(77); 
 val e1 = code match {
 	case f: Fork => f.chars
 	case l: Leaf => l.char
 };System.out.println("""e1  : Any = """ + $show(e1 ));$skip(34); val res$19 = 
 
 
 decode(code,List(0,0,0,1,1));System.out.println("""res19: List[Char] = """ + $show(res$19));$skip(35); val res$20 = 
 encode(code)(List('a', 'b', 'c'));System.out.println("""res20: List[patmat.Huffman.Bit] = """ + $show(res$20));$skip(15); val res$21 = 
 convert(code);System.out.println("""res21: patmat.Huffman.CodeTable = """ + $show(res$21));$skip(60); 
 val freqs = times(List('a', 'b', 'a', 'c', 'a', 'a', 'b'));System.out.println("""freqs  : List[(Char, Int)] = """ + $show(freqs ));$skip(37); val res$22 = 
 decode(t1, encode(t1)("ab".toList));System.out.println("""res22: List[Char] = """ + $show(res$22));$skip(72); val res$23 = 
 //decode(frenchCode, secret)
 
 quickEncode(code)(List('a', 'b', 'c'));System.out.println("""res23: List[patmat.Huffman.Bit] = """ + $show(res$23));$skip(89); 
 
 lazy val fibs: Stream[Int] = 0 #:: 1 #:: fibs.zip(fibs.tail).map { n => n._1 + n._2 };System.out.println("""fibs: => Stream[Int]""");$skip(31); 
 println((fibs take 8).toList)}
 
}
