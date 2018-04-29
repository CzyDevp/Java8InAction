package Chapter1;
import java.util.*;
import java.util.function.Predicate;
public class FilteringApples{
	//static Logger logger = Logger.getLogger(FilteringApples.class);
    public static void main(String[] args){
         //************************************************google code challenge**********************************
    	  int[] sorted ={1,3,2,9,4,5};
       	  int min1= Arrays.stream(sorted).reduce(Integer.MAX_VALUE,Integer::min);
    	  int max1 = Arrays.stream(sorted).reduce(Integer.MIN_VALUE,Integer::max);
    	  System.out.println("Difference is "+(max1-min1));
    	  //**********************************************Google Code Challenge Done******************************
    	  
    	  List<Integer>nums = Arrays.asList(1,2,3,4);
    	  System.out.println(nums.stream().reduce(Integer::sum).orElse(14));
    	  System.out.println("Max is: "+nums.stream().max(Comparator.naturalOrder()).orElse(13));
    	  Optional<Integer> sum = nums.stream().reduce(Integer::max);
    	  boolean allEven = nums.stream().allMatch(e->e%2==0);
    	  boolean anyEven= nums.stream().anyMatch(e->e%2==0);
    	  System.out.println("Print 1st <10 : "+nums.stream().filter(e->e<10).findFirst().orElse(15));
    	  System.out.println("Print 1st >2 : "+nums.stream().filter(e->e>2).findAny().orElse(10));
    	  System.out.println("is any Even: "+anyEven);
    	  System.out.println("is all Even: "+allEven);
    	  int sum1 = nums.stream().mapToInt(e->e).sum();
    	  nums.stream().mapToInt(e->e).max().ifPresent(System.out::println);
    	  System.out.println("Sum is "+sum1);
    	  if(sum.isPresent()) {
    		 System.out.println(sum.get());
    	  }
    	  else {
    		 System.out.println("no sum");
    	  }
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                                              new Apple(155, "green"),
                                              new Apple(120, "red"),new Apple(123,"green"));	
        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(greenApples);
        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println(heavyApples);
        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples2);
        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println(heavyApples2);
        // []
        List<Apple> weirdApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80 || 
                                                          "brown".equals(a.getColor()));
        System.out.println(weirdApples); //gitcheck
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }
    public static List<Apple> filterHeavyApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }
    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor()); 
    }
    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }       

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
        }
        public Integer getWeight() {
            return weight;
        }
        public void setWeight(Integer weight) {
            this.weight = weight;
        }
       public String getColor() {
            return color;
        }
        public void setColor(String color) {
            this.color = color;
        }
        public String toString() {
            return "Apple{" +
                   "color='" + color + '\'' +
                   ", weight=" + weight +
                   '}';
        }
        @Override
        public boolean equals(Object o)
        {
     	   if(o instanceof Apple)
     	   {
     		 /*  if(((Apple) o).getColor().equals("green"))
     		   {
     			   return true;
     		   }*/
     	       if(((Apple) o).getColor().equals("green") && ((Apple) o).getWeight()>0)
 				{
 						return true;
 				}
     		   if(((Apple) o).getWeight()>150)
     		   {
     			   return true;
     		   }
     	   }
     	   
     	   return false;
        }
        @Override
        public int hashCode()
        {
     	   return 5; 
        }
	}
    
}