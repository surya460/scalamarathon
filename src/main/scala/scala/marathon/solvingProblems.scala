package scala.marathon

object solvingProblems extends App{

  def containsCommonItems1(a1:Array[Char],a2:Array[Char]):Boolean = {

    var done = false
    for (i <- 0 to a1.length - 1) {
      if (a2.contains(a1(i)) && !done) done=true }
    done
  }


  val arr1:Array[Char] = Array('a','b','c','x','a')

  val arr2:Array[Char] = Array('z','y','i','a','a',1)

  //val output1 = containsCommonItems1(arr1,arr2)
  //println(output1)


  def containsCommonItems2(a1:Array[Char],a2:Array[Char]) = {

    val a1Map = (a1 zipWithIndex).toMap

    var done = false
    for (i<- 0 to a2.length - 1)
      {
        if(a1Map.contains(a2(i)) && !done) done=true
  }
    println(done)


  }
  containsCommonItems2(arr1,arr2)


  def hasPairWithSum(a1:Array[Int],sum:Int) = {

    var diffSet = scala.collection.mutable.Set[Int]()
    var done = false

    for ( i <- 0 to a1.length-1)
      {
        if (diffSet.contains(a1(i)) && !done) {

          done=true
        }
        diffSet.add(sum-a1(i))
      }
    println(done)
  }

  hasPairWithSum(Array(6,4,3,2,1,7),15)
}
