val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
val nums = 1 :: (2 :: (3 :: (4 :: Nil)))

// The correct way to create that List is with the following sentence: 
val asoci = 1 :: 2 :: 3 :: Nil
// A Method way to create the list is: 
val asoci2 = Nil.::(4).::(3).::(2).::(1)
// * Remeber, all the operator ARE method with a special call, so as "+" or "*" can be used as 1.+(2), you can use "::" as a method
//      val asoci = 1 :: 2 :: 3 --> WORNG: The method "::" is to add the Left value to a List in the Right value (is Right Associativity)
//      In this case, you are tryng to add the Int "1" to an unexisting List, because the second parameter will be "2 :: 3", and that's not a List
//      The correct way to do it is the showed above, that is the same to call: 
val asoci3 = 1 :: (2 :: (3 :: Nil))

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

// Sort code
def insertionSort(xs: List[Int]): List[Int] = 
  xs match {
    case List() => List()
    case y :: ys => insert(y, insertionSort(ys))
  }

val cond: (Int, Int) => Boolean = (x,y) => x < y

// Recursive fun
def insert(x: Int, xs: List[Int]): List[Int] =
  xs match {
    case List() => x :: Nil

    case y :: ys =>
      if (cond(x, y)) x :: y :: ys
      else y :: insert(x, ys)
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


// Nil = empty List
val empty = Nil

println(fruit(1))
println(asoci(2))
