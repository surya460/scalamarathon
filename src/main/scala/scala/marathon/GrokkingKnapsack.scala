package scala.marathon

import java.security.KeyStore.TrustedCertificateEntry

object GrokkingKnapsack extends App {

  def knapsack (profits:List[Int],weigths:List[Int],capacity:Int) :Int = {

    def recursiveKnapsack(profits:List[Int],weights:List[Int],capacity:Int,currentIndex:Int):Int = {



      if (capacity<=0 || currentIndex > profits.length-1) return 0


      var profit1=0



      if(weights(currentIndex) <=capacity) {

        profit1 = profits(currentIndex) + recursiveKnapsack(profits,weights,capacity - weights(currentIndex),currentIndex+1)
      }


      val profit2 = recursiveKnapsack(profits, weights, capacity, currentIndex + 1)


      return scala.math.max(profit1,profit2)


    }

    recursiveKnapsack(profits,weigths,capacity,0)

  }

  def knapsackWithMemoization (profits:List[Int],weigths:List[Int],capacity:Int) :Int = {

    def recursiveKnapsack(profits:List[Int],weights:List[Int],capacity:Int,currentIndex:Int):Int = {

      var m1 = scala.collection.mutable.Map[Int,Int]()

      if (capacity<=0 || currentIndex > profits.length-1) return 0

      if (m1.contains(currentIndex)) return m1(currentIndex)


      var profit1=0



      if(weights(currentIndex) <=capacity) {

        profit1 = profits(currentIndex) + recursiveKnapsack(profits,weights,capacity - weights(currentIndex),currentIndex+1)
      }


      val profit2 = recursiveKnapsack(profits, weights, capacity, currentIndex + 1)
      val maxProfit = scala.math.max(profit1,profit2)

      m1 = m1 ++ Map(currentIndex -> maxProfit)


      return maxProfit


    }

    recursiveKnapsack(profits,weigths,capacity,0)

  }


  //println(knapsack(List(1,6,10,16),List(1,2,3,5),6))
  //println(knapsackWithMemoization(List(1,6,10,16),List(1,2,3,5),7))


  def partitionEqualSubset(input:List[Int]):Boolean = {

    val sum = input.sum

    if (sum % 2 != 0) return false

    recursivePartitionEqualSubset(input, sum / 2, 0)
  }

    def recursivePartitionEqualSubset(num:List[Int],sum:Int,currentIndex:Int):Boolean = {

      if (sum==0) return true

      if (num.length == 0 || currentIndex >= num.length) return false

      if (num(currentIndex) <= sum ) {

        if (recursivePartitionEqualSubset(num,sum-num(currentIndex),currentIndex+1)) return true
      }

      return recursivePartitionEqualSubset(num,sum,currentIndex+1)


    }


  def partitionEqualSubsetWithMem(input:List[Int]):Boolean = {

    val sum = input.sum



    if (sum % 2 != 0) return false

    recursivePartitionEqualSubsetWithMem(input, sum / 2, 0)
  }

  def recursivePartitionEqualSubsetWithMem(num:List[Int],sum:Int,currentIndex:Int):Boolean = {
    var m1 = scala.collection.mutable.Map[Int,Boolean]()

    if (sum==0) return true

    if (num.length == 0 || currentIndex >= num.length) return false

    if (num(currentIndex) <= sum ) {

      if (recursivePartitionEqualSubsetWithMem(num,sum-num(currentIndex),currentIndex+1))
        {
          m1 = m1 ++ Map(currentIndex -> true)
          return true
        }
    }

    m1 = m1 ++ Map(currentIndex -> recursivePartitionEqualSubsetWithMem(num,sum,currentIndex+1))



    return m1(currentIndex)
  }






  //println(partitionEqualSubset(List(1,2,3,4)))
  //println(partitionEqualSubset(List(2,3,4,6)))

  println(partitionEqualSubsetWithMem(List(1,2,3,4)))
  println(partitionEqualSubsetWithMem(List(2,3,4,6)))

}
