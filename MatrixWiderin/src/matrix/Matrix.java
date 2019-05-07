package matrix;

public class Matrix {
	public int[][] mat;
	int r;
	int c;

	public Matrix(int r, int c) {
		mat = new int[r][c];
		this.r = r;
		this.c = c;
	}

	public Matrix copy() {
		Matrix copy = new Matrix(this.r, this.c);
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				copy.mat[i][j] = this.mat[i][j];
			}
		}
		return copy;
	}

	public void skalarMult(int s) throws BadMatrix{
		try {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				mat[i][j] *= s;
			}
		}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new BadMatrix();
		}
	}

	public static Matrix skalarMult(int s, Matrix m) throws BadMatrix {
		Matrix copy = m.copy();
		copy.skalarMult(s);
		return copy;
	}

	public static int[] vertMult(int[] v, Matrix m) throws LengthMismatch, BadMatrix {
		int[] nv=new int[v.length];
		if(v.length!=m.c) {
			throw new LengthMismatch();
		}
		try {
		for (int i = 0; i < m.r; i++) {
			int zw = 0;
			for (int j = 0; j < m.c; j++) {
				zw += m.mat[i][j] * v[j];
			}
			nv[i] = zw;
		}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new BadMatrix();
		}
		return nv;
	}

	public static int[] horizonMult(int[] v, Matrix m) throws LengthMismatch, BadMatrix {
		int[] nv=new int[v.length];
		if(v.length!=m.r) {
			throw new LengthMismatch();
		}
		try {
		for(int i=0;i<m.r;i++) {
			int zw=0;
			for(int j=0;j<m.c;j++) {
				zw+=m.mat[j][i]*v[j];
			}
			nv[i]=zw;
		}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new BadMatrix();
		}
		return nv;
	}
}
