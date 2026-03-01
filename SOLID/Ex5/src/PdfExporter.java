import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter {

    public PdfExporter() {
        super(new PdfFormat());
    }   

    @Override
    public ExportResult export(ExportRequest req) {
        // LSP violation: tightens precondition arbitrarily
        if (req.body != null && req.body.length() > 20) {
            return new ExportResult("PDF cannot handle content > 20 chars");
        }
        byte[] bytes = format.encode(req);
        return new ExportResult("application/pdf", bytes);
    }
}
