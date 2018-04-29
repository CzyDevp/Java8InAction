//package Chapter1.Test;
//
//import static org.hamcrest.CoreMatchers.*;
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//import java.util.Arrays;
//import java.util.List;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import Chapter1.FilteringApples;
//import Chapter1.FilteringApples.Apple;
//class FilteringApplesTest {
//	java.util.List<FilteringApples.Apple> greenApplesActual=null;
//	java.util.List<FilteringApples.Apple> greenApplesExpected= null,heavyApplesActual=null;
//	FilteringApples.Apple apple1 =null , apple2=null;
//	@BeforeEach
//	void setUp() throws Exception {
//		apple1=new 	FilteringApples.Apple(90,"green");
//		apple2=new 	FilteringApples.Apple(190,"Red");
//		
//		greenApplesActual=Arrays.asList(new Apple(80, "green"),
//				 new Apple(160, "Red"),new Apple(180, "green"),
//				 new Apple(140, "Red"),new Apple(110, "green"),new Apple(160, "green"));
//		//Green Apples Expected
//		greenApplesExpected=Arrays.asList(new Apple(80, "green"),
//				                          new Apple(180, "green"),new Apple(110, "green"),new Apple(160, "green"));
//		//Heavy Apples Actual 
//		heavyApplesActual=Arrays.asList(new Apple(180, "green"),
//				new Apple(160, "Red"), new Apple(160, "green"));
//	}
//	@Test
//	void testObject()
//	{
//		//assertSame(apple1, apple2,"notsame");
//		//assertEquals(apple1, apple2);
//		List<Integer>numbers = Arrays.asList(1,2,3);
//		List<Integer>numbers1 = Arrays.asList(1,2,3);
//		  String str = "calligraphy";
//	        String start = "call";
//	        String end = "phy";
//	        assertThat(str, allOf(startsWith(start), endsWith(end)));
//	        assertThat("no present",numbers,hasItem(3));
//	        assertThat(numbers, hasSize(3));
//	        assertThat(numbers,is(equalTo(numbers1)));
//	        //assertThat(numbers, everyItem(greaterThan(1)));
//	}
//	@Test
//	void testFilterGreenApples() {
//		assertEquals(greenApplesExpected,FilteringApples.filterGreenApples(greenApplesActual));
//		
//		//fail("Not yet implemented");
//	}
//	@Test
//	void testFilterHeavyApples() {
//		assertEquals(heavyApplesActual,FilteringApples.filterHeavyApples(greenApplesActual));	
//		//fail("Not yet implemented");
//	}
//
//	@Test
//	void testIsGreenApple() {
//		 assertAll("Green apple",
//				 ()->assertTrue(FilteringApples.isGreenApple(apple1)),
//		          ()->assertFalse(FilteringApples.isGreenApple(apple2)));
//		//fail("Not yet implemented");
//	}
//	@Test
//	void testIsHeavyApple() {
//		 assertTrue(FilteringApples.isHeavyApple(apple2));
//		 assertFalse(FilteringApples.isHeavyApple(apple1));
//		//fail("Not yet implemented");
//	}
//	@Test
//	void testFilterApples() {
//		assertEquals(heavyApplesActual,FilteringApples.filterApples(greenApplesActual, (Apple a )-> a.getWeight()>150));
//		//fail("Not yet implemented");
//	}
//}
