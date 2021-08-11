package scala.marathon

import scala.collection.mutable

object GrokkingKthLargestElem  extends App {

  case class Point(x:Int=0,y:Int=0) extends Ordered[Point] {

    var this.x = x
    var this.y = y

    override def compare(that: Point) = this.x.compareTo(that.x)

  }

  import scala.collection.mutable.PriorityQueue



  def kLargestElem(input:Array[Int],k:Int):Array[Int] = {


    import scala.collection.mutable.PriorityQueue

    val q = PriorityQueue.empty[Int].reverse

    for (i<- 0 to k-1) {

      q.enqueue(input(i))
    }

    for(i<-k-1 to input.length-1) {

      if (q.head<input(i)) {
        q.dequeue()
        q.enqueue(input(i))

      }
    }


    q.toArray

  }

  def kSmallestElem(input:Array[Int],k:Int):Int = {

    import scala.collection.mutable.PriorityQueue

    val q = PriorityQueue.empty[Int]

    for (i<- 0 to k-1) {

      q.enqueue(input(i))
    }

    for (i<- k-1 to input.length-1) {

      if (q.head>input(i)) {

        q.dequeue()
        q.enqueue(input(i))


      }
    }
    println(q)
    q.head
  }

  def distanceFromOrigin(input:Point):Int = {

    (input.x*input.x) + (input.y * input.y)

  }

  def euclideanDistance(input:Array[Point],k:Int):Array[Point] = {

    import scala.collection.mutable.PriorityQueue

    val q = PriorityQueue.empty[Point]

    for (i <- 0 to k-1) {

      q.enqueue(input(i))
    }

    println(q)

    for (i<- k-1 to input.length-1) {

      println(input(i))
      println(distanceFromOrigin(input(i)))
      println(q.head)
      println(distanceFromOrigin(q.head))

      if (distanceFromOrigin(input(i)) < distanceFromOrigin(q.head)) {

        q.dequeue()

        q.enqueue(input(i))
      }


    }
    q.toArray



  }


  def minHeap(input:Array[Int]):Int = {

    import scala.collection.mutable.PriorityQueue

    val q = (PriorityQueue.empty[Int] ++ input).reverse
    var result = 0

    while(q.length>1) {

      val temp = q.dequeue() + q.dequeue()
      result += temp

      q.enqueue(temp)

    }

    result


  }

  def findTopKFrequentNums(input:Array[Int],k:Int):Array[Int] = {

    var m1 = scala.collection.mutable.Map[Int,Int]()

    for (i <- 0 to input.length-1) {

      if (!m1.contains(input(i))) {

        m1 = m1 ++ Map(input(i) -> 1)

      }
      else {

        m1(input(i)) += 1
      }
    }

    import scala.collection.mutable.PriorityQueue

    val q = PriorityQueue.empty[(Int,Int)].reverse

    m1.keys.foreach(x => {

      q.enqueue((m1(x),x))

      if (q.length>k) {

        q.dequeue()


      }

    }


    )

    import scala.collection.mutable.ArrayBuffer

    var output:ArrayBuffer[Int] = ArrayBuffer.empty

    for(i<- 0 to q.length-1) {

      output += q.dequeue()._2
    }


    output.toArray


  }


  def frequencySort(input:String):String = {

    import scala.collection.mutable.Map
    import scala.collection.mutable.PriorityQueue


    var m:Map[Char,Int] = Map.empty

    for (i<- 0 to input.length-1) {

      if (!m.contains(input(i))) {

        m = m ++ Map(input(i) -> 1)

      }
      else {

        m(input(i)) += 1
      }


    }

    val q = PriorityQueue.empty[(Int,Char)]

    m.keys.foreach( k =>

      q.enqueue((m(k),k))


    )

    var output:String = ""


    while(q.length>0) {

      val o = q.dequeue()

      for ( i <- 0 to o._1-1) {

        output += o._2
      }
    }
    output

  }




  //frequencySort("Programming")
  //println(frequencySort("abcbab"))


  //println(findTopKFrequentNums(Array(1, 3, 5, 12, 11, 12, 11),2).toList)
  //println(findTopKFrequentNums(Array(5, 12, 11, 3, 11),2).toList)



  //println(kLargestElem(Array(3, 1, 5, 12, 2, 11),3).toList)
  //println(kLargestElem(Array(5, 12, 11,-1,12),3).toList)

  //println(kSmallestElem(Array(5, 12, 11, -1,12),3))

  //println(euclideanDistance(Array(new Point(1, 3), new Point(3, 4), new Point(2, -1)),2).toList)
  //println(euclideanDistance(Array(new Point(1, 2), new Point(1, 3)),1).toList)

  //println(minHeap(Array(1,3,11,5)))


}
