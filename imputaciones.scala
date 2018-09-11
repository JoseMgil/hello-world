val cod1 = "Z/0912"
val cod2 = "Z/1094"
val cod3 = "Z/1029"
val h1 = 3 
val h2 = 46

class Imputacion(v_codigo: String, v_horas: Int) {
  var codigo = v_codigo
  var horas = v_horas
  
  def totalDias(jornada: Int): Int = {
    horas / jornada
  }

  def restoHoras(jornada: Int): Int = {
    horas % jornada
  }
  
  def esImputacionRedonda(jornada: Int): Boolean = {
    if (horas % jornada == 0) true
    else false
  }
  
  override def toString(): String = {
    "[" + codigo + "|" + horas + "]"
  }
  
}

val imp1 = 
new Imputacion(cod1,h2)


println("Total días: " + imp1.totalDias(8))
println("La imputación es redonda: " + imp1.esImputacionRedonda(8))
println(imp1 + "-> " + imp1.totalDias(8) + " dias y " + imp1.restoHoras(8) + " horas")
