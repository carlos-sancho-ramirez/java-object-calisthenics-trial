package sword.calisthenics.trial;

public final class ProductName {

    private final String name;

    private ProductName(String name) {
        this.name = name;
    }

    public static ProductName read(String name) {
        return new ProductName(name);
    }

    public void print(Printer printer) {
        printer.print(name);
    }
}
