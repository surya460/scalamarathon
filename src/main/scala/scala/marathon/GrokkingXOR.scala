package scala.marathon

object GrokkingXOR extends App{


  def missingNumber(input:Array[Int]):Int = {

    val n = input.length+1

    var x1 = 1

    for (i <- 2 to n) {
      //println(x1)

      x1 = x1^i
    }
    //println(x1)

    var x2 = input(0)

    for ( j <- 1 to input.length-1) {

      //println(x2)

      x2 = x2^input(j)
    }
    //println(x2)

    x1^x2
  }

  def singleNumber(input:Array[Int]):Int = {

    var n =0

    for (i <- 0 to input.length-1) {

      //println(n)
      n ^= input(i)
    }

    //println(n)

    n


  }

  def doubleNumber(input:Array[Int]):List[Int] = {

    var m1 = scala.collection.mutable.Map[Int,Int]()

    for (i <- 0 to input.length-1) {

      if (m1.contains(input(i))) {

        m1 -= input(i)
      } else {

        m1 = m1 ++ Map(input(i) -> 1)
      }


    }

    m1.keys.toList


  }

  def compliment(input:Int):Int = {

    var bitcount = 0
    var num = input

    while (num>0) {

      bitcount +=1

      num = num >>1
    }

    val allbitset = scala.math.pow(2,bitcount)-1


    return input ^ allbitset.toInt


  }



  //println(missingNumber(Array(2,4,3)))

  //println(singleNumber(Array(1,4,2,1,3,2,3)))
  //println(singleNumber(Array(1, 4, 2, 1, 3, 5, 6, 2, 3, 5)))
  //println(doubleNumber(Array(1, 4, 2, 1, 3, 5, 6, 2, 3, 5)))

  //println(doubleNumber(Array(2,1,3,2)))

  //println(1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6 )

  println(compliment(10))






}
