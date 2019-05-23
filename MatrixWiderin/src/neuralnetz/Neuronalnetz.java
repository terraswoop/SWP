package neuralnetz;

import java.util.ArrayList;

import matrix.BadMatrix;
import matrix.LengthMismatch;
import matrix.Matrix;

public class Neuronalnetz {
	public float[] inputn;
	ArrayList<float[]> hln=new ArrayList<float[]>();
	ArrayList<Matrix> weights=new ArrayList<Matrix>();
	ArrayList<float[]> biases = new ArrayList<float[]>();
	public float[] outputn;
	public Neuronalnetz(float[] inputn, ArrayList<float[]> hln, ArrayList<Matrix> weights, ArrayList<float[]> biases, float[] outputn) {
		this.inputn=inputn;
		this.hln=hln;
		this.weights=weights;
		this.biases=biases;
		this.outputn=outputn;
	}
	public Neuronalnetz(int in, int[] hl, int ou) {
		inputn=new float[in];
		outputn=new float[ou];
		int lb=in;
		for(int i=0;i<hl.length;i++) {
			Matrix m=new Matrix(hl[i],lb);
			for(int j=0;j<hl[i];j++) {
				for(int k=0;k<lb;k++) {
					m.mat[j][k]=(float)Math.random()*2000-1000;
					weights.add(m);
				}
			}
			lb=hl[i];
			float[] b=new float[lb];
			for(int j=0;j<lb;j++) {
				b[j]=(float)Math.random()*500-250;
			}
			biases.add(b);
		}
		Matrix m=new Matrix(ou,lb);
		for(int j=0;j<ou;j++) {
			for(int k=0;k<lb;k++) {
				m.mat[j][k]=(float)Math.random()*2000-1000;
				weights.add(m);
			}
		}
	}
	public void randomIn(float[] in) {
		for(int i=0;i<in.length;i++) {
			in[i]=(float) Math.random()*1000-500;
		}
	}
	public void cycle() throws LengthMismatch, BadMatrix {
		float[] prev=inputn;
		for(int i=0;i<weights.size()-1;i++) {
			System.out.println(weights.get(i).c);
			System.out.println(prev.length);
			float[] temphln=Matrix.vertMult(weights.get(i), prev);
			for(int j=0;j<temphln.length;j++) {
				
				temphln[j]=Matrix.sigmoidFunc((float)(temphln[j]+biases.get(i)[j]));
			}
			hln.add(temphln);
			prev=temphln;
		}
		float[] temphln=Matrix.vertMult(weights.get(weights.size()-1), prev);
		for(int i=0;i<temphln.length;i++) {
			temphln[i]=Matrix.sigmoidFunc((float)(temphln[i]));
		}
		outputn=temphln;
		
	}
	public Neuronalnetz paaren(Neuronalnetz n) {
		ArrayList<Matrix> weightsneu=new ArrayList<Matrix>();
		ArrayList<float[]> biasesneu = new ArrayList<float[]>();
		for(int i=0;i<weights.size();i++) {
			Matrix mn=new Matrix(weights.get(i).mat.length,weights.get(i).mat[0].length);
			for(int j=0;j<weights.get(i).mat.length;j++) {
				
				for(int k=0;k<weights.get(i).mat[j].length;k++) {
					if(j%2!=0) {
						mn.mat[j][k]=this.weights.get(i).mat[j][k];
					}
					else {
						mn.mat[j][k]=n.weights.get(i).mat[j][k];
					}
				}
			}
			weightsneu.add(mn);
		}	
		for(int i=0;i<biases.size();i++) {
			float[] nb=new float[biases.get(i).length];
			for(int j=0;j<biases.get(i).length;j++) {
				if(j%2!=0) {
					nb[j]=this.biases.get(i)[j];
				}
				else {
					nb[j]=n.biases.get(i)[j];
				}
			}
			biasesneu.add(nb);
		}
		return new Neuronalnetz(new float[this.inputn.length],new ArrayList<float[]>(),weightsneu,biasesneu,new float[this.outputn.length]);
	}
	public static void main(String[] args) throws LengthMismatch, BadMatrix {
		int[] a= {5,4,3};
		Neuronalnetz n=new Neuronalnetz(10,a,3);
		n.randomIn(n.inputn);
		n.cycle();
		for(int i=0;i<n.outputn.length;i++) {
			System.out.printf(" %f;", n.outputn[i]);
		}

	}

}
