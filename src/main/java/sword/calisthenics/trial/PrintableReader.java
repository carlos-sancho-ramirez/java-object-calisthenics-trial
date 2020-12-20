package sword.calisthenics.trial;

import java.io.IOException;
import java.io.InputStream;

public interface PrintableReader<T extends Printable> extends Reader<T> {
    default void readAndPrint(InputStream stream) throws IOException {
        final Printable printable = read(stream);
        final Printer printer = new PrintStreamWrapper(System.out);
        printable.print(printer);
    }
}
