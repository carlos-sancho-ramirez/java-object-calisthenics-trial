package sword.calisthenics.trial;

public final class Price {

    private final int price;

    private Price(int price) {
        this.price = price;
    }

    public static Price read(String price) {
        return new Price(Integer.parseInt(price));
    }

    public void print(Printer printer) {
        printer.print(Integer.toString(price));
        printer.print("c");
    }

    public void printMultiplied(Amount amount, Printer printer) {
        amount.printMultiplied(price, printer);
        printer.print("c");
    }
}
