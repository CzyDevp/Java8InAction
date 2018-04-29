package finale;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import static finale.Course.Program;

public class ExamQuestion1 {

	public static void main(String[] args) {
		System.out.println("Hello, SOEN6411 Exam Question 1!");
		
		List<Course> courses = Arrays.asList(
				new Course("Advanced Programming Practices", Program.SOEN, "6441", 4),
				new Course("Materials Engineering for Aerospace", Program.ENGR, "6441", 4),
				new Course("Helicopter Flight Dynamics", Program.MECH, "6231", 4),
				new Course("Semantic Computing", Program.SOEN, "6211", 4),
				new Course("PhD Seminar", Program.ENCS, "8011", 2),		
				new Course("Parallel Programming", Program.COMP, "6281", 4),
				new Course("Doctoral Research and Thesis", Program.COMP, "8901", 70),				
				new Course("Software Systems Requirements Specifications", Program.SOEN, "6481", 4));
		
		// Subtask a)
		List<Course> fourCreditCourses = courses.stream().filter(c->c.getCredits()==4).collect(Collectors.toList());
		System.out.println("a) " + fourCreditCourses);

		// Subtask b)
		int sumCredits = courses.stream().map(Course::getCredits).reduce(0,Integer::sum);
		System.out.println("b) " + sumCredits);

		// Subtask c)
		boolean hasMegaCourse = courses.stream().anyMatch(c->c.getCredits()>50);
		System.out.println("c) " + hasMegaCourse);
		
		// Subtask d)
		Optional<Course> c6441 = courses.stream().filter(c->c.getNumber()=="6441").findFirst();
		System.out.println("d) " + c6441);
		
		// Subtask e)
		String allWords =  courses.stream().map(Course::getName).distinct().collect(Collectors.joining(" "));
		List<String> elements = Arrays.asList(allWords.split(" "));
		Set<String> courseWords=elements.stream().collect(Collectors.toCollection(()->new TreeSet<>(String.CASE_INSENSITIVE_ORDER))); //ordered version
		System.out.println("e) " + courseWords);
		
		System.out.println("Goodbye, SOEN6411 Exam Question 1!");
	}
}
