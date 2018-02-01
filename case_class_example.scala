/*
  Case class and sealed trait example with methods
*/

sealed trait NoteName
case object A extends NoteName
case object B extends NoteName
case object C extends NoteName

sealed trait Symbol
case class Note(name: NoteName, duration: String, octave: Int) extends Symbol
case class Rest(duration: String) extends Symbol

val c1: Symbol = Note(A,"Half", 1)
val c2: Symbol = Rest("One")

def symbolDuration(symbol: Symbol): String =
  symbol match {
    case Note(name, duration, octave) => duration
    case Rest(duration) => duration
  }

println(symbolDuration(c2))
if (c1 == c2) println("Equals!")
else println("Not equals...")
