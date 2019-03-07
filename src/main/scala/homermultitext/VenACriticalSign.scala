package org.homermultitext.multitext
import edu.holycross.shot.cite._

trait CriticalSign {
  def label: String
  def greek: String
  def unicode: String
  def usage: String
}

case object Obelos extends CriticalSign {
  def label = "obelos"
  def greek = "ὀβελός"
  def unicode = "0x2014"
  def usage = "Text considered spurious (athetesis)"
}

case object Diple extends CriticalSign {
  def label = "diple"
  def greek = "διπλῆ ἀπερίστικτος"
  def unicode = "0x003E"
  def usage = "Line considered worth commenting on"
}

case object DottedDiple extends CriticalSign {
  def label = "dotted diple"
  def greek = "διπλῆ περιεστιγμένη"
  def unicode = "0x2E16"
  def usage = "Aristarchus rejects Zenodotus"
}


case object Asterisk extends CriticalSign {
  def label = "asterisk"
  def greek = "ἀστερίσκος"
  def unicode = "0x203B"
  def usage = "Line repeated elsewhere"
}

case object Antisigma extends CriticalSign {
  def label = "antisigma"
  def greek = "ἀντίσιγμα"
  def unicode = "0x03FD"
  def usage = "Lines transposed (?)"
}

case object DottedAntisigma extends CriticalSign {
  def label = "dotted antisigma"
  def greek = "ἀντίσιγμα περιστιγμένον"
  def unicode = "0x03FF"
  def usage = "Lines considered tautologies"
}



/** Model of a Venetus A critical sign.
**
* @param urn The URN for the lexical entity.
* @param label Human-readable label.
*
*/
case class VenACriticalSign(
  critSignUrn: Cite2Urn,
  critSignLabel: String,
  critSignImage: Cite2Urn,
  critSignFolio : Page,
  sign: CriticalSign,
  iliadLine: IliadLine
) extends VisualFeature {

  def urn = critSignUrn
  def label = critSignLabel
  def image = critSignImage
  def folio = critSignFolio
}
