package sword.calisthenics.trial;

import java.util.ArrayList;

public final class Customers implements Printable {

    private final ArrayList<Customer> table;

    Customers(ArrayList<Customer> table) {
        this.table = table;
    }

    @Override
    public void print(Printer printer) {
        printer.println("Customers:");
        for (Customer customer : table)
            customer.println(printer);
        printer.println();
    }
}
