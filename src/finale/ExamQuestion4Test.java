package finale;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import finale.Course.Program;
import finale.ExamQuestion4;
public class ExamQuestion4Test {
	List<Course> courses = new ArrayList<>();  //normal case
	List<Course> nullCourses = null;
	@Before
	public void setUp() throws Exception {
		    courses = Arrays.asList(
				new Course("Advanced Programming Practices", Program.SOEN, "6441", 4),
				new Course("Helicopter Flight Dynamics", Program.MECH, "6231", 4),
				new Course("Semantic Computing", Program.SOEN, "6211", 4),
				new Course("PhD Seminar", Program.ENCS, "8011", 2),		
				new Course("Parallel Programming", Program.COMP, "6281", 4),
				new Course("Doctoral Research and Thesis", Program.COMP, "8901", 70),				
				new Course("Software Systems Requirements Specifications", Program.SOEN, "6481", 4)
				,new Course("Advanced Programming Practices", Program.SOEN, "6441", 8));
	}

	@Test
	public void testGetCredits() {
		  assertEquals(0,ExamQuestion4.getCredits(nullCourses, Program.COMP, "6441"));    //test with null output
	}
    
	@Test
	public void testGetCreditsWithDuplication() {
		  assertEquals(4,ExamQuestion4.getCredits(courses, Program.SOEN, "6441"));    //test with duplication case
			}
	
	@Test
	public void testGetCreditsCourseNotThere() {
		  assertEquals(0,ExamQuestion4.getCredits(courses, Program.ENGR, "6441"));    //test when course not there
		}
}
