/*
 * Monocle examples 
 * By Mgil
*/
import monocle.Iso
// A inmutable Case Class
case class Vehicle(model: String, wheels: Int)

// An ISO to trasform between Case Class and (String, Int) tuple
val vehicleToTuple = Iso[Vehicle, (String, Int)](p => (p.model, p.wheels)) {case (model, wheels) => Vehicle(model, wheels)}

println(vehicleToTuple.get(Vehicle("Opel", 4)))
println(vehicleToTuple(("Ford", 2)))

// An Iso also is used to trasnform collections (like List to Vector)
def listToVector[A] = Iso[List[A], Vector[A]](_.toVector)(_.toList)

println(listToVector.get(List(1, 2, 3)))

//TODO: Implement other Iso for other collections (i.e. List to Map)
