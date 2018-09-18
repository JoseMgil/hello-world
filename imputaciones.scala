/*
  Class Imputaciones - To get the exact days and hours to register
  By Mgil
*/
// IMPUTACIONES JULIO

 
/**
 * Class Resultado
 * Identify the total days and hours necesary to input 
*/ 
case class Resultado(dias: Int, horas: Int){
  override def toString(): String = dias + " dias y " + horas + " horas"
}


/**
 * Class Imputacion
 * Identify the total hours to input in the specified project code 
*/
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

/**
  * Class RealizaImputacion
  * Checks and obtain all the ResultadoImputacion from a List of Imputaciones 
*/
class RealizaImputacion(v_nombre: String, v_totalImputar: Int, v_listaImp: List[Imputacion], v_jornada: Int) {
  
  var nombre = v_nombre
  var listaImp = v_listaImp
  var totalImputar = v_totalImputar
  var jornada = v_jornada
  
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
    imp.toString() + "-> " + resultadoImputacion(imp).toString()
  }
  
  def resultadoImputacion(imp: Imputacion): Resultado = {
    Resultado(imp.totalDias(jornada), imp.restoHoras(jornada))
  }
  
  //TODO: Implementar ordenado
  def ordenarImputacion(): Boolean = false
  
}

//TEST CASE: 
val listaImp = List(imp1, imp2, imp3, imp4, imp5, imp6, imp7, imp8, imp9, imp10, imp11, imp12, imp13, imp14, imp15)

val imputar1 = new RealizaImputacion("Jose", 154, listaImp, 7)

for (item <- imputar1.obtenerImputaciones()) println(item)
