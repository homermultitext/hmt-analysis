package org.homermultitext.multitext
import edu.holycross.shot.cite._

case class EthnicGroup(ethnicUrn: Cite2Urn, ethnicLabel: String,
  ethnicOccurrences: Vector[TextPassage]) extends NamedEntity {
  def urn: Cite2Urn = ethnicUrn
  def label: String = ethnicLabel
  def occurrences = ethnicOccurrences
}
