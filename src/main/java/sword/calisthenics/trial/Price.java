package sword.calisthenics.trial;

public final class Price {

    private final int price;

    private Price(int price) {
        this.price = price;
    }

    public static Price fromValue(int price) {
        return new Price(price);
    }

    public static Price read(String price) {
        return fromValue(Integer.parseInt(price));
    }

    public void print(Printer printer) {
        printer.print(Integer.toString(price));
        printer.print("c");
    }

    public void printMultiplied(Amount amount, Printer printer) {
        amount.printMultiplied(price, printer);
        printer.print("c");
    }

    public void accumulateMultiplied(Amount amount, PriceAccumulator accumulator) {
        amount.accumulateMultiplied(price, accumulator);
    }

    public void println(Printer printer) {
        print(printer);
        printer.println();
    }
}
