package org.homermultitext.multitext
import edu.holycross.shot.cite._
import edu.holycross.shot.dse._


/** Model of a single scholion in a concrete version.
*
* @param urn The URN for the scholion.
* @param label Human-readable label.
* @param dse The DSE record for the line: manuscript page and image.
* @param scholion Vector[scholionLine]  Line(s) commentedon by this scholion.  Should
* never be empty.
*/
case class Scholion(
  scholionUrn: CtsUrn,
  scholionLabel: String,
  scholionDse: DsePassage,
  iliad: Vector[IliadLine]
) extends TextPassage {

  def urn = scholionUrn
  def label =  scholionLabel
  def dse = scholionDse

}
