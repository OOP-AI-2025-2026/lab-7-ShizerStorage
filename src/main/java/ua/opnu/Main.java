package ua.opnu;

import java.math.BigInteger;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Завдання 1: перевірка простих чисел
        Predicate<Integer> isPrime = PrimeChecker.isPrimePredicate();
        System.out.println("=== Завдання 1: прості числа ===");
        int[] testPrimes = {-1, 0, 1, 2, 3, 4, 17, 18, 19, 97, 100};
        for (int v : testPrimes) System.out.printf("%d -> %b\n", v, isPrime.test(v));


        // Приклад студентів для подальших задач
        Student[] students = new Student[]{
                new Student("Ivan", "Petrenko", "A1", new int[]{75, 80, 90}),
                new Student("Stepan", "Kovalenko", "A1", new int[]{55, 60, 70}),
                new Student("Olena", "Shevchenko", "B2", new int[]{100, 98, 95}),
                new Student("Mariia", "Bondar", "B2", new int[]{59, 40, 80})
        };


        // Завдання 2
        Predicate<Student> hasAtLeastOneFail = s -> s != null && s.hasFailingMarks();
        List<Student> failing = StudentFilter.filterStudents(students, hasAtLeastOneFail);
        System.out.println("\n=== Завдання 2: Студенти з 1+ заборгованістю ===");
        failing.forEach(s -> System.out.println(" " + s));


        // Завдання 3
        Predicate<Student> groupB2 = s -> s != null && "B2".equals(s.getGroup());
        Predicate<Student> noFails = groupB2.and(hasAtLeastOneFail.negate());
        List<Student> both = StudentFilter.filterByTwoPredicates(students, groupB2, noFails);
        System.out.println("\n=== Завдання 3: Студенти у B2 та без заборгованостей ===");
        both.forEach(s -> System.out.println(" " + s));


        // Завдання 4
        StudentConsumer printLastFirst = s -> {
            if (s == null) return;
            System.out.println((s.getLastName() == null ? "" : s.getLastName().toUpperCase())
                    + " " + (s.getFirstName() == null ? "" : s.getFirstName()));
        };
        System.out.println("\n=== Завдання 4: forEachStudent ===");
        StudentFilter.forEachStudent(students, printLastFirst);


        // Завдання 5
        Integer[] numbers = {-5, 0, 1, 2, 3, 10, 15, 20};
        Predicate<Integer> positive = x -> x != null && x > 0;
        Consumer<Integer> printSquare = x -> System.out.println(x + " -> " + (x * x));
        System.out.println("\n=== Завдання 5: applyIf (позитивні -> квадрат) ===");
        NumberTasks.applyIf(numbers, positive, printSquare);


        // Завдання 6
        Function<Integer, BigInteger> pow2 = NumberTasks.powerOfTwoFunction();
        System.out.println("\n=== Завдання 6: 2^n ===");
        for (int n = 0; n <= 10; n++) System.out.printf("2^%d = %s\n", n, pow2.apply(n).toString());


        // Завдання 7
        int[] tenDigits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Function<Integer, String> digitToUkr = d -> {
            switch (d) {
                case 0:
                    return "нуль";
                case 1:
                    return "один";
                case 2:
                    return "два";
                case 3:
                    return "три";
                case 4:
                    return "чотири";
                case 5:
                    return "п'ять";
                case 6:
                    return "шість";
                case 7:
                    return "сім";
                case 8:
                    return "вісім";
                case 9:
                    return "дев'ять";
                default:
                    throw new IllegalArgumentException("digit must be 0..9");
            }
        };
        String sentence = NumberTasks.stringify(tenDigits, digitToUkr);
        System.out.println("\n=== Завдання 7: stringify ===");
        System.out.println(sentence);
    }
}
