package Chapter2;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.imageio.ImageTypeSpecifier;

import Chapter1.FilteringApples.Apple;
public class FilteringApples{
	public static void main(String ... args){
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(195, "red"), new Apple(155, "green"), new Apple(120, "red"));	
		Function<Apple, String> format = a->a.getWeight().toString();
		Function<Apple, String> heavyOrNot = a->{
			Predicate<Apple> aPredicate = (Apple a1)->a1.getWeight()>150;
			String heavy="";
			if (aPredicate.test(a)) {
				heavy = a.getColor()+ " "+a.getWeight()+" is heavy";
			}
			else {
				heavy=a.getColor()+ " "+a.getWeight()+" No heavy";
			}		
			return heavy;
			};
			String heavy = prettyPrintApple(inventory,heavyOrNot);
			System.out.println("Apple is here "+ heavy);
		String onlyWieght = prettyPrintApple(inventory,format );
		System.out.println("All weights here "+ onlyWieght);
		//prettyPrintApple(inventory,(Apple a)->{System.out.println(a.getWeight());} );
		//prettyPrintApple(inventory, (Apple a)->a.getColor().equals("red"));
		List<Apple> greenApples = filterApplesByColor(inventory, "green");
		System.out.println("GreenApples List\n"+ greenApples);
		// [Apple{color='red', weight=120}]
		List<Apple> redApples = filterApplesByColor(inventory, "red");
		System.out.println("RedApples List\n"+redApples);
		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		List<Apple> greenApples2 = filter(inventory, new AppleColorPredicate());
		System.out.println("GreenApples List\n"+greenApples2);
		// [Apple{color='green', wei//ght=155}]
		List<Apple> heavyApples = filter(inventory, new AppleWeightPredicate());
		System.out.println("HeavyApples List\n"+heavyApples);
		// []
		List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
		System.out.println("Red$HeavyApples List\n"+redAndHeavyApples);
		// [Apple{color='red', weight=120}]
				List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
			public boolean test(Apple a){
				return a.getColor().equals("red"); 
			}
			});
		System.out.println("RedApples\n"+redApples2);
	}
	public static List<Apple> filterGreenApples(List<Apple> inventory){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory){
			if("green".equals(apple.getColor())){
				result.add(apple);
			}
		}
		return result;
	}
	public static List<Apple> filterApplesByColor(List<Apple> inventory, String color){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory){
			if(apple.getColor().equals(color)){
				result.add(apple);
			}
		}
		return result;
	}
	public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory){
			if(apple.getWeight() > weight){
				result.add(apple);
			}
		}
		return result;
	}


	public static List<Apple> filter(List<Apple> inventory, ApplePredicate p){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory){
			if(p.test(apple)){
				result.add(apple);
			}
		}
		return result;
	}
	
	public static String prettyPrintApple(List<Apple> apples,Function<Apple, String> format)
	{
		String result="";
		for (Apple a:apples) {
			 result+=format.apply(a)+" ";			
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
	}

	interface ApplePredicate{
		public boolean test(Apple a);
	}
	
    
static class AppleWeightPredicate implements ApplePredicate{
		public boolean test(Apple apple){
			return apple.getWeight() > 150; 
		}
	}
	static class AppleColorPredicate implements ApplePredicate{
		public boolean test(Apple apple){
			return "green".equals(apple.getColor());
		}
	}

	static class AppleRedAndHeavyPredicate implements ApplePredicate{
		public boolean test(Apple apple){
			return "red".equals(apple.getColor()) 
					&& apple.getWeight() > 150; 
		}
	}
}