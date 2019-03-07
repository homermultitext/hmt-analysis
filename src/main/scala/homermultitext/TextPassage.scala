package org.homermultitext.multitext
import edu.holycross.shot.cite._
import edu.holycross.shot.dse._

trait TextPassage {
  def urn : CtsUrn
  def label: String
  def dse: DsePassage
}
