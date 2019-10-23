import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

public class Logger {
	private static Logger loginst;
	static PrintWriter writer;
	private static int loglvl=0;
	private static int loggedlvl=0;
	private Logger() throws IOException {
		writer = new PrintWriter(new FileWriter("the-file-name.txt", true));
	}
	private Logger(String path) throws IOException {
		writer =new PrintWriter(new FileWriter(path, true));
	}
	public static void log() throws IOException {
		if (loginst == null) {
			loginst = new Logger();
		}
		writer.println(LocalTime.now() + " | Eingeloggt");
		writer.flush();
	}

	public static void log(String msg) throws IOException {
		if (loginst == null) {
			loginst = new Logger();
		}
		writer.println(LocalTime.now() + " | " + msg);
		writer.flush();
	}

	public static void set(String path) throws IOException {
		if (writer != null) {
			writer.close();
		}
		loginst= new Logger(path);
	}
	public static void error(String msg) throws IOException {
		if(loggedlvl!=1) {
			set("error.txt");
			loggedlvl=1;
		}
		log(msg);
	}
	public static void warning(String msg) throws IOException {
		if(loglvl>=2) {
			if(loggedlvl!=2) {
				set("warning.txt");
				loggedlvl=2;
			}
			log(msg);
		}
	}
	public static void info(String msg) throws IOException {
		if(loglvl>=3) {
			if(loggedlvl!=3) {
				set("info.txt");
				loggedlvl=3;
			}
			log(msg);
		}
	}
	public static void debug(String msg) throws IOException {
		if(loglvl==4) {
			if(loggedlvl!=4) {
				set("debug.txt");
				loggedlvl=4;
			}
			log(msg);
		}
	}
	public static void setLogLvl(lvl l) {
		if(l==lvl.ERROR) {
			loglvl=1;
		}
		else if(l==lvl.WARNING) {
			loglvl=2;
		}
		else if(l==lvl.INFO) {
			loglvl=3;
		}
		else if(l==lvl.DEBUG) {
			loglvl=4;
		}
	}
	@Override
	protected void finalize() throws Throwable {
		
		writer.close();
		super.finalize();
	}
}
