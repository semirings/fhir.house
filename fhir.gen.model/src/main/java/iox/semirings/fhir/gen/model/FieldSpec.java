package iox.semirings.fhir.gen.model;

public class FieldSpec {
    /** Full FHIR path, e.g. "Patient.name.family" */
    private String path;
    /** FHIR type, e.g. "string", "boolean", "integer" */
    private String type;
    /** min cardinality */
    private int min;
    /** max cardinality ("*" or numeric as string) */
    private String max;

    public FieldSpec() {}

    public FieldSpec(String path, String type, int min, String max) {
        this.path = path;
        this.type = type;
        this.min = min;
        this.max = max;
    }

    public String getPath() { return path; }
    public String getType() { return type; }
    public int getMin() { return min; }
    public String getMax() { return max; }

    public void setPath(String path) { this.path = path; }
    public void setType(String type) { this.type = type; }
    public void setMin(int min) { this.min = min; }
    public void setMax(String max) { this.max = max; }
}
