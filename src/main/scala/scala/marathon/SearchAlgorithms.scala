package scala.marathon

object SearchAlgorithms extends App{

  def linearSearch[T <% Ordered[T]] (ele:T,collection:List[T]):Boolean = {

   collection match {

     case head :: tail if (head == ele) => true
     case Nil => false
     case _ => linearSearch(ele,collection.tail)
   }

  }

  //println(linearSearch(10,List(2,3,4,1)))


  def binarySearch [T <% Ordered[T]] (ele:T,input:List[T]):Boolean = {


/*
    def search [T <% Ordered[T]](left:List[T],right:List[T]) : Boolean = {

      (left,right) match {

        case

      }

    }
*/

    val n = (input.length)/2
    val (left, right) = input.splitAt(n)

    if (n==0) {

      if (input.head == ele) true else false
    }
    else if (input(n) == ele) {
      true
    }
    else if ( ele > input(n)) {

      binarySearch(ele,right)

    }
    else {

      binarySearch(ele,left)
    }

  }


  //println(binarySearch(10,List(1,2,3,4,5)))


/*  def binarySearchIndex[T <% Ordered[T]](input:List[T],ele:T):T = {

    var low = 0
    var high = input.length-1
    var done = false


    while (low <= high) {

      if (!done) {

        //val mid =

      }

    }



  }*/



}
