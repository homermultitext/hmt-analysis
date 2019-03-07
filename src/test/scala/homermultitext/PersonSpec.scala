package org.homermultitext.multitext
import org.scalatest.FlatSpec
import edu.holycross.shot.cite._
import edu.holycross.shot.scm



import edu.holycross.shot.scm._
import edu.holycross.shot.cite._
import edu.holycross.shot.dse._
import edu.holycross.shot.ohco2._
import edu.holycross.shot.citeobj._
import edu.holycross.shot.cex._
import edu.holycross.shot.citerelation._

class PersonSpec extends FlatSpec {

  val cex = "src/test/resources/hmt-sample.cex"
  lazy val lib = HmtLibrary(CiteLibrarySource.fromFile(cex))


  "A Person" should "do things" in pending
}
