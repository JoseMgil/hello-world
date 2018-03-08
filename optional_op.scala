/*
  Examples of Optional values and Either
  By Mgil
*/

/* 
* Optional return value
* - Option[A] reprepent a optional Return value as A Type
* - If there is no value, ret: None
* - If there is a value, ret: Some(x) --> Note that x could be a operation
*/
def sqrtOption(x: Double): Option[Double] = {
if (x < 0) None
else Some(x * x)
}

/*
* Either return value
* - Either[A, B]: You can choose between A or B type to return in your function
* - For the A type, uses Left(x)
* - For the B type, uses Right(x)
*/
def sqrtEither(x: Double): Either[Double, String] = {
if (x < 0) Right("x must be positive")
else 
   Left(x * x)
}

/* 
* Use of "map" 
* TODO: Review the use of "map", "filter" and "flatMap". 
*/
def sqrtSome(x: Double): Option[Double] = {

if(x < 0) None
else {
  val ret = Some(x * x)
  ret.map(y => y * y)
  } 
}

// Test cases
println(sqrtOption(2))
println(sqrtOption(-2))
println(sqrtEither(2))
println(sqrtEither(-2))

/* Results: 
Some(4)
None
Left(4)
Right(x must be positive)
*/

  
