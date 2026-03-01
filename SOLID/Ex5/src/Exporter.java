public abstract class Exporter {
    // implied "contract" but not enforced (smell)
    protected IFormat format;

    public Exporter(IFormat format) {
        this.format = format;
    }

    public ExportResult doExport(ExportRequest req) {
        if(req == null) {
            return new ExportResult("Request cannot be null");
        }
        return export(req);
    }

    public abstract ExportResult export(ExportRequest req);
}
