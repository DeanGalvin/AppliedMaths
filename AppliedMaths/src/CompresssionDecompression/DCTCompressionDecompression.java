package CompresssionDecompression;

public class DCTCompressionDecompression {

	static int N = 8;
	static double[][] M = new double[][] {
		{16, 8, 23, 16, 5, 14, 7, 22 },
		{20, 14, 22, 7, 14, 22, 24, 6},
		{15, 23, 24, 23, 9, 6, 6, 20},
		{14, 8, 11, 14, 12, 12, 25, 12},
		{10, 9, 11, 9, 13, 19, 5, 17},
		{8, 22, 20, 15, 12, 8, 22, 17},
		{24, 22, 17, 12, 18, 11, 23, 14},
		{21, 25, 15, 16, 23, 14, 22, 22}
	};

	public static void main(String[] args) {
		Generate_T.Generate_T(); //Generate T and T'
		System.out.println("Matrix T: ");
		Generate_T.PrintMatrix(Generate_T.T);
		System.out.println();
		System.out.println("Matrix T': ");
		Generate_T.PrintMatrix(Generate_T.Tt);
		System.out.println();

		double[][] TM = MultiplyMatrix(Generate_T.T, M);
		System.out.println("TM Matrix: ");
		Generate_T.PrintMatrix(TM);
		System.out.println();

		double[][] DCT = MultiplyMatrix(TM, Generate_T.Tt);
		System.out.println("DCT Matrix: ");
		Generate_T.PrintMatrix(DCT);
		System.out.println();
	}

	public static double[][] MultiplyMatrix(double[][] A, double[][] B) {
		int aRows = A.length;
		int aColumns = A[0].length;
		int bRows = B.length;
		int bColumns = B[0].length;

		double[][] C = new double[aRows][bColumns];

		if (aColumns != bRows) {
			throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				C[r][c] = 0.0;
			}
		}

		for (int i = 0; i < aRows; i++) {
			for (int j = 0; j < bColumns; j++) {
				for (int k = 0; k < aColumns; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}

		return C;
	}
}
