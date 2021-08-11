package scala.marathon

object SortingAlgorithms extends App {


  def largestElement[T <% Ordered[T]](input:List[T]):(T,List[T]) = {

    input match {

      case head :: Nil => (head,Nil)


      case head :: tail =>

        val (large,remaining) = largestElement(tail)

        if (head > large) (head,large::remaining) else (large,head::remaining)
    }

  }

 def BubbleSort[T <% Ordered[T]](input:List[T]):List[T] = {


    input match {

      case Nil => Nil

      case head::tail =>
        val (large,rest) = largestElement(input)

        BubbleSort(rest) ++ List(large)
    }
  }


  //println(BubbleSort(List(3,1,4,7,8)))


  def smallestElement[T <%Ordered[T]](input:List[T]):(T,List[T]) = {

    input match {

      case head :: Nil => (head,Nil)
      case head :: tail =>

        val (small,remaining) = smallestElement(tail)

        if (head < small) (head, List(small) ++ remaining) else (small, List(head) ++ remaining)
    }
  }


  def SelectionSort[T <% Ordered[T]](input:List[T]):List[T] ={

    input match {

      case Nil => Nil
      case head :: tail =>
        val (small,rest) = smallestElement(input)

        small :: SelectionSort(rest)



    }
  }

  //println(SelectionSort(List(1,22,0,3)))

  def insertElement[T <% Ordered[T]](input:T,output:List[T]):List[T] = {

    (input,output) match {

      case (input,Nil) => List(input)
      case (input,head::tail) => if (input<head) List(input) ++ output else List(head) ++ insertElement(input,tail)
    }
  }

  //println(insertElement(6,List(3,4,5)))

 def InsertionSort[T <% Ordered[T]](input:List[T]):List[T] ={

   input match {

     case Nil => Nil

     case head :: tail =>
       val sorted = InsertionSort(tail)

       insertElement(head,sorted)
   }
 }

  //println(InsertionSort(List(1,14,2,3,15,5)))


  def MergeSort[T <% Ordered[T]](input:List[T]):List[T] = {

    def merge[T <% Ordered[T]] (left:List[T],right:List[T]):List[T] = {


        (left, right) match {

          case (left, Nil) => left
          case (Nil,right) => right
          case (lh::lt,rh::rt) => if (lh<rh) lh :: merge(lt,right)
          else rh :: merge(rt,left)
        }
      }

    val len = input.length/2

if (len==0) input
    else  {
      val (left, right) = input.splitAt(len)

  merge(MergeSort(left),MergeSort(right))

    }


  }


//println(MergeSort(List(22,1,2,45,6)))

  def doPivot[T <% Ordered[T]](ele:T,lst:List[T]): (List[T],List[T]) = {

  def doPivot[T <% Ordered[T]](ele:T,lst:List[T],smallerElems:List[T],largerElems:List[T]): (List[T],List[T]) =
  {
  lst match {

  case Nil => (smallerElems,largerElems)
  case head::tail => if (head<ele) doPivot(ele,tail,List(head)++smallerElems,largerElems) else doPivot(ele,tail,smallerElems,List(head)++largerElems)
  }

  }
  doPivot(ele,lst,Nil,Nil)

  }


  def quickSort[T <% Ordered[T]](input:List[T]):List[T] = {

    input match {

      case Nil => Nil

      case head :: Nil => input

      case head :: tail =>
        val (lst1,lst2) = doPivot(head,tail)

        val smallerList = quickSort(lst1)
        val largerList =  quickSort(lst2)

        smallerList ++ List(head) ++ largerList




    }

     }

  println(quickSort(List(44,3,22,1,8)))
}