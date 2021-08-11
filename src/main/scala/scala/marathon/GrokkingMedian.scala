package scala.marathon

import scala.collection.mutable.ArrayBuffer

class GrokkingMedian {

  import scala.collection.mutable.PriorityQueue

  var minHeap = PriorityQueue.empty[Int].reverse
  var maxHeap = PriorityQueue.empty[Int]


  def insertEle(n: Int): Unit = {

    if (maxHeap.length == 0 || maxHeap.head >= n) {

      maxHeap.enqueue(n)
    }
    else {

      minHeap.enqueue(n)
    }

    if (maxHeap.length > minHeap.length + 1) {

      minHeap.enqueue(maxHeap.dequeue())
    }
    else if (maxHeap.length < minHeap.length) {

      maxHeap.enqueue(minHeap.dequeue())
    }

  }

  def findMedian(): Double = {

    if (maxHeap.length == minHeap.length) {

      maxHeap.head / 2.0 + minHeap.head / 2.0
    }
    else {
      maxHeap.head

    }
  }

  def slidingMedian(input: Array[Int], s: Int): Array[Double] = {

    var output = scala.collection.mutable.ArrayBuffer[Double]()


    for (i <- 0 to input.length - 1) {


      if (maxHeap.length == 0 || (input(i) <= maxHeap.head)) {

        maxHeap.enqueue(input(i))
      }
      else {
        minHeap.enqueue(input(i))
      }

      if (maxHeap.length > minHeap.length + 1) {

        minHeap.enqueue(maxHeap.dequeue())

      }
      if (minHeap.length > maxHeap.length) {

        maxHeap.enqueue(minHeap.dequeue())
      }


      if (i - s + 1 >= 0) {

        if (maxHeap.length == minHeap.length) {

          output += maxHeap.head / 2.0 + minHeap.head / 2.0
        }
        else {
          output += maxHeap.head

        }




      if (input(i - s + 1) <= maxHeap.head) {

        var tempQueue = scala.collection.mutable.PriorityQueue[Int]()


        while (maxHeap.length > 0) {

          if (maxHeap.head == input(i - s + 1)) {

            maxHeap.dequeue()
          }
          else {
            tempQueue.enqueue(maxHeap.dequeue())

          }

        }
        maxHeap = tempQueue
        //maxHeap.foreach(x => if (x != input(i-s+1)) tempQueue.enqueue(x))
        //maxHeap.dequeue()


      }
      else {

        var tempQueue = scala.collection.mutable.PriorityQueue[Int]().reverse

        while (minHeap.length > 0) {

          if (minHeap.head == input(i - s + 1)) {

            minHeap.dequeue()
          }
          else {
            tempQueue.enqueue(minHeap.dequeue())

          }

        }
        minHeap = tempQueue
      }


    }

    }

    output.toArray


  }

  def maximizeCapital(capital:List[Int],profit:List[Int],numberOfProj:Int,initialCapital:Int): Unit = {

    var outputQueue= scala.collection.mutable.PriorityQueue[Int]()

    val capProf:Map[Int,Int] = (capital zip profit).toMap

    var cap = initialCapital

    var output = 0



    var x=1

    while(x <= numberOfProj ) {

      if (capProf.contains(cap)){


        //println(cap)

        cap = cap + capProf(cap) //2
       // println(cap)
        output =  cap
        println(output)

        x=x+1
      }

    }

    output

    //println(capProf)

  }


  def maximizeCapitalQueue(capital:List[Int],profit:List[Int],numberOfProj:Int,initialCapital:Int): Int = {

    var capitalQueue= scala.collection.mutable.PriorityQueue[(Int,Int)]().reverse
    var profitQueue= scala.collection.mutable.PriorityQueue[(Int,Int)]()
    var maxProfit = initialCapital

    //println(capital(0))

    for (i<-0 to capital.length-1) {

      capitalQueue.enqueue((capital(i),i))

    }
    println(capitalQueue)

    /*for (i <- 0 to numberOfProj-1) {



      while(capitalQueue.length>0 && capitalQueue.head._1 <= maxProfit ) {


        val (capital,index) = capitalQueue.dequeue()

        println("Index is:",i)

        profitQueue.enqueue((profit(i),i))



      }*/

    var i=0

    while (i <= numberOfProj) {



      while(capitalQueue.length>0 && capitalQueue.head._1 <= maxProfit ) {


        val (capital,index) = capitalQueue.dequeue()

        println("Index is:",i)

        profitQueue.enqueue((profit(i),i))

        i=i+1


      }

      println(profitQueue)

      println("Before Sum:" , maxProfit)

      maxProfit = maxProfit + profitQueue.dequeue()._1

      println("After Sum:" , maxProfit)


    }

    maxProfit


  }

}

object GrokkingMedian{

  def main(args:Array[String]) = {

    val output = new GrokkingMedian()

    /*output.insertEle(3)
    output.insertEle(1)
    println(output.findMedian())
    output.insertEle(5)
    println(output.findMedian())
    output.insertEle(4)
    println(output.findMedian())*/

    /*val slidingMedian = new GrokkingMedian()

    val op1 = slidingMedian.slidingMedian(Array(1, 2, -1, 3, 5),2)
    op1.toList.foreach(println)
*/
    //println(scala.collection.mutable.PriorityQueue(2,1,5,6))


    //output.maximizeCapital(List(0,1,2,3),List(1,2,3,5),3,0)
    //println(output.maximizeCapitalQueue(List(0,1,2,3),List(1,2,3,5),3,0))
    println(output.maximizeCapitalQueue(List(0,1,2),List(1,2,3),2,1))



  }


}
