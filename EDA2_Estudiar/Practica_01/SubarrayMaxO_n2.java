package Practica_01;

public class SubarrayMaxO_n2 {

	

	public static String maxSubarray(int[] array) {

		int A = array.length;
		int sum = 0;
		int maxSum = 0;
		int indiceInf = 0, indiceSup = 0;
		String cadena = "";
		
		for (int i = 0; i < A; i++) {
			sum = array[i];
			for (int j = i+1; j < A; j++) {
				sum+=array[j];
				if (sum > maxSum) {
					maxSum = sum;
					indiceInf = i;
					indiceSup = j;
				}
			}
		}
		
		//mostrar
		for (int i = indiceInf; i <= indiceSup; i++) {
			cadena+=array[i] + ", ";
		}
		
		return cadena;
	}
	
	
	
	
	
	public static void main(String[] args) {
		int[] A = { 29, -7, 14, 31, 1, -47, 30, 7, -39, 23, -20, -36, -41, 27, 15, -34, 48, 35, -46, -16, 32, 18, 5,
				-33, 27, -28, -22, 12, 11, -42, 13 };	
		System.out.println(maxSubarray(A));
	}
	
}
