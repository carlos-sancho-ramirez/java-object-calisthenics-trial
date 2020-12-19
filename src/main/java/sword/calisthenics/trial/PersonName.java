package sword.calisthenics.trial;

public final class PersonName {

    private final FirstName first;
    private final FamilyName family;

    private PersonName(FirstName first, FamilyName family) {
        this.first = first;
        this.family = family;
    }

    public void print(Printer printer) {
        family.print(printer);
        printer.print(", ");
        first.print(printer);
    }

    public static PersonName read(String text) {
        final int separatorIndex = CsvUtils.findFirstSeparator(text);
        final String firstNameString = text.substring(0, separatorIndex);
        final FirstName firstName = FirstName.read(firstNameString);

        final String familyNameString = text.substring(separatorIndex + 1);
        final FamilyName familyName = FamilyName.read(familyNameString);

        return new PersonName(firstName, familyName);
    }
}
