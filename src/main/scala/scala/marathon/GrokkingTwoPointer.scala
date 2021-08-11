package scala.marathon

import com.sun.prism.impl.Disposer.Target

import scala.collection.mutable.ArrayBuffer

object GrokkingTwoPointer extends App{

  def pairWithTargetSum(input:Array[Int],target:Int):Array[Int]={



    var left = 0
    var right = input.length-1


    while (left < right) {

      if (input(left) + input(right) == target) {

        return Array(left,right)


      }

      if (input(left) + input(right) < target) {

        left += 1
      } else if (input(left) + input(right) > target){

        right -=1
      }
    }
    return Array(-1,-1)

  }


  //println(pairWithTargetSum(Array(2,5,9,11),11).toList)

  def removeDuplicates(input:Array[Int]):Int = {

    var i=1
    var nonDuplicate =1

    while (i<input.length) {

      if (input(nonDuplicate-1) != input(i)) {

        input(nonDuplicate) = input(i)


        nonDuplicate +=1

      }

      i+=1
    }

    nonDuplicate



  }

  //println(removeDuplicates(Array(2, 3, 3, 3, 6, 9, 9)))

  def sortedArray(input:Array[Int]):Array[Int] = {

    input.map(x => x*x).sorted
  }

  //println(sortedArray(Array(-2,-1,0,2,3)).toList)
  //println(Array.fill(5)(0).toList)

  def squaringSortedArray(input:Array[Int]):Array[Int] = {

    var output = Array.fill(input.length)(0)
    var left = 0
    var right = input.length-1
    var maxEle = input.length-1

    while(left<right) {

      if ((input(left)*input(left)) >  (input(right)*input(right))) {

        output(maxEle) = input(left)*input(left)
        maxEle -= 1
        left +=1
      } else {

        output(maxEle) = input(right) * input(right)
        maxEle -=1
        right -=1
      }
    }



    output
  }


  //println(squaringSortedArray(Array(-2,-1,0,2,3)).toList)
  //println(squaringSortedArray(Array(-3,-1,0,1,2)).toList)

  /*def tripletSumToZero(input:Array[Int]):ArrayBuffer[ArrayBuffer[Int]] = {


    import scala.collection.mutable.ArrayBuffer
    val sortedInput = input.sorted

    var output: ArrayBuffer[ArrayBuffer[Int]] = ArrayBuffer.empty

    for (i <- 0 to input.length - 1) {

      while (i > 0 && input(i) != input(i - 1)) {
        tripletSearch(-input(i), input, i+1)
      }
    }


    def tripletSearch(target: Int, sortedInput: Array[Int], left:Int): ArrayBuffer[ArrayBuffer[Int]] = {

      var l =left

      var r = sortedInput.length-1

      while(l < r) {

        if (sortedInput(l) + sortedInput(r) ==target) {

          output = output ++ ArrayBuffer(ArrayBuffer(target,l,r))

          l +=1
          r -=1
          while (l<r && sortedInput(l)==sortedInput(l-1)){

            l+=1
          }
          while (l<r && sortedInput(r) == sortedInput(r+1)){
            r -=1
          }

        } else if ( sortedInput(l) + sortedInput(r) < target) {

          l +=1

          } else {
          r +=1
        }
        }

      output

      }




    output

  }

  println(tripletSumToZero(Array(-3, 0, 1, 2, -1, 1, -2)))*/

  def tripletSumToZero(unsortedinput:List[Int]):Set[List[Int]] ={

    val input = unsortedinput.sorted

    var output:Set[List[Int]] = Set.empty

    for (i<- 0 to input.length-1) {

      if (! (i>0 && input(i) == input(i-1))) {

        var left = i+1
        var target = -input(i)
        var right = input.length-1


            while(left<right) {



          if (input(left)+input(right) == target) {


            output = output ++ Set(List(-target,input(left),input(right)))

            left += 1
            right -=1

            while (left<right && input(left) == input(left-1)){

              left +=1
            }
            while (left<right && input(right) == input(right+1)) {

              right -=1
            }


          } else if (input(left) + input(right) < target){

            left += 1
          } else {
            right -=1
          }
        }


      }



    }


    output
  }

  //println(tripletSumToZero(List(-3, 0, 1, 2, -1, 1, -2)))


  def tripletSumCloseToTarget(input:List[Int],sum:Int):Int = {

    val inputS = input.sorted
    var minSum = sum
    var done = false

    for(i <- 0 to inputS.length-2) {

      var left = i+1
      var right = inputS.length-1






      while (left<right && !done) {

        var totalSum = sum - inputS(i)-inputS(left)-inputS(right)

        //println(totalSum)

        if (totalSum == 0) {
          minSum = sum-totalSum
          done = true

        } else if (Math.abs(totalSum) < Math.abs(minSum)) {
          minSum = totalSum

        } else if(Math.abs(totalSum) < Math.abs(minSum) || (Math.abs(totalSum) == Math.abs(minSum) && totalSum > minSum)) {
          minSum = totalSum

        }

        if (totalSum>0) {
          left +=1
        } else {
          right -=1
        }

      }

    }
    sum-minSum

  }


  //println(tripletSumCloseToTarget(List(-3,-1,1,2),1))

  def subArrayWithProductLess(input:List[Int],target:Int):Set[List[Any]] = {

    var windStart = 0
    var windProd = 1
    var output:Set[List[Any]] = Set.empty


    for (windEnd <-  0 to input.length-1) {

      //println(windEnd)

      windProd = input(windEnd) * windProd
      //println(windProd)


      while (windProd >=target && windStart < input.length-1) {

        windProd /= input(windStart)

        //println("In while loop" + windProd)

        /* if (input(windEnd) < target) {
            output = output ++ Set(List(input(windEnd)))
          }*/

        windStart += 1

      }



        var tempList: List[Any] = List.empty

      var i=windEnd
       while (i > windStart -1) {

          println("In for loop" + i)


          tempList =  List(input(i)) ++ tempList

          output =  Set(tempList) ++ output

         i -= 1

        }


      /*if (input(windEnd)<target & windProd < target) {

        output = output ++ Set(List(input(windEnd)))

      }*/

    }
    output


  }

  println(subArrayWithProductLess(List(2, 5, 3, 10), 30))


  def dutchNationalFlagProblem(input:Array[Int]):Array[Int] = {


    var low = 0
    var high = input.length-1
    var i = 0


    while (i<=high) {

      if (input(i)==0) {

        val inputI = input(i)
        val inputL = input(low)

        input(i) = inputL
        input(low) = inputI

        i +=1
        low +=1
      } else if (input(i)==1) {

        i +=1
      } else {

        val inputI = input(i)
        val inputH = input(high)

        input(i) = inputH
        input(high) = inputI

        high -= 1
      }

    }
    input
  }

  //println(dutchNationalFlagProblem(Array(1,0,2,1,0)).toList)

  def quadrapleSumToZero(input:List[Int],target:Int):Set[List[Int]] = {

    val inputS = input.sorted

    val windSize = 4
    var windStart = 0
    var windSum = 0
    var output:Set[List[Int]] = Set.empty


    for (windEnd <- 0 to inputS.length-1) {

      windSum += inputS(windEnd)

      println("windEnd"+windEnd)
      println("windSum"+windSum)

      if(windEnd >= windSize-1 && windStart <= inputS.length-3) {

        println("In if loop"+"windEnd"+windEnd+"windSum"+windSum+"windStart"+windStart)


        if (windSum == target) {

          output = output ++ List(inputS.slice(windStart,windSize))



        }

        windSum -= inputS(windStart)
        windStart +=1
      }




    }

    output




  }

  println(quadrapleSumToZero(List(4,1,2,-1,1,-3),-2))
  //println(List(1,2,3,4,5).slice(1,4))



  def stringComparison(str1:String,str2:String):Boolean = {




    val output1 = str1.foldRight("",0){(ele,agg) =>
      (ele,agg._2) match {

        case ('#',0) => (agg._1,1)
        case (x,1) => (agg._1,0)
        case _ => (ele+agg._1,0)


    }}



    val output2 = str2.foldRight("",0){(ele,agg) =>
      (ele,agg._2) match {

        case ('#',0) => (agg._1,1)
        case (x,1) => (agg._1,0)
        case _ => (ele+agg._1,0)


      }}

    if (output1._1==output2._1) true else false



  }

  //println(stringComparison("xy#z","xyz#"))



  def minWindSort(input:Array[Int]):Int = {

    val output = -1

    var left = 1
    var right = input.length-1

  while (right<=input.length-1)
    {

      if (input(left)<=input(left-1)) {

        left += 1

      }
    }



    output


  }

}
