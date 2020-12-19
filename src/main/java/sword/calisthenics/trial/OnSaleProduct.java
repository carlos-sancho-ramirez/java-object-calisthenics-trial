package sword.calisthenics.trial;

public final class OnSaleProduct {

    private final Product product;
    private final Price price;

    private OnSaleProduct(Product product, Price price) {
        this.product = product;
        this.price = price;
    }

    public void println(Printer printer) {
        product.print(printer);
        printer.print(" ( ");
        price.print(printer);
        printer.println(" )");
    }

    public static OnSaleProduct read(String text) {
        final int separatorIndex = CsvUtils.findLastSeparator(text);
        final String productText = text.substring(0, separatorIndex);
        final Product product = Product.read(productText);

        final String priceText = text.substring(separatorIndex + 1);
        final Price price = Price.read(priceText);

        return new OnSaleProduct(product, price);
    }

    public boolean hasId(ProductId productId) {
        return product.hasId(productId);
    }

    public void printName(Printer printer) {
        product.printName(printer);
    }

    public void printPrice(Printer printer) {
        price.print(printer);
    }

    public void printMultipliedPrice(Amount amount, Printer printer) {
        price.printMultiplied(amount, printer);
    }
}
