/*
  Examples of List uses and methods
  By Mgil
*/

/*
* Declare a List
* 
* Info: 
*  - Lists are immutable --- the elements of a list cannot be changed,
*  - Lists are recursive (as you will see in the next subsection),
*  - Lists are homogeneous: the elements of a list must all have the same type.
*/
val fruit = List("apples", "oranges", "pears") 
val nums = List(1, 2, 3, 4)  
val diag3 = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1)) //List composed of List
val empty = List()  // An empty List --> Represented as "Nil"
val nums2: List[Int] = List(1, 2, 3, 4) // List with specify type (note the ":" in the val definition)

/* 
* Construction of a List
*   Operator "::" => x :: xs = Return a new list with the first element "x", included in the "xs" List at first position
*/
val fruit2 = "apples" :: ("oranges" :: ("pears" :: Nil))
val nums3 = 1 :: (2 :: (3 :: (4 :: Nil)))

/* val asoci = 1 :: 2 :: 3 --> WORNG */
val asoci = 1 :: 2 :: 3 :: Nil // The correct way to create that List, same as  ** val asoci3 = 1 :: (2 :: (3 :: Nil)) ** 

// The Method way to create the list above is: 
val asoci2 = Nil.::(4).::(3).::(2).::(1)
/* 
* Remeber, all the operators ARE method with a special call, so as "+" or "*" can be used as 1.+(2), you can use "::" as a method
* 
* The method "::" is to add the Left value to a List in the Right value (is Right Associativity)
* 
* In the WORNG case, you are tryng to add the Int "1" to an unexisting List, because the second parameter will be "2 :: 3", and that's not a List. 
*/

// List with pattern matching 
nums match {
  // Lists of `Int` that starts with `1` and then `2`
  case 1 :: 2 :: xs => println("One an two List")
  // Lists of length 1
  case x :: Nil => println("One size List")
  // Same as `x :: Nil`
  case List(x) => println("One size List()")
  // The empty list, same as `Nil`
  case List() => println("An empty List")
  // A list that contains as only element another list that starts with `2`
  // case List(2 :: xs) => println("A List with a 2 List start")
}

// Common operations: 
val mapList = List(1, 2, 3).map(x => x + 1)
println(mapList)

val filterList = List(1, 2, 3).filter(x => x % 2 == 0) 
println(filterList)

val flatMapList =
  List(1, 2, 3).flatMap { x =>
    List(x, 2 * x, 3 * x)
  }
println(flatMapList)

/*
* Sort method: Exercise of List
* 
*  - Define the following parameters: 
*     A)  val cond: (Int, Int) => Boolean = "_ _ _ _"
*       
*     B)  case List() => x :: "_"
*/ 

// 
  def insertionSort(xs: List[Int]): List[Int] = 
    xs match {
      case List() => List()
      case y :: ys => insert(y, insertionSort(ys))
    }

  val cond: (Int, Int) => Boolean = (x,y) => x < y // Question A

  // Recursive fun
  def insert(x: Int, xs: List[Int]): List[Int] =
    xs match {
      case List() => x :: Nil // Question B
      case y :: ys =>
        if (cond(x, y)) x :: y :: ys
        else y :: insert(x, ys)
    }
//

// Test code
println(fruit(1))
println(asoci(2))
println(asoci(3))
