package sword.calisthenics.trial;

public final class OrderId {

    private final String id;

    private OrderId(String id) {
        this.id = id;
    }

    public static OrderId read(String line) {
        return new OrderId(line);
    }

    public void print(Printer printer) {
        printer.print(id);
    }
}
