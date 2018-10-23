package com.dojo.scalatra.first

import com.dojo.scalatra.first.Concesionario.Carro
import org.scalatra._
// JSON-related libraries
import org.json4s.{DefaultFormats, Formats}

// JSON handling support from Scalatra
import org.scalatra.json._

class FirstServlet extends ScalatraServlet with JacksonJsonSupport {
  protected implicit lazy val jsonFormats: Formats = DefaultFormats

  before() {
    contentType = formats("json")
  }

  get("/carros") {
    Concesionario.carros
  }

  get("/carros/puertas/color") {
    Concesionario.colorPuertas()
  }

  post("/") {
    Concesionario.crearCarro(extraerCarro())
  }

  put("/:referencia") {
    Concesionario.actualizarCarro(extraerReferencia(), extraerCarro())
  }

  delete("/:referencia") {
    Concesionario.borrarCarro(extraerReferencia())
  }

  def extraerCarro(): Carro = {
    parse(request.body).extract[Carro]
  }

  def extraerReferencia(): String = {
    params.get("referencia").orNull
  }

}
