import java.nio.charset.StandardCharsets;

public class JsonFormat implements IFormat {
    @Override
    public byte[] encode(ExportRequest req) {
        String json = "{\"title\":\"" + escape(req.title) + "\",\"body\":\"" + escape(req.body) + "\"}";
        return json.getBytes(StandardCharsets.UTF_8);
    }

    private String escape(String s) {
        if (s == null) return "";
        return s.replace("\"", "\\\"");
    }
}