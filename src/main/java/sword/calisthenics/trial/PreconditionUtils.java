package sword.calisthenics.trial;

public final class PreconditionUtils {

    private PreconditionUtils() {
    }

    private static void ensureNonNullSingle(Object arg) {
        if (arg == null)
            throw new IllegalArgumentException();
    }

    public static void ensureNonNull(Object... args) {
        for (Object arg : args)
            ensureNonNullSingle(arg);
    }
}
