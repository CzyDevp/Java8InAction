package chapter5;

import java.util.Scanner;
public class Fujistu {
static int input,sum=0;
public static void main(String[] args) {
	System.out.println("Enter UpperBound");
	Scanner scanner = new Scanner(System.in);
	input = scanner.nextInt();
	scanner.close();
          for(int i=0;i<=input;i++){
        	  checkNumber(i);
          }
	System.out.println("Sum of Binary Digits :"+sum);
}
public static boolean checkNumber(int input){
	int in;
     in = input;
		while(input>0){
			if(input%10>1){
				return false;
			}
			input=input/10;
		}
		if(input==0){
			//System.out.println(in);
			sum+=in;
		}
	return true;
}
}