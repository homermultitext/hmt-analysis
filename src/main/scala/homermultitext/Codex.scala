package org.homermultitext.multitext
import edu.holycross.shot.cite._
import edu.holycross.shot.dse._


/** Model of a physical manuscript.
*/
case class Codex(
  urn: Cite2Urn,
  label: String,
  description: String,
  archivalSiglum: String,
  allen: String,
  pages : Vector[Page]
)
