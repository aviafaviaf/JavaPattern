package Practice2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {
    private ArrayList<Human> humans = new ArrayList<>();
    public void fillArray() {
        humans.add(new Human(19, 70, "Vlad", "Kulikov", LocalDate.of(2004, 3, 11)));
        humans.add(new Human(21, 75, "Ilya", "Podkolzin", LocalDate.of(2002, 5, 13)));
        humans.add(new Human(24, 19, "Pavel", "Morozov", LocalDate.of(2000, 1, 6)));
        humans.add(new Human(22, 65, "Denis", "Grib", LocalDate.of(2001, 7, 4)));
    }
    public void sortByLastCharAtLastName() {
        System.out.println("Сортировка по последней букве в фамилии: ");
        Stream<Human> stream = humans.stream();
        stream.sorted((human1, human2) -> {
            if (human1.getLastName().charAt(human1.getLastName().length() - 1) > human2.getLastName().charAt(human2.getLastName().length() - 1))
                return 1;
            else
                return -1;
        }).forEach(System.out::println);
        System.out.println();
    }
    public void filter() {
        System.out.println("Фильтрация по признаку \"возраст больше чем вес\":");
        Stream<Human> stream = humans.stream();
        stream.filter(human -> human.getWeight() < human.getAge()).forEach(System.out::println);
        System.out.println();
    }
    public void sortByBirthDate() {
        System.out.println("Сортировка по дате рождения: ");
        Stream<Human> stream = humans.stream();
        stream.sorted((human1, human2) -> {
            if (human1.getBirthDate().isAfter(human2.getBirthDate()))
                return 1;
            else
                return -1;
        }).forEach(System.out::println);
        System.out.println();
    }

    public void multipleAllAges() {
        System.out.println("Произведение всех возрастов: ");
        Stream<Human> stream = humans.stream();
    }
}
