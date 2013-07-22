import objsets._
//import common._
import TweetReader._

object TestObjsets {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(121); 
  println("Welcome to the Scala worksheet");$skip(80); 
  val google = List("android", "Android", "galaxy", "Galaxy", "nexus", "Nexus");System.out.println("""google  : List[String] = """ + $show(google ));$skip(69); 
  val apple = List("ios", "iOS", "iphone", "iPhone", "ipad", "iPad");System.out.println("""apple  : List[String] = """ + $show(apple ));$skip(25); val res$0 = 
  //
  "test".capitalize;System.out.println("""res0: String = """ + $show(res$0));$skip(21); val res$1 = 
  "test".toUpperCase;System.out.println("""res1: String = """ + $show(res$1));$skip(39); val res$2 = 
  apple.map(x=>x.toUpperCase).distinct;System.out.println("""res2: List[String] = """ + $show(res$2));$skip(79); val res$3 = 
  TweetReader.allTweets.filter(tw=> google.exists(txt=>txt.contains(tw.text)));System.out.println("""res3: objsets.TweetSet = """ + $show(res$3))}
}
