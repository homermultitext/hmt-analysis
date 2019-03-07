package org.homermultitext.multitext
import edu.holycross.shot.cite._


/** Model of lexical entity.
**
* @param urn The URN for the lexical entity.
* @param lemma Human-readable label.
*
*/
case class LexicalEntity(
  urn: Cite2Urn,
  lemma: String
)
