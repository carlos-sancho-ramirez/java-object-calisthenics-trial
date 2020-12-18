package sword.calisthenics.trial;

public final class Email {

    private final String email;

    private Email(String email) {
        this.email = email;
    }

    public static Email read(String email) {
        return new Email(email);
    }

    public void print(Printer printer) {
        printer.print(email);
    }
}
