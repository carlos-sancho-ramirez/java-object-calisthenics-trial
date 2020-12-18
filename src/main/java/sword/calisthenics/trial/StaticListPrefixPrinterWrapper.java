package sword.calisthenics.trial;

public final class StaticListPrefixPrinterWrapper implements Printer {
    private final Printer printer;
    private final String prefix;
    private boolean prefixAddedInCurrentLine;

    public StaticListPrefixPrinterWrapper(Printer printer, String prefix) {
        PreconditionUtils.ensureNonNull(printer, prefix);
        this.printer = printer;
        this.prefix = prefix;
    }

    private void printPrefix() {
        printer.print(prefix);
        prefixAddedInCurrentLine = true;
    }

    @Override
    public void print(String text) {
        if (!prefixAddedInCurrentLine)
            printPrefix();

        printer.print(text);
    }

    @Override
    public void println() {
        printer.println();
        prefixAddedInCurrentLine = false;
    }

    @Override
    public void println(String text) {
        if (!prefixAddedInCurrentLine)
            printPrefix();

        printer.println(text);
        prefixAddedInCurrentLine = false;
    }
}
