/*
 * @author Roshy Moongathottathil & Sebastian Pilz 
 */
import java.awt.EventQueue;
/*
 * Lässt das Spiel laufen
 */
public class Main {
	public static long start;
	public static void main(String[] args) {
		
		new GUI();
		new Var();
		new Bewegen();
		new BallBewegen();
		new BallKollision();
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					GUI gui = new GUI();
					gui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
