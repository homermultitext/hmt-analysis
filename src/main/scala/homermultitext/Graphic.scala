package org.homermultitext.multitext
import edu.holycross.shot.cite._



/** Model of a graphic feature of any kind.
**
* @param urn The URN for the lexical entity.
* @param label Human-readable label.
*
*/
case class Graphic(
  graphicUrn: Cite2Urn,
  graphicLabel: String,
  graphicImage: Cite2Urn,
  graphicFolio : Page
) extends VisualFeature {

  def urn = graphicUrn
  def label = graphicLabel
  def image = graphicImage
  def folio = graphicFolio
}
