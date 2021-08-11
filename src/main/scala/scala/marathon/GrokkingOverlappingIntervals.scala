package scala.marathon

object GrokkingOverlappingIntervals extends App{

  case class Interval (st:Int,ed:Int) extends Ordered[Interval] {



    val start = this.st

    val end = this.ed
    import scala.math.Ordered.orderingToOrdered

    def compare(that: Interval): Int = (start, end) compare (that.start, that.end)
    //def compare(that: Interval): Int = (start,that.start) compare (start,that.start)





    def printInterval (): Unit = {
      println(start + " " + end)
    }
  }


  def merge(input:Array[Interval]):Array[Interval] = {

    val inputSorted:Array[Interval] = input.sorted

    if (inputSorted.length<2) {

      inputSorted
    }

    var start = inputSorted(0).start
    var end = inputSorted(0).end
    var output:Array[Interval] = Array.empty

    for (i <-  1 to inputSorted.length-1) {

      val intrvl = inputSorted(i)

      if (intrvl.start <= end) {

        end = Math.max(intrvl.end,end)

      } else {

        output = output ++ Array(new Interval(start,end))
        start = intrvl.start
        end = intrvl.end
      }
    }

    output = output ++ Array(new Interval(start,end))


    output

  }

/*  println("Merged intervals: ")
  val result = merge(Array(new Interval(6, 7), new Interval(2, 4), new Interval(5,9)))
  for (i <- 0 to result.length-1) {
    result(i).printInterval()
  }*/



  def insertInterval(input:Array[Interval],target:Interval):Array[Interval] =
  {

    var done = false
    var i = 0
    var output:Array[Interval] = Array.empty

    while (!done) {

      if (target.start < input(i).start) {

        output = Array(target) ++ input
        done = true

      } else {
        i += 1
      }
    }

    merge(output)

  }



/*
 println("Insert intervals: ")
val result = insertInterval(Array(new Interval(1, 3), new Interval(5, 7), new Interval(8,12)),new Interval(4,6))
for (i <- 0 to result.length-1) {
  result(i).printInterval()
}
*/


  def insertIntervalBetter(input:Array[Interval],newInter:Interval):Array[Interval] = {

    var output:Array[Interval] = Array.empty

    var i = 0
    var start = 0
    var end = 0




      while (i<input.length && input(i).end < newInter.start) {

        output = output ++ Array(input(i))
        i +=1
      }

    while (i<input.length && input(i).start <= newInter.end) {

      start = Math.min(newInter.start,input(i).start)
      end = Math.max(newInter.end,input(i).end)
      i +=1

    }

    output = output ++ Array(Interval(start,end))

    while(i<input.length) {

      output = output ++ Array(input(i))
      i +=1
    }



    output



  }

/*  println("Insert intervals Better: ")
  val result = insertIntervalBetter(Array(new Interval(1, 3), new Interval(5, 7), new Interval(8,12)),new Interval(4,10))
  for (i <- 0 to result.length-1) {
    result(i).printInterval()
  }*/


  def appointmentConflict(input:Array[Interval]):Boolean = {

    val inputSorted = input.sorted
    var start = input(0).start
    var end = input(1).end
    var output = true

    for (i <- 1 to inputSorted.length-1) {

      if (output) {

        if (end > inputSorted(i).start) {

          output = false
        } else {

          start = inputSorted(i).start
          end = inputSorted(i).end
        }

      }
    }

    output
  }

    println("Appointment Conflict: ")
  //val result = appointmentConflict(Array(new Interval(6,7), new Interval(2, 4), new Interval(8,12)))

  //val result = appointmentConflict(Array(new Interval(1,4), new Interval(2, 5), new Interval(7,9)))
  //println(result)

  def insertInterval2(input:Array[Interval],intervl:Interval):Array[Interval] = {

    var output:Array[Interval] = Array.empty


    var i=0
    var start = intervl.start
    var end = intervl.end

    while (i< input.length && input(i).end < start) {

      output = output ++ Array(input(i))
      i +=1
    }

    while (i<input.length && input(i).start <= end) {

      start = scala.math.min(input(i).start,start)
      end = scala.math.max(input(i).end,end)
      i +=1
    }

    output = output ++ Array(new Interval(start,end))

    while (i<input.length) {

      output = output ++ Array(input(i))
      i +=1
    }

    output
  }

/*   println("Insert intervals Better: ")
    val result = insertInterval2(Array(new Interval(1, 3), new Interval(5, 7), new Interval(8,12)),new Interval(4,10))
    for (i <- 0 to result.length-1) {
      result(i).printInterval()
    }*/


  def minimumMeetingRoom(inputUnSorted:Array[Interval]): Int = {

    var output = 1

    var input = inputUnSorted.sorted

    var start = input(0).start
    var end = input(0).end

    for (i <- 1 to input.length-1) {

      if (end > input(i).start) {
        output +=1
      }
    }


    output

  }

  println(minimumMeetingRoom(Array(new Interval(1,4), new Interval(2,5), new Interval(7,9))))
  println(minimumMeetingRoom(Array(new Interval(6,7), new Interval(2,4), new Interval(8,12))))
  println(minimumMeetingRoom(Array(new Interval(1,4), new Interval(2,3), new Interval(3,6))))

  //println(Range(Array(1,2,3,4).length))

}
