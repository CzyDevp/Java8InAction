package chapter3;
import java.io.*;
import java.net.URL;
import java.util.stream.Collectors;
public class ExecuteAround {
 static File f=null;
	public static void main(String ...args) throws IOException{
		URL path = ExecuteAround.class.getResource("data.txt");
	    f = new File(path.getFile());
		// method we want to refactor to make more flexible
        String result = processFileLimited();
        System.out.println("First lne is " + result);
        System.out.println("----------------------");
		String oneLine = processFile((BufferedReader b) -> b.readLine());
		System.out.println(oneLine);
		String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
		System.out.println(twoLines);
		//numberOflines
		System.out.println("Number of lines");
		String numLines = processFile((BufferedReader b)-> {
			long lines = b.lines().count();
			return Long.toString(lines);
		});
		System.out.println(numLines);
	}
    public static String processFileLimited() throws IOException {
        try (BufferedReader br =  new BufferedReader(new FileReader(f))) {
            return br.readLine();
        }
    }
	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(f))){
			return p.process(br);
		}
	}
	public interface BufferedReaderProcessor{
		public String process(BufferedReader b) throws IOException;
	}
}
