package chapter3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ThreadSafeProblem {
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	private static String[] stringDates = { "21/12/2012", "10/10/2013", "23/02/2014" };
	public static void main(String[] args) throws ParseException {
     /*    String ans ="";
		  System.out.println("Enter String to ASCII reverse");
		  Scanner sc = new Scanner(System.in);
		  ans = sc.nextLine();
		  System.out.println("String to Reverse is "+ ans);
		  int[] ansRevArray = new int[ans.length()];
		  for(int i=0;i<ans.length();i++)
		  {
			  ansRevArray[i]=ans.charAt(i);
		  }
		  System.out.println("CharArray of String is : ");
		  String rev="";
		  for(int i=0;i<ans.length();i++)
		  {
			  while(ansRevArray[i]>0)
			  {
				  rev+=ansRevArray[i]%10;
				  ansRevArray[i]=ansRevArray[i]/10;
			  }
			  //System.out.print(ansRevArray[i]+" ");
		  }
		  System.out.println("Reverse numbes are "+rev);*/
		//************************************************************************************\\
		  //SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
	        //String dateInString = "7-Jun-2013";
		  //System.out.println("Date is : " +formatter.parse(dateInString));
		Thread t1 = new Thread(new MyThread(),"ok");
		Thread t2 = new Thread(new MyThread(),"ok2");
		Thread t3 = new Thread(new MyThread(),"ok3");
		t1.start();
		t2.start();
		t3.start();
	}

	private static class MyThread implements Runnable {

		@Override
		public void run() {
			//Date date = new Date();
			//sdf1 = new SimpleDateFormat("E");
			for (String strDate : stringDates) {
				try {
					System.out.println(sdf1.parse(strDate));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println();
			}
			//sdf1 = new SimpleDateFormat("dd/mm/yyyy");
		}

	}
	 
    //ThreadLocal1 td = new ThreadLocal1();
    // Two threads are created
  /*  Thread t1 = new Thread(td, "Thread-1");
   // Thread.sleep(new Random().nextInt(1000));
    Thread t2 = new Thread(td, "Thread-2");
     t2.start();
     Thread.sleep(new Random().nextInt(1000));
     t1.start();*/
	
	/*  try {
	Thread.sleep(1000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}*/
	
	
	/*	@Override
	public void run() {
		// TODO Auto-generated method stub
		//System.out.println("Thread Execution of "+  Thread.currentThread().getName());
		System.out.println("Thread Name= "+Thread.currentThread().getName()+" default Formatter = "+dateFormat.get().toPattern());
		 System.out.println("Formatted date is " + dateFormat.get().format(new Date()));
		 try {
	            Thread.sleep(new Random().nextInt(1000));
	        } 
		 catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		dateFormat.set(new SimpleDateFormat());
		  System.out.println(Thread.currentThread().getName()+ " Date formatter pattern is  "  + dateFormat.get().toPattern());
 System.out.println("Formatted date is " + dateFormat.get().format(new Date()));
	}*/
	
	
    
    
		     //new ThreadLocal<SimpleDateFormat>()
		    // {
/*	@Override
	protected SimpleDateFormat initialValue()
	{
		System.out.println("INtializing Simple format for -"+
	                       Thread.currentThread().getName());
	 return new SimpleDateFormat("dd/MM/yyyy");
	}
		     };*/
}