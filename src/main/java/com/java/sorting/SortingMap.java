package com.java.sorting;

import java.util.*;
import java.util.stream.Collectors;

public class SortingMap {

    public static Map<Integer, String> getSortedMapByKey(Map<Integer, String> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    }

    public static Map<Integer, String> getSortedMapByValue(Map<Integer, String> map) {
        Comparator comparator = Comparator.comparing((Student::getName));

        Comparator<Student> comparator1 = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getRoll(), o2.getRoll());
            }
        };
        Collections.sort(new ArrayList<>(), Collections.reverseOrder(comparator1));
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    }

    public static Map<Student, Integer> sortMapByKeyUsingStudentNameAndRoll(Map<Student, Integer> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Student::getName).thenComparing(Student::getRoll)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    }

    public static Map<Integer, Student> sortMapByValueUsingStudentNameAndRoll(Map<Integer, Student> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Student::getName).thenComparing(Student::getRoll)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    }
}

class TestSortingMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Rahat");
        map.put(3, "Rahul");
        map.put(2, "Sankalp");

        System.out.println(SortingMap.getSortedMapByKey(map));
        System.out.println(SortingMap.getSortedMapByValue(map));

        Student s1 = new Student("Rahat", 1, 3);
        Student s2 = new Student("Sankalp", 2, 3);
        Student s3 = new Student("Anju", 3, 3);
        Student s4 = new Student("Anju", 3, 3);

        Map<Integer, Student> studmap = new HashMap<>();
        studmap.put(1, s1);
        studmap.put(2, s2);
        studmap.put(3, s3);
        studmap.put(4, s4);

        System.out.println(SortingMap.sortMapByValueUsingStudentNameAndRoll(studmap));

        Map<Student, Integer> studmapforkey = new HashMap<>();
        studmapforkey.put(s1, 1);
        studmapforkey.put(s2, 2);
        studmapforkey.put(s3, 3);
        studmapforkey.put(s4, 4);

        System.out.println(SortingMap.sortMapByKeyUsingStudentNameAndRoll(studmapforkey));

    }


}

class Student {
    private String name;
    private int roll;
    private int std;

    public Student(String name, int roll, int std) {
        this.name = name;
        this.roll = roll;
        this.std = std;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return roll == student.roll && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, roll);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getStd() {
        return std;
    }

    public void setStd(int std) {
        this.std = std;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", roll=" + roll +
                ", std=" + std +
                '}';
    }


}
