package scala.marathon

import com.sun.prism.impl.Disposer.Target
import com.sun.tools.doclets.internal.toolkit.util.DocFinder.Input

object GrokkingMisc extends App {

  def pairWithTargetSum(input: Array[Int], target: Int): Array[Int] = {

    def run(left: Int, right: Int, output: Array[Int]): Array[Int] = {

      (left, right) match {

        case (left, right) if (left < right && input(left) + input(right) == target) => Array(left, right)

        case (left, right) if (left < right && input(left) + input(right) > target) => run(left, right - 1, output)

        case (left, right) if (left < right && input(left) + input(right) < target) => run(left + 1, right, output)

        case _ => Array(-1, -1)


      }

    }

    run(0, input.length - 1, Array.empty)

  }

  //println(pairWithTargetSum(Array(2,5,9,11),11).toList)


  def tripletSum(inputUns: Array[Int]): Set[Array[Int]] = {

    val input = inputUns.sorted

    var output: Set[Array[Int]] = Set.empty

    for (i <- 0 to input.length - 1) {

      if (!(i > 0 && input(i) == input(i - 1))) {

        var left = i + 1
        var right = input.length - 1
        var target = -input(i)

        while (left < right) {

          if (input(left) + input(right) == target) {

            output = output ++ Set(Array(-target, input(left), input(right)))

            left += 1
            right -= 1


            while (left < right && input(left) == input(left - 1)) {

              left += 1
            }

            while (left < right && input(right) == input(right + 1)) {
              right -= 1
            }
          }


          else if (input(left) + input(right) < target) {

            left += 1
          } else {
            right -= 1
          }
        }
      }
    }


    output
  }

  /* def findTriplet(input: Array[Int], target: Int, l: Int,r: Int):Set[Array[Int]] = {
      var left = l
      var right = r

      while (left < right) {

        if (input(left) + input(right) == target) { output = output ++ Set(Array(-target,input(left),input(right)))

        left +=1
        right -=1}

        while (left < right && input(left) == input(left-1)) {

          left += 1
        }

        while (left < right && input(right) == input(right+1)) {
          right -=1
        }

        if (input(left) + input(right) > target) { rihttps://www.samsung.com/us/home-appliances/refrigerators/all-refrigerators/?type=3+door+French+Door,4+door+French+Doorght -=1}
        else if (input(left) + input(right) < target) { left +=1}
      }

      output
    }

    output
  }
*/
  //println(tripletSum(Array(-3, 0, 1, 2, -1, 1, -2)).foreach(x => println(x.toList)))


  def tripletSumLessThanTarget(unsortedinput: Array[Int],target:Int): Int = {
    var count=0

    val input = unsortedinput.sorted

    var output: Set[Array[Int]] = Set.empty

    for (i <- 0 to input.length - 1) {

      //if (!(i > 0 && input(i) == input(i - 1))) {

        var left = i + 1
        var right = input.length - 1


        while (left < right) {

        /*  println("Inside while loop")

          println(input(i),input(left),input(right))

*/
          if (input(i) + input(left) + input(right) < target) {
           // println("Inside if loop")




            output = output ++ Set(Array(input(i), input(left), input(right)))

            count +=right-left

            left += 1
            //right -= 1

           /* while (left < right && input(left) == input(left - 1)) {

              left += 1
            }
            while (left < right && input(right) == input(right + 1)) {

              right -= 1
            }*/


          } else {

            right -= 1
          }
        }


      }


    //}


    count
  }



  println(tripletSumLessThanTarget(Array(-1, 4, 2, 1,3),5))

}
