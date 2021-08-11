package scala.marathon

object TreeTraversal extends App{


  import scala.collection.immutable.Queue

  /**
    *
    *               1
    *             / |  \
    *           /   |   \
    *         /     |    \
    *        2      3     8
    *      /  \    / \   / \
    *     4    5  6   7 9  10
    * Preorder: 1,2,4,5,3,6,7,8,9,10
    * InOrder: 4,2,5,1,6,3,7,9,8,10
    * PostOrder: 4,5,2,6,7,3,9,10,8,1
    * LevelOrder: 1,2,3,8,4,5,6,7,9,10
    *
    **/


  case class Tree[T](value: T, children: List[Tree[T]])

  val tree = Tree(1,List(
    Tree(2,List(Tree(4,Nil), Tree(5,Nil))),
    Tree(3,List(Tree(6,Nil), Tree(7,Nil))),
    Tree(8,List(Tree(9,Nil), Tree(10,Nil)))
  ))


  def preOrder[T,S](tree: Tree[T], f: T => S): scala.collection.immutable.Queue[S] = {
    def loop(g: Tree[T], output: scala.collection.immutable.Queue[S]): scala.collection.immutable.Queue[S] = g match {
      case Tree(v,c) =>   c.foldLeft(output.enqueue(f(v))){case (acc,n) => loop(n,acc)}
    }
    loop(tree,Queue.empty[S])
  }

  /*def postOrder[T,S](tree: Tree[T], f: T => S): scala.collection.immutable.Queue[S] = {
    def loop(g: Tree[T], output: scala.collection.immutable.Queue[S]): scala.collection.immutable.Queue[S] = g match {
      case Tree(v,rest) => rest.foldLeft(output){case (agg,node) => loop(node,agg)}.enqueue(f(v))
    }
    loop(tree,Queue.empty)
  }
*/
  def inOrder[T,S](tree: Tree[T], f: T => S): scala.collection.immutable.Queue[S] = {
    def loop(g: Tree[T], output: scala.collection.immutable.Queue[S]): scala.collection.immutable.Queue[S] = g match {
      case Tree(v,l::ls) => ls.foldLeft(loop(l,output).enqueue(f(v))){case (acc,n) => loop(n,acc)}
      case Tree(v,Nil) => output.enqueue(f(v))
    }
    loop(tree, Queue.empty)
  }

/**
  *
  *               1
  *             / |  \
  *           /   |   \
  *         /     |    \
  *        2      3     8
  *      /  \    / \   / \
  *     4    5  6   7 9  10
  * Preorder: 1,2,4,5,3,6,7,8,9,10
  * InOrder: 4,2,5,1,6,3,7,9,8,10
  * PostOrder: 4,5,2,6,7,3,9,10,8,1
  * LevelOrder: 1,2,3,8,4,5,6,7,9,10
  *
  * Tree(1,List(
    Tree(2,List(Tree(4,Nil), Tree(5,Nil))),
    Tree(3,List(Tree(6,Nil), Tree(7,Nil))),
    Tree(8,List(Tree(9,Nil), Tree(10,Nil)))
  **/

  def breadthFirstSearch[T,S](node: Tree[T], f: T => S): scala.collection.immutable.Queue[S] = {
    def recurse(g: Tree[T],output: scala.collection.immutable.Queue[S]): scala.collection.immutable.Queue[S] = {



      g match  {

        case Tree(v,rest) => rest.foldLeft(output){case(acc,n) => recurse(n,acc)}

        case Tree(v,Nil) => output.enqueue(f(v))

          //c.foldLeft(output.enqueue(f(v))){case(acc,n) => recurse(n,acc)}

        //case Tree(v,Nil) => output.enqueue(f(v))
      }

/*     if (q.isEmpty) {
        Queue.empty
      } else {
        val (node, tail) = q.dequeue
        node #:: recurse(tail ++ f(node))
      }*/
    }

    recurse(node,Queue.empty)


  }
  val preO = preOrder(tree,identity[Int])
  val breadth0 = breadthFirstSearch(tree,identity[Int])
/*  val postO = postOrder(tree,identity[Int])
  val inO = inOrder(tree,identity[Int])


  println(s"post-order: $postO")
  println(s"in-order: $inO")*/

  //println(s"pre-order: $preO")
  //println(s"breadth-frist-search: $breadth0")

/*

  import scala.collection.immutable.Queue

  def breadth_first_traverse[Node](node: Node, f: Node => scala.collection.immutable.Queue[Node]): Stream[Node] = {
    def recurse(q: scala.collection.immutable.Queue[Node]): Stream[Node] = {
      if (q.isEmpty) {
        Stream.Empty
      } else {
        val (node, tail) = q.dequeue
        node #:: recurse(tail ++ f(node))
      }
    }

    node #:: recurse(Queue.empty ++ f(node))
  }
*/


  case class BTree[T](node:T,left:Option[BTree[T]]=None,right:Option[BTree[T]]=None)

  val btree1 = BTree(1, Some(BTree(2, Some(BTree(4)),Some(BTree(5)))), Some( BTree (3, Some(BTree(6)), Some(BTree(7)))))
  val btree = BTree(1,Some(BTree(2, Some(BTree(4)), Some(BTree(5)))), Some(BTree(3, Some(BTree(6)), Some(BTree(7)))))
  val btree2 = BTree(1,Some(BTree(2, Some(BTree(4, Some(BTree(8)), Some(BTree(9)))), Some(BTree(5)))), Some(BTree(3, Some(BTree(6)), Some(BTree(7)))))

  def preOrderTree[T](btree:BTree[T],output:scala.collection.mutable.Queue[T]):scala.collection.mutable.Queue[T] = {

    output.enqueue(btree.node)

    if (btree.left.isDefined)  preOrderTree(btree.left.get,output)
    if (btree.right.isDefined) preOrderTree(btree.right.get,output)

    output


  }


  def preOrderTree1[T,S](btree:BTree[T],f:T => S):scala.collection.mutable.Queue[S] = {

    def loop (btree:BTree[T],output:scala.collection.mutable.Queue[S]): scala.collection.mutable.Queue[S]  = {

      output.enqueue(f(btree.node))

      if (btree.left.isDefined) loop (btree.left.get, output)
      if (btree.right.isDefined) loop (btree.right.get, output)

      output

    }



    loop(btree,scala.collection.mutable.Queue.empty)
  }
  /*
   *
   *               1
   *             / |  \
     *           /   |
     *         /     |
     *        2      3
   *      /  \    / \
   *     4    5  6   7
 */


  def levelOrderTree[T,S](btree:BTree[T],f:T => S):scala.collection.mutable.Queue[S] = {

    def loop(btree: BTree[T],output : scala.collection.mutable.Queue[S]): scala.collection.mutable.Queue[S] = {




      if (btree.left.isDefined && btree.right.isDefined)
        {
          output.enqueue(f(btree.left.get.node))
          output.enqueue(f(btree.right.get.node))

        }


      loop(btree.left.get,output)
      loop(btree.right.get,output)




output
    }

    loop(btree,scala.collection.mutable.Queue(f(btree.node)))



  }

  def inOrderTree[T](btree:BTree[T]):Unit = {

    if (btree.left.isDefined) inOrderTree(btree.left.get)

    print(btree.node)
    if (btree.right.isDefined) inOrderTree(btree.right.get)


  }

  def postOrderTree[T](btree: BTree[T]):Unit = {

    if (btree.left.isDefined) postOrderTree(btree.left.get)
    if (btree.right.isDefined) postOrderTree(btree.right.get)
    print(btree.node)

  }

  //val preOrderOutput1 = preOrderTree1(btree1,identity[Int])

  val levelOrderOuput = levelOrderTree(btree2,identity[Int])

  println(levelOrderOuput)

  //println(preOrderOutput1)

  //val preOrderOutput = println(preOrderTree(btree1,scala.collection.mutable.Queue.empty))
  println("")

  //val inOrderOutput = inOrderTree(btree1)

  println("")

  //val postOrderOutput = postOrderTree(btree1)

}
