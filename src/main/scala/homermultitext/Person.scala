package org.homermultitext.multitext
import edu.holycross.shot.cite._

case class Person(personUrn: Cite2Urn, personLabel: String,
  personOccurrences: Vector[TextPassage]) extends NamedEntity {
  def urn: Cite2Urn = personUrn
  def label: String = personLabel
  def occurrences = personOccurrences
}
