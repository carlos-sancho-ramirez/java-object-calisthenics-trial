package sword.calisthenics.trial;

import java.util.HashMap;

public final class Order {

    private final HashMap<ProductId, Amount> products = new HashMap<>();

    void addProduct(ProductId productId, Amount amount) {
        Amount currentAmount = products.get(productId);
        Amount newAmount = amount;
        if (currentAmount != null)
            newAmount = currentAmount.add(amount);

        products.put(productId, newAmount);
    }

    void addProductInOrderLineWithAmount(String line) {
        final int separatorIndex = CsvUtils.findFirstSeparator(line);
        final String rawProductIdText = line.substring(0, separatorIndex);
        final String productIdText = rawProductIdText.trim();
        final ProductId productId = ProductId.read(productIdText);

        final String amountText = line.substring(separatorIndex + 1);
        final Amount amount = Amount.fromText(amountText);
        addProduct(productId, amount);
    }

    private void printRowWithTitle(ProductId productId, Printer printer) {
        final Amount amount = products.get(productId);
        productId.printWithAmount(amount, printer);
    }

    public void printWithTitle(OrderId id, Printer printer) {
        id.print(printer);
        printer.println(":");
        final Printer indentedPrinter = new StaticListPrefixPrinterWrapper(printer, " ");
        for (ProductId productId : products.keySet())
            printRowWithTitle(productId, indentedPrinter);
    }

    private void printRow(ProductId productId, OnSaleProducts onSaleProducts, Printer printer) {
        final OnSaleProduct onSaleProduct = onSaleProducts.findByProductId(productId);
        onSaleProduct.printName(printer);
        printer.print("\t");

        final Amount amount = products.get(productId);
        amount.print(printer);
        printer.print("\t");

        onSaleProduct.printPrice(printer);
        printer.print("\t\t");

        onSaleProduct.printMultipliedPrice(amount, printer);
        printer.println();
    }

    private void accumulateProductMultipliedPrice(ProductId productId, OnSaleProducts onSaleProducts, PriceAccumulator accumulator) {
        final OnSaleProduct onSaleProduct = onSaleProducts.findByProductId(productId);
        final Amount amount = products.get(productId);
        onSaleProduct.accumulateMultipliedPrice(amount, accumulator);
    }

    private void printlnTotalPrice(OnSaleProducts onSaleProducts, Printer printer) {
        final var accumulator = new PriceAccumulator();
        for (ProductId productId : products.keySet())
            accumulateProductMultipliedPrice(productId, onSaleProducts, accumulator);

        accumulator.println(printer);
    }

    private void printTotalsRow(OnSaleProducts onSaleProducts, Printer printer) {
        printer.print("Total\t\t\t\t\t");
        printlnTotalPrice(onSaleProducts, printer);
    }

    public void printWithTitleAndProductNameAndPrices(OrderId id, OnSaleProducts onSaleProducts, Printer printer) {
        id.print(printer);
        printer.println(":");

        final Printer indentedPrinter = new StaticListPrefixPrinterWrapper(printer, " ");
        indentedPrinter.println("Product\tAmount\tUnity price\tTotal price");
        indentedPrinter.println();

        for (ProductId productId : products.keySet())
            printRow(productId, onSaleProducts, indentedPrinter);

        printTotalsRow(onSaleProducts, indentedPrinter);
        printer.println();
    }
}
