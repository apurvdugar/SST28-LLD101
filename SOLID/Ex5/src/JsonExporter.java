import java.nio.charset.StandardCharsets;

public class JsonExporter extends Exporter {

    public JsonExporter() {
        super(new JsonFormat());
    }
    
    @Override
    public ExportResult export(ExportRequest req) {
        byte[] bytes = format.encode(req);
        return new ExportResult("application/json", bytes);
    }
}
