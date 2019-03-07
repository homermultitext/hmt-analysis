package org.homermultitext.multitext

import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._


/** Model of a captioned graphic feature of any kind.
**
* @param urn The URN for the lexical entity.
* @param label Human-readable label.
*
*/
case class CaptionedGraphic(
  captionedGraphicUrn: Cite2Urn,
  captionedGraphicLabel: String,
  captionedGraphicImage: Cite2Urn,
  captionedGraphicFolio : Page,
  caption: CitableNode
) extends VisualFeature
{

  def urn = captionedGraphicUrn
  def label = captionedGraphicLabel
  def image = captionedGraphicImage
  def folio = captionedGraphicFolio
}
