package sword.calisthenics.trial;

public final class FamilyName {

    private final String name;

    private FamilyName(String name) {
        this.name = name;
    }

    public void print(Printer printer) {
        printer.print(name);
    }

    public static FamilyName read(String name) {
        return new FamilyName(name);
    }
}
