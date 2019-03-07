package org.homermultitext.multitext
import edu.holycross.shot.cite._

case class AstronomicalBody(astroUrn: Cite2Urn,
  astroLabel: String,
  astroOccurrences: Vector[TextPassage]) extends NamedEntity {
  def urn: Cite2Urn = astroUrn
  def label: String = astroLabel
  def occurrences = astroOccurrences
}
