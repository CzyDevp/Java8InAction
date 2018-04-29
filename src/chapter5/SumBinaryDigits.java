package chapter5;
import java.util.stream.IntStream;
public class SumBinaryDigits {
	public static void main(String[] args)
	{
		int input  = Integer.parseInt(args[0]);
		int sum = IntStream.rangeClosed(0,input).filter(n->{
			while(n!=0){
				if (n%10>1) {
					return false;
				}
				n=n/10;
			}
		     return true;
		}).sum();
		System.out.println("Binary Digits Sum: "+sum);
		
	}

}
