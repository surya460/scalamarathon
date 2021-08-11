package scala.marathon

case class Stack[T]() {

  var head:StackNode[T] = null

  def push (data:T) = {

    head match {

      case null => head = new StackNode[T](data,null)
      case _ => var last:StackNode[T]=head

        if (last.next !=null)
          {
            last = last.next
          }
        last.next = new StackNode(data,null)
    }

  }

  def print() = {

    if (head!=null) head.printList()
    println()
  }

  def pop() = {

    head = head.next


  }

  def top():Unit = {


    println(head.data)


  }

}

sealed case class StackNode[T](var data:T,var next:StackNode[T]) {

  def getData = this.data
  def getNext = this.next
  def printList():Unit = {

    print(data)
    if (next != null){
      print(",")
      next.printList()

    }

  }

}

object StackMain extends App {

  val stack = new Stack[Int]()
  stack.push(1)
  stack.push(2)
  stack.push(3)
  stack.print()
  stack.pop()
  stack.pop()
  stack.print()
  stack.top()
}
