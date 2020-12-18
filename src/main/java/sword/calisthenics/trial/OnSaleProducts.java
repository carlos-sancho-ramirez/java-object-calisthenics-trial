package sword.calisthenics.trial;

import java.util.ArrayList;

public final class OnSaleProducts implements Printable {

    private final ArrayList<OnSaleProduct> table;

    OnSaleProducts(ArrayList<OnSaleProduct> table) {
        this.table = table;
    }

    public OnSaleProduct findByProductId(ProductId productId) {
        for (OnSaleProduct product : table)
            if (product.hasId(productId))
                return product;

        throw new NotFoundException();
    }

    @Override
    public void print(Printer printer) {
        printer.println("On Sale Products:");
        for (OnSaleProduct onSaleProduct : table)
            onSaleProduct.println(printer);
        printer.println();
    }
}
