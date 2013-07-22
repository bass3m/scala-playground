package forcomp
import Anagrams._

object testAnag {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  val tst = "helloworld";System.out.println("""tst  : String = """ + $show(tst ));$skip(140); 
  def occ(st: String) : List[(Char,Int)] =
  	(for {(c,clist) <- (st toLowerCase) groupBy identity } yield (c, clist length)).toList sorted;System.out.println("""occ: (st: String)List[(Char, Int)]""");$skip(49); 
  
 val wl = List("love","hate","hello","dummy");System.out.println("""wl  : List[String] = """ + $show(wl ));$skip(25); 
 val fl = wl flatMap occ;System.out.println("""fl  : List[(Char, Int)] = """ + $show(fl ));$skip(26); val res$0 = 
 wl.foldRight ("") (_++_);System.out.println("""res0: String = """ + $show(res$0));$skip(29); val res$1 = 
 occ ((wl flatten).toString);System.out.println("""res1: List[(Char, Int)] = """ + $show(res$1));$skip(14); val res$2 = 
 occ("hello");System.out.println("""res2: List[(Char, Int)] = """ + $show(res$2));$skip(60); 
// (for {c <- "hello" }
 val dicty = loadDictionary take 10;System.out.println("""dicty  : List[String] = """ + $show(dicty ));$skip(46); val res$3 = 
 Map('c'->2,'b'->4) equals Map('b'->4,'c'->2);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(113); 
 
 def occmap(st: String) : Map[Char,Int] =
  	for {(c,clist) <- st groupBy identity } yield c -> (clist length);System.out.println("""occmap: (st: String)Map[Char,Int]""");$skip(25); 
 val d = occmap("hello");System.out.println("""d  : Map[Char,Int] = """ + $show(d ));$skip(57); val res$4 = 
 //d keys
// dicty map occmap
 wordOccurrences("Helloh");System.out.println("""res4: forcomp.Anagrams.Occurrences = """ + $show(res$4));$skip(125); 
 //filterKeys (w=> (occmap("eat") keys) == w)
 //dicty groupBy occ
 val ml = List("eat","cat","ate","tat","tea") groupBy occ;System.out.println("""ml  : scala.collection.immutable.Map[List[(Char, Int)],List[String]] = """ + $show(ml ));$skip(118); val res$5 = 
// (List("eat","cat","ate","tat","tea") groupBy occ) keys
 ((List("eat","cat","ate","tat","tea") groupBy occ) values);System.out.println("""res5: Iterable[List[String]] = """ + $show(res$5));$skip(20); val res$6 = 
 ml.get(occ("ate"));System.out.println("""res6: Option[List[String]] = """ + $show(res$6));$skip(27); val res$7 = 
 
 wordAnagrams("zachary");System.out.println("""res7: List[forcomp.Anagrams.Word] = """ + $show(res$7));$skip(15); val res$8 = 
 
 occ("abab");System.out.println("""res8: List[(Char, Int)] = """ + $show(res$8));$skip(545); 
 
 //def combi(w: List[(Char,Int)]): List[List[(Char,Int)]] = {
 //		w match {
 //			case Nil => List()
 //			case (c,n) :: xs => (for { i <- 1 to n
 //																other <- combi(List(c,i)) } yield other) :: combi(xs)
 //		}
//	}
 def combi2(occurrences: Occurrences): List[Occurrences] = occurrences match {
    case List() => List(List())
    case occ :: occs =>
      for {
        occSub <- (0 to occ._2).map((occ._1,_)).toList
        occsCombination <- combi2(occs)
      } yield (occSub :: occsCombination).filter(x => x._2 != 0)
  };System.out.println("""combi2: (occurrences: forcomp.Anagrams.Occurrences)List[forcomp.Anagrams.Occurrences]""");$skip(449); 
 def combi4(occurrences: Occurrences): List[Occurrences] =
    //if (occurrences.isEmpty || occurrences == Nil) List(Nil)
    if (occurrences.isEmpty) List(List())
    else
      //(List() :: (for {
      (for {
        split <- (1 to occurrences.length).toList
        first <- (occurrences take split)
        rest <- combi4(occurrences drop split)
        word <- (1 to first._2) map (x => (first._1, x))
      } yield word :: rest).toSet.toList;System.out.println("""combi4: (occurrences: forcomp.Anagrams.Occurrences)List[forcomp.Anagrams.Occurrences]""");$skip(366); 
     // } yield node :: rest)).toSet.toList.sortWith((x, y) => x.length < y.length)
       
 def combi3(occurrences: Occurrences): List[Occurrences] = occurrences match {
    case (c,n) :: occs =>
      for {
        first <- (0 to n).map((c,_)).toList
        rest <- combi3(occs)
      } yield (first :: rest).filter(x => x._2 != 0)
    case _ => List(List())
  };System.out.println("""combi3: (occurrences: forcomp.Anagrams.Occurrences)List[forcomp.Anagrams.Occurrences]""");$skip(37); val res$9 = 
  
 combi3(List(('a', 3), ('b', 2)));System.out.println("""res9: List[forcomp.Anagrams.Occurrences] = """ + $show(res$9));$skip(217); 
 //  Example: the subsets of the occurrence list `List(('a', 2), ('b', 2))` are:
	def dumy(w: (Char,Int)) : List[(Char,Int)] = {
		for {
			i <- (0 to w._2).map((w._1,_))
			} yield i
			//} yield (w._1,i)
		}.toList;System.out.println("""dumy: (w: (Char, Int))List[(Char, Int)]""");$skip(16); val res$10 = 
		
	dumy('c',3);System.out.println("""res10: List[(Char, Int)] = """ + $show(res$10));$skip(33); 
	val dfd = List(('a',2),('b',2));System.out.println("""dfd  : List[(Char, Int)] = """ + $show(dfd ));$skip(21); 
	val dfm = dfd.toMap;System.out.println("""dfm  : scala.collection.immutable.Map[Char,Int] = """ + $show(dfm ));$skip(42); 
	val dfd2 = List(('a',3),('c',9),('z',3));System.out.println("""dfd2  : List[(Char, Int)] = """ + $show(dfd2 ));$skip(23); 
	val dfm1 = dfd2.toMap;System.out.println("""dfm1  : scala.collection.immutable.Map[Char,Int] = """ + $show(dfm1 ));$skip(11); val res$11 = 
	dfm1('c');System.out.println("""res11: Int = """ + $show(res$11));$skip(23); val res$12 = 
	dfm1 updated ('c',10);System.out.println("""res12: scala.collection.immutable.Map[Char,Int] = """ + $show(res$12));$skip(13); val res$13 = 
	dfm ++ dfm1;System.out.println("""res13: scala.collection.immutable.Map[Char,Int] = """ + $show(res$13));$skip(14); val res$14 = 
  dfm1 ++ dfm;System.out.println("""res14: scala.collection.immutable.Map[Char,Int] = """ + $show(res$14));$skip(12); val res$15 = 
	dfm.toList;System.out.println("""res15: List[(Char, Int)] = """ + $show(res$15));$skip(129); val res$16 = 
	//dfm /: ((acc,e)=> acc updated('a', (e apply 'a') + 10))
	
	(for {
		(c,n) <- dfd
		num <- 1 to n
	} yield dumy(c,num)).toList;System.out.println("""res16: List[List[(Char, Int)]] = """ + $show(res$16));$skip(314); 
	def suby(x: Occurrences, y: Occurrences): Occurrences =
		//y.toMap.foldLeft(x.toMap)((a: Map[Char, Int], kv: (Char, Int)) => a.updated(kv._1, a(kv._1) - kv._2)).filter(x => x._2 > 0).toList.sorted
  	y.toMap.foldLeft(x.toMap)((acc, e) => acc.updated(e._1, acc(e._1) - e._2)).filter(x => x._2 != 0).toList.sorted;System.out.println("""suby: (x: forcomp.Anagrams.Occurrences, y: forcomp.Anagrams.Occurrences)forcomp.Anagrams.Occurrences""");$skip(286); 
  
  def sub1(x: Occurrences, y: Occurrences): Occurrences =
  	y match {
  		//case (c,n)::ys => sub1((x.toMap /:)
  								//(e => if (e contains c) x updated (c,n - 1) ) ,
  		//						((acc: Map[Char,Int],e: (Char,Int)) => println e._2).toList,
  		//						ys)
  		case _ => x
  	};System.out.println("""sub1: (x: forcomp.Anagrams.Occurrences, y: forcomp.Anagrams.Occurrences)forcomp.Anagrams.Occurrences""");$skip(72); val res$17 = 
  	
  suby(List(('a', 1), ('d', 1), ('l', 1), ('r', 2)),List(('r', 1)));System.out.println("""res17: forcomp.Anagrams.Occurrences = """ + $show(res$17))}
		//for {
		//	xocc <- x
		//	yocc <- y
			
		//} yield x diff y
}
