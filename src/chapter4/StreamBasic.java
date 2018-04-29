package chapter4;
import java.util.*;
import java.util.stream.*;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static chapter4.Dish.menu;
public class StreamBasic {
    public static void main(String...args){
        // Java 7
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);
        System.out.println("---");
        // Java 8
        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);
       List<Dish> meat2Dishes = menu.stream().filter((Dish d)->d.getType().equals(Dish.Type.MEAT)).limit(2).collect(Collectors.toList());
       System.out.println("MeatDishes are "+ meat2Dishes);
       List<Integer> number = Arrays.asList(1,2,3,4,5);
       System.out.println("Square of numbers : ");
       number.stream().mapToInt(n->n*n).forEach(System.out::print);;
       String string = "Hello word Hello";
       List<String> s1List=Arrays.asList(string);
       List<String[]>diStrings = s1List.stream().map(d->d.split(" ")).collect(toList());
       List<String>dStrings = s1List.stream().map(d->d.split(" ")).flatMap(Arrays::stream).collect(toList());
       dStrings.stream().forEach(System.out::println);
       System.out.println("\nSize of List  is : "+diStrings.size());
        for(String[] s1:diStrings) {
        	System.out.println(s1.length);
        	Stream<String> s11 = Arrays.stream(s1);
        	List<String>s12 = s11.distinct().collect(toList());
           	System.out.println(s12);
        }
        //pairing
        List<Integer>number1 = Arrays.asList(1,2,3);
        List<Integer>number2 = Arrays.asList(3,4);
        List<int[]> pairs = number1.stream().flatMap(i->number2.stream().filter(j->(i+j)%3==0).map(j->new int[]{i,j})).collect(toList());
        //System.out.println("Size is "+pairs.size());
        System.out.println("Number of Pairs: ");
        for(int[] a:pairs){
        for(int i=0;i<a.length;i++){
        	 System.out.print(a[i]);
         }
         System.out.println();
        }
        
        //task3 Reducing
        
        
    }
    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes){
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for(Dish d: dishes){
            if(d.getCalories() < 400){
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish d1, Dish d2){
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for(Dish d: lowCaloricDishes){
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }
    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes){
        return dishes.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }
}
