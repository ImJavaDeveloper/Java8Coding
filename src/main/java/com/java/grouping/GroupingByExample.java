package com.java.grouping;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GroupingByExample {

    public void printGroupByExample() {
        Student student = new Student();
        List<Student> studentData = student.studentData();
        //Address Group By
        Map<String, List<Student>> addressGroupBy = studentData.stream().collect(Collectors.groupingBy(Student::getAddress));
        System.out.println("****************Printing student list Address Group By ********\n");
        System.out.println(addressGroupBy);

        Map<String, Set<Student>> addressGroupByUnique = studentData.stream()
                .collect(Collectors.groupingBy(Student::getAddress, Collectors.toSet()));
        System.out.println("****************Printing unique student list Address Group By ********\n");
        System.out.println(addressGroupByUnique);

        Map<String, Set<Student>> addressGroupByUniqueAndSorted = studentData.stream()
                .collect(Collectors.groupingBy(Student::getAddress, TreeMap::new, Collectors.toSet()));
        System.out.println("****************Printing unique student and sorted list Address Group By ********\n");

        System.out.println(addressGroupByUniqueAndSorted);
        
    }
}
