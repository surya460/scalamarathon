package scala.marathon

object scalaArrays extends App{

  val intArray = Array(1,2,3,4,10,11,12,13,1)
  val intArray2 = Array(11,12,13)
  val outputArray = intArray.dropRight(1)


  println(intArray.reduceLeft((x,y) =>
    if (x>y) {
      println(x)
      x }
    else
      y))


  //finding length of Array
  println(intArray.foldLeft(0){(len,elem) => len+1})

  //finding last element of Array
  println(intArray.foldLeft(0){(elem,i) => if (intArray.indexOf(elem) > intArray.indexOf(i)) elem else i})

  println(intArray.foldLeft(0){(elem,i) => i})

  val intArray3 = Array(10) ++ intArray2

  println(intArray3.mkString(","))


  import Array._
  val output = range(10,20)

  //println(output.foreach(println))

  //finding Average of Array using foldLeft
  //(1,2)
  //intArray.foldLeft(intArray.head,1.0) {

    //(avg,cur) => (avg._1 * avg._2 + cur)/(avg._2 + 1.0), avg._2 + 1.0}

val (leftArray,rightArray) = intArray.span(x=>x<10)
  println("Left")
  leftArray.foreach(println)
  println("Right")
  rightArray.foreach(println)

  val iArray = Array(1,2,3,4,1)
  println(iArray.combinations(2).toList.map(x => x.toList))

  println((1 to 1000000000).view.filter(_%2==0).take(10).toList)

 println(iArray.fold(0)(_+_))
  println(iArray.scan(0)(_+_).toList)

 println(Array(1,2,3,4,5,6,7,8).sliding(3,4).toList.map(_.toList))

  var iArray2 = Array(1,2)
 //iArray2.slice(2,0,3)

  val input1 = List(1,2,4,7,9)
  val input2 = List(3,5,6,8)

 /* def reverseArray(arr:List[Int]):List[Int] = {

    arr match {
      case Nil => Nil
      case head :: Nil => List(head)
      case head :: tail => reverseArray(tail) ++ List(head)
    }
  }

  println(reverseArray(input1))

  */

  def mergeSortedList(ls1:List[Int],ls2:List[Int]):List[Int] = {

    (ls1,ls2) match {
      case (ls1,Nil) => ls1
      case (Nil,ls2) => ls2
      case (headls1::taills1,headls2::taills2) => if (headls1<headls2) List(headls1)++ mergeSortedList(taills1,ls2) else List(headls2) ++ mergeSortedList(ls1,taills2)
      }
    }

  //println(mergeSortedList(input1,input2))


  val inputString = "Hello this is Surya"
  val inputArray = inputString.split("").toArray

  def reverseArray(arr:Array[String]):Array[String] = {

    arr match {
      case arr if (arr.length==0) => Array()
      case arr if (arr.length==1) => arr
      case arr if (arr.length>1) => reverseArray(arr.tail) ++ Array(arr.head)
    }
  }

  //println(reverseArray(inputArray).toList.mkString(""))

/*
  def mergeSortedArray(arr1:Array[Int],arr2:Array[Int]):Array[Int] = {

    (arr1,arr2) match {
      case (arr1,arr2) if (arr1.length==0 && arr2.length>0) => arr2
      case (arr1,arr2) if (arr1.length>0 && arr2.length==0) => arr1
      case (arr1,arr2) if (arr1.length>0 && arr2.length>0) => if (arr1.head.toInt < arr2.head.toInt) arr1
      case _ => arr1


    }
  }*/

  def moveZeros(arr:Array[Int]):Array[Int] = {

    arr match {

      case arr if (arr.length==0) => Array()
      case arr if (arr.length==1) => arr
      case Array(x,_*) => if (x==0) moveZeros(arr.tail) ++ Array(x) else Array(x) ++ moveZeros(arr.tail)

    }
  }

  moveZeros(Array(0,1,0,3,12)).toList.foreach(print)


  def twoSum(arr:Array[Int],sum:Int):Array[Int] = {



    var s1 = scala.collection.mutable.Set[Int]()



    for (x<-arr) {
       if (s1.contains(x) ) {return Array(x,sum-x)}
        else s1.add(sum - x)
    }

    Array(0,0)



  }

  //println(twoSum(Array(2,7,11,15),9).toList)

  println(Array(1,1,2,4).toSet.sameElements(Array(1,1,2,4)))

  def maxSubArray(arr:Array[Int]):Int = {

    var max = 0
    var curr = 0

    for (ele <- arr) {
      curr = Math.max(ele+curr,ele)
      max = Math.max(curr,max)
    }
    max
  }

  println(maxSubArray(Array(-2,1,-3,4,-1,2,1,-5,4)))


  def rotateKSteps(arr:Array[Int],len:Int):Array[Int] = {

    //arr.slice(len+1,arr.length) ++ arr.slice(0,len+1)
    var l1 = len

    if (len%2==0) l1 else l1 + 1

    val (left,right) = arr.splitAt(l1)

    right ++ left
  }

 // println(rotateKSteps(Array(-1,-100,3,99),2).toList)

  //println(rotateKSteps(Array(1,2,3,4,5,6,7),3).toList)

  def longestWord(in:String):String ={

    in.split(" ").foldLeft(""){(x,y) => if(x.length == y.length) x else if (x.length > y.length) x else y}
  }

 // println(longestWord("fun&!! time"))

}
