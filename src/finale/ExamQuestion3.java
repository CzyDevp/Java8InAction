package finale;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import finale.Course.Program;
public class ExamQuestion3 {
// Subtask a)
	private static CompletionStage<Integer> addCredits (List<Course> courses) {
		return  CompletableFuture.supplyAsync(()->courses.stream().map(Course::getCredits).reduce(0,Integer::sum));
}
 		
 	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Hello, SOEN6411 Exam Question 3!");
		
		List<Course> courses = Arrays.asList(
				new Course("Advanced Programming Practices", Program.SOEN, "6441", 4),
				new Course("Materials Engineering for Aerospace", Program.ENGR, "6441", 4),
				new Course("Helicopter Flight Dynamics", Program.MECH, "6231", 4),
				new Course("Semantic Computing", Program.SOEN, "6211", 4),
				new Course("PhD Seminar", Program.ENCS, "8011", 2),		
				new Course("Parallel Programming", Program.COMP, "6281", 4),
				new Course("Doctoral Research and Thesis", Program.COMP, "8901", 70),				
				new Course("Software Systems Requirements Specifications", Program.SOEN, "6481", 4));
		// Subtask a) -- see method addCredits above
		final CompletionStage<Integer> futureSum = addCredits(courses);
		futureSum.thenAcceptAsync(System.out::println);
		Thread.sleep(100);
		futureSum.thenAccept(action->{
			System.out.println(action.intValue());
			});
     	// Subtask c)
		final CompletionStage<Boolean> futureStatus = addCredits(courses).thenApply(fn->{
		/*	if(fn.intValue()>50){
			return true;
				}*/
			return (fn.intValue()>50) ? true : false;  //5 to 1 line code
			//System.out.println(fn);
				//return false;
		});		
		futureStatus.thenAccept(System.out::println);

		System.out.println("Goodbye, SOEN6411 Exam Question 3!");
	}
}
