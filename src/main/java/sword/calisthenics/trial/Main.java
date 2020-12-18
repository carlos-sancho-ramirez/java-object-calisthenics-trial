package sword.calisthenics.trial;

import java.io.IOException;
import java.io.InputStream;

public final class Main {
    private static ClassLoader getClassLoader() {
        final var cls = Main.class;
        return cls.getClassLoader();
    }

    private static InputStream openResource(String name) {
        return getClassLoader().getResourceAsStream(name);
    }

    interface RunnableWithIOException {
        void run() throws IOException;
    }

    private static void tryWithIOException(RunnableWithIOException runnable) {
        try {
            runnable.run();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readAndPrintCustomers() throws IOException {
        final InputStream stream = openResource("customers.csv");
        if (stream != null)
            new CustomersReader().readAndPrint(stream);
    }

    private static void readAndPrintOnSaleProducts() throws IOException {
        final InputStream stream = openResource("products.csv");
        if (stream != null)
            new OnSaleProductsReader().readAndPrint(stream);
    }

    private static void readAndPrintOrders() throws IOException {
        final InputStream stream = openResource("orders.csv");
        if (stream != null)
            new OrdersReader().readAndPrint(stream);
    }

    private static void readAndPrintOrdersWithPrices() throws IOException {
        InputStream stream = openResource("products.csv");
        final OnSaleProducts onSaleProducts = new OnSaleProductsReader().read(stream);

        stream = openResource("orders.csv");
        final Orders orders = new OrdersReader().read(stream);

        final OrdersWithPrice ordersWithPrice = orders.attachPrices(onSaleProducts);
        final Printer printer = new PrintStreamWrapper(System.out);
        ordersWithPrice.print(printer);
    }

    public static void main(String[] args) {
        tryWithIOException(Main::readAndPrintCustomers);
        tryWithIOException(Main::readAndPrintOnSaleProducts);
        tryWithIOException(Main::readAndPrintOrders);

        tryWithIOException(Main::readAndPrintOrdersWithPrices);
    }
}
