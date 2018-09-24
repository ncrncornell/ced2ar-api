import mill._
import mill.scalalib._
import mill.scalajslib._

object api extends Cross[Ced2arApiModule]("2.12.6") {
  def artifactName = "ced2ar3-api"
  def publishVersion = "0.0.0"
  def pomSettings = PomSettings(
    description =
      """Comprehensive Extensible Data Documentation and
      | Access Repository (AAR) was designed to improve the documentation and
      | discoverability of both public and restricted data. Version 3 is a
      | modular implementaiton of CED2AR.""".stripMargin.replaceAll("\n", " "),
    organization = "Cornell University",
    url = "https://github.com/ncrncornell/ced2ar-api",
    licenses = Seq(License.`CC-BY-NC-SA-4.0`),
    versionControl = VersionControl.github("ncrncornell", "ced2ar-api"),
    developers = Seq(
      Developer("bbarker",
                "Brandon Barker",
                "https://www.cac.cornell.edu/barker/",
                "Cornell University"),
      Developer("larsvilhuber",
                "Lars Vilhuber",
                "https://www.ilr.cornell.edu/people/lars-vilhuber",
                "Cornell University"),
      Developer("CSimmer",
                "Charles C Simmer",
                "https://github.com/CSimmer",
                "Cornell University")
    )
  )
}
class Ced2arApiModule(val crossScalaVersion: String)
    extends CrossScalaModule
    with ScalaJSModule
    with PublishModule {
  def scalaJSVersion = "0.6.25"
}
