package sword.calisthenics.trial;

import java.io.BufferedReader;
import java.io.IOException;

public final class OrdersReader implements PrintableReader<Orders> {

    @Override
    public Orders read(BufferedReader reader) throws IOException {
        Orders orders = new Orders();
        orders.readOrders(reader);
        return orders;
    }
}
