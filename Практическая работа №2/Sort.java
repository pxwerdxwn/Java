import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

class Human {
    int age;
    String firstName;
    String lastName;
    LocalDate birthDate;
    int weight;

    public Human(int age, String firstName, String lastName, LocalDate birthDate, int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    public String toString() {
        return "Human{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", weight=" + weight +
                '}';
    }
}

public class Sort {
    public static void main(String[] args) {
        List<Human> humans = Arrays.asList(
                new Human(30, "Alice", "Smith", LocalDate.of(1993, 5, 15), 70),
                new Human(25, "Bob", "Johnson", LocalDate.of(1998, 8, 21), 65),
                new Human(35, "Charlie", "Brown", LocalDate.of(1988, 2, 10), 80),
                new Human(28, "David", "Lee", LocalDate.of(1995, 11, 8), 91)
        );

        humans.sort((h1, h2) -> Character.compare(h1.firstName.charAt(1), h2.firstName.charAt(1)));
        System.out.println("Сортировка по второй букве имени:");
        humans.forEach(System.out::println);

        List<Human> filteredHumans = humans.stream()
                .filter(human -> human.weight % 10 == 0)
                .toList();
        System.out.println("Фильтрация по весу, кратному 10:");
        filteredHumans.forEach(System.out::println);

       humans.sort((h1, h2) -> Integer.compare(h1.age * h1.weight, h2.age * h2.weight));
        System.out.println("Сортировка по произведению веса на возраст:");
        humans.forEach(System.out::println);

        int weightProduct = 1; 
        for (Human human : humans) {
            weightProduct *= human.weight;
        }
        System.out.println("Произведение всех весов: " + weightProduct);        //33124000
    
    }
}
