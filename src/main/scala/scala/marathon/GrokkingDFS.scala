package scala.marathon

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks._

object GrokkingDFS extends App{

  case class TreeNode(_value:Int,var _left:TreeNode=null,var _right:TreeNode=null){

    var value=_value
    var left = _left
    var right =_right

  }


  var output = false
  def hasPath(root:TreeNode,sum:Int):Boolean = {
println("Output is:")
println(output)

if (!output) {

  if (root == null) {

    output = false

  }

  println(root)
  println(sum)

  if (root.value == sum && root._left == null && root._right == null) {

    output = true
    true
    //break()
  }

  println(output)

  //if ((root._left !=null && hasPath(root._left,sum-root.value,output)) || (root._right != null && hasPath(root._right,sum-root.value,output)))
  if (root._left != null && hasPath(root._left, sum - root.value) && !output) {
    output = true
  }

  if (root._right != null && hasPath(root._right, sum - root.value) && !output) {

    output = true
  }
  else {

    output = false


  }

}

    output

  }




  def findAllPaths(input:TreeNode,s:Int):Set[Array[Int]] = {

    var output = Set(Array.emptyIntArray)

    //var output1 = Set(Array.empty[Int])
    var q = scala.collection.mutable.Queue[Int]()

    def findAllPaths(input:TreeNode,s:Int,q:scala.collection.mutable.Queue[Int]):Set[Array[Int]] = {

   /*   if (q.length>0) {
        q.dequeue()
      }
*/

      if (input == null) {
       output = output ++ Set(Array.emptyIntArray)
      }

      println(q)
      println(s)

      q.enqueue(input._value)

      println(q)

      if (input._value == s && input._left == null && input._right == null) {
        println("In If loop")
        output = output ++ Array(q.toArray)
      }

      println(input.left)
      println(input._left)

      if (input._value != null && input._left !=null) {
        println("In left if loop")
        findAllPaths(input._left, s- input._value, q)
        //findAllPaths(input._right,s- input.value, q)

      }
      if (input._value != null && input._right !=null) {
        println("In right if loop")
        println("value of sum is:"+ s)
        println("value of node is:"+ input._value)
        //findAllPaths(input._left, s- input.value, q)
        findAllPaths(input._right,s- input._value, q)

      }


      q.dequeue()

      output

    }

    findAllPaths(input,s,q)


  }



  val root=new TreeNode(12)

  root._left = new TreeNode(7)
  root._right = new TreeNode(1)
  root._left._left = new TreeNode(4)
  root._right._left = new TreeNode(10)
  root._right._right = new TreeNode(5)

  println(root)

  //println(hasPath(root,23))
  findAllPaths(root,23).foreach(x => println(x.toList))

}
