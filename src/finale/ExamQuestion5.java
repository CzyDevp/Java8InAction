package finale;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import finale.Course.Program;

public class ExamQuestion5 {
	
	public static void main(String[] args) {
		System.out.println("Hello, SOEN6411 Exam Question 5!");
		
		List<Course> coursesJoe = Arrays.asList(
				new Course("Advanced Programming Practices", Program.SOEN, "6441", 4),
				new Course("Software Systems Requirements Specifications", Program.SOEN, "6481", 4));
		
		List<Student> students = Arrays.asList(
				new Student("Jane", 199999999L, Optional.empty()),
				new Student("Joe", 200000000L, Optional.of(coursesJoe))
				);
		
		// a) list of stude
		Map<Long, List<Optional<List<Course>>>>student=students.stream().filter(st->st.getCourses().isPresent()).collect(Collectors.groupingBy(Student::getId,Collectors.mapping(Student::getCourses, Collectors.toList())));
	    System.out.println(student);
	    
	    
	    
		// b) print number of courses per id
		System.out.println("Goodbye, SOEN6411 Exam Question 5!");
	}
}
