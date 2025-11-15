package ua.opnu;
import java.math.BigInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NumberTasks {
    // Завдання 5: applyIf — робить Consumer тільки якщо Predicate істинний
    public static void applyIf(Integer[] arr, Predicate<Integer> predicate, Consumer<Integer> consumer) {
        if (arr == null || predicate == null || consumer == null) return;
        for (Integer x : arr) {
            if (predicate.test(x)) consumer.accept(x);
        }
    }

    // Завдання 6: Function n -> 2^n
    public static Function<Integer, BigInteger> powerOfTwoFunction() {
        return n -> {
            if (n == null) throw new IllegalArgumentException("n == null");
            if (n < 0) throw new IllegalArgumentException("n must be >= 0");
            return BigInteger.TWO.pow(n);
        };
    }


    // Завдання 7: stringify
    public static String stringify(int[] digits, Function<Integer, String> mapper) {
        if (digits == null || mapper == null) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            int d = digits[i];
            if (d < 0 || d > 9) throw new IllegalArgumentException("Digits must be in 0..9");
            if (i > 0) sb.append(" ");
            sb.append(mapper.apply(d));
        }
        return sb.toString();
    }
}