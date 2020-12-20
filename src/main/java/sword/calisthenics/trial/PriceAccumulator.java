package sword.calisthenics.trial;

public final class PriceAccumulator {

    private int totalPrice;

    public void add(int price) {
        totalPrice += price;
    }

    public void println(Printer printer) {
        final Price price = Price.fromValue(totalPrice);
        price.println(printer);
    }
}
