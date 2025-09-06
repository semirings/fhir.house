package iox.semirings.fhir.gen.gen

import java.util.List

interface Generator {
    def String generateClass(String className, List<FieldSpec> fields)
}