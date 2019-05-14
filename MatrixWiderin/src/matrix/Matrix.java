package matrix;

public class Matrix implements Ifunction{
	public float[][] mat;
	int r;
	int c;

	public Matrix(int r, int c) {
		mat = new float[r][c];
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
	public void sigmoidFunc() throws BadMatrix{
		try {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				mat[i][j]=(float) (1/(Math.exp(-mat[i][j])+1));
			}
		}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new BadMatrix();
		}
	}
	public void skalarMult(float s) throws BadMatrix{
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

	public static Matrix skalarMult(float s, Matrix m) throws BadMatrix {
		Matrix copy = m.copy();
		copy.skalarMult(s);
		return copy;
	}

	public static float[][] vertMult(float[] v, Matrix m) throws LengthMismatch, BadMatrix {
		Matrix end=m.copy();
		if(v.length!=m.c) {
			throw new LengthMismatch();
		}
		try {
		for (int i = 0; i < m.r; i++) {
			for (int j = 0; j < m.c; j++) {
				end.mat[i][j] = m.mat[i][j] * v[i];
			}
		}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new BadMatrix();
		}
		return end.mat;
	}

	public static float[] horizonMult(float[] v, Matrix m) throws LengthMismatch, BadMatrix {
		float[] nv=new float[v.length];
		if(v.length!=m.r) {
			throw new LengthMismatch();
		}
		try {
		for(int i=0;i<m.r;i++) {
			float zw=0;
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
	public static float[] vertMult(Matrix m, float[] v) throws LengthMismatch, BadMatrix {
		float[] nv=new float[v.length];
		if(v.length!=m.c) {
			throw new LengthMismatch();
		}
		try {
		for(int i=0;i<m.r;i++) {
			float zw=0;
			for(int j=0;j<m.c;j++) {
				zw+=m.mat[i][j]*v[j];
			}
			nv[i]=zw;
		}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new BadMatrix();
		}
		return nv;
	}
	public static float[][] horizonMult(Matrix m, float[] v) throws LengthMismatch, BadMatrix {
		Matrix end=m.copy();
		if(v.length!=m.r) {
			throw new LengthMismatch();
		}
		try {
		for (int i = 0; i < m.r; i++) {
			for (int j = 0; j < m.c; j++) {
				end.mat[i][j] = m.mat[i][j] * v[j];
			}
		}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new BadMatrix();
		}
		return end.mat;
	}
	public static Matrix matMult(Matrix m, Matrix n)throws BadMatrix{
		Matrix e;
		if(m.r<=n.r && m.c>=n.c) {
			e= new Matrix(m.r,n.c);
			try {
			for(int i=0;i<m.r;i++){
				float zw=0;
				for(int j=0;j<n.c;j++){
					for(int k=0;k<n.r;k++) {
						zw+=m.mat[i][k]*n.mat[k][j];
					}
					e.mat[i][j]=zw;
				}
			}
			}
			catch(ArrayIndexOutOfBoundsException k) {
				throw new BadMatrix();
			}
		}
		else if(m.r>=n.r && m.c<=n.c) {
			e= new Matrix(n.r,m.c);
			try {
				for(int i=0;i<n.r;i++){
					float zw=0;
					for(int j=0;j<m.c;j++){
						for(int k=0;k<m.r;k++) {
							zw+=n.mat[i][k]*m.mat[k][j];
						}
						e.mat[i][j]=zw;
					}
				}
				}
				catch(ArrayIndexOutOfBoundsException k) {
					throw new BadMatrix();
				}
		}
		else {
			throw new BadMatrix();
		}
		
		return e;
	}
	public static Matrix addMat(Matrix m, Matrix n){
		Matrix e= new Matrix(m.r,m.c);
		for(int i=0;i<m.r;i++){
			for(int j=0;j<m.c;j++){
				e.mat[i][j]=m.mat[i][j]+n.mat[i][j];
			}
		}
		return e;
	}

	@Override
	public boolean equals(Matrix m) {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(mat[i][j]!=m.mat[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
