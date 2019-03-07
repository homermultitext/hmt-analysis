package org.homermultitext.multitext

import edu.holycross.shot.scm._
import edu.holycross.shot.cite._
import edu.holycross.shot.dse._
import edu.holycross.shot.ohco2._
import edu.holycross.shot.citeobj._
import edu.holycross.shot.cex._
import edu.holycross.shot.citerelation._

/**  A CITE library that understands the HomerMultitext project.*
*
* @param library A CiteLibrary, possibly created from a comprehensive CEX
* release publication of the HMT project.
*/
case class HmtLibrary(library: CiteLibrary) {


  lazy val collectionRepo: CiteCollectionRepository = library.collectionRepository.get
  lazy val textRepo : TextRepository = library.textRepository.get
  lazy val relations:  Set[CiteTriple]  = library.relationSet.get.relations

  lazy val dseCollections : Vector[Cite2Urn]= {
    library.collectionsForModel(HmtLibrary.DseModelUrn)
  }

  /** All codices in this library. */
  lazy val codices: Vector[Codex] = {

    // query the  codexCollection to find out collection with TBS model
    // of sequence of pages for that MS.
    // The codex collection is not yet in published version,
    //   so we'll make this up by hand right now:
    val tbsCollections =   Vector(Cite2Urn("urn:cite2:hmt:msA.v1:"))

    // collect pages for each
    /*
    for (tbsVector <- tbsCollection) yield {
      val pageVector = library.collectionRepository.get.collectionsMap(tbsVector)
    }
    */
    Vector.empty[Codex]
  }


  lazy val persons: Vector[Person] = {
    Vector.empty[Person]
  }

  /** Get all objects in a collection modelled by DSE. */
  def dseRecords(collectionUrn: Cite2Urn) = {
     collectionRepo.objectsForCollection(collectionUrn)
  }

  def textPassage(urn: CtsUrn) = {//: TextPassage  = {

/*
    */
  }

  def dseForCodex(tbsUrn: Cite2Urn )= {
    tbsUrn match {
      case HmtLibrary.vaPages => {
        collectionRepo.objectsForCollection(tbsUrn)

      }
      case _ => {
        println("No records for this collection in library.")
      }
    }
  }

  def pagesForCodex(codexUrn: Cite2Urn): Vector[Page] = {
    Vector.empty[Page]
  }

  def personAppearsIn(person: Cite2Urn) : Set[CtsUrn] = {
    val psgUrns = relations.filter(_.urn1Match(person)).toVector.map(_.urn2)
    val justCts = for (p <- psgUrns) yield {
      p match {
        case cts: CtsUrn => Some(cts)
        case c2: Cite2Urn=> None
      }
    }
    justCts.flatten.toSet
  }

}

object HmtLibrary {
  val DseModelUrn = Cite2Urn("urn:cite2:cite:datamodels.v1:dse")
  val codexCollection = Cite2Urn("urn:cite2:hmt:codices.v1:")
  val vaPages = Cite2Urn("urn:cite2:hmt:msA.v1:")
}
