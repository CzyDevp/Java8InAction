package finale;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import finale.Course.Program;

public class ExamQuestion2 {
	public static void main(String[] args) {
		System.out.println("Hello, SOEN6411 Exam Question 2!");
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
		Map<Program, List<Course>> coursesByType = courses.stream().collect(Collectors.groupingBy(Course::getProgram));
		System.out.println("a) " + coursesByType);
		
		// Subtask b)
		Map<Boolean, List<Course>> partitionedCourses = courses.stream().collect(Collectors.partitioningBy(course->course.getProgram().equals(Program.SOEN)));
		System.out.println("b) " + partitionedCourses);
		
		// Subtask c)
		final Course courseLongestName = courses.stream().collect(Collectors.maxBy(Comparator.comparing((Course c) -> c.getName().length())))
	               .orElseThrow(RuntimeException::new);;  
		System.out.println("c) " + courseLongestName.getName() );
		
		System.out.println("Goodbye, SOEN6411 Exam Question 2!");
	}
}