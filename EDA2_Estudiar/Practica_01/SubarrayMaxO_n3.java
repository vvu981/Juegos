package Practica_01;
import java.util.ArrayList;
import java.util.List;
public class SubarrayMaxO_n3 {

	public static String maxSubarray(int[] array) {

		int A = array.length;
		int sum = 0;
		int maxSum = 0;
		int indiceInf = 0, indiceSup = 0, currentStart = 0;
		String cadena = "";
		for (int i = 0; i < A; i++) {
			sum+=array[i];
			
			if (sum < 0) {
				sum = 0;
				 currentStart = i +1;
			} else if (sum > maxSum) {
				maxSum = sum;
				indiceInf = currentStart;
				indiceSup = i;
			}
			
			
		}
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
