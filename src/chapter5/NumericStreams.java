package chapter5;
import java.util.stream.*;

import chapter4.Dish;

import java.util.*;
import static chapter4.Dish.menu;;
public class NumericStreams{
    public static void main(String...args){
        List<Integer> numbers = Arrays.asList(3,4,5,1,2);
        Arrays.stream(numbers.toArray()).forEach(System.out::println);
        int calories = menu.stream()
                           .mapToInt(Dish::getCalories)
                           .sum();
        System.out.println("Number of calories:" + calories);
        // max and OptionalInt
        OptionalInt maxCalories = menu.stream()                                                      
                                      .mapToInt(Dish::getCalories)
                                      .max();
        int max;
        if(maxCalories.isPresent()){
            max = maxCalories.getAsInt();
        }
        else {
            // we can choose a default value
            max = 1;
        }
        System.out.println("Max Calories "+max);
        // numeric ranges
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                                                             .filter(n -> n % 2 == 0);
        System.out.println("Even Numbers "+evenNumbers.count());
      /*  Stream<int[]> pythagoreanTriples =
               IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a -> IntStream.rangeClosed(a, 100)
                                               .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0).boxed()
                                               .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));  */     
        Stream<double[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed().flatMap(a -> IntStream.rangeClosed(a, 100).mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})).filter(t-> t[2] % 1 == 0);  

        pythagoreanTriples.limit(4).forEach(t -> System.out.println((int)t[0] + ", " +(int) t[1] + ", " +(int) t[2])); 
    }
     /*  public static boolean isPerfectSquare(int n){
        return Math.sqrt(n) % 1 == 0;
    }*/

}
