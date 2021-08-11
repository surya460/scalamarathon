package scala.marathon

object bigONotation extends App {
  def performaceArray(input:Array[String]) ={

    val t0 = System.currentTimeMillis

    for (i <- 0 to input.length - 1)
    {
      if (input(i) == "nemo")
      {
        println("Found Nemo")
      }
    }
    val t1 = System.currentTimeMillis
    println("Time took for execution in secs ", t1-t0)
  }

  val input:Array[String] = Array("nemo")
  performaceArray(input)

  val arrayCombination: Array[Int] = Array(1,2,3,4,5)

  def logAllPairs(arrayCombination:Array[Int])= {
      arrayCombination.combinations(2).map(_.toList).foreach(println)
    arrayCombination.combinations(2).map(_.toList).map(x => x(0) +x(1)).foreach(println)
  }

  logAllPairs(arrayCombination)

  def logAllPairs2(arrayCombination:Array[Int]) = {
    for (i <- 0 to arrayCombination.length - 1)
      {
        for (j <- 0 to arrayCombination.length - 1)
          {
            println(Array(arrayCombination(i),arrayCombination(j)).toList)
          }
      }
  }

  //logAllPairs2(arrayCombination)

}
