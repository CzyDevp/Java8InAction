package finale;
public class ExamQuestionNotCompletedException extends RuntimeException {
	public ExamQuestionNotCompletedException() {
		super("Please remove this line of code and implement the exam question!");
	}
}
