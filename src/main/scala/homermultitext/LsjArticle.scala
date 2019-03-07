package org.homermultitext.multitext
import edu.holycross.shot.cite._


/** Model of an article in LSJ.  This belongs in a different library,
* since it is not HMT-specific.
*/
case class LsjArticle(
  urn: Cite2Urn,
  label: String,
  lexicalEntity: LexicalEntity,
  text: String // markdown
)
