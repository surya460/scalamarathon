package scala.marathon


case class LinkedList[T](){

  var head:Node[T] = null

  def push(data:T) ={

    head match {

      case null => head = new Node[T](data,null);
      case _ => {
        var last:Node[T] = head
        println("value of head is: " + last)
        //println(last)
        while (last.next != null){
          last = last.next
          //println(last)
        }
        last.next = new Node[T](data,null)

      }
    }
  }

  def prepend(data:T) = {

    val tempHeadNode:Node[T] = new Node(data,head)
    head = tempHeadNode

  }
/*1,2,3,4;delete(3)
  1
  currentNode.data != deleteItem
  previousNode = 1,2,3,4
  currentNode = 2,3,4
  2
  currentNode.data != deleteItem
  previousNode = 2,3,4
  currentNode = 3,4
  3
  currentNode.data = deleteItem
  currentNode.next != previousNode.next
  previousNode.next = 4*/


  def delete(deleteItem:T) = {

    var currentNode = head
    var previousNode = head
    var done = false

    while (head != null && !done)
      {
    if (currentNode.data.equals(deleteItem))
      {
        if (currentNode.next == previousNode.next)
          {
            head = currentNode.next
            done = true

          }
        else
          {
            currentNode.next = previousNode.next
          }
      }
        else
      {
        previousNode = currentNode
        currentNode = currentNode.next
      }

      }
  }

  def reverse() = {

    var currentNode:Node[T] = head
    var previousNode:Node[T] = null
    var next:Node[T] = null

    while (currentNode != null)

      {
        println(currentNode)
        next = currentNode.next
        currentNode.next = previousNode
        previousNode = currentNode
        println(previousNode)
        currentNode = next
      }

    head = previousNode


  }

/*
  1,2,3,4 => head=1,2,3,4; next = 2,3,4; currentNode.next=null;previousNode = 1,null; currentNode = 2,3,4
                           next = 3,4; currentNode.next=1,null; previousNode = 2,3,4; currentNode=3,4


   */

  def print() = {
    if (head != null) { head.printList() }
    println()
  }

}




sealed case class Node[T](var data:T,var next:Node[T]){

  def getData(): T = this.data;

  def getNext():Node[T] = this.next;

  def printList() :Unit = {

    print(data)
    if (next != null)
      {
        print(",")
        next.printList()
      }
  }
}



object Main extends App {

  var list: LinkedList[Int] =  LinkedList()
  list.push(1);
  list.push(2);
  list.push(3);
  list.push(4);
  list.print()
  //list.prepend(0)
  //list.print()
  list.delete(1)
  list.print()
  list.reverse()
  list.print()

}




