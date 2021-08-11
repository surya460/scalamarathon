package scala.marathon

object AlgorithmsRecursion extends App{

  def factorialRecursion(n:Int):Int = {


    n match {

      case n if (n==0) => 1
      case n if (n>0) => n*factorialRecursion(n-1)

    }
  }

  //println(factorialRecursion(0))


  def factorialIteration(n:Int):Int={
    var y =1
    for (x <- 1 to n)
      {
        y = y*x
      }
    y
  }

  //println(factorialIteration((5)))

  def fibonacciRecursion(n:Int):Int = {

    def fibonacciRecursion(pprev:Int,prev:Int,n:Int):Int ={

      n match {

        case 0 => pprev

        case _ => fibonacciRecursion(prev,prev+pprev,n-1)

      }
    }

    fibonacciRecursion(0,1,n)
  }

  //println(fibonacciRecursion(5))


 def fibonacciIteration(n:Int):Int = {

    var inputArray = Array(0,1)

    for (x<- 2 to n) {

      inputArray = inputArray ++ Array(inputArray(x-2) + inputArray(x-1))


    }
   inputArray(n)
  }

  //println(fibonacciIteration((6)))

  def reverseOfAStringRecursion(s:String):List[Any] = {


    s.toList match {

      case head :: tail => reverseOfAStringRecursion(tail.mkString("")) ++ List(head)
      case head :: Nil => List(head)
      case Nil => Nil

    }


  }

  println(reverseOfAStringRecursion("Hello").mkString(""))



}
