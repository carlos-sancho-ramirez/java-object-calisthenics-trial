package sword.calisthenics.trial;

public final class FirstName {

    private final String name;

    private FirstName(String name) {
        this.name = name;
    }

    public void print(Printer printer) {
        printer.print(name);
    }

    public static FirstName read(String name) {
        return new FirstName(name);
    }
}
