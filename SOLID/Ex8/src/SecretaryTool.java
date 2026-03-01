public class SecretaryTool implements IMinutesTools {
    private final MinutesBook book;
    public SecretaryTool(MinutesBook book) { this.book = book; }

    @Override public void addMinutes(String text) { book.add(text); }

}
