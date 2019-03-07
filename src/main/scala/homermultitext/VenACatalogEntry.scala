package org.homermultitext.multitext
import edu.holycross.shot.cite._



/** Model of an annotated entry in the catalog of ships.

* @param iliad Iliad line the marker appears on.
* @param label Description of simile.
* @param image Image with RoI identifying marker, if preserved.
* @param numberShips Numeric value of marker.
*/
case class VenACatalogEntry(
  iliad: IliadLine,
  label: String,
  image: Cite2Urn,
  folio: Page,
  group: EthnicGroup,
  numberShips: Int
)
