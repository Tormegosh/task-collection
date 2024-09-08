package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import static java.time.LocalDate.now;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        task17();
        task18();
        task19();
        task20();
        task21();
        task22();
    }

    public static void task1() {
        List<Animal> animals = Util.getAnimals();
        List<Animal> youngAnimals = animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() <= 20)
                .sorted(Comparator.comparingInt(Animal::getAge))
                .toList();

        List<List<Animal>> zoos = new ArrayList<>();
        for (int i = 0; i < youngAnimals.size(); i += 7) {
            zoos.add(youngAnimals.stream()
                    .skip(i)
                    .limit(7)
                    .collect(Collectors.toList()));
        }

        System.out.println("\nTask №1 result:");
        if (zoos.size() >= 3) {
            List<Animal> thirdZoo = zoos.get(2);
            System.out.println("Animals in 3 zoos:");
            thirdZoo.forEach(System.out::println);
        } else {
            System.out.println("There are not enough animals for 3 zoos.");
        }
    }

    public static void task2() {
        List<Animal> animals = Util.getAnimals();
        List<String> japaneseAnimals = animals.stream()
                .filter(animal -> "Japanese".equalsIgnoreCase(animal.getOrigin()))
                .filter(animal -> "Female".equalsIgnoreCase(animal.getGender()))
                .map(animal -> animal.getBread().toUpperCase())
                .toList();
        System.out.println("\nTask 2 result:");
        japaneseAnimals.forEach(System.out::println);
    }

    public static void task3() {
        List<Animal> animals = Util.getAnimals();
        Set<String> countriesStartingWithA = animals.stream()
                .filter(animal -> animal.getAge() > 30)
                .map(Animal::getOrigin)
                .filter(origin -> origin.startsWith("A"))
                .collect(Collectors.toSet());
        System.out.println("\nTask 3 result:");
        countriesStartingWithA.forEach(System.out::println);
    }

    public static void task4() {
        List<Animal> animals = Util.getAnimals();
        long femaleCount = animals.stream()
                .filter(animal -> "Female".equalsIgnoreCase(animal.getGender()))
                .count();

        System.out.println("\nTask 4 result:");
        System.out.println("Total number of female animals: " + femaleCount);
    }

    public static void task5() {
        List<Animal> animals = Util.getAnimals();
        boolean hasHungarianAnimal = animals.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
                .anyMatch(animal -> "Hungarian".equalsIgnoreCase(animal.getOrigin()));
        System.out.println("\nTask 5 result:");
        if (hasHungarianAnimal) {
            System.out.println("Yes, the Hungarian animal is present");
        } else {
            System.out.println("No, the Hungarian animal is missing");
        }
    }

    public static void task6() {
        List<Animal> animals = Util.getAnimals();
        Set<String> invalidGenders = animals.stream()
                .map(Animal::getGender)
                .filter(gender -> !"Male".equalsIgnoreCase(gender) && !"Female".equalsIgnoreCase(gender))
                .collect(Collectors.toSet());
        System.out.println("\nTask 6 result:");
        if (invalidGenders.isEmpty()) {
            System.out.println("All animals have either Male or Female gender.");
        } else {
            System.out.println("Animals with other genders:");
            invalidGenders.forEach(System.out::println);
        }
    }

    public static void task7() {
        List<Animal> animals = Util.getAnimals();
        boolean noOceaniaOrigin = animals.stream()
                .noneMatch(animal -> "Oceania".equalsIgnoreCase(animal.getOrigin()));
        System.out.println("\nTask 7 result:");
        if (noOceaniaOrigin) {
            System.out.println("No animals have Oceania as their origin.");
        } else {
            System.out.println("There is at least one animal with Oceania as its origin.");
        }
    }

    public static void task8() {
        List<Animal> animals = Util.getAnimals();
        List<Animal> first100Animals = animals.stream()
                .sorted((a1, a2) -> a1.getBread().compareToIgnoreCase(a2.getBread()))
                .limit(100)
                .toList();
        System.out.println("\nTask 8 result:");
        if (first100Animals.isEmpty()) {
            System.out.println("No animals found.");
        } else {
            int maxAge = first100Animals.stream()
                    .mapToInt(Animal::getAge)
                    .max()
                    .orElseThrow(() -> new IllegalStateException("Error finding max age"));
            System.out.println("The age of the oldest animal among the first 100 sorted by breed is: " + maxAge);
        }
    }

    public static void task9() {
        List<Animal> animals = Util.getAnimals();
        int minLength = animals.stream()
                .map(animal -> animal.getBread().toCharArray())
                .mapToInt(arr -> arr.length)
                .min()
                .orElseThrow(() -> new IllegalStateException("Error finding minimum length"));
        System.out.println("\nTask 9 result:");
        System.out.println("The length of the shortest breed array is: " + minLength);
    }

    public static void task10() {
        List<Animal> animals = Util.getAnimals();
        int totalAge = animals.stream()
                .mapToInt(Animal::getAge)
                .sum();
        System.out.println("\nTask 10 result:");
        System.out.println("The total age of all animals is: " + totalAge);
    }

    public static void task11() {
        List<Animal> animals = Util.getAnimals();
        double averageAge = animals.stream()
                .filter(animal -> "Indonesian".equalsIgnoreCase(animal.getOrigin()))
                .mapToInt(Animal::getAge)
                .average()
                .orElse(Double.NaN);
        System.out.println("\nTask 11 result:");
        if (Double.isNaN(averageAge)) {
            System.out.println("There are no Indonesian animals.");
        } else {
            System.out.println("The average age of Indonesian animals is: " + String.format("%.2f", averageAge));
        }
    }

    public static void task12() {
        List<Person> persons = Util.getPersons();

        List<Person> selectedCandidates = persons.stream()
                .filter(person -> "Male".equalsIgnoreCase(person.getGender()) &&
                        Period.between(person.getDateOfBirth(), now()).getYears() >= 18 &&
                        Period.between(person.getDateOfBirth(), now()).getYears() <= 27)
                .sorted(Comparator.comparingInt(Person::getRecruitmentGroup))
                .limit(200)
                .toList();
        System.out.println("\nTask 12 result:");
        selectedCandidates.forEach(System.out::println);
    }

    public static void task13() {
        List<House> houses = Util.getHouses();
        List<Person> persons = houses.stream()
                .filter(house -> "Hospital".equalsIgnoreCase(house.getBuildingType()))
                .flatMap(house -> house.getPersonList().stream())
                .toList();
        List<Person> evacuationStage1 = persons.stream()
                .filter(person -> "Male".equalsIgnoreCase(person.getGender()) ||
                        "Female".equalsIgnoreCase(person.getGender()))
                .filter(person -> Period.between(person.getDateOfBirth(), now()).getYears() <= 18 ||
                        Period.between(person.getDateOfBirth(), now()).getYears() >= 65)
                .sorted(Comparator.comparing(Person::getDateOfBirth).reversed())
                .limit(500)
                .toList();
        System.out.println("\nTask 13 result:");
        evacuationStage1.forEach(System.out::println);
    }

    public static void task14() {
        List<Car> cars = Util.getCars();
        Map<String, List<Car>> countryCars = cars.stream()
                .filter(car -> "Jaguar".equalsIgnoreCase(car.getCarMake()) || "White".equalsIgnoreCase(car.getColor()) ||
                        (car.getMass() <= 1500 && List.of("BMW", "Lexus", "Chrysler", "Toyota").contains(car.getCarMake())) ||
                        ("Black".equalsIgnoreCase(car.getColor()) && car.getMass() > 4000) ||
                        List.of("GMC", "Dodge").contains(car.getCarMake()) ||
                        (car.getReleaseYear() <= 1982 || List.of("Civic", "Cherokee").contains(car.getCarModel())) ||
                        (!List.of("Yellow", "Red", "Green", "Blue").contains(car.getColor()) || car.getPrice() > 40000) ||
                        car.getVin().contains("59"))
                .collect(Collectors.groupingBy(car -> {
                    if ("Jaguar".equalsIgnoreCase(car.getCarMake()) || "White".equalsIgnoreCase(car.getColor())) {
                        return "Turkmenistan";
                    } else if (car.getMass() <= 1500 && List.of("BMW", "Lexus", "Chrysler", "Toyota").contains(car.getCarMake())) {
                        return "Uzbekistan";
                    } else if ("Black".equalsIgnoreCase(car.getColor()) && car.getMass() > 4000 ||
                            List.of("GMC", "Dodge").contains(car.getCarMake())) {
                        return "Kazakhstan";
                    } else if (car.getReleaseYear() <= 1982 ||
                            List.of("Civic", "Cherokee").contains(car.getCarModel())) {
                        return "Kyrgyzstan";
                    } else if (!List.of("Yellow", "Red", "Green", "Blue").contains(car.getColor()) ||
                            car.getPrice() > 40000) {
                        return "Russia";
                    } else if (car.getVin().contains("59")) {
                        return "Mongolia";
                    } else {
                        return "unknown";
                    }
                }));
        Map<String, Double> totalMasses = countryCars.entrySet().stream()
                .filter(entry -> entry.getKey() != null)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream().mapToDouble(Car::getMass).sum()
                ));

        Map<String, Double> totalCosts = totalMasses.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue() * 7.14
                ));
        System.out.println("\nTask 14 result:");
        totalCosts.forEach((country, cost) -> System.out.printf("Total transport cost for %s: $%.2f%n", country, cost));
        double totalRevenue = totalCosts.values().stream().mapToDouble(Double::doubleValue).sum();
        System.out.printf("Total revenue: $%.2f%n", totalRevenue);
    }

    public static void task15() {
        List<Flower> flowers = Util.getFlowers();
        double totalCost = flowers.stream()
                .sorted(Comparator.comparing(Flower::getOrigin).reversed()
                        .thenComparing(Flower::getPrice)
                        .thenComparing(Comparator.comparingDouble(Flower::getWaterConsumptionPerDay).reversed()))
                .filter(flower -> {
                    String commonName = flower.getCommonName().toUpperCase();
                    return commonName.compareTo("C") >= 0 && commonName.compareTo("S") <= 0;
                })
                .filter(flower -> flower.isShadePreferred() &&
                        flower.getFlowerVaseMaterial().stream()
                                .anyMatch(vase -> List.of("Glass", "Aluminum", "Steel").contains(vase)))
                .mapToDouble(flower -> {
                    double flowerCost = flower.getPrice();
                    double waterCostFor5Years = flower.getWaterConsumptionPerDay() * 365 * 5 * 1.39;
                    return flowerCost + waterCostFor5Years;
                })
                .sum();
        System.out.println("\nTask 15 result:");
        System.out.println("Total budget cost: $" + totalCost);
    }

    public static void task16() {
        List<Student> students = Util.getStudents();
        System.out.println("\nTask 16 result:");
        students.stream()
                .filter(student -> student.getAge() < 18)
                .sorted(Comparator.comparing(Student::getSurname))
                .forEach(student ->
                        System.out.println(student.getSurname() + " - " + student.getAge())
                );
    }

    public static void task17() {
        List<Student> students = Util.getStudents();
        Set<String> uniqueGroups = students.stream()
                .map(Student::getGroup)
                .collect(Collectors.toSet());
        System.out.println("\nTask 17 result:");
        uniqueGroups.forEach(System.out::println);
    }

    public static void task18() {
        List<Student> students = Util.getStudents();
        Map<String, Double> averageAgeByFaculty = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.averagingInt(Student::getAge)
                ));
        System.out.println("\nTask 18 result:");
        averageAgeByFaculty.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + String.format("%.2f", entry.getValue())));
    }

    public static void task19() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
        System.out.println("\nTask 19 result:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the group name: ");
        String targetGroup = scanner.nextLine();
        Map<Integer, Examination> studentExams = examinations.stream()
                .collect(Collectors.toMap(Examination::getStudentId, exam -> exam));
        students.stream()
                .filter(student -> student.getGroup().equals(targetGroup))
                .filter(student -> {
                    Examination exam = studentExams.get(student.getId());
                    return exam != null && exam.getExam3() > 4;
                })
                .forEach(student -> System.out.println(student.getSurname() + ", " + student.getAge()));
    }

    public static void task20() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
        Map<Integer, Student> studentMap = students.stream()
                .collect(Collectors.toMap(Student::getId, student -> student));
        Map<String, Double> facultyAverageScores = examinations.stream()
                .collect(Collectors.groupingBy(
                        exam -> studentMap.get(exam.getStudentId()).getFaculty(),
                        Collectors.averagingInt(Examination::getExam1)
                ));
        String topFaculty = facultyAverageScores.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No faculty found");
        System.out.println("\nTask 20 result:");
        System.out.println("Faculty with the highest average score on the first exam: " + topFaculty);
    }

    public static void task21() {
        List<Student> students = Util.getStudents();
        Map<String, Long> groupCounts = students.stream()
                .collect(Collectors.groupingBy(Student::getGroup, Collectors.counting()));
        System.out.println("\nTask 21 result:");
        groupCounts.forEach((group, count) ->
                System.out.println("Group: " + group + ", Number of students: " + count)
        );
    }

    public static void task22() {
        List<Student> students = Util.getStudents();
        Map<String, Integer> minAgeByFaculty = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.collectingAndThen(
                                Collectors.minBy(Comparator.comparingInt(Student::getAge)),
                                minStudent -> minStudent.map(Student::getAge).orElse(Integer.MAX_VALUE)
                        )
                ));
        System.out.println("\nTask 22 result:");
        minAgeByFaculty.forEach((faculty, minAge) ->
                System.out.println("Faculty: " + faculty + ", Minimum Age: " + minAge)
        );
    }
}
