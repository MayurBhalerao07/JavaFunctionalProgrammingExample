package programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExampleFPListToString {
    public static void main(String[] args) {
        List<String> courses = Arrays.asList(
          "Spring","SpringBoot","AWS","Azure","Docker","Kubernetes","PCF"
        );
        List<String> courses2 = Arrays.asList(
                "Spring","SpringBoot","AWS","Azure","Docker","Kubernetes","PCF"
        );
        courses2.removeIf(course -> course.length()<6);

        System.out.println(courses.stream().collect(Collectors.joining(",")));

        System.out.println(
                courses.stream().map(course -> course.split("")).flatMap(Arrays::stream)
                        .collect(Collectors.toList())
        );

        System.out.println(
                courses.stream().flatMap(
                course -> courses2.stream().map(course2 -> Arrays.asList(course, course2)))
                .collect(Collectors.toList()));

        System.out.println(
            courses.stream().flatMap(course -> courses2.stream().map(course2 ->Arrays.asList(course,course2)
                    )).filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList())
        );

        System.out.println(
               courses.stream().flatMap(course -> courses2.stream()
                               .filter(course2 -> course2.length()==course.length())
                       .map(course2 -> Arrays.asList(course,course2))).filter(list -> !list.get(0).equals(list.get(1)))
                       .collect(Collectors.toList())
        );

    }
}
