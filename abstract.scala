

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def sub(x:Int): IntSet
}

class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NoEmpty(x, new Empty, new Empty)
  def sub(x: Int): IntSet = new Empty()
  override def toString = "O"
}

class NoEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  
  def contains(x: Int): Boolean = 
    if(x < elem) left.contains(x)
    else if(x > elem) right.contains(x)
    else true
  
  def incl(x: Int): IntSet = 
    if(x < elem) new NoEmpty(elem, left.incl(x), right)
    else if(x > elem) new NoEmpty(elem, left, right.incl(x))
    else this
    
  def sub(x: Int): IntSet = 
    if(x < elem) left.sub(x)
    else if(x > elem) right.sub(x)
    else right
  
  override def toString = "(" + left + "[" + elem + "]" + right + ")"
    
}

val a = new Empty()
val b = new NoEmpty(3, a, a)
val c = b.incl(1)
val d = c.incl(8)
val r = d.sub(3)

println(c)
