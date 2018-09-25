import monocle.Iso
import monocle.macros.GenIso
// A inmutable Case Class
case class Vehicle(model: String, wheels: Int)

// An ISO to trasform between Case Class and (String, Int) tuple
val vehicleToTuple = Iso[Vehicle, (String, Int)](p => (p.model, p.wheels)) {case (model, wheels) => Vehicle(model, wheels)}

println("@Iso - get example = " + vehicleToTuple.get(Vehicle("Opel", 4)))
println("@Iso - reverseGet example = " + vehicleToTuple(("Ford", 2)))

// An Iso also is used to trasnform collections (like List to Vector)
def listToVector[A] = Iso[List[A], Vector[A]](_.toVector)(_.toList)

println("@Iso - Collection Example = " + listToVector.get(List(1, 2, 3)))

//TODO: Implement other Iso for other collections (i.e. List to Map)

// GenIso - Macro that generates an Iso of the given type
/* 
 * It can be used as "apply" (use it directly) to get the Iso 
 * Or can use "fields" to automate generate a Iso of the given object
 * And also can use "unit" for objects or empty case class (with no field)
*/

case class Note(name: String)
println("#GenIso - Apply example = " + GenIso[Note, String].get(Note("C")))

println("#GenIso - Fields example= " + GenIso.fields[Vehicle].get(Vehicle("Citroen", 3)))

case class Out()
println("#GesIso - Unit example = " + GenIso.unit[Out])
