import mill._
import mill.scalalib._

val crossMatrix = for {
  crossVersion <- Seq("212")
  platform <- Seq("jvm", "js")
} yield (crossVersion, platform)

object api extends Cross[Ced2arApiModule]("2.12.6")
class Ced2arApiModule(val crossScalaVersion: String) extends CrossScalaModule { 

}

/*
import mill._
import mill.scalalib._

val crossMatrix = for {
  crossVersion <- Seq("212")
  platform <- Seq("jvm", "js")
} yield (crossVersion, platform)

object api extends mill.Cross[Ced2arApiModule](crossMatrix:_*)
class Ced2arApiModule(crossScalaVersion: String, platform: String) extends CrossScalaModule {
  def suffix = T { crossScalaVersion + "_" + platform }
}
*/