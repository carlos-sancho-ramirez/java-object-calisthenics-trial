package sword.calisthenics.trial;

import java.io.PrintStream;

public final class PrintStreamWrapper implements Printer {
    private final PrintStream stream;

    public PrintStreamWrapper(PrintStream stream) {
        PreconditionUtils.ensureNonNull(stream);
        this.stream = stream;
    }

    @Override
    public void print(String text) {
        stream.print(text);
    }

    @Override
    public void println() {
        stream.println();
    }

    @Override
    public void println(String text) {
        stream.println(text);
    }
}
