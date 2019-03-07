package org.homermultitext.multitext
import edu.holycross.shot.cite._

trait NamedEntity {
  def urn: Cite2Urn
  def label: String
  def occurrences: Vector[TextPassage]
}
