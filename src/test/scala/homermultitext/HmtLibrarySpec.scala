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

class HmtLibrarySpec extends FlatSpec {

  val cex = "src/test/resources/hmt-sample.cex"
  lazy val lib = HmtLibrary(CiteLibrarySource.fromFile(cex))


  "An HmtLibrary" should "have a CiteLibrary with collections, text repository, relations and data models" in {
    assert(lib.library.hasCollections)
    assert(lib.library.hasDataModels)
    assert(lib.library.hasIndexes)
    assert(lib.library.hasTexts)
  }

  it should "find all text passages where a person appears" in {
    val achilles = Cite2Urn("urn:cite2:hmt:pers.v1:pers1")
    val achillesPsgs = lib.personAppearsIn(achilles)
    val expectedPsgs = 2

    println("Achilles appears in " + achillesPsgs.size + " passages")
    assert(achillesPsgs.size == expectedPsgs)
  }
}
