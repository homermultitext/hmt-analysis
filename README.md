# `hmt-analysis`:  building and analyzing a digital multitext

This is a library modelling the content of the Homer Muiltitext project.


## Stage 1

The library should completely model the  contents of published releases of the Homer Muiltitext  project.  Since those releases can be instantiated as a `CiteLibrary`, the central class in this code library, the `HmtLibrary`, can be instatiated from a `CiteLibrary`.  For example:

```scala
import edu.holycross.shot.scm._
val citeLib = CiteLibrarySource.fromFile("hmt-2018e.cex")
val hmt = HmtLibrary(citeLib)
```

From this object, we should model two kinds of access to data:

1. `lazy val`s that instantiate from the `CiteLibrary` all of the instances of a particular type of HMT object.  E.g., `lazy val persons: Set[Person]` instantiates all `Person` objects represented in the library, and `lazy val iliadLines: Vector[IliadLine]` instantiates an order list of all `IliadLine` objects in the library.
2.  functions that select material from these collections by URN.  E.g., `def person(urn: Cite2): Option[Person]` selects a single person, or none if the URN fails to match.

## Stage 2

When we have completely modelled the contents of HMT publications, we can begin to develop functionality for HMT-specific analysis of the publication.
