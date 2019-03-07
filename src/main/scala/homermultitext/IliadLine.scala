package org.homermultitext.multitext
import edu.holycross.shot.cite._
import edu.holycross.shot.dse._

/** Model of a single Iliad line in a concrete version.
*
* @param urn The URN for the line.
* @param label Human-readable label.
* @param dse The DSE record for the line: manuscript page and image.
* @param scholia Vector[Scholion]  Scholia commenting on this line.  Defaults to Vector.empty[Scholion].
*/
case class IliadLine(
  iliadUrn: CtsUrn,
  iliadLabel: String,
  iliadDse: DsePassage,
  scholia: Vector[Scholion] = Vector.empty[Scholion],
  criticalSigns : Vector[CriticalSign]= Vector.empty[CriticalSign]

) extends TextPassage {

  def urn = iliadUrn
  def label =  iliadLabel
  def dse = iliadDse

}
