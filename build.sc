import mill._
import mill.scalalib._
import mill.scalajslib._
import mill.scalalib.publish._

val crossMatrix = for {
  crossVersion <- Seq("2.12.6")
  platform <- Seq("jvm", "js", "native")
  if !(platform == "native")
} yield (platform, crossVersion)

val apiFolder: String = "api"

trait ObjName { self => def objName = self.getClass.getName.split("\\$").last } 

object api extends Cross[Ced2arApiModule](crossMatrix: _*) with ObjName {
  assert(objName == apiFolder)
}

class Ced2arApiModule(val crossScalaVersion: String)
    extends CrossScalaModule
    with ScalaJSModule
    with PublishModule {

  /*
  def sources = T.sources(
    build.millSourcePath /apiFolder / "src" 
  )
  */

  def scalaJSVersion = "0.6.25"
  def artifactName = "ced2ar3-api"
  def publishVersion = "0.0.2"
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
