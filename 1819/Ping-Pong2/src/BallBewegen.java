/*
 * @author Roshy Moongathottathil & Sebastian Pilz 
 */
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

/*
 * lässt den Ball bewegen
 */
public class BallBewegen implements Serializable{
	Timer move;
	public static long diff;
	public void finish() {
		try {
			FileOutputStream fileOut=new FileOutputStream("test.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(BallKollision.n);
			out.writeLong(diff);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	public BallBewegen(){
		move = new Timer();
		move.scheduleAtFixedRate(new TimerTask(){
			public void run(){
				
				if(Var.moveupsp1 || Var.movedownsp1 || Var.moveupsp2 || Var.movedownsp2||Var.run ){
					if (Var.cnt % (long) Var.ballm == 0)
					{
						Var.ballx += Var.balldirx;
						Var.bally += Var.balldiry;
					}
				Var.cnt++;		
				Var.run = true;
				}
				if(Var.player1points == 7){
					Var.run = false;
					diff=System.currentTimeMillis()-Main.start;
					finish();
				}
				if(Var.player2points == 7){
					Var.run = false;
				}
			}
		},0, 1);
	}

}
