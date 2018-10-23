package com.dojo.scalatra.first

import org.scalatra.test.scalatest._

class FirstServletTests extends ScalatraFunSuite {

  addServlet(classOf[FirstServlet], "/*")

  test("GET / on FirstServlet should return status 200") {
    get("/") {
      status should equal (200)
    }
  }

}
