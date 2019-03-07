package org.homermultitext.multitext
import edu.holycross.shot.cite._

case class Place(placeUrn: Cite2Urn, placeLabel: String,
  placeOccurrences: Vector[TextPassage]) extends NamedEntity {
  def urn: Cite2Urn = placeUrn
  def label: String = placeLabel
  def occurrences = placeOccurrences
}
