package scala.marathon

/*abstract class customList[T]() {

   def head:T
   def tail:customList[T]
   def isEmpty:Boolean

  def length:Int
  def insert(data:T):customList[T]


}

case object EmptyList extends customList {

  override def isEmpty: Boolean = true

  override def length: Int = 0

  def head:Nothing = throw new NoSuchElementException("head of list is empty")
  def tail:customList[Nothing] = throw new NoSuchElementException("tail of list empty")

  override def insert(data: T): customList[T] = NonEmptyList(data,EmptyList)



}
case class NonEmptyList[T](hd:T,tl:customList[T]) extends customList[T]{

  def head = hd
  def tail = tl

  override def isEmpty: Boolean = false

  override def insert(data: T): customList[T] = {

  def insert(l:customList[T],data:T):customList[T] = {
    l match {

      case NonEmptyList(_,_) =>
    }

  }

    insert(this,data)
  }

  override def length:Int = {
    if (isEmpty) 0 else 1 + tail.length
  }


}


object listMain extends App {

  val ls1 = Nil
  val ls2 = ls1 :: 1

  println(ls1)

}*/