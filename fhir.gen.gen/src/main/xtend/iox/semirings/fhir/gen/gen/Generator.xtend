package iox.semirings.fhir.gen.gen

import java.util.List
import iox.semirings.fhir.gen.model.FieldSpec

interface Generator {
    def String generateClass(String className, List<FieldSpec> fields)
}