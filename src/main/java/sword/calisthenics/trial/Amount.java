package sword.calisthenics.trial;

public final class Amount {

    private final int amount;

    private Amount(int amount) {
        if (amount < 0)
            throw new IllegalArgumentException();

        this.amount = amount;
    }

    public static Amount fromValue(int amount) {
        return new Amount(amount);
    }

    public static Amount fromText(String amountText) {
        return fromValue(Integer.parseInt(amountText));
    }

    public Amount add(Amount amount) {
        return new Amount(this.amount + amount.amount);
    }

    private String toText() {
        return Integer.toString(amount);
    }

    public void println(Printer printer) {
        printer.println(toText());
    }

    public void print(Printer printer) {
        printer.print(toText());
    }

    public void printMultiplied(int price, Printer printer) {
        final int result = amount * price;
        final String text = Integer.toString(result);
        printer.print(text);
    }

    public void accumulateMultiplied(int price, PriceAccumulator accumulator) {
        accumulator.add(price * amount);
    }
}
