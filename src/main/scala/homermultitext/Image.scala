package org.homermultitext.multitext
import edu.holycross.shot.cite._
import edu.holycross.shot.dse._


/** Model of a single documentary image in a concrete version.
*
* @param urn The URN for the image.
* @param label Human-readable label.
* @param surface The DSE record for the line: manuscript page and image.
* @param dse Vector[DsePassage]  Dse structures for
*/
case class Image(
  urn: Cite2Urn,
  label: String,
  surface: Cite2Urn,
  dse: Vector[DsePassage] = Vector.empty[DsePassage]
)
