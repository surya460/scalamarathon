package scala.marathon

import com.sun.org.apache.xpath.internal.functions.FuncFalse

import scala.collection.mutable.Map

object GrokkingPatternSliding extends App{

  def maxSubArray(input:Array[Int],size:Int):Int = {

    var maxSum = 0

    for (i<- 0 until input.length-size+1) {

      var windowSum = 0

      for (j<- i until i+size ) {

        windowSum = input(j) +  windowSum

      }

      maxSum = Math.max(windowSum,maxSum)
    }
    maxSum

    }

  //println(maxSubArray(Array(2,1,5,1,3,2),3))


  //println(List(2,1,5,1,3,2).sliding(3,1).toList.map(x => x.sum).max)


  def maxSubArraySliding(input:Array[Int],size:Int) : Int = {

    var maxSum=0
    var windSum = 0
    var windStart = 0

    for (windEnd <- 0 to input.length-1) {

      windSum = windSum + input(windEnd)

      if (windEnd >= size-1)
        {
          maxSum = Math.max(maxSum,windSum)
          windSum = windSum - input(windStart)
          windStart = windStart + 1

        }
    }
    maxSum

  }

  println(maxSubArraySliding(Array(2,1,5,1,3,2),3))


  def minSubArraySliding(input:Array[Int],size:Int) : Int = {

    var minSum = input.sum
    var windSum = 0
    var windStart = 0

    for (windEnd<- 0 to input.length-1) {

      windSum = windSum + input(windEnd)

      if (windEnd >= size-1){
        minSum = Math.min(minSum,windSum)
        windSum = windSum - input(windStart)
        windStart = windStart + 1
      }
    }
    minSum
  }


  //println(minSubArraySliding(Array(2,1,5,1,3,2),2))


  def smallestSubArrayOfSum(input:Array[Int],sum:Int) : Int = {

    var windSum = 0
    var windLen = 0
    var windStart = 0
    var minLen = input.length+1


    for (windEnd <- 0 to input.length-1){

      windSum = windSum + input(windEnd)

      while (windSum>=sum) {

        minLen = Math.min(minLen,windEnd-windStart+1)
        windSum = windSum - input(windStart)

        windStart = windStart +1

      }

    }
    if (minLen == input.length+1)
    {
     0
    }
    else minLen
  }

  //println(smallestSubArrayOfSum(Array(2,1,5,2,3,2),7))


/*  def longestSubString(input:String,size:Int):Int = {

    val inputList = input.toList

    var m1:Map[Char,Int] = Map()

    for(windEnd <- 0 to inputList.length-1) {

      if (!m1.contains(inputList(windEnd))) {

        m1 = m1 + Map(inputList(windEnd) -> 0)
      }

     /* if (!m1.keys.exists(inputList(windEnd))) {
        m1 = m1 + m1(inputList(windEnd) -> 0)
      }
      else */


    }

  }*/


  def longestSubString(input:String,k:Int):Int = {

    var windStart = 0
    var maxLen = 0
    var maxString:scala.collection.mutable.Map[Char,Int] = scala.collection.mutable.Map[Char,Int]()

    for (windowEnd <- 0 to input.length-1) {

      if (!(maxString.contains(input(windowEnd))) )
        { maxString = maxString ++ scala.collection.mutable.Map(input(windowEnd) -> 0) }



      maxString(input(windowEnd)) += 1

      println(maxString)

      while(maxString.keys.toList.length > k) {




        maxString(input(windStart)) -= 1

        println(maxString)



        if (maxString(input(windStart))==0){
         maxString -= input(windStart)
        }


        println(maxString)


        windStart += 1

      }

      maxLen = Math.max(maxLen,windowEnd-windStart+1)





    }



    maxLen

  }

  //println(longestSubString("araaci",1))

/*
  araaci

  windStart = 0
  maxString = empty.List
  maxLen = 0

  windowEnd (0 to length-1)

  a
  if (maxString.distinct.length <=k)

  maxLen = Math.max(maxLen,maxString)

  distString = a + distString



*/


/*  "arraci".toList.foldLeft("",List.empty){ (acc,ele) => acc match {


  }
  }*/


  def fruitsIntoBasket(input:String):Int = {

    var windStart = 0
    var maxLen = 0




    var fruits:scala.collection.mutable.Map[Char,Int] = scala.collection.mutable.Map[Char,Int]()

    for (windowEnd<- 0 to input.length-1) {

      if (!(fruits.contains(input(windowEnd)))) fruits = fruits ++ scala.collection.mutable.Map(input(windowEnd) -> 0)

      fruits(input(windowEnd)) += 1


      while (fruits.keys.toList.length > 2) {

        fruits(input(windStart)) -= 1

        if (fruits(input(windStart)) == 0) {
          fruits -= input(windStart)
        }

        windStart += 1


      }

      maxLen = Math.max(maxLen, windowEnd - windStart + 1)

    }
    maxLen

  }

  //println(fruitsIntoBasket("ABCAC"))

  def nonRepeatingSubString(input:String):Int = {
    import scala.collection.mutable.Map

    var m1:Map[Char,Int] = Map[Char,Int]()
    var maxLen = 0
    var windStart = 0

    for (windEnd <- 0 to input.length-1)
      {

        if (!(m1.contains(input(windEnd)))){

          m1 = m1 ++ Map(input(windEnd) -> 0)
        }
        m1(input(windEnd)) +=1

        if(m1.keys.toList.distinct.length > maxLen)
          {
            maxLen = m1.keys.toList.distinct.length
          } else
          {
            //m1(input(windStart)) -= 1
            windStart = windEnd

            m1 = Map[Char,Int]()
            m1 = m1 ++ Map(input(windEnd)->1)


          }

        //maxLen = Math.max(maxLen,m1.keys.toList.distinct.length)



      }
    maxLen
  }


  def nonRepatingSubString2(input:String):Int = {

    var m1 = scala.collection.mutable.Map[Char,Int]()
    var maxLen = 0

    for (i<- 0 to input.length-1) {

      if(!(m1.contains(input(i)))) {

        m1 = m1 ++ Map(input(i) -> 1)
        maxLen += 1
      }


    }
    maxLen

  }

  println(nonRepatingSubString2("aabccbb"))
  println(nonRepatingSubString2("abbbb"))
  //println(nonRepeatingSubString("aabccbb"))

  def longestSubstringWithReplacement(input:String,size:Int):Int = {
    import scala.collection.mutable

    var maxLen:Int = 0
    var windStart:Int = 0
    var maxRepeatingCount =0

    var m1:Map[Char,Int] = Map[Char,Int]()

    for (windEnd <- 0  to input.length-1) {
      if (!(m1.contains(input(windEnd)))){

        m1 = m1 ++ Map(input(windEnd) -> 0)
      }

      m1(input(windEnd)) +=1

      maxRepeatingCount = Math.max(maxRepeatingCount,m1(input(windEnd)))

    while ((windEnd-windStart+1-maxRepeatingCount) > size) {

      m1(input(windStart)) -= 1
      windStart +=1
    }

      maxLen = Math.max(maxLen,windEnd-windStart+1)
    }
    maxLen


  }

  //println(longestSubstringWithReplacement("aabccbb",2))


  def longestSubarrayWithOnesAfterReplacement(input:String,size:Int):Int = {


    var maxOnes = 0
    var windStart = 0
    var maxLen = 0

    for (windEnd <- 0 to input.length-1) {

      if (input(windEnd)=='1'){
        maxOnes +=1
      }

      while((windEnd-windStart+1-maxOnes) > size) {

        if (input(windEnd)=='1') {
          maxOnes -=1
        }
        windStart += 1
      }
      maxLen = Math.max(maxLen,windEnd-windStart+1)
    }
    maxLen



  }

  //println(longestSubarrayWithOnesAfterReplacement(List(0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1),2))

  //println(longestSubarrayWithOnesAfterReplacement("01100011011",2))

  def permutationInaString(input:String,pattern:String):Boolean = {

    import scala.collection.mutable.Map
    var m1:Map[Char,Int] = Map[Char,Int]()

    var windStart = 0
    var output = false




    for (windEnd <- 0 to input.length-1) {

      if(!(m1.contains(input(windEnd)))) {

        m1 = m1 ++ Map(input(windEnd) -> 0)
      }

      m1(input(windEnd)) += 1
      //println(windEnd)
      //println(output)
      //println(m1)
      //println(output)



      while((m1.keys.toList.length >= pattern.length) && output == false ){

        var break = false
        //println(m1)
        for(char <- pattern) {
          println("char"+char)
          println("initial"+m1)
          println("initialbreak"+break)

          if (!(m1.contains(char)) && break == false) {

            break = true

          } }
          println("break:" + break)

          if (break == true) {

            m1(input(windStart)) -= 1
            if (m1(input(windStart)) == 0) {
              m1 -= input(windStart)
              println("m1"+ m1)
            }

          } else
            {
              println("finalm1"+m1)
              println("In else")
              output = true
            }

          windStart += 1


      }


    }
    output

  }

  //println(permutationInaString("bcdxabcdy","bcdyabcdx"))

  //oidbcaf", Pattern="abc"

  def permutationInaString2(input:String,pattern:String):Boolean = {

    import scala.collection.mutable.Map
    var m1 : Map[Char,Int] = Map[Char,Int]()
    var matched = 0
    var output = false
    var windStart = 0

    for (windEnd <- 0 to pattern.length-1) {

      if(!(m1.contains(pattern(windEnd)))) {

        m1 = m1 ++ Map(pattern(windEnd) -> 0)
      }
      m1(pattern(windEnd)) +=1

  }

    //println(m1)

    for (windEnd <- 0 to input.length-1) {

      if (output == false) {

      if (m1.contains(input(windEnd))) {

        m1(input(windEnd)) -= 1

        if (m1(input(windEnd)) == 0) {

          matched +=1

        }
      }

      if (matched == m1.keys.toList.length) {

        println(matched)
        println(m1.keys.toList)

        output = true

      }

      if (windEnd > pattern.length-1) {

        val leftChar = input(windStart)

        windStart += 1

        if (m1.contains(input(leftChar))) {

          if (m1(input(leftChar))==0) {

            matched -= 1
          }
          m1(input(leftChar)) += 1
        }


      }


    }
  }
    output
  }


  def averageConstiguosArray(input:Array[Int],k:Int):List[Double] = {

    var windSum = 0

    var windStart = 0

    var output = scala.collection.mutable.ArrayBuffer[Double]()

    for (i <- 0 to input.length-1) {

      windSum += input(i)



      if(i>= k-1){

        output += (windSum.toDouble/k)

        windSum -= input(windStart)

        windStart +=1

      }



    }

    output.toList



  }

  //println(permutationInaString2("bcdxabcdy","bcdyabcdx"))
  //println(permutationInaString2("odicf","dc"))
  //println(permutationInaString2("odibcaf","abc"))

  //println(averageConstiguosArray(Array(1, 3, 2, 6, -1, 4, 1, 8, 2),5))

  println("bca".sorted)

  val m1 = Map('o'->1,'i' ->1,'d' ->1)
  println(m1.keys.mkString)


}


