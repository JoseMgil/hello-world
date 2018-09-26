import monocle.Lens

case class City(postal_code: Int, city_name: String)


// Lens create a zoom into the field of the case class 
/* 
 * It creates two methods: get and set
*/ 
val strPostal = Lens[City, Int](_.postal_code)(n => a => a.copy(postal_code = n))

val c1 = City(123 , "Kansas")

println(strPostal.get(c1))

println(strPostal.set(212)(c1))

println(strPostal.modify(_ + 1)(c1))
println(strPostal.set(10 + 1)(c1))
