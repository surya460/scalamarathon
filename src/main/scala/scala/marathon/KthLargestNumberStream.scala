package scala.marathon

case class KthLargestNumStream(q:Array[Int],k:Int){

  var this.q = q
  var this.k = k
  import scala.collection.mutable.PriorityQueue


  val output = PriorityQueue.empty[Int].reverse

  q.foreach( x =>

    add(x)
  )






  def add(x:Int):Int = {

    output.enqueue(x)


    while (output.length > k  ) {

      output.dequeue()
    }

    println(output)
    output.head



  }



}

//var kthLargestNumber = new KthLargestNumStream(Array(3, 1, 5, 12, 2, 11), 4)



object KthStream {

  def main (args:Array[String]) {

    val kthLargestNumber = new KthLargestNumStream(Array(3, 1, 5, 12, 2, 11), 4)

    println(kthLargestNumber.add(6))
    println(kthLargestNumber.add(13))
  }
}





