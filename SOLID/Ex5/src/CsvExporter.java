import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {

    public CsvExporter() {
        super(new CsvFormat());
    }

    @Override
    public ExportResult export(ExportRequest req) {
        // LSP issue: changes meaning by lossy conversion
        byte[] bytes = format.encode(req);
        return new ExportResult("text/csv", bytes);
    }
}
