package scala.marathon

object GrokkingLinkedList extends App {

  case class Node (_value:Int=0,_next:Node=null) {

    var value = _value

    var next = _next

    def getList(): String = {

      var output = ""

      var temp = this

      while (temp != null) {

        output +=   temp.value + " "

        temp = temp.next

      }

      output

    }

  }


  def reverse(head:Node) : Node = {

    var current = head
    var previous:Node = null

    while (current != null) {

      val next = current.next
      current.next = previous
      previous = current
      current = next


    }

    previous

  }

  def reverseSubList(head:Node,p:Int,q:Int) : Node = {

    var current =head
    var previous:Node = null

    var i = 0

    while (i<p-1) {

      previous = current
      current = current.next
      i += 1

    }

    var last_part_of_node = previous // previous = 1; current = 2

    var last_node_of_sub_list = current

    var x:Int = 0
    var next:Node = null
    while (current != null & x < q-p+1 ) {

      next = current.next //3

      current.next = previous //1

      previous = current //2

      current = next //3
      x +=1

    }

    if (last_part_of_node !=null) {
      last_part_of_node.next = previous
    } else {
      last_part_of_node = head
    }

    last_node_of_sub_list.next = current


    head

  }

  def reverseKSizedSubList(input:Node,k:Int):Node = {

    var head =input
    var done = false
    var current = head
    var previous:Node = null


    while (!done) {

      var last_node_of_sublist = current
      var last_part_of_node = previous

      var next:Node = null
      var i=0
      while (current != null & i < k) {

        next = current.next
        current.next = previous
        previous = current
        current = next

        i +=1


      }

      if (last_part_of_node !=null) {

        last_part_of_node.next = previous

      } else {

        head = previous
      }

      last_node_of_sublist.next = current

      if (current==null) {

        done = true
      }


      previous = last_node_of_sublist




    }

    head

  }



  var head:Node = new Node(2)

  head.next = new Node(4)

  head.next.next = new Node(6)

  head.next.next.next = new Node(8)

  head.next.next.next.next = new Node(10)

  //println(head.getList())
  //println(reverse(head).getList())
  var head1:Node = new Node(1)

  head1.next = new Node(2)

  head1.next.next = new Node(3)

  head1.next.next.next = new Node(4)

  head1.next.next.next.next = new Node(5)
  head1.next.next.next.next.next = new Node(6)
  head1.next.next.next.next.next.next = new Node(7)
  head1.next.next.next.next.next.next.next = new Node(8)

  //println(reverseSubList(head1,2,4).getList())

  println(reverseKSizedSubList(head1,3).getList())


}
