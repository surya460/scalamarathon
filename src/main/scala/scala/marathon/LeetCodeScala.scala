package scala.marathon

object LeetCodeScala extends App{

  def kidsWithCandies(candies:Array[Int],extraCandies:Int):Array[Boolean] = {

    val maxOfCandies = maxOfArray(candies)

    candies.map(x => if (x+ extraCandies >= maxOfCandies) true else false)

    /* for (i <- 0 to candies.length-1)
       {
         if (candies(i) + extraCandies >= maxOfCandies ) println(true) else println(false)
       }*/
  }
  def maxOfArray(input:Array[Int]) : Int = {


    def maxOfArray(input:Array[Int],max:Int):Int = {
      input match {

        case input if(input.length>1) => if (input.head > max) maxOfArray(input.tail,input.head) else maxOfArray(input.tail,max)
        case input if (input.length==1) => if (input.head > max) input.head else max
        case input if (input.length==0) => max

      }

    }

    maxOfArray(input,0)

  }

  //println(kidsWithCandies(Array(2,3,5,1,3),3).toList)

  //println(Array(1,2,3,4,5).scanLeft(0)((x,y)=> x+y).tail.toList)

  //println("1.1.1.1".replace(".","[.]"))

  def countMatches(items:List[List[String]],ruleKey:String,ruleValue:String) :Unit = {

    items.map(y => println(y))
  }

  //countMatches(List(List("phone","blue","pixel"),List("computer","silver","lenovo")),"color","silver")


  val vowels = Map ('a' -> 1,'e'->1,'i'->1,'o'->1,'u'->1)
  //println("forgiveness".map(x => if(!vowels.contains(x)) x.toString else "" ).mkString)

  //println(Array(Array(1,2,3),Array(3,2,0),Array(5,4,3)).map(x => x.sum).reduce(_ max _))

  //println("aA".split("").toList)

  //println(List(2,65,34,2,1,7,8).sorted)

  /*def smallerNumbersThanCurrent(nums:Array[Int]):Array[Int] = {


  }*/

  val input1 = Array(8,1,2,2,3)
 //   println(input1.map(x => input1.filter(_<x).toList.length).toList)

  //println(14/2)

  def numberOfSteps(num:Int):Int = {

    def numberOfSteps(num:Int,steps:Int):Int = {

      num match {

        case num if (num==0) => steps
        case num if(num%2==0) => numberOfSteps(num/2,steps+1)
        case num if (num%2!=0) => numberOfSteps(num-1,steps+1)

      }


    }

    numberOfSteps(num,0)

  }

  //println(numberOfSteps(14))


  def restoreString(s:String,indices:Array[Int]):String= {

    val stringList = s.split("").toArray

   val restoreMap = indices.zip(stringList).toMap



      val output = for (i<- 0 to indices.length-1) yield restoreMap(i)

    output.mkString



  }

  //println(restoreString("codeleet",Array(4,5,6,7,0,2,1,3)))


  def substractProductAndSum(n:Int):Int = {

    n.toString.split("").foldLeft(1)((x,y) => x.toInt*y.toInt) - n.toString.split("").foldLeft(0)((x,y) => x.toInt +y.toInt)

    //n.toString.split("").reduce((x,y) => x.toInt * y.toInt) - n.toString.split("").reduce((x,y) => x.toInt + y.toInt)
  }

//  println(substractProductAndSum(234))


  def decompressRLElist(nums:Array[Int]):List[Int] = {

    nums.grouped(2).flatMap(x => Array.fill(x(0))(x(1))).toList
  }

  //println(decompressRLElist(Array(1,1,2,3)))

  //println(Array.fill(2)(1))

  import scala.util.matching.Regex

  val input = "  +123|"
  val inputPattern = "([\\s*\\-*\\+*])([\\d*])([.*])".r

  val output = inputPattern.findAllMatchIn(input)



/*
for (outputValues <- output)
  {
  println(outputValues.group(1))

  }*/

  //println("G()()()()(al)".replace("()","o").replace("(al)","al"))


  def createTargetArray(nums:Array[Int],index:Array[Int]):Unit = {

    var result =  scala.collection.immutable.List

    val resultSet = nums.zip(index).toList

    //resultSet.map((x,y) => result(y)=x)

    }




  //createTargetArray(Array(0,1,2,3,4),Array(0,1,2,2,1))

  var result =  scala.collection.immutable.List(4)
  //result(1)=2

  //println(result)

  //println(List(1,2,3) equals List(1,2,3))


  def destCity(paths:List[List[String]]):String = {

    val m1 = paths.map(x => x(0) -> x(1)).toMap.keys.toList

    paths.flatten.map(x => if (!m1.contains(x)) x.toString else "".toString).mkString("")


  }


  //println(destCity(List(List("B","C"),List("D","B"),List("C","A"))))



  def highFive(items: List[List[Int]]):List[List[Int]] ={



    items.groupBy(x => x(0)).mapValues(x =>x.map(y=>y(1)).sorted.reverse.take(5).sum/5).map(x => List(x._1,x._2)).toList.sortBy(x => x(0))

  }

  //println(highFive(List(List(1,91),List(1,92),List(2,93),List(2,97),List(1,60),List(2,77),List(1,65),List(1,87),List(1,100),List(2,100),List(2,76))))


  val S ="aaaaba".toList

  def balancedStringSplit(s:String):Int = {


    s.foldLeft(0,0)((acc,curr) =>
    acc match {

      case (1,count) if (curr == 'L')  => (0,count+1)
      case (-1,count) if (curr == 'R') => (0,count+1)
      case (flag,count) if (curr == 'L') => (flag-1,count)
      case (flag,count) if (curr == 'R') => (flag+1,count)


    }


    )._2

    }

  //println(balancedStringSplit("RLRRLLRLRL"))

  def mergeAlternately(word1:String,word2:String):Unit = {

    for (i <- word1) {

      for (j <- word2) {

        print(i); print(j)


      }
    }
  }

/*
  //mergeAlternately("abc","pqr")

import scala.collection.immutable.Stack
  import scala.collection.immutable.Queue
  val s1 = Stack(1,2,3,4)

  val q = Queue(1,2,3,4)

  println(s1.push(11))

  val out1 = s1.top
  println(out1)

  println(q.enqueue(10))

//import scala.collection.immutable.Stream
  val s = Stream(1,2,3,4)

  val s12 = 1 #:: 2 #:: 3 #:: 4 #:: 5 #:: Stream.empty

  s12.take(3).print

  println(s)
  println(s12)
*/





}
