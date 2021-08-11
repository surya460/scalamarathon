package scala.marathon

import java.util.Comparator

import scala.collection.mutable.ArrayBuffer
import scala.marathon.GrokkingKthLargestElem.Point

object GrokingKWayMerge extends App{
  case class ListNode (var value:Int,var next:ListNode=null) extends Ordered[ListNode] {
     this.value = value
    this.next = next

    override def compare(that: ListNode) = this.value.compareTo(that.value)
  }

  case class ListOrdering (var ele:Int,var i:Int,var lst:List[Int]) extends Ordered[ListOrdering] {

    this.ele = ele
    this.i = i
    this.lst = lst

    override def compare(that: ListOrdering) = this.ele.compareTo(that.ele)

  }



  def mergeList(lists:List[ListNode]):List[Int] = {

    import scala.collection.mutable.PriorityQueue

    var minHeap = PriorityQueue.empty[ListNode].reverse




    lists.foreach { x =>

      if (x != null)
        {
          minHeap.enqueue(x)

        }
    }

    //println(minHeap)

    var resultHead:ListNode = null

    var resultTail:ListNode = null
   // var output = List


   while (minHeap.length>0) {



      val n = minHeap.dequeue()


      if (resultHead==null) {

        resultHead= n
        resultTail = n

      } else {

        println(resultHead)

        //println(resultTail)
        //println(n)
        //println(resultTail.next)

        resultTail.next = n
        //println(resultTail.next)
        //println(resultTail)
        resultTail = resultTail.next
        //println(resultTail)
        //println(resultTail.next)
        println(resultHead)

      }

     if (n.next != null) {

       minHeap.enqueue(n.next)
     }



    }

    var result = resultHead
    var output  = List[Int]()

    while (result != null) {


      output = output ++ List(result.value)
      result = result.next


    }

    output

  }



  def kthSmallestNumbers(input:List[List[Int]],k:Int):Int = {

    var q = scala.collection.mutable.PriorityQueue.empty[ListOrdering].reverse

    for (i<- 0 to input.length-1){

      q.enqueue(new ListOrdering(input(i)(0),0,input(i)))


    }

    var done = false
    var count = 0
    var output = 0

    while(q.length > 0 ) {

      val e = q.dequeue()

      val l = e.lst
      val j = e.i
      val el = e.ele

      if (!done) {
        count += 1
        if (count == k) {

          done=true

          output = el

        }

        if (l.length > j + 1 ) {

          q.enqueue(new ListOrdering(l(j+1),j+1,l))


        }

      }



    }

    output

    //println(q.dequeue())
    //println(q.dequeue())

  }


  def smallestNumRange(input:List[List[Int]]):(Int,Int) = {

    var q = scala.collection.mutable.PriorityQueue.empty[ListOrdering].reverse

    var maxNum = -100000
    var start = 0
    var end = 100000


    for (i <- 0 to input.length-1) {

      q.enqueue(new ListOrdering(input(i)(0),0,input(i)))

      maxNum = scala.math.max(maxNum,input(i)(0))

    }

    while(q.length == input.length) {

      val e = q.dequeue()

      if (end - start > maxNum-e.ele) {

        start = e.ele
        end = maxNum
      }

      if (e.lst.length > e.i + 1 ) {

        q.enqueue(new ListOrdering(e.lst(e.i+1),e.i+1,e.lst))

        maxNum = scala.math.max(maxNum,e.lst(e.i+1))


      }


    }


    (start,end)

  }

  val l1 = new ListNode(2)
  l1.next = new ListNode(6)
  l1.next.next = new ListNode(8)

  val l2 = new ListNode(3)
  l2.next = new ListNode(6)
  l2.next.next = new ListNode(7)

  val l3 = new ListNode(1);
  l3.next = new ListNode(3);
  l3.next.next = new ListNode(4);

  //val result = mergeList(List(l1, l2, l3));

  //println(result)

  println(kthSmallestNumbers(List(List(2,6,8),List(3,6,7),List(1,3,4)),5))
  println(smallestNumRange(List(List(1,5,8),List(4,12),List(7,8,10))))




}
