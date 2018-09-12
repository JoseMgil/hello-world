// Start writing your ScalaFiddle code here
// IMPUTACIONES JULIO
val imp1 = new Imputacion("Z/019664-001",19)
val imp2 = new Imputacion("Z/017604-001",1)
val imp3 = new Imputacion("Z/017624-001",2)
val imp4 = new Imputacion("Z/017597-001",6)
val imp5 = new Imputacion("Z/019071-001",1)
val imp6 = new Imputacion("Z/020241-001",8)
val imp7 = new Imputacion("Z/016599-001",49)
val imp8 = new Imputacion("Z/021708-001",5)
val imp9 = new Imputacion("Z/019068-001",8)
val imp10 = new Imputacion("Z/021915-001",5)
val imp11 = new Imputacion("Z/018543-002",11)
val imp12 = new Imputacion("Z/018338-001",4)
val imp13 = new Imputacion("Z/019029-002",7)
val imp14 = new Imputacion("Z/019504-002",14)
val imp15 = new Imputacion("Z/019520-002",14)

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
    if(sumaImputaciones(listaImp) == totalImputar) true
    else false
  }
  
  def sumaImputaciones(list: List[Imputacion]): Int = {
    list match{
      case List() => 0 
      case x :: xs => x.horas + sumaImputaciones(xs)
    }
  }
  
  def obtenerImputaciones(): List[String] = {
    
    if(imputacionCorrecta()) {
      // Revisar si es correcto el "var" aqui
      var ret = List("Imputaciones " + nombre + ":")
      for ( e <- listaImp) {
        ret = ret:+ resumenImputacion(e)
      }
      ret      
    }
    else{
      List("Imputación Incorrecta")
    } 
    
  }
  
  def resumenImputacion(imp: Imputacion): String  = {
    imp.toString() + "-> " + imp.totalDias(7) + " dias y " + imp.restoHoras(7) + " horas"
  }
  
  
}
val listaImp = List(imp1, imp2, imp3, imp4, imp5, imp6, imp7, imp8, imp9, imp10, imp11, imp12, imp13, imp14, imp15)

val imputar1 = new RealizaImputacion("Jose", 154, listaImp)

for (item <- imputar1.obtenerImputaciones()) println(item)
