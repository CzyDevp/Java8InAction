package Chapter2;
public class Chapter2
{
	public final int value = 4;
	public void doIt()
	{
		int value = 6;
		System.out.println(this.value);
		Runnable r = new Runnable(){
			public final int value = 5;
			public void run(){
				int value = 10;
				System.out.println(value);
				System.out.println("Object's value : "+this.value);
			}
		};
		r.run(); 
	}
	public static void main(String...args)
	{       
		Chapter2 m = new Chapter2();
		m.doIt(); // ???   
	}
}
