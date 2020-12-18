package sword.calisthenics.trial;

import static sword.calisthenics.trial.PreconditionUtils.ensureNonNull;

public final class OrdersWithPrice implements Printable {

    private final Orders orders;
    private final OnSaleProducts onSaleProducts;

    private OrdersWithPrice(Orders orders, OnSaleProducts onSaleProducts) {
        ensureNonNull(orders, onSaleProducts);
        this.orders = orders;
        this.onSaleProducts = onSaleProducts;
    }

    @Override
    public void print(Printer printer) {
        orders.printWithProductNamesAndPrices(onSaleProducts, printer);
    }

    public static OrdersWithPrice obtain(Orders orders, OnSaleProducts onSaleProducts) {
        return new OrdersWithPrice(orders, onSaleProducts);
    }
}
