/*
  Case class and sealed trait example with methods
*/

// Definition of the Note Name: Enum Like code
// TODO: Complete the full note names
sealed trait NoteName
case object A extends NoteName
case object B extends NoteName
case object C extends NoteName

// Definition of the Symbol sealed trait and the differents classes
// INFO: Note that the constructor must extend the Symbol trait
sealed trait Symbol
case class Note(name: NoteName, duration: String, octave: Int) extends Symbol
case class Rest(duration: String) extends Symbol

// Duration method: The case constructor must be equal here than the case class definition
def symbolDuration(symbol: Symbol): String =
  symbol match {
    case Note(name, duration, octave) => duration
    case Rest(duration) => duration
  }

// Note name conversion: To convert the name ot the note from UK system to the Latin system
def noteNameConversion(name: NoteName): String = 
  name match {
    case A => "sol"
    case B => "la"
    case C => "do"
  }

// Testing Code
val c1: Symbol = Note(A,"Half", 1)
val c2: Symbol = Rest("One")

println(symbolDuration(c2))
if (c1 == c2) println("Equals!")
else println("Not equals...")

