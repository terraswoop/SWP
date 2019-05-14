package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import matrix.BadMatrix;
import matrix.LengthMismatch;
import matrix.Matrix;

public class MatrixTest {

	@Test
	public void skalarTest() throws BadMatrix {
		Matrix m=new Matrix(2,4);
		for(int i=0;i<2;i++) {
			for(int j=1;j<=4;j++) {
				m.mat[i][j-1]=(float)j;
			}
		}
		m.skalarMult(5);
		Matrix n=new Matrix(2,4);
		for(int i=0;i<2;i++) {
			for(int j=1;j<=4;j++) {
				n.mat[i][j-1]=(float)j*5;
			}
		}
		for(int i=0;i<2;i++) {
			for(int j=1;j<=3;j++) {
				assertEquals(m.mat[i][j],n.mat[i][j],0.000001);
			}
		}
	}
	@Test
	public void vertMultTest() throws LengthMismatch, BadMatrix {
		Matrix m=new Matrix(2,2);
		float[] v= {1,2};
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				m.mat[i][j]=j+1;
			}
		}
		float[][] mat= {{1,2},{2,4}};
		Matrix n=new Matrix(2,2);
		n.mat=mat;
		m.mat=Matrix.vertMult(v, m);
		assertEquals(true,n.equals(m));
	}
	@Test
	public void sigmoidTest() throws BadMatrix {
		Matrix m=new Matrix(2,4);
		for(int i=0;i<2;i++) {
			for(int j=1;j<=4;j++) {
				m.mat[i][j-1]=(float)j;
			}
		}
		m.mat[1][3]=(float) 1000;
		m.sigmoidFunc();
		assertEquals(m.mat[1][3],1,0.1);
	}
	

}
