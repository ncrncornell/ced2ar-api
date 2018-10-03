import mill._
import mill.scalalib._
import mill.scalajslib._
import mill.scalalib.publish._

val scalaVersions = List("2.11.12", "2.12.7")


object api extends Module {

  class ApiJvmModule(val crossScalaVersion: String)
      extends Ced2arApiModule {
    def platformSegment = "jvm" 
  }
  object jvm extends Cross[ApiJvmModule](scalaVersions: _*)

  class ApiJsModule(val crossScalaVersion: String)
      extends Ced2arApiModule
      with ScalaJSModule {
    def platformSegment = "js"
    def scalaJSVersion = "0.6.25"
  }
  object js extends Cross[ApiJsModule](scalaVersions: _*)

}

trait Ced2arApiModule
    extends CommonModule
    with CrossScalaModule
    with PublishModule {

  val apiFolder: String = "api"
  def millSourcePath = build.millSourcePath / apiFolder


  def artifactName = "ced2ar3-api"
  def publishVersion = "0.0.3"
  def pomSettings = PomSettings(
    description =
      """Comprehensive Extensible Data Documentation and
      | Access Repository (AAR) was designed to improve the documentation and
      | discoverability of both public and restricted data. Version 3 is a
      | modular implementaiton of CED2AR.""".stripMargin.replaceAll("\n", " "),
    organization = "edu.cornell.ncrn.ced2ar",
    url = "https://github.com/ncrncornell/ced2ar-api",
    licenses = Seq(License.`CC-BY-NC-SA-4.0`),
    versionControl = VersionControl.github("ncrncornell", "ced2ar-api"),
    developers = Seq(
      Developer("bbarker",
                "Brandon Barker",
                "https://www.cac.cornell.edu/barker/",
                Some("Cornell University")),
      Developer("larsvilhuber",
                "Lars Vilhuber",
                "https://www.ilr.cornell.edu/people/lars-vilhuber",
                Some("Cornell University")),
      Developer("CSimmer",
                "Charles C Simmer",
                "https://github.com/CSimmer",
                Some("Cornell University"))
    )
  )
  
}


trait CommonModule extends ScalaModule {
  
  def platformSegment: String

  def sources = T.sources(
    millSourcePath / platformSegment / "src"  ,
    millSourcePath / "shared" / "src"  ,
  )

  def scalacOptions = Seq(
    "-Ypartial-unification",
    "-language:higherKinds",
    "-deprecation",
    "-feature"
  )
   
  /*
  def ivyDeps = Agg(
    ivy"org.typelevel::cats-core::$catsVersion",
    ivy"org.typelevel::cats-free::$catsVersion",
    ivy"com.lihaoyi::fastparse::$fastparseVersion",
    ivy"com.github.mpilquist::simulacrum::$simulacrumVersion"
  )

  def scalacPluginIvyDeps = super.scalacPluginIvyDeps() ++ Agg(
    ivy"org.spire-math::kind-projector:$kindProjectorVersion",
    ivy"org.scalamacros:::paradise:$macroParadiseVersion"
  )
  */
}