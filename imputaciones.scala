// Start writing your ScalaFiddle code here
val cod1 = "Z/0912"
val cod2 = "Z/1094"
val cod3 = "Z/1029"
val h1 = 10
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


class RealizaImputacion(v_nombre: String, v_totalImputar: Int, v_listaImp: List[Imputacion]) {
  
  var nombre = v_nombre
  var listaImp = v_listaImp
  var totalImputar = v_totalImputar
  
  def imputacionCorrecta(): Boolean = {
    //TODO: Implementar 
    if(sumaImputaciones(listaImp) == totalImputar) true
    else false
  }
  
  def sumaImputaciones(list: List[Imputacion]): Int = {
    list match{
      case List() => 0 
      case x :: xs => x.horas + sumaImputaciones(xs)
    }
  }
  
}


val imp1 = new Imputacion(cod1,h1)
val imp2 = new Imputacion(cod2,h2)

println("Total días: " + imp1.totalDias(8))
println("La imputación es redonda: " + imp1.esImputacionRedonda(8))
println(imp1 + "-> " + imp1.totalDias(8) + " dias y " + imp1.restoHoras(8) + " horas")

val imputar1 = new RealizaImputacion("Jose", 56, List(imp1, imp2))
println(imputar1.imputacionCorrecta())
