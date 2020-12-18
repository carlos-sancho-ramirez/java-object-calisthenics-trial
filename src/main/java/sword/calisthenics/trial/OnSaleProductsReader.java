package sword.calisthenics.trial;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public final class OnSaleProductsReader implements PrintableCollectionReader<OnSaleProducts> {
    @Override
    public OnSaleProducts read(BufferedReader reader) throws IOException {
        final ArrayList<OnSaleProduct> table = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null)
            table.add(OnSaleProduct.read(line));
        return new OnSaleProducts(table);
    }
}
