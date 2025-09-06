package iox.semirings.fhir.gen.engine.services;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import iox.semirings.fhir.gen.model.FieldSpec;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class FHIRGeneratorService {

        Logger log = LoggerFactory.getLogger(FHIRGeneratorService.class);

    public void processJson(MultipartFile file) {
        try {
            InputStream jsonStream = file.getInputStream();
            iterateSnapshotsJson(jsonStream);
        } catch (Exception e) {
            log.error(", e");
        }
    }
    

    public void processXml(MultipartFile file) {


    }

    public void iterateSnapshotsJson(InputStream jsonStream) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(jsonStream);

        // Navigate to snapshot.element
        JsonNode snapshot = root.path("snapshot").path("element");
        if (!snapshot.isArray()) {
            throw new IllegalStateException("snapshot.element not found or invalid");
        }

        List<FieldSpec> fieldSpecs  = new ArrayList<>();
        String typeNode = snapshot.path("type").asText();
        for (JsonNode element : snapshot) {
            FieldSpec fieldSpec = new FieldSpec();
//            fieldSpec.id = element.path("id").asText();
            fieldSpec.setPath(element.path("path").asText());
            fieldSpec.setMin(element.path("min").asInt());
            fieldSpec.setMax(element.path("max").asText());
            fieldSpecs.add(fieldSpec);

            log.info("Element: {} (id {} )", fieldSpec.getPath());
            log.info("Cardinality: {} .. {}", fieldSpec.getMin(), fieldSpec.getMax());
        }
        JavaGenerator generator = new JavaGenerator();
        generator.generateClass(typeNode, fieldSpecs);
}

    public void iterateSnapshotsXml(InputStream xmlStream) throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        JsonNode root = xmlMapper.readTree(xmlStream); // parse XML into JsonNode

        JsonNode snapshot = root.path("snapshot").path("element");
        for (JsonNode element : snapshot) {
            String path = element.path("path").asText();
            String max = element.path("max").asText();
            int min = element.path("min").asInt();

            System.out.println(path + " => " + min + ".." + max);
        }
    }
}
