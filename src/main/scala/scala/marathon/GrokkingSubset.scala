package scala.marathon

import scala.collection.mutable.ArrayBuffer

case class paranthesisString(st:String,openCt:Int,closeCt:Int) {

  val str = this.st
  val openCount = this.openCt
  val closeCount = closeCt


}

object GrokkingSubset extends App {


  def subsets(input:List[Int]):Unit = {

    var output: List[List[Any]] = List(List.empty)

    //output = output ++ List(List(" "))

    //println(output.length)
    //println(output(1))

    //output.foreach(println)


   for (i<- 0 to input.length-1) {

      val currentEle = input(i)

      val n = output.size

      for (j <-  0 to n-1) {

        val element = output(j)
        val outputElement =element ++ List(currentEle)

        output = output ++ List(outputElement)

      }
    }
    println(output.toSet)
    //output = output + scala.collection.mutable.


  }




  //subsets(List(1,3,3))


  def stringPermutations(input:String):List[String]= {

    var outputList: List[String] = List(input)

    for (i <- 0 to input.length - 1) {

      val n = outputList.length

      if (!input(i).isDigit) {

        for (j <- 0 to n - 1) {

          var tempList = outputList(j).split("").toArray

          if (tempList(i) == tempList(i).toLowerCase) {

            tempList(i) = tempList(i).toUpperCase

          }
          else {
            tempList(i) = tempList(i).toLowerCase()

          }

          outputList = outputList ++ List(tempList.mkString(""))


        }


      }


    }


    outputList

  }
    def permutations(input:List[Int]):List[List[Any]]={

      val outputLen = input.length

      var q:scala.collection.mutable.Queue[List[Int]] = scala.collection.mutable.Queue(List.empty)
      var permutations: List[List[Any]] = List(List.empty)
      var output = List[List[Any]]()


      for (i<- 0 to input.length-1) {

        val currentElement = input(i)

        for (j <- 0 to permutations.length-1) {

          val oldElement = permutations(j)
          //println(oldElement.length)


          for (k <- 0 to oldElement.length){

            var newElement = oldElement

            newElement = oldElement.take(k) ++ List(currentElement) ++ oldElement.drop(k)
            //println(newElement)

            if (newElement.length == outputLen) {

              output = output ++ List(newElement)
            }
            else {

              permutations = permutations ++ List(newElement)
            }

          }



        }


      }
      output



    }

  def paranthesis(n:Int):List[Any] = {



    var q = scala.collection.mutable.Queue(new paranthesisString("",0,0))

    var output = List[Any]()


    while (q.length>0) {

      val element = q.dequeue()

      if (element.openCount==n && element.closeCount==n) {

        output = output ++ List(element.str)

      }
      else {

        if (element.openCount < n) {

          q.enqueue(new paranthesisString(element.str + '(', element.openCount + 1, element.closeCount))
        }

        if (element.openCount >element.closeCount) {

          q.enqueue(new paranthesisString(element.str + ')', element.openCount, element.closeCount + 1))
        }
      }

    }

    output
  }




  //println(stringPermutations("ab7c"))
  //println("abc".substring(0,0) + 'A' + "abc".substring(1))

  import scala.collection.mutable.Queue

  var q:scala.collection.mutable.Queue[List[Int]] = scala.collection.mutable.Queue(List.empty)


  q.enqueue(List(1))

  //println(q)

  val test = List(1,2,3,5)

  //println(test.take(0)++ List(4) ++ test.drop(0))

  //println(permutations(List(1,3,5)))

  println(paranthesis(3))






}
