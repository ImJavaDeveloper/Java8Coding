package com.java.stream.stream.set_1;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSet1 {
    public static void main(String[] args) {

        List<Employee> employees = new EmployeeData().getEmployees();

        //print all employees
        System.out.println("\n********** print all employees *******\n");
        employees.stream().forEach(System.out::println);

        //print all employees whose salary is greater than 10000
        System.out.println("\n**********Employees whose salary is greater than 10000 *******\n");
        employees.stream().filter(e -> e.getSalary() > 10000).collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("\n**********Get the employee by city *******\n");

        Map<String, List<Employee>> employeeMap = employees.stream().collect(Collectors.groupingBy(Employee::getCity));
        employeeMap.entrySet().stream().forEach(System.out::println);

        System.out.println("\n********** Count of Female and Male Employee *******\n");

        Map<String, Long> employeeCount = employees.stream().collect(
                Collectors.groupingBy(Employee::getGender, Collectors.counting())
        );
        //System.out.println(employeeCount);
        employeeCount.entrySet().forEach(System.out::println);

        System.out.println("\n********** Find the  name of all department *******\n");

        List<String> departments = employees.stream().map(Employee::getDepartment).distinct().toList();
        System.out.println(departments);

        System.out.println("\n********** Find the  max age of employee*******\n");

        int maxAge = employees.stream().map(Employee::getAge).max(Integer::compareTo).get();
        System.out.println(maxAge);

        System.out.println("\n********** Find average age of Male and Female employee *******\n");

        Map<String, Double> avgAge = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
        System.out.println(avgAge);

        System.out.println("\n********** Find number of employee in each department *******\n");

        Map<String, Long> employeeCountByDepartment = employees.stream().collect(
                Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        System.out.println(employeeCountByDepartment);

        System.out.println("\n********** Find the oldest employee detail *******\n");

        Employee oldestEmployee = employees.stream().max(Comparator.comparing(Employee::getAge)).get();
        System.out.println(oldestEmployee);

        System.out.println("\n********** Find the youngest employee detail *******\n");

        Employee youngestEmployee = employees.stream().min(Comparator.comparing(Employee::getAge)).get();
        System.out.println(youngestEmployee);

        System.out.println("\n********** Find the Department name which has highest number of employee *******\n");

        String departmentName = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

        System.out.println("\n********** Find the Department name where number of employee greater than 3 *******\n");

        List<String> departName = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 3).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(departName);

        System.out.println("\n********** Find the all employee who lives in Hyderabad and sort by the name of employee*******\n");

        List<Employee> empList = employees.stream().filter(e -> e.getCity().equalsIgnoreCase("Hyderabad"))
                .sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
        empList.forEach(System.out::println);

        System.out.println("\n********** Sorting employee with age and name *******\n");

        List<Employee> employeeList = employees.stream().sorted(Comparator.comparing(Employee::getAge).thenComparing(Employee::getName)).collect(Collectors.toUnmodifiableList());
        employeeList.stream().forEach(System.out::println);

        System.out.println("\n********** Print average and total salary of all employee *******\n");

        DoubleSummaryStatistics doubleSummaryStatistics = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println("Average Salary:" + doubleSummaryStatistics.getAverage());
        System.out.println("Total Salary:" + doubleSummaryStatistics.getSum());

        System.out.println("\n********** Highest Salary Based on Department *******\n");
        Map<String, Long> departWiseMaxSalary = employees.stream().collect(
                Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)), e -> e.get().getSalary())
                ));
        System.out.println(departWiseMaxSalary);

        System.out.println("\n********** Sort the salary in each Department *******\n");

        Map<String, Stream<Employee>> empListByDepartment = employees.stream().collect(
                Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(
                        Collectors.toList(), e -> e.stream().sorted(Comparator.comparingLong(Employee::getSalary))
                ))
        );

        empListByDepartment.forEach((k, v) -> {
            System.out.print("Department:" + k);
            System.out.println(v.collect(Collectors.toList()));
        });
    }
}
