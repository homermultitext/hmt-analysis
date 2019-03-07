package org.homermultitext.multitext
import edu.holycross.shot.cite._




trait VisualFeature {
  def urn: Cite2Urn
  def label: String
  def image: Cite2Urn
  def folio: Page
}
