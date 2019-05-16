package neuralnetz;

import java.util.ArrayList;

import matrix.Matrix;

public class Neuronalnetz {
	public float[] inputn;
	ArrayList<Matrix> weights=new ArrayList<Matrix>();
	ArrayList<float[]> biases = new ArrayList<float[]>();
	public float[] outputn;
	public Neuronalnetz(int in, int[] hl, int ou) {
		inputn=new float[in];
		outputn=new float[ou];
		int lb=in;
		for(int i=0;i<hl.length;i++) {
			Matrix m=new Matrix(hl[i],lb);
			for(int j=0;j<hl[i];j++) {
				for(int k=0;k<lb;k++) {
					m.mat[j][k]=(float)Math.random()*2000-1000;
				}
			}
			lb=hl[i];
			float[] b=new float[lb];
			for(int j=0;j<lb;j++) {
				b[j]=(float)Math.random()*500-250;
			}
			biases.set(i,b);
		}
		Matrix m=new Matrix(ou,lb);
		for(int j=0;j<ou;j++) {
			for(int k=0;k<lb;k++) {
				m.mat[j][k]=(float)Math.random()*2000-1000;
			}
		}
	}
	public void randomIn(float[] in) {
		for(int i=0;i<in.length;i++) {
			in[i]=(float) Math.random()*1000-500;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
