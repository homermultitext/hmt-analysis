package org.homermultitext.multitext

import edu.holycross.shot.scm._
import edu.holycross.shot.cite._
import edu.holycross.shot.dse._
import edu.holycross.shot.ohco2._
import edu.holycross.shot.citeobj._
import edu.holycross.shot.cex._
import edu.holycross.shot.citerelation._

/**  A CITE library that understands the HomerMultitext project.
* The HmtLibrary should know how to create every object in this code package
* from  a single CiteLibrary.
*
* @param library A CiteLibrary, possibly created from a comprehensive CEX
* release publication of the HMT project.
*/
case class HmtLibrary(library: CiteLibrary) {


  // Pull out CiteLibrary components for convenient reference:
  lazy val collectionRepo: CiteCollectionRepository = library.collectionRepository.get
  lazy val textRepo : TextRepository = library.textRepository.get
  lazy val relations:  Set[CiteTriple]  = library.relationSet.get.relations

  lazy val dseCollections : Vector[Cite2Urn]= {
    library.collectionsForModel(HmtLibrary.DseModelUrn)
  }
  lazy val vaDse = dseRecords(HmtLibrary.vaPages)

  def dseDataForMs(codex: Cite2Urn) = {
    dseRecords(codex)
  }




  ///////// Lazy instantiation of all object types in the library.
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


  lazy val iliadLines: Vector[IliadLine] = {
    Vector.empty[IliadLine]
  }

  lazy val scholia: Vector[Scholion] = {
    Vector.empty[Scholion]
  }

  lazy val tokens: Vector[GroupedToken] = {
    Vector.empty[GroupedToken]
  }

  lazy val persons: Vector[Person] = {
    Vector.empty[Person]
  }
  // turn this into a type parameter function
  def person(urn: Cite2Urn): Option[Person] = {
    val matches = persons.filter(_.urn == urn)
    matches.size match {
      case 0 => None
      case 1 => Some(matches(0))
      case 2 => throw new Exception(s"Urn ${urn} matched ${matches.size} persons." )
    }
  }


  lazy val places: Vector[Place] = {
    Vector.empty[Place]
  }
  def place(urn: Cite2Urn): Option[Place] = {
    val matches = places.filter(_.urn == urn)
    matches.size match {
      case 0 => None
      case 1 => Some(matches(0))
      case 2 => throw new Exception(s"Urn ${urn} matched ${matches.size} persons." )
    }
  }

  lazy val ethnicGroups: Vector[EthnicGroup] = {
    Vector.empty[EthnicGroup]
  }
  def ethnicGroup(urn: Cite2Urn): Option[EthnicGroup] = { None }

  lazy val speeches: Vector[Speech]  = {
    Vector.empty[Speech]
  }
  def speech(urn: Cite2Urn): Option[Speech] = { None }

  lazy val vaShipsCatalog: Vector[VenACatalogEntry]  = {
    Vector.empty[VenACatalogEntry]
  }
  def venACatalogEntry(urn: Cite2Urn):  Option[VenACatalogEntry] = { None }

  lazy val vaSimileMarkers: Vector[VenASimileMarker]  = {
    Vector.empty[VenASimileMarker]
  }
  def vaSimileMarker(urn: Cite2Urn):  Option[VenASimileMarker] = { None }

  lazy val textReuse: Vector[TextReuse]  = {
    Vector.empty[TextReuse]
  }




  ///////////  Functions to find specific sets of content

  /** Get all objects in a collection modelled by DSE.
  *
  * @param context Limiting URN, perhaps a whole manuscript.
  */
  def dseRecords(context : Cite2Urn) = {
     collectionRepo.objectsForCollection(context)
  }


  def scholion(urn: CtsUrn) = { // Scholion
  }

  def iliadLine(urn: CtsUrn) = { // IliadLine

    val label = s"Iliad ${urn.passageComponent} (${urn.version})"

    // get vector of Scholia
    // get vector of CriticalSign
    //IliadLine(urn, "I")
/*
  iliadUrn: CtsUrn,
  iliadLabel: String,
  iliadDse: DsePassage,
  scholia: Vector[Scholion] = Vector.empty[Scholion],
  criticalSigns : Vector[CriticalSign]= Vector.empty[CriticalSign]
*/
  }

  /// create individual object from URN
  def textPassage(urn: CtsUrn) = {//: TextPassage  = {
    urn.textGroup match {
      case "tlg0012" => iliadLine(urn)
      case "tlg5026" => scholion(urn)
      case _ => throw new Exception("Don't know about texts in group " + urn.textGroup)
    }
  }


/*
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
*/
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
