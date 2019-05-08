package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import matrix.BadMatrix;
import matrix.Matrix;

public class MatrixTest {

	@Test
	public void skalarTest() throws BadMatrix {
		Matrix m=new Matrix(2,4);
		for(int i=0;i<2;i++) {
			for(int j=1;j<=4;j++) {
				m.mat[i][j-1]=j;
			}
		}
		m.skalarMult(5);
		Matrix n=new Matrix(2,4);
		for(int i=0;i<2;i++) {
			for(int j=1;j<=4;j++) {
				n.mat[i][j-1]=j*5;
			}
		}
		for(int i=0;i<2;i++) {
			for(int j=1;j<=3;j++) {
				assertEquals(m.mat[i][j],n.mat[i][j]);
			}
		}
	}

}
