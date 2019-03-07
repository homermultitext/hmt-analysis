package org.homermultitext.multitext
import edu.holycross.shot.cite._

trait TextReuseType {
  def label: String
}


case object Multiform
/*  From Krakow paper: revisit their classification of
quote1, quote2, quote3, langusage, multiform1
*/


case class TextReuse(
  //passage: Vector[GroupedToken],
  //reusedSource: Option[CtsUrn],
  reuseType: TextReuseType
)
