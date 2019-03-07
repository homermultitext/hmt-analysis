package org.homermultitext.multitext
import edu.holycross.shot.cite._



/** Model of a graphic simile marker.

* @param iliad Iliad line the marker appears on.
* @param label Description of simile.
* @param image Image with RoI identifying marker, if preserved.
* @param numericValue Numeri value of marker, if preserved.
*/
case class VenASimileMarker(
  urn: Cite2Urn,
  iliad: IliadLine,
  label: String,
  folio: Cite2Urn,
  image: Option[Cite2Urn],
  numericValue: Option[Int]
)


/** Model of an extant graphic simile marker.

*/
case class VenAGraphicSimileMarker(
  graphicUrn: Cite2Urn,
  graphicLabel: String,
  graphicImage: Cite2Urn,
  graphicFolio: Page,
  iliad: IliadLine,
  numericValue: Int
) extends VisualFeature {
  def urn = graphicUrn
  def label = graphicLabel
  def image = graphicImage
  def folio = graphicFolio
}


object VenAGraphicSimileMarker {

  def apply(allSimiles: Vector[VenASimileMarker]) : Vector[VenAGraphicSimileMarker] = {
    for (sim <- allSimiles) yield {
      sim.image match {
        case None => None
        case _ => sim
      }
    }
    Vector.empty[VenAGraphicSimileMarker]
  }
}
