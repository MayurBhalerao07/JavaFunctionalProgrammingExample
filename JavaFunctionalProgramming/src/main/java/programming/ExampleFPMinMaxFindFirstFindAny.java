package programming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ExampleFPMinMaxFindFirstFindAny {

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

        Comparator<Course> comparingByNoOfStudentAndNoOfReviews
                = Comparator.comparingInt(Course :: getNoOfStudents)
                .thenComparingInt(Course :: getReviewScore)
                .reversed();

        System.out.println(courses);

        System.out.println(courses.stream().min(comparingByNoOfStudentAndNoOfReviews));
        //Optional[Microservices Microservices 96 25000]

        System.out.println(courses.stream().max(comparingByNoOfStudentAndNoOfReviews));
        //Optional[FullStack FullStack 91 14000]

        System.out.println(courses.stream()
                        .filter(x->x.getReviewScore() <=90)
                .max(comparingByNoOfStudentAndNoOfReviews)
                .orElse(new Course("Sales Force" ,"CRM Tool", 100, 30000)));

       // Optional.empty else Sales Force CRM Tool 100 30000

        System.out.println(courses.stream().filter(x->x.getReviewScore()>=95).findFirst());
        //Optional[Spring Framework 98 20000]

        System.out.println(courses.stream().filter(x->x.getReviewScore()>=91).findAny());
       // Optional[Spring Framework 98 20000]
    }


}
