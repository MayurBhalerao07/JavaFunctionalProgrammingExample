package programming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExampleFPLimitSkipTakeWhileDropWhile {

    public static void main(String[] args) {

        List<Course> courses = Arrays.asList(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000));

        //limit method
        System.out.println(courses.stream().sorted(Comparator.comparing(Course::getNoOfStudents))
                 .limit(5)
                 .collect(Collectors.toList()));

        //skip method
        System.out.println(courses.stream().sorted(Comparator.comparing(Course::getNoOfStudents)).skip(3).collect(Collectors.toList()));

        // limit and skip method
        System.out.println(courses.stream().sorted(Comparator.comparing(Course::getNoOfStudents)).limit(5).skip(2).collect(Collectors.toList()));

        System.out.println(courses);
        // takeWhile method
        System.out.println(
                courses.stream()
                        .takeWhile(course -> course.getReviewScore()>=95)
                        .collect(Collectors.toList()));

        // dropWhile method
        System.out.println(
                courses.stream().dropWhile(course -> course.getReviewScore()>=95)
                        .collect(Collectors.toList())
        );




    }
}
