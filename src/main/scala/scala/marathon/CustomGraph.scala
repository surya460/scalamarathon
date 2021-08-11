package scala.marathon

 trait CustomGraph[T] {

   def edges:List[(T,T)]
   def vertices: List[T]
   def addEdges(a:T,b:T):CustomGraph[T]
   def neighbours(a:T): List[T]

}

case class DirectedCustomGraph[T](adjacentList: Map[T,List[T]]) extends CustomGraph[T] {


  override def vertices: List[T] = adjacentList.keys.toList

  override def edges: List[(T, T)] = adjacentList.toList.flatMap{ case(a,n) => n.map(x => (a,x)) }

  override def addEdges(a: T, b: T): CustomGraph[T] = {

    val aCustomGraph = b +: neighbours(a)

    new DirectedCustomGraph (adjacentList + (a -> aCustomGraph))
  }

  override def neighbours(a:T): List[T] = adjacentList.getOrElse(a,Nil)
}


/*case class AdjacentCustomGraph[T](adjacentList:Map[T,List[T]]) extends CustomGraph[T] {

  override def edges: List[(T, T)] = adjacentList.toList.flatMap{case(a,b) => b.map(n => (a,n))}

  override def addEdges(a: T, b: T): CustomGraph[T] = {

  }

}*/

object CustomGraph {
  def apply[T](adjList:Map[T, List[T]]): CustomGraph[T] = new DirectedCustomGraph(adjList)

  def apply[T](): CustomGraph[T] = new DirectedCustomGraph(Map[T, List[T]]())
}