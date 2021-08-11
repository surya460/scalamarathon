package scala.marathon

import scala.collection.mutable.ArrayBuffer

object GrokkingCyclicSort extends App {

/*  def cyclicSort(input:Array[Int]):Array[Int] = {


    def cyclicSort(input:Array[Int],output:Array[Int]):Array[Int] = {

      input match {

        case Array(a,b,rest @_*) =>
      }
    }

    cyclicSort(input,Array.empty)
  }*/


  def cyclicSort(input:Array[Int]):Array[Int] = {


    var i =0
    while (i<input.length) {

      val j = input(i)-1

      if (input(j) != input(i)) {

        val temp = input(i)
        input(i) = input(j)
        input(j) = temp
      }
      i +=1
    }
    input

  }

  //println(cyclicSort(Array(3,1,5,4,2)).toList)
  //println(cyclicSort(Array(2,6,4,3,1,5)).toList)

  def missingNumber(input:Array[Int]):Int = {

    var i = 0
    var output = -1

    while (i<input.length) {

      val j = input(i)

      if (input(i)< input.length && input(i) != input(j)) {

        var temp = input(i)
        input(i) = input(j)
        input(j) = temp
      }
      i+=1
    }

    for (i <- 0 to input.length-1) {

      if (i != input(i)-1) {
        output = input(i)-1
      }
    }

    output
  }

  //println(missingNumber(Array(4,0,3,1)))


  def missingNumbers(input:Array[Int]):Array[Int] = {

    var i = 0
    var output:Array[Int] = Array.empty

    while (i<input.length) {

      val j = input(i)-1

      if (input(i) != input(j)) {

        val temp = input(i)
        input(i) = input(j)
        input(j) = temp
      }
      i+=1
    }


    for (i <- 0 to input.length-1) {

      if (input(i) != i+1) {
        output = output ++ Array(i+1)
      }
      }

    output


  }

  //println(missingNumbers(Array(2, 3, 1, 8, 2, 3, 5, 1)).toList)


  def duplicateNumber(input:Array[Int]):Int = {

    var i = 0
    var output = -1

    while (i<input.length) {

      val j = input(i)-1

      if (input(i) != input(j)) {

        val temp = input(i)
        input(i) = input(j)
        input(j) = temp
      }
      i +=1
    }

    println(input.toList)

    for (i<- 0 to input.length-1) {

      if (input(i) != i+1){
        output = input(i)
      }
    }

    output

  }

  //println(duplicateNumber(Array(1,4,4,3,2)))


  def missingNumber2(input:Array[Int]):Array[Int] = {

    val n = input.length
    var i=0

    while (i<n) {

      val j = input(i)-1

      if (input(i)!=input(j)) {

        input(i) = input(i) +input(j)
        input(j) = input(i) - input(j)
        input(i) = input(i) - input(j)

        /*val temp = input(i)

        input(i)=input(j)
        input(j)=temp*/
      } else {

        i +=1
      }


    }

    var output:Array[Int] = Array.empty

    for (i<- 0 to n-1) {

      if (i != input(i)-1) {

        output = output ++ Array(i)
      }

    }

    output

  }

  //println(missingNumber2(Array(2,4,1,2)).toList)

  def missingAndDup(input:Array[Int]):Int = {

    val n = input.length
    var i=0
    var output:Array[Int] = Array.empty

    while (i<n) {

      if (input(i) != i+1) {

        val j = input(i)-1

        if (input(i) !=input(j)) {

          input(i) = input(i) + input(j)
          input(j) = input(i) - input(j)
          input(i) = input(i) - input(j)
        } else {

          return input(i)
        }

      } else {

        i +=1
      }


    }

    return -1


  }

  println("output")

  println(missingAndDup(Array(2,4,1,4,4)))
}
