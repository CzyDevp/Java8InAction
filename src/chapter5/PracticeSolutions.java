package chapter5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class PracticeSolutions {
			 public static void main(String[] args) {
				 Trader raoul = new Trader("Raoul", "Cambridge");
			     Trader mario = new Trader("Mario","Milan");
			     Trader alan = new Trader("Alan","Cambridge");
			     Trader brian = new Trader("Brian","Cambridge");
					 List<Transaction> transactions = Arrays.asList(
																         new Transaction(brian, 2011, 300), 
																         new Transaction(raoul, 2012, 1000),
																         new Transaction(raoul, 2011, 400),
																         new Transaction(mario, 2012, 710),	
																         new Transaction(mario, 2012, 700),
																         new Transaction(brian, 2011, 200),
																         new Transaction(alan, 2012, 950));
			//task1
			List<Transaction> by2011year = transactions.stream()
					                                            .filter((Transaction t) -> t.getYear()==2011)
					                                            .sorted(Comparator.comparing(Transaction::getValue))
					                                            .collect(Collectors.toList());
			System.out.println("Task1-Transactions only for 2011 "+by2011year);
		    //===========================================================================================\\         

			//task2
		    List<String> uniqueCities = transactions.stream()
		    		                                         .map((Transaction t)->t.getTrader().getCity())
		    		                                         .distinct()
		    		                                         .collect(Collectors.toList());
		    System.out.println("Task2-Unique Cities "+uniqueCities);
			//===========================================================================================\\         

		    //task3
			List<String> cityCambridgeUsers = transactions.stream().
					                                                filter((Transaction t)->t.getTrader().getCity().equals("Cambridge"))
					                                                .map((Transaction t)->t.getTrader().getName())
					                                                .distinct()
					                                                .sorted()
					                                                .collect(Collectors.toList());
			System.out.println("Task3-Trades from city Cambridge "+cityCambridgeUsers);			
		    //===========================================================================================\\         

		   //task4
		   String allSortedNames = transactions.stream().map((Transaction t)->t.getTrader().getName()).distinct().sorted().reduce("",(n1,n2)->n1+" "+n2);
           System.out.println("Task4-All Sorted names are:"+allSortedNames);
		    //===========================================================================================\\         

           //task5  Are any traders based in Milan?
			List<Trader> milan = transactions.stream().
					                                   map(Transaction::getTrader)
					                                   .filter((Trader t)->t.getCity().equals("Milan"))
					                                   .distinct()
					                                   .collect(Collectors.toList());
		    System.out.println("Task5-Milano based Traders "+ milan);
			boolean milano = transactions.stream()
					                              .anyMatch((Transaction t)->t.getTrader().getCity().equals("Milan"));
			System.out.println("Is there anyone from Milan "+milano);
			//===========================================================================================\\         
       
			//task6 Print all transactions values from the traders living in Cambridge.
			List<Integer> ValueSource = transactions.stream().
					                                          filter((Transaction t)->t.getTrader().getCity().equals("Cambridge"))
					                                          .map((Transaction t)->t.getValue())
					                                          .collect(Collectors.toList());
		    System.out.println("Task6- Values based on Cambridge "+ValueSource);	
		    //===========================================================================================\\         

			//task7 What's the highest value of all the transactions?
		    Optional<Transaction> maxVlaue = transactions.stream()
		    		                                              .max(Comparator.comparing(Transaction::getValue));
		    System.out.println("Task7-Maximum Transaction Value is "+ maxVlaue.get().getValue());
			int highValue = transactions.stream().
					                              map(Transaction::getValue)
					                              .reduce(0,Integer::max);
		    System.out.println("Highest Value is "+highValue);
		    //===========================================================================================\\         

			//task8 Find the transaction with the smallest value.
			Optional<Transaction> minValue = transactions.stream().
					                                               min(Comparator.comparing(Transaction::getValue));
			System.out.println("Task8-Minimum Transaction Value is "+ minValue.get().getValue());
		    int lowestValue = transactions.stream()
		    		                               .mapToInt(Transaction::getValue)
		    		                               .reduce(Integer.MAX_VALUE, Integer::min);
		    System.out.println("Lowest Value is "+lowestValue);
		      Integer lowValue = transactions.stream().map((Transaction t)->t.getValue())
		    		                                  .reduce(Integer::min)
		    		                                  .get();
		             System.out.println("Vlaue is "+lowValue);
		    //===========================================================================================\\         
		    //task9 find lowerCase letters in name
		      String nameTrader  =transactions.stream()
		    		                                   .map(t->t.getTrader().getName())
		    		                                   .distinct()
		    		                                   .max(Comparator.comparingLong(o->o.chars()
		    		                                   .filter(Character::isLowerCase)
		    		                                   .count()))
		    		                                   .get();
		      System.out.println("Maximum number of lowerCase letters in Name: "+nameTrader);
		        /* List<String>names = transactions.stream().map((Transaction t)->t.getTrader().getName()).distinct().collect(Collectors.toList());
		             for(String n:names)
		    			{
		    	          System.out.println("LowerCase Letters in Name: "+n);
		                  long lower = n.chars().filter((x)->Character.isLowerCase(x)).count();
		                  System.out.println(lower);
		                }*/
			    //===========================================================================================\\         

               //Task10 Find the city String with the largest number of lowercase letters from all the cities in the transaction list. 
		      List<Transaction>t1=new ArrayList<>();
              Optional<String> citynames= Optional.ofNullable(t1.stream().map((Transaction t)->t.getTrader()
		    		                                       .getCity()).distinct().max(Comparator.comparingLong(ch->ch.chars()
		    	                                           .filter(Character::isLowerCase).count())).orElse("novalue"));
		     citynames.ifPresent(System.out::println);
              
              List<String>cityNames1 = transactions.stream().map((Transaction t)->t.getTrader().getCity()).distinct().collect(Collectors.toList());
		      long l1=0;
		      String city="";
		      for(String n:cityNames1)
		       {
		    	 if(l1>n.chars().filter(Character::isLowerCase).count()) {}
		    	 else{
		    	     l1 =n.chars().filter((x)->Character.isLowerCase(x)).count();
		    	     city=n;
		    	    }
		      }
		     System.out.println(city);
			 //===========================================================================================\\         

		     //Task #4: Generating Streams from Functions Fabonacci
		     Stream.iterate(new int[]{0, 1},p->new int[] {p[1],p[0]+p[1]}).limit(5).forEach(t -> System.out.println(t[1]));
	
			 }
}
		 
