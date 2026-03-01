import java.nio.charset.StandardCharsets;

public class PdfFormat implements IFormat {
    @Override
    public byte[] encode(ExportRequest req) {
        String fakePdf = "PDF(" + req.title + "):" + req.body;
        return fakePdf.getBytes(StandardCharsets.UTF_8);
    }
}