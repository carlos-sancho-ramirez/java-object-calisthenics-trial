package sword.calisthenics.trial;

import java.util.Objects;

public final class Product {

    private final ProductId id;
    private final ProductName name;

    private Product(ProductId id, ProductName name) {
        this.id = id;
        this.name = name;
    }

    public static Product read(String text) {
        final int separatorIndex = CsvUtils.findFirstSeparator(text);
        final String idText = text.substring(0, separatorIndex);
        final ProductId id = ProductId.read(idText);

        final String nameText = text.substring(separatorIndex + 1);
        final ProductName name = ProductName.read(nameText);

        return new Product(id, name);
    }

    public void print(Printer printer) {
        id.print(printer);
        printer.print(" ");
        name.print(printer);
    }

    public boolean hasId(ProductId productId) {
        return Objects.equals(id, productId);
    }

    public void printName(Printer printer) {
        name.print(printer);
    }
}
