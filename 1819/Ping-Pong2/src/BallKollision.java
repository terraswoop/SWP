/*
 * @author Roshy Moongathottathil & Sebastian Pilz 
 */
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

import matrix.BadMatrix;
import matrix.LengthMismatch;
import neuralnetz.Neuronalnetz;
/*
 * kümmert sich darum das bei kollision der Ball zurückgeworfen wird
 */
public class BallKollision implements Serializable{
	Timer kollision;
	static float[] a={Var.bally,Var.ballx};
	static int[] b={10,10,10};
	public static Neuronalnetz n=new Neuronalnetz(a,b,2,4,4);
	public BallKollision() {
		kollision = new Timer();
		kollision.scheduleAtFixedRate(new TimerTask(){
			public void run(){
				if(System.currentTimeMillis()%10==0) {
				a[0]=Var.bally-Var.screenheight/2; a[1]=Var.ballx-Var.screenwidth/2;
				n.inputn=a;
				try {
					n.cycle();
				} catch (LengthMismatch e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BadMatrix e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(n.outputn[0]+", "+n.outputn[1]);
					if(n.outputn[0]>0.5 && n.outputn[0]>n.outputn[1]) {
						Var.moveupsp2 = true;
						Var.movedownsp2 = false;
					}
					else if(n.outputn[1]>0.5 && n.outputn[1]>n.outputn[0]) {
						Var.movedownsp2 = true;
						Var.moveupsp2 = false;
					}
					else {
						Var.moveupsp2 = false;
						Var.movedownsp2 = false;
					}
				}
				if(Var.bally + 50 >= Var.screenheight){
					Var.balldiry = -1;
				}
				if(Var.bally <= 0){
					Var.balldiry = 1;
				}
				if(Var.ballx +20 >= Var.screenwidth){
					Var.ballx = Var.screenwidth/2 -10;
					Var.bally = Var.screenheight/2 -10;
					
					Var.balldirx = 1;
					Var.player1points += 1;
					Var.ballm = 8;
				}
				if(Var.ballx <= 0){
					Var.ballx = Var.screenwidth/2 -10;
					Var.bally = Var.screenheight/2 -10;
					
					Var.balldirx = -1;
					Var.player2points += 1;
					Var.ballm = 8;
				}
				if(Var.ballx < Var.xsp1 +25 && Var.ballx > Var.xsp1){
					Var.balldirx = 1;
					Var.ballm -=0.5;

					
				}
				if(Var.ballx < Var.xsp2  && Var.ballx > Var.xsp2 -20 && Var.bally -20 < Var.ysp2 +150 && Var.bally > Var.ysp2){
					Var.balldirx = -1;
					Var.ballm -= 0.5;
					
				}
				
				if (Var.ballm <= 1) {
					Var.ballm = 1;
				}
			}
		},0,4);
	}

}
