package ua.opnu;
import java.util.function.Predicate;


public class PrimeChecker {
    public static Predicate<Integer> isPrimePredicate() {
        return n -> {
            if (n == null) return false;
            int x = n;
            if (x <= 1) return false;
            if (x <= 3) return true;
            if (x % 2 == 0) return false;
            int r = (int) Math.sqrt(x);
            for (int i = 3; i <= r; i += 2) {
                if (x % i == 0) return false;
            }
            return true;
        };
    }
}