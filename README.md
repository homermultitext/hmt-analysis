# `hmt-analysis`:  building and analyzing a digital multitext

This is a library modelling the content of the Homer Muiltitext project.


## Stage 1

The library should completely model the  contents of published releases of the Homer Muiltitext  project.  Since those releases can be instantiated as a `CiteLibrary`, the central class in this code library, the `HmtLibrary`, can be instatiated from a `CiteLibrary`.  For example:

```scala
import edu.holycross.shot.scm._
val citeLib = CiteLibrarySource.fromFile("hmt-2018e.cex")
val hmt = HmtLibrary(citeLib)
```


## Stage 2

When we have completely modelled the contents of HMT publications, we can begin to develop functionality for HMT-specific analysis of the publication.
