package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Student;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testTask2() {
        List<Animal> animals = Util.getAnimals();
        List<String> japaneseAnimals = animals.stream()
                .filter(animal -> "Japanese".equalsIgnoreCase(animal.getOrigin()))
                .filter(animal -> "Female".equalsIgnoreCase(animal.getGender()))
                .map(animal -> animal.getBread().toUpperCase())
                .collect(Collectors.toList());

        assertNotNull(japaneseAnimals);
    }

    @Test
    void testTask3() {
        List<Animal> animals = Util.getAnimals();
        Set<String> countriesStartingWithA = animals.stream()
                .filter(animal -> animal.getAge() > 30)
                .map(Animal::getOrigin)
                .filter(origin -> origin.startsWith("A"))
                .collect(Collectors.toSet());

        assertNotNull(countriesStartingWithA);
        assertTrue(countriesStartingWithA.contains("Arabic"));
    }

    @Test
    void testTask4() {
        List<Animal> animals = Util.getAnimals();
        long femaleCount = animals.stream()
                .filter(animal -> "Female".equalsIgnoreCase(animal.getGender()))
                .count();

        assertTrue(femaleCount > 0);
    }

    @Test
    void testTask17() {
        List<Student> students = Util.getStudents();
        Set<String> uniqueGroups = students.stream()
                .map(Student::getGroup)
                .collect(Collectors.toSet());

        assertNotNull(uniqueGroups);
        assertTrue(uniqueGroups.contains("C-3"));
    }

    @Test
    void testTask21() {
        List<Student> students = Util.getStudents();
        Map<String, Long> groupCounts = students.stream()
                .collect(Collectors.groupingBy(Student::getGroup, Collectors.counting()));

        assertNotNull(groupCounts);
        assertTrue(groupCounts.containsKey("C-3"));
        assertTrue(groupCounts.get("C-3") > 0);
    }
}
