package programming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course{

    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
       return name;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public String getCategory(){
        return category;
    }
    public void setReviewScore(int reviewScore){
        this.reviewScore = reviewScore;
    }
    public int getReviewScore(){
        return reviewScore;
    }
    public void setNoOfStudents(int noOfStudents){
        this.noOfStudents = noOfStudents;
    }
    public int getNoOfStudents()
    {
        return noOfStudents;
    }

    public Course(String name,String category ,int reviewScore,int noOfStudents){
        super();
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String toString(){
        return name + " " + category + " " + reviewScore + " " + noOfStudents;
    }


}
public class ExampleFPCustomClass {
    public static void main(String[] args) {

        List<Course> courses = Arrays.asList(new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000), new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000), new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000));


        // allMatch , anyMatch , noneMatch

        Predicate<Course> reviewScoreGreaterThen95Predicate = course -> course.getReviewScore()>95;
        Predicate<Course> reviewScoreGreaterThen90Predicate = course -> course.getReviewScore()>90;
        Predicate<Course> reviewScoreLessThen90Predicate = course -> course.getReviewScore()<90;

        System.out.println(courses.stream().allMatch(reviewScoreGreaterThen95Predicate));
        System.out.println(courses.stream().noneMatch(reviewScoreGreaterThen90Predicate));
        System.out.println(courses.stream().anyMatch(reviewScoreLessThen90Predicate));
        System.out.println(courses.stream().anyMatch(reviewScoreGreaterThen95Predicate));

        Comparator<Course> comparingByNoOfStudentsIncreasingOrder = Comparator.comparing(Course::getNoOfStudents);
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsIncreasingOrder).collect(Collectors.toList()));

        Comparator<Course> comparingByNoOfStudentsDecreasingOrder = Comparator.comparing(Course :: getNoOfStudents).reversed();
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsDecreasingOrder).collect(Collectors.toList()));

        Comparator<Course> comparingBtNoOfStudentsAndNoOfReview = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed();
        System.out.println(courses.stream().sorted(comparingBtNoOfStudentsAndNoOfReview).collect(Collectors.toList()));
    }
}
