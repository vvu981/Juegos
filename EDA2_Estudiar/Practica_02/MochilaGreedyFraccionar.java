package Practica_02;

import java.util.Arrays;
import java.util.Comparator;

public class MochilaGreedyFraccionar {

	private static double getMaxValue(double[] valor, double[] peso, double capacidad) {
		int tam = valor.length;
		double[] ratio = new double[valor.length];
		for (int i = 0; i < tam; i++) {
			ratio[i] = valor[i] / peso[i];
		}

		Integer[] indices = new Integer[tam];
		for (int i = 0; i < indices.length; i++) {
			indices[i] = i;
		}

		Arrays.sort(indices, new Comparator<Integer>() {

			public int compare(Integer i1, Integer i2) {
				if (ratio[i1] < ratio[i2])
					return 1;
				else if (ratio[i1] > ratio[i2])
					return -1;
				else
					return 0;
			}
		});

		double fraccionable = 0;
		double valorMochila = 0;
		double[] pesoMochila = new double[tam];
		for (int i = 0; i < tam; i++) {
			pesoMochila[i] = 0;
		}
		int j = 0;
		for (int i : indices) {

			if (capacidad - peso[i] >= 0) {
				capacidad -= peso[i];
				pesoMochila[j] = peso[i];
				valorMochila += valor[i];
				j++;
			} else {
				fraccionable = capacidad / peso[i];
				capacidad-=peso[i]*fraccionable;
				valorMochila += valor[i]*fraccionable;
				pesoMochila[j] = peso[i]*fraccionable;
				j++;
			}
		}

		/*
		 * for (int i = 0; i<binarioEntra.length; i++) { System.out.print(peso[i] +
		 * " = " + binarioEntra[i] + ", "); } System.out.println();
		 * System.out.print("Pesos de los elementos incluidos en la mochila: "); for (j
		 * = 0; j < pesoMochila.length; j++) System.out.print(pesoMochila[j] + ", ");
		 * 
		 * System.out.println(); System.out.println("Valor total de la mochila: " +
		 * valorMochila); return valorMochila;
		 * 
		 */
		return 0;
	}

	public static void main(String[] args) {
		double[] peso = { 3, 45, 5, 25, 35, 25, 2, 2 };
		double[] valor = { 8, 450, 20, 350, 400, 70, 5, 5 };
		double capacidad = 104;

		getMaxValue(valor, peso, capacidad);

	}
}
