import mill._
import mill.scalalib._
import mill.scalajslib._

object api extends Cross[Ced2arApiModule]("2.12.6")
class Ced2arApiModule(val crossScalaVersion: String) extends CrossScalaModule with ScalaJSModule { 
  def scalaJSVersion = "0.6.25"
}