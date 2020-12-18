package sword.calisthenics.trial;

import java.util.Objects;

import static sword.calisthenics.trial.PreconditionUtils.ensureNonNull;

public final class ProductId {

    private final String id;

    private ProductId(String id) {
        ensureNonNull(id);
        this.id = id;
    }

    public static ProductId read(String id) {
        return new ProductId(id);
    }

    public void print(Printer printer) {
        printer.print(id);
    }

    public void printWithAmount(Amount amount, Printer printer) {
        printer.print(id);
        printer.print(" x ");
        amount.println(printer);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ProductId))
            return false;

        final ProductId that = (ProductId) other;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
