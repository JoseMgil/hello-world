/*
  By Mgil
*/
class Rational(x: Int, y: Int) {
  require(x > 0, "numerator must be positive")
  require(y > 0, "denominator must be positive")
  // You could use "assert(x > 0) to check the value of the parameters. The difference between this two methods is:"
  // "require" is used to enforce a precondition on the caller of a function.
  // "assert" is used as to check the code of the function itself.

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  def numer = x / gcd(x, y)
  def denom = y / gcd(x, y)
  
  def add(r: Rational) = 
    new Rational(numer * r.denom + r.numer * denom, denom * r.denom)
  
  def sub(r: Rational) = 
    new Rational(numer * r.denom - r.numer * denom, denom * r.denom)
    
  def mul(r: Rational) = 
    new Rational(numer * r.numer, denom * r. denom) 
  
  def div(r: Rational) = 
    new Rational(numer * r.denom, denom * r.numer)
    
  override def toString = numer + "/" + denom
  
  def less(that: Rational) =
    this.numer * that.denom < that.numer * this.denom
    
  def max(that: Rational) =
    if(this.less(that)) that else this
  

}

val x = new Rational(3, 1)
val y = new Rational(5, 2)
val z = new Rational(1, 4)

println(x.add(y).mul(z))
println(x add y)

println(x.toString)
println(new Rational(24, 8)) // Example with the GCD private method
println(new Rational(1, -3)) // Example or require method
