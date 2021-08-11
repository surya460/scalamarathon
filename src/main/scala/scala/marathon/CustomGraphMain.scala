package scala.marathon

import scala.marathon.CustomGraph

object CustomGraphMain extends App {


val g = CustomGraph[String]()
.addEdges("London", "Lisbon")
.addEdges("Lisbon", "Madrid")
.addEdges("Madrid", "London")
.addEdges("Madrid", "Rome")
.addEdges("Rome", "London")
.addEdges("Paris", "Rome")

  println(g.edges)
  println(g.vertices)
  println(g.neighbours("Madrid"))
}

