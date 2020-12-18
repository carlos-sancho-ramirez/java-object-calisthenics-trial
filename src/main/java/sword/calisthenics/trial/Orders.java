package sword.calisthenics.trial;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public final class Orders implements Printable {

    private final HashMap<OrderId, Order> table = new HashMap<>();

    private boolean validLine(String line) {
        return line != null && line.length() > 0;
    }

    public boolean readOrder(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        if (line == null)
            return false;

        final OrderId id = OrderId.read(line);
        final Order order = new Order();
        while (validLine(line = reader.readLine()))
            order.addProductInOrderLineWithAmount(line);

        table.put(id, order);
        return true;
    }

    public void readOrders(BufferedReader reader) throws IOException {
        while (readOrder(reader));
    }

    @Override
    public void print(Printer printer) {
        printer.println("Orders:");
        final Printer indentedPrinter = new StaticListPrefixPrinterWrapper(printer, " ");
        for (OrderId id : table.keySet())
            table.get(id).printWithTitle(id, indentedPrinter);
    }

    public void printWithProductNamesAndPrices(OnSaleProducts onSaleProducts, Printer printer) {
        printer.println("Orders:");
        final Printer indentedPrinter = new StaticListPrefixPrinterWrapper(printer, " ");
        for (OrderId id : table.keySet())
            table.get(id).printWithTitleAndProductNameAndPrices(id, onSaleProducts, indentedPrinter);
    }

    public OrdersWithPrice attachPrices(OnSaleProducts onSaleProducts) {
        return OrdersWithPrice.obtain(this, onSaleProducts);
    }
}
