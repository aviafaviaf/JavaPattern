package Practice2;

import java.time.LocalDate;

public class Human {
    private int age;
    private int weight;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public Human(int age, int weight, String firstName, String lastName, LocalDate birthDate) {
        this.age = age;
        this.weight = weight;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + age + " " + weight + " " + birthDate;
    }
}
