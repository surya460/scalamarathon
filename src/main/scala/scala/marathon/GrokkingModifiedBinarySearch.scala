package scala.marathon

import com.sun.tools.doclets.internal.toolkit.util.DocFinder.Input

object GrokkingModifiedBinarySearch extends App{

  case class ArrayReader(var arr:Array[Int]) {

    this.arr = arr

    def getIndex(index:Int): Int = {

      if(index<=this.arr.length) {

        this.arr(index)
      } else {

        -1
      }

    }

  }

  def searchFiniteArray(input:ArrayReader,key:Int):Int = {

    var start = 0
    var end = 1

    var output = -1

    while (key>input.getIndex(end)) {

      val newStart = end+1

      end += (end-start+1) * 2
      start= newStart
    }

    output = binarysearch_reader(input,start,end,key)

    output

  }

  def binarysearch_reader(input:ArrayReader, start: Int, end: Int, key: Int):Int = {

    var start_1 = start
    var end_1 = end

    while (start_1<=end_1) {

      val mid = start_1 + (end_1-start_1)/2
      if (key<input.getIndex(mid)) {

        end_1 = mid -1

      } else if (key > input.getIndex(mid)) {

        start_1 = mid+1

      } else {

        return mid
      }

    }
    return -1


  }



  def orderAgnosticBinarySearch(input:List[Int],key:Int):Int = {

    var start = 0
    var end = input.length-1



    val isAscending = if(input(start)<input(end)) true else false




      while (start <= end) {

        var mid = start + (end - start) / 2

        if (key == input(mid)) {
          return mid
        }

        if (isAscending) {


          if (key < input(mid)) {

            end = mid - 1
          } else if (key > input(mid)) {

            start = mid + 1

          }


        }

        else {

          if (key < input(mid)) {

            start = mid +1
          }
          else {

            end = mid-1
          }


        }
      }



    return -1


  }


  def cielingNumber(input:List[Int],key:Int):Int = {


    var start = 0
    var end = input.length-1

    while (start <=end) {

      var mid = start + (end-start)/2

      if (input(mid) == key) {
        return mid
      }

      if (key < input(mid)) {

        end = mid - 1
      } else if (key > input(mid)) {

        start = mid + 1

      }




    }

    return start


  }


  def smallestNumInCircular(input:List[Char],key:Char):Char = {

    var start = 0
    var end = input.length-1
    val n = input.length

    if (key<input(0) || key > input(end)) {

      return input(0)

    }

    while (start <= end) {

      var mid = start + (end-start)/2

      if (key<input(mid)) {

        end = mid -1
      } else {

        start = mid +1
      }

    }
    return input(start%n)



  }

  def findRange(input:List[Int],key:Int):(Int,Int) = {

    var left = -1
    var right = -1

    left = rangeOfNumber(input,key,false)

    if (left != -1) {

      right = rangeOfNumber(input,key,true)


    }
    (left,right)

  }


  def rangeOfNumber(input:List[Int],key:Int,leftOrRight:Boolean):Int = {


    var start = 0
    var end = input.length-1
    var outputIndex = -1


    while (start <=end) {

      var mid = start + (end-start)/2


      if (key < input(mid)) {

        end = mid - 1
      } else if (key > input(mid)) {

        start = mid + 1

      } else {

        outputIndex=mid

        if(leftOrRight) {

          start=mid+1

        }else {

          end = mid-1
        }





      }




    }

    return outputIndex


  }


  def closestEle(input:List[Int],key:Int):Int = {

    var start = 0
    var end = input.length-1

    while (start <= end) {

      val mid = start+(end-start)/2

      if (key<input(mid)) {

        end = mid -1

      } else if (key > input(mid)) {

        start = mid+1
      } else {

        return input(mid)
      }


    }

    if ((input(start)-key) < (key - input(end))) {

      return input(start)

    } else {

      return input(end)
    }

  }

  //println(orderAgnosticBinarySearch(List(4,6,10),10))

  //println(orderAgnosticBinarySearch(List(1,2,3,4,5,6,7,8),5))

  //println(cielingNumber(List(4,6,10),6))
  //println(cielingNumber(List(1, 3, 8, 10, 15),12))

  //println(smallestNumInCircular(List('a', 'c', 'f', 'h'),'b'))

  //println(findRange(List(4,6,6,6,9),7))

  //val reader = new ArrayReader(Array(4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30));
  //println(searchFiniteArray(reader, 19))

  println(closestEle(List(4,6,10),6))




}
