package sword.calisthenics.trial;

import java.io.PrintStream;

public final class Customer {

    private final PersonName name;
    private final Email email;

    private Customer(PersonName name, Email email) {
        this.name = name;
        this.email = email;
    }

    public void println(Printer printer) {
        name.print(printer);
        printer.print(" (");
        email.print(printer);
        printer.println(")");
    }

    public static Customer read(String line) {
        final int separatorIndex = CsvUtils.findFirstSeparator(line);
        final String emailString = line.substring(0, separatorIndex);
        final Email email = Email.read(emailString);

        final String personNameString = line.substring(separatorIndex + 1);
        final PersonName personName = PersonName.read(personNameString);

        return new Customer(personName, email);
    }
}
