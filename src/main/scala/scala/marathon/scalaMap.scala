package scala.marathon

object scalaMap extends App{

  val m1:Map[Int,String] = Map(1 -> "ABC",2 -> "CDE", 3 -> "EFG", 4 -> "GHI" )

  import scala._
  println(m1.keys.aggregate((0,0)) ((x,y) => (x._1 + y,x._2+1),
    (x,y) => (x._1+y._1,x._2+y._2)))

  val m2:Map[Int,String] = Map(1 -> "ABC",2 -> "CDE", 4 -> "GHI",3 -> "EFG",5->"GHI")

println(m2.getOrElse(6,"Not Found"))

  def firstRecurringCharacter(arr:Array[Int]) = {

    var m1 = scala.collection.mutable.Map[Int,Int]()



    for (i<- 0 to arr.length-1) {

      var done=false

      if (m1.contains(arr(i)) && !done) {done=true;println(arr(i))}
      else { m1 = m1 ++ Map(arr(i) -> 1)}
    }

  }

  println(firstRecurringCharacter(Array(1,2,1,4,5)))

  println(scala.collection.immutable.ListMap(1 -> "ABC",2 -> "CDE", 100 -> "RRR", 4 -> "GHI",3 -> "EFG",5->"GHI",100 -> "AAA"))
  println(Map(1 -> "ABC",2 -> "CDE", 100 -> "RRR", 4 -> "GHI",3 -> "EFG",5->"GHI"))

  import scala.collection.mutable.Stack

  var s = Stack[Int]()

  s.push(1)
  s.push(2)
  s.push(3)
  println(s.top)
  println(s.toList)
  s.pop()
  println(s.top)
  println(s.toList)
  println(s.isEmpty)
  println(s.size)


  import scala.collection.mutable.Queue

  var q = Queue[Int]()

  q.enqueue(1)
  q.enqueue(2)
  q.enqueue(3)
  println(q.front)
  println(q.toList)
  q.dequeue()
  println(q.front)
  println(q.isEmpty)
  println(q.size)
  println(q.clear)
  println(q.size)

  var input1 = "abc,cde,efg"
  var input2 = "ghi,ijk,klm"
  var tmp1 = input1.split(",")
  var tmp2 = input2.split(",")
  println(tmp1.intersect(tmp2).toString)


}
