/*
  Polymorphic types example
  By Mgil
*/
abstract class Set[A] {
  def incl(a: A): Set[A]
  def contains(a: A): Boolean
}
class Empty[A] extends Set[A] {
  def incl(a: A): Set[A] = new NonEmpty[A](a, new Empty[A], new Empty[A])  
  def contains(a: A): Boolean = false
  override def toString = "·"
}
class NonEmpty[A](elem: A, left: Set[A], right: Set[A]) extends Set[A] {
  
  def contains(a: A): Boolean = 
    if(!a.equals(elem)) right.contains(a) || left.contains(a)
    else true
  // One big problem with this method: 
  // The type parameter has the Any class as definition, so it only has the "equal" method to compare between values
  // * Can't use the comparator operators "<" or ">" because the language don't recongnice them in a Type parameter
  // So the "incl" function hasn't correct funcionality
  def incl(a: A): Set[A] = 
    if(!left.contains(a)) new NonEmpty(elem, left.incl(a), right)
    else if(!right.contains(a)) new NonEmpty(elem, left, right.incl(a))
    else this
  
  override def toString = "(" + left.toString() + "[" + elem + "]" + right.toString() + ")"
}

println("Test")


val a = new Empty[Int]()
val b = new NonEmpty[Int](3, a, a)
val c = b.incl(1)
val d = c.incl(8)
val f = d.incl(3)
println(f.toString())
