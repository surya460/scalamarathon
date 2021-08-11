package scala.marathon

object bigO extends App{

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


}
