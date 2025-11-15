package ua.opnu;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StudentFilter {
    // Завдання 2: фільтрація масиву студентів за предикатом
    public static List<Student> filterStudents(Student[] students, Predicate<Student> predicate) {
        List<Student> result = new ArrayList<>();
        if (students == null || predicate == null) return result;
        for (Student s : students) {
            if (predicate.test(s)) result.add(s);
        }
        return result;
    }


    // Завдання 3: фільтрація за двома умовами (AND)
    public static <T> List<T> filterByTwoPredicates(T[] items, Predicate<T> p1, Predicate<T> p2) {
        List<T> result = new ArrayList<>();
        if (items == null || p1 == null || p2 == null) return result;
        for (T it : items) {
            if (p1.test(it) && p2.test(it)) result.add(it);
        }
        return result;
    }


    // Завдання 4: forEach для Student з власним StudentConsumer
    public static void forEachStudent(Student[] students, StudentConsumer consumer) {
        if (students == null || consumer == null) return;
        for (Student s : students) consumer.accept(s);
    }
}