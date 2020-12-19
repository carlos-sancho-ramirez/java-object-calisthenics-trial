package sword.calisthenics.trial;

public final class CsvUtils {

    private CsvUtils() {
    }

    public static int findFirstSeparator(String text) {
        final int separatorIndex = text.indexOf(',');
        if (separatorIndex <= 0)
            throw new IllegalArgumentException();

        return separatorIndex;
    }

    public static int findLastSeparator(String text) {
        final int separatorIndex = text.lastIndexOf(',');
        if (separatorIndex <= 0)
            throw new IllegalArgumentException();

        return separatorIndex;
    }
}
