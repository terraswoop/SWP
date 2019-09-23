/*
 * @author Roshy Moongathottathil & Sebastian Pilz 
 */
import java.util.Timer;
import java.util.TimerTask;
/*
 * Ermöglicht das bewegen der Figuren
 */
public class Bewegen {
	Timer move;

	//kümmert sich darum das der vorgang wiederholt wird
	public Bewegen() {
		move = new Timer();
		move.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {

				//Wenn die variable auf true ist, wird die Figur bewegt
				if (Var.moveupsp1 == true) {
					if (Var.ysp1 >= 20) {
						Var.ysp1 -= 2;
					}
				} else if (Var.movedownsp1 == true) {
					if (Var.ysp1 <= Var.screenheight - 200) {
						Var.ysp1 += 2;
					}
				}

				if (Var.moveupsp2 == true) {
					if (Var.ysp2 >= 20) {
						Var.ysp2 -= 2;
					}
				} else if (Var.movedownsp2 == true) {
					if (Var.ysp2 <= Var.screenheight - 200) {
						Var.ysp2 += 2;
					}
				}

			}
		}, 0, 6);
	}
}
