package org.homermultitext.multitext
import edu.holycross.shot.cite._
import edu.holycross.shot.dse._

trait Side {
  def label: String
}

case object Recto extends Side {
  def label = {"recto"}
}

case object Verso extends Side {
  def label = {"verso"}
}


/** Model of a single page in a manuscript.
*
* @param urn The URN for the page.
* @param label Human-readable label.
* @param dse The DSE record for the line: manuscript page and image.
* @param texts All citable texts appearing on this page.
* @param visualFeatures All graphic features appearing on this page.
*/
case class Page(
  urn: Cite2Urn,
  label: String,
  val side: Side,
  dse: Vector[DsePassage] = Vector.empty[DsePassage],
  texts: Vector[TextPassage] = Vector.empty[TextPassage],
  visualFeatures: Vector[VisualFeature] = Vector.empty[VisualFeature]

)
