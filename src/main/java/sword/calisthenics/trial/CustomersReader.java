package sword.calisthenics.trial;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public final class CustomersReader implements PrintableCollectionReader<Customers> {

    @Override
    public Customers read(BufferedReader reader) throws IOException {
        final ArrayList<Customer> table = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null)
            table.add(Customer.read(line));
        return new Customers(table);
    }
}
