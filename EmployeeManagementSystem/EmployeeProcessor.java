package EmployeeManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeProcessor {

    public static void main(String[] args) {
        // 1. Read the dataset and store it in a collection
        List<Employee> employees = getEmployeeData();

        // 2. Write a function using the Function interface
        Function<Employee, String> nameAndDepartmentFunction = employee ->
                "Name: " + employee.getName() + ", Department: " + employee.getDepartment();

        // 3. Use streams to generate a new collection with concatenated strings
        List<String> nameAndDepartmentList = employees.stream()
                .map(nameAndDepartmentFunction)
                .collect(Collectors.toList());

        System.out.println("\nEmployee Names and Departments:");
        nameAndDepartmentList.forEach(System.out::println);

        // 4. Find the average salary of all employees using streams
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0); // Handle empty stream case

        System.out.println("\nAverage Salary: " + averageSalary);

        // 5. Incorporate a filter function (age above 30)
        int ageThreshold = 30;
        List<Employee> filteredEmployees = employees.stream()
                .filter(employee -> employee.getAge() > ageThreshold)
                .collect(Collectors.toList());

        System.out.println("\nEmployees Above " + ageThreshold + " Years Old:");
        filteredEmployees.forEach(System.out::println);

        //Demonstrate the creation of a stream from a collection
        Stream<Employee> employeeStream = employees.stream();
        System.out.println("\nStream of Employees: " + employeeStream);

        //Demonstrate the use of peek
        List<Employee> peekDemo = employees.stream()
                .peek(e -> System.out.println("Peeking at employee: " + e.getName())) // Perform an action withou modifying
                .collect(Collectors.toList());
        System.out.println("\nPeek demo result: " + peekDemo);

        // 6. Summarize the program (Purpose, Characteristics, and Usage of Function Interface and Streams) - in comments

        /*
         * Purpose, Characteristics, and Usage of Function Interface in Java:
         *
         * Purpose:
         * The Function interface is a core functional interface in Java that represents a function
         * that accepts one argument and produces a result. It's designed to support functional programming
         * paradigms by allowing you to treat functions as first-class citizens.  It's a generic interface,
         * `Function<T, R>`, where `T` is the type of the input to the function, and `R` is the type of
         * the result of the function.
         *
         * Characteristics:
         * -   Single Abstract Method (SAM): It has a single abstract method called `apply(T t)`.  This
         * method takes an argument of type `T` and returns a value of type `R`.
         * -   Generic: It's a generic interface, providing flexibility to work with different types.
         * -   Predefined Functional Interface:  It is part of the `java.util.function` package,
         * so it's readily available for use.
         * -   Can be used with Lambda Expressions or Method References:  You can create instances
         * of Function using lambda expressions or method references, making the code concise and readable.
         * -   Supports Function Composition:  The `compose()` and `andThen()` methods allow you to combine
         * Function instances to create more complex functions.
         *
         * Usage:
         * The Function interface is widely used in Java, especially with streams and other functional
         * programming constructs.  Common use cases include:
         * -   Transforming data:  Used with the `map()` method of streams to convert elements from one type to another.
         * -   Filtering data:  Although `Predicate` is more common, a `Function` that returns a Boolean
         * can be used in filtering scenarios.
         * -   Extracting data:  Extracting specific attributes from objects.
         * -   Defining custom logic:  Passing behavior as an argument to methods.
         * -   Method Chaining: Combining multiple function operations.
         *
         *
         * Purpose, Characteristics, and Usage of Streams in Java:
         *
         * Purpose:
         * Streams provide a way to process collections of data in a declarative and efficient manner.
         * They enable sequential and parallel operations on data, supporting functional-style programming.
         * Streams are designed to work with collections, arrays, or I/O resources, allowing for operations
         * like filtering, mapping, and reducing data. They focus on *what* needs to be done, rather than
         * *how* to do it.
         *
         * Characteristics:
         * -   Sequence of Elements: A stream represents a sequence of elements.
         * -   Source: Streams take their elements from a source, which could be a collection, an array,
         * a generator function, or an I/O channel.
         * -   Data Processing Operations: Streams support various operations like filtering, mapping,
         * reducing, finding, and sorting.
         * -   Pipelining:  Most stream operations return a stream themselves, allowing operations to
         * be chained to form a pipeline.
         * -   Internal Iteration:  Unlike collections, which use external iteration (you control the
         * iteration with a loop), streams use internal iteration (the stream controls the iteration).
         * -   Laziness: Stream operations are often lazy; they are executed only when a terminal
         * operation is invoked. This allows for optimizations like short-circuiting.
         * -   Single-Use:  A stream can be consumed only once. After a terminal operation is called,
         * the stream is closed.
         * -   Optional Parallelism: Streams can be processed sequentially or in parallel.
         *
         * Usage:
         * Streams are used extensively for data manipulation and processing in Java.  Common use cases include:
         * -   Processing collections:  Filtering, mapping, sorting, and reducing elements in collections.
         * -   Performing calculations:  Calculating sums, averages, and other statistics.
         * -   Data transformations:  Converting data from one format to another.
         * -   Working with I/O:  Reading and processing data from files or other input sources.
         * -   Parallel processing:  Leveraging multi-core processors for improved performance.
         * -   Implementing complex queries: Performing database-like operations on in-memory data.
         */
    }

    // Method to get employee data (simulates reading from a database or file)
    private static List<Employee> getEmployeeData() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice Smith", 32, "Sales", 55000.0));
        employees.add(new Employee("Bob Johnson", 28, "Marketing", 48000.0));
        employees.add(new Employee("Charlie Brown", 45, "Engineering", 75000.0));
        employees.add(new Employee("David Wilson", 24, "Sales", 50000.0));
        employees.add(new Employee("Eve Davis", 38, "Engineering", 80000.0));
        employees.add(new Employee("Frank Miller", 31, "Marketing", 52000.0));
        employees.add(new Employee("Grace Taylor", 29, "HR", 45000));
        employees.add(new Employee("Henry Anderson", 52, "Engineering", 92000));
        employees.add(new Employee("Ivy Martinez", 27, "Sales", 51000));
        employees.add(new Employee("Jack Robinson", 36, "HR", 60000));
        return employees;
    }
}
