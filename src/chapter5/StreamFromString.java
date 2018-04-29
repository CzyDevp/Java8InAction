package chapter5;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.print.DocFlavor.STRING;
public class StreamFromString {
public static void main(String[] args){
	String name = "Nav nav is nav NAV is is nav IS iS";
	List<String> elements = Arrays.asList(name.split(" "));
/*	Set<String> S1 = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
	for(String s1 : elements)
	{
		S1.add(s1);
	}
	S1.stream().forEach(System.out::println);*/
	Set<String> S11=elements.stream().collect(Collectors.toCollection(()->new TreeSet<>(String.CASE_INSENSITIVE_ORDER)));
	S11.stream().forEach(System.out::println);
	/*System.out.println("Print with Streams");
	List<String>aList =  elements.stream().flatMap(e->elements.stream().filter(c->{
			if(c.equalsIgnoreCase(e))
				//if(c.)
				return false;
			else
				return true;
			})).collect(Collectors.toList());
		System.out.println(aList);*/
    //number1.stream().flatMap(i->number2.stream().filter(j->(i+j)%3==0).map(j->new int[]{i,j})).collect(toList());
	Map<String, Long> collect = elements.stream().map(String::toLowerCase).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	  collect.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
	  Stream<String> stream = Stream.generate(() -> "test").limit(10);
      stream.forEach(System.out::println);
     // Stream<Integer> stream1 = Stream.of(new int[]{1,2,3,4});
      int a=10;
      Runnable runnable = ()->System.out.println(a);
      runnable.run();
      List<Integer>squares = Arrays.asList(1,2,3,4);
      squares.stream().map(i->i*i).forEach(System.out::println);
      
}
}
