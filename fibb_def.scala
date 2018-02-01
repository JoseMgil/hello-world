// Fibonacii definition
def fibb(n: Int): Int = {

  def iter(x: Int): Int = 
  if (x <= 0) 0 
  else if (x == 1) 1
  else iter(x - 1) + iter(x - 2) 

  iter(n)
}

println(fibb(7))
