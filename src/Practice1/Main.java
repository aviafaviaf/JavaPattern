package Practice1;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<Student[]> predicate = (Student[] students) -> {
            for (int i = 0; i < students.length; i++) {
                if (students[i].getMark() == 100)
                    return true;
            }
            return false;
        };
        Student[] students1 = {new Student(15), new Student(35), new Student(45), new Student(100)};
        Student[] students2 = {new Student(15), new Student(35), new Student(45)};
        System.out.println(predicate.test(students1));
        System.out.println(predicate.test(students2));
    }
}