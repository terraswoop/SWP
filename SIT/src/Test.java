import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Test {

	public static void main(String[] args) throws IOException {
		System.out.println(Singleton.getInstance());
		System.out.println(Singleton.getInstance());
	/*	PrintWriter writer;
		try {
			writer=new PrintWriter(new FileWriter("the-file-name.txt",true));
			writer.println("The first Line");
			writer.close();
		} catch(FileNotFoundException| UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/
		Logger.setLogLvl(lvl.INFO);
		Logger.debug("AYY");
		//Logger.set("Batuhan.txt");
		//Logger.log("Hallo");
		
	}

}
