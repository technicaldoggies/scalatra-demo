package com.dojo.scalatra.first

object Concesionario {

  case class TipoCarro(nombre: String, descripcion: String)
  case class PuertaCarro(color:String, peso:Int)
  case class Carro(referencia:String, tipo:TipoCarro, puertas:Seq[PuertaCarro], marca:String)

  val carros = crearCarros()

  def crearCarros():Seq[Carro] = {
    List(
      Carro("ABC1", TipoCarro("Automovil", "Description automovil"), List(PuertaCarro("Rojo", 90)), "Mazda"),
      Carro("ABC2", TipoCarro("Camioneta", "Description camioneta"), List(PuertaCarro("Verde", 90)), "Ford"),
      Carro("ABC3", TipoCarro("Furgon", "Description furgon"), List(PuertaCarro("Blanco", 90)), "Doge"),
      Carro("ABC4", TipoCarro("Deportivo", "Description deportivo"), List(PuertaCarro("Negro", 90)), "Ferrari"),
      Carro("ABC5", TipoCarro("Familiar", "Description familiar"), List(PuertaCarro("Azul", 90)), "Chevrolet"))
  }

  def colorPuertas(): Seq[String] = {
    carros.flatMap(_.puertas).map(_.color)
  }

  def crearCarro(carro: Carro): Seq[Carro] = {
    carros:+carro
  }

  def actualizarCarro(referencia: String, carro: Carro): Seq[Carro] = {
    buscarCarro(referencia)
    borrarCarro(carro.referencia):+carro
  }

  def buscarCarro(referencia: String): Either[String, Carro] = {
    val carro = carros.find(_.referencia == referencia)
    if (carro.isEmpty) {
      Left("Carro no encontrado")
    }
    Right(carro.get)
  }

  def borrarCarro(referencia: String): Seq[Carro] = {
    carros.filterNot(_.referencia == referencia)
  }
}
