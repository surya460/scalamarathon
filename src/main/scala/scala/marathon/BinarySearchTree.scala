package scala.marathon

import scala.marathon

abstract class BinarySearchTree {

  def isEmpty: Boolean
  def isValid: Boolean

  def insert(x:Int):BinarySearchTree
  def contains(x:Int):Boolean

  //def breadthFirstSearch[Node](x:Node,f:Node => Queue[Node]):Stream[Node]

}

case object EmptyTree extends BinarySearchTree {

  override def isEmpty: Boolean = true
  override def isValid: Boolean = true

  override def contains(x: Int): Boolean = false

  override def toString: String = "."

  //override def breadthFirstSearch[Node](x: Node,f:Node => Queue[Node]): Stream[Node] = Stream.empty

  def insert(data:Int): BinarySearchTree = NonEmptyTree(data,EmptyTree,EmptyTree)
}

case class NonEmptyTree(data:Int,left:BinarySearchTree,right: BinarySearchTree) extends BinarySearchTree{

  override def isEmpty: Boolean = false

  override def isValid: Boolean = true


  override def insert(data:Int): BinarySearchTree = {

    def insert(bs:BinarySearchTree,data: Int):BinarySearchTree = bs match {

      case NonEmptyTree(t,l,r) if (t > data) => NonEmptyTree(t,insert(l,data),r)
      case NonEmptyTree(t,l,r) if (t < data) => NonEmptyTree(t,l,insert(r,data))
      case EmptyTree => bs insert data
      case _ => bs

    }

    insert(this,data)
  }

  override def contains(data:Int): Boolean = {

    def contains(bs:BinarySearchTree,data: Int) : Boolean = {
      bs match {

        case NonEmptyTree(t,l,r) if (data == t)  => true
        case NonEmptyTree(t,l,r) if (t>data) => contains(l,data)
        case NonEmptyTree(t,l,r) if (t<data) => contains(r,data)
        case _ => false

      }

    }

    contains(this,data)
  }

  override def toString: String = "{" + left + data + right + "}"

 /* import scala.collection.immutable.Queue

  def breadthFirstSearch[Node](node: Node, f: Node => scala.collection.immutable.Queue[Node]): Stream[Node] = {
    def recurse(q: scala.collection.immutable.Queue[Node]): Stream[Node] = {
      if (q.isEmpty) {
        Stream.Empty
      } else {
        val (node, tail) = q.dequeue
        node #:: recurse(tail ++ f(node))
      }
    }

    node #:: recurse(Queue.empty ++ f(node))
  }*/
}

object BSTMain extends App {

  val BS1 = EmptyTree

  val BS2 = BS1 insert(1)

  val BS3 = BS2 insert(2)
  val BS4 = BS3 insert(3)

  //BS4.breadthFirstSearch(1, f = BS4 ) find(_ == 16)



  //val BS2 = BS1 NonEmptyTree.insert 1

  //println(BS4)

  //println(BS4 contains(2))
}