public class ExportResult {
    public final String contentType;
    public final byte[] bytes;
    public final String error;

    public ExportResult(String contentType, byte[] bytes) {
        this.contentType = contentType;
        this.bytes = bytes;
        this.error = null;
    }

    public ExportResult(String contentType, byte[] bytes, String error) {
        this.contentType = contentType;
        this.bytes = bytes;
        this.error = error;
    }

    public ExportResult(String error) {
        this.bytes = new byte[0];
        this.contentType = null;
        this.error = error;
    }

    public boolean isError() {
        return error != null;
    }
}
