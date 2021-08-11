package scala.marathon

object GrokkingfastAndSlowPointers extends App {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

  def hasCycle(input: ListNode) : Boolean = {

    var fast = input
    var slow = input
    var output = false



    while (fast != null && fast.next !=null && !output) {


      /*println(fast)
      println(slow.toString)
      println(fast.next.toString)*/

      fast = fast.next.next
      slow = slow.next


      if (fast == slow)
        {

          output=true

        }

      }

    output

    }



  def startOfCycle(input:ListNode): Int = {

    var fast = input
    var slow = input
    var output = false
    var lengthOfCycle = -1


    while (fast != null && fast.next != null & !output) {

      fast = fast.next.next
      slow = slow.next

      if (slow == fast) {

        output = true
        lengthOfCycle = findLengthOfCycle(slow)
      }



    }

    if (lengthOfCycle != -1) {
      return(findStartOfCycle(slow,fast,lengthOfCycle))

    }
    else { -1 }



  }

  def findLengthOfCycle(slow:ListNode):Int = {

    var input = slow
    var lengthOfCycle = 0

    while (input != slow) {

      input = input.next

      lengthOfCycle +=1
    }

    lengthOfCycle
  }

  def findStartOfCycle(s:ListNode,f:ListNode,l:Int): Int = {

    var slow = s
    var fast = f
    var length = l

    while (length>0) {

      fast=fast.next
      length -=1
    }

    while (fast != slow){

      slow=slow.next
      fast = fast.next
    }

    fast.x

  }

  def happNumber(input:Int):Boolean = {


    var slow = input
    var fast = input
    var done = false

    while (done !=true) {

      slow = sumOfSquares(slow)
      fast = sumOfSquares(sumOfSquares(fast))

      if (slow == fast) {
        done=true

      }
    }

    if (done == true && slow ==1) {
      true
    } else
      {
        false

      }

  }



  def sumOfSquares(input:Int) : Int = {



    var num=input
    var output = 0

      while (num>0) {

        val i = num % 10

        output += i*i
        num = Math.round(num/10)


    }
    output


  }

  def middleOfLinkedList(input:ListNode): Int = {

    var pointer = input
    var length = 1

    while (pointer!=null && pointer.next!=null) {

      pointer = pointer.next
      length += 1
    }

    length/2 + 1
  }

  def middleOfLinkedListFS(input:ListNode):Int = {

    var fast = input
    var slow = input
    var done = false

    while (fast != null && fast.next !=null && !done) {

      fast = fast.next.next
      slow = slow.next
      if (fast == slow) {

        done = true

      }
    }
    slow.x
  }



  var l2 = new ListNode(1)
  l2.next = new ListNode(2)
  l2.next.next = new ListNode(3)
  l2.next.next.next = new ListNode(4)
  l2.next.next.next.next = new ListNode(5)
  l2.next.next.next.next.next = new ListNode(6)
  //println(hasCycle(l2))
  l2.next.next.next.next.next.next = l2.next.next


  //println(hasCycle(l2))
  //println(startOfCycle(l2))
  //println(sumOfSquares(13))

  //println(happNumber(23))


  var l3 = new ListNode(1)
  l3.next = new ListNode(2)
  l3.next.next = new ListNode(3)
  l3.next.next.next = new ListNode(4)
  l3.next.next.next.next = new ListNode(5)
  l3.next.next.next.next.next = new ListNode(6)
  l3.next.next.next.next.next.next = new ListNode(7)

  //println(middleOfLinkedList(l3))

  //println(middleOfLinkedListFS(l3))






}
