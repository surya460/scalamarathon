package scala.marathon

case class Queue[T]() {

  var head:QueueNode[T]=null

  /*def enqueue(data:T) = {



  }
*/

}

sealed case class QueueNode[T](data:T,next:QueueNode[T]) {

  def getData = this.data
  def getNextNode = this.next
  def printQueue():Unit = {

    print(data)
    if (next !=null)
      println(",")
      next.printQueue()

  }



}
