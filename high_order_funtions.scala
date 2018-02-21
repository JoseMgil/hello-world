/*
 Examples with High order Functions (functions as a parameter)
*/

// Default sum function, the High order function example
// - Note the fun parameter definition: "Int => Int" as a function that recieve one parameter as Int value and return a Int value
def sum(fun: Int => Int, a: Int, b: Int): Int =
  if (a > b) 0
  else fun(a) + sum(fun, a + 1, b)

// Functions to use as a parameter
def id(x: Int): Int = x // Return the same value
def cube(x: Int): Int = x * x // Return x^2
// Return the factorial value of a number: "n!"
def factorial(x: Int): Int = {
  if (x == 0) 0
  else if (x == 1) 1
  else x * factorial(x - 1)
}

// Sums funtions using the model "sum"
def sumInts(a: Int, b: Int) = sum(id, a, b)
def sumCubes(a: Int, b: Int) = sum(cube, a, b)
def sumFactorials(a: Int, b: Int) = sum(factorial, a, b)

// Function definition with Anonymous Functions
// - Note the declaration as a parameter of the "x^3" function: "x => x * x * x"
def sumElevateThree(a: Int, b: Int) = sum(x => x * x * 2, a, b)


// Testing code
println(sumFactorials(4, 5))
println(sumCubes(2, 3))
println(sumInts(1, 10))
println(sumElevateThree(2,6))
