package scala.marathon

import com.sun.tools.hat.internal.model.Root

object GrokkingBFS extends App{

  case class TreeNode(var _value: Int = 0,var _left:TreeNode=null,var _right:TreeNode=null) {

    var value = _value
    var left = _left
    var right = _right


  }


  import scala.collection.mutable.ArrayBuffer
  import scala.collection.mutable.Queue

  def BFSTraverse(root:TreeNode):Array[Any] = {

    var output:ArrayBuffer[Any] = ArrayBuffer.empty
    var q = scala.collection.mutable.Queue[TreeNode]()
    q.enqueue(root)

    //var leftToRight = true

    //println(q.length)

    while (q.length > 0) {
      //println(q)

      var currentLevel:ArrayBuffer[Any] = ArrayBuffer.empty



      for (i<- 0 to q.length-1) {

        val currentNode = q.dequeue()

        currentLevel = currentLevel ++ ArrayBuffer(currentNode.value)


   /*     if (leftToRight)
          {
            currentLevel = currentLevel ++ ArrayBuffer(currentNode.value)

          }
        else {

          currentLevel = ArrayBuffer(currentNode.value) ++ currentLevel
        }*/



        if (currentNode._left != null) {

          q.enqueue(currentNode._left)
        }

        if (currentNode._right != null) {

          q.enqueue(currentNode._right)
        }



      }

      output = output ++ currentLevel

      //leftToRight = !leftToRight


    }



    output.toArray
  }


  def reverseBFS(root:TreeNode) :Array[Any] = {

    var output:ArrayBuffer[Any] = scala.collection.mutable.ArrayBuffer.empty


    var q = scala.collection.mutable.Queue[TreeNode]()


    q.enqueue(root)

    while (q.length>0) {

      var currentLevel:ArrayBuffer[Any] = scala.collection.mutable.ArrayBuffer.empty


      for (i<- 0 to q.length-1) {

        val currentNode = q.dequeue()


        currentLevel = currentLevel ++ ArrayBuffer(currentNode.value)

        if (currentNode._left != null) {

          q.enqueue(currentNode._left)
        }
        if (currentNode._right != null) {

          q.enqueue(currentNode._right)
        }


      }

      output = currentLevel ++ output

    }



    output.toArray

  }


  def BFSLevelAverages(root:TreeNode):Array[Any] = {

    var output : ArrayBuffer[Any] = scala.collection.mutable.ArrayBuffer.empty
    var q  = scala.collection.mutable.Queue[TreeNode]()

    q.enqueue(root)

    while(q.length>0)
      {
        var currentLevel:ArrayBuffer[Any] = scala.collection.mutable.ArrayBuffer.empty
        var arraySum = 0.0

        for (i<- 0 to q.length-1)
          {

            val currentNode = q.dequeue()
            currentLevel = currentLevel ++ ArrayBuffer(currentNode.value)
            arraySum = arraySum + currentNode.value

            if (currentNode._left != null) {
              q.enqueue(currentNode._left)
            }
            if (currentNode._right != null) {

              q.enqueue(currentNode._right)
            }

          }



        output = output ++ ArrayBuffer(arraySum/currentLevel.length)




      }




    output.toArray

  }

  def BFSMinTreeDepth(root:TreeNode):Int = {

    var minDepth = 0
    var done = false

    var q  = scala.collection.mutable.Queue[TreeNode]()

    q.enqueue(root)

    while(q.length>0)
    {
      minDepth +=1

      if (!done) {

        for (i <- 0 to q.length - 1) {

          val currentNode = q.dequeue()

          if (currentNode._left == null && currentNode._right == null) {

            done=true

          }


          if (currentNode._left != null) {
            q.enqueue(currentNode._left)
          }
          if (currentNode._right != null) {

            q.enqueue(currentNode._right)
          }

        }
      }

    }

    minDepth

  }


  val root = new TreeNode(12);
  root._left = new TreeNode(7);
  root._right = new TreeNode(1);
  root._left._left = new TreeNode(9);
  root._right._left = new TreeNode(10);
  root._right._right = new TreeNode(5);



  //println(root)
  //println(BFSTraverse(root).toList)
  //println(reverseBFS(root).toList)
  //println(BFSLevelAverages(root).toList)
  println(BFSMinTreeDepth(root))

}
