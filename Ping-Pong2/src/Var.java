/*
 * @author Roshy Moongathottathil & Sebastian Pilz 
 */
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
/*
 * Sammlung der Variablen die im Spiel benötigt werden
 */
public class Var {
	static long cnt =0;
	static JFrame jf1;
	static int screenwidth = 800;  //Breite des Fensters
	static int screenheight = 600;//Höhe des Fensters

	//Position von Spieler 1
	static int xsp1 = 20;
	static int ysp1 = 185;
	
	//Position von Spieler 2
	public static int xsp2 = 755;
	public static int ysp2 = 185;
	
	//Position vom Ball
	public static int ballx = 200;
	public static int bally = 200;
	
	//Boolwert der zeigt ob Spieler 1 nach oben oder nack unten geht
	static boolean moveupsp1 = false;
	static boolean movedownsp1 = false;
	
	//Boolwert der zeigt ob Spieler 1 nach oben oder nack unten geht
	static boolean moveupsp2 = false;
	static boolean movedownsp2 = false;

	static int balldirx = 1, balldiry = -1;
	
	//regellt die Geschwindigkeit des Balls
	static double ballm = 8;

	//Speichert die Punktezahl der Spielr
	static int player1points = 0;
	static int player2points = 0;
	
	static boolean abc;
	static boolean run = false;

	public Var() {
	}

}
