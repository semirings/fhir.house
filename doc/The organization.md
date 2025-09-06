The project is called fhir.ampm.  It consists of two sub projects: fhir.core and fhir.ig. 
# fhir.core
Contains the Xtend code. It contains everything needed to generate the Java results.

# fhir.ig
Contains what constituted the usable product.  This includes the flutter ui and the http server that serves it.  It contains all the Java that generate the FHIR resources.  

# Dependencies
There are a host of dependencies.  The three versions of FHIR 4.0.1, 4.3.0, 5.0.0 are all included from .m2. 