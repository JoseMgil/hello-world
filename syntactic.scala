/*
  JoseMgil
  Syntactics conveniences
*/
def greet(name: String): String =
  s"Hello, $name!"

def greetUp(name: String): String =
  s"Hello, ${name.toUpperCase}!"


println(greet("Antonio"))
println(greetUp("manuel"))


def pair(i: Int, s: String): (Int, String) = (i, s)

println(pair(1, "Manuel"))


case class Range(start: Int, end: Int, step: Int)
var a = Range(start = 1, end = 10, step = 1) 
println(a)


/* 
  Function with arbitrary number of parameters
  The function does: 
  - Take a list pased by parameter, and SUM the elements
  - Cast the result to Double
  - Divide it by the size of the list (it use xs so you need to plus 1 because x is missing)
*/
def variosParam(x: Int, xs: Int*): Double =
  (x :: xs.to[List]).sum.toDouble / (xs.size + 1)

println(variosParam(1,2))
println(variosParam(1,2,3))

/* 
   Example of Type expresion with name
*/
type Result = Either[String, (Int, Int)]
def divide(dividend: Int, divisor: Int): Result =
  if (divisor == 0) Left("Division by zero")
  else Right((dividend / divisor, dividend % divisor))
  
println(divide(4,2))
