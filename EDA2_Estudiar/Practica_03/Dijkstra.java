package Practica_03;

import java.io.IOException;
import java.util.Scanner;

public class Dijkstra {
	static int Infinito = Integer.MAX_VALUE / 2;

	public static int minDistance(int[] distancia, Boolean[] sptSet) {
		int min = Integer.MAX_VALUE, min_index = -1;

		
		for (int i = 0; i < distancia.length; i++) {
			if (!sptSet[i] && distancia[i] <= min) {
				min = distancia[i];
				min_index = i;
			}
		}
		
		return min_index;
	}

	public static void dijkstra(int[][] grafo, int inicio) {

		int A = grafo.length;
		int[] distancia = new int[A];
		Boolean[] pasados = new Boolean[A];
		int[] source = new int[A];
		
		for (int i = 0; i < A; i++) {
				if (grafo[inicio][i] != Infinito) {
					distancia[i] = grafo[inicio][i];
					
				} else {
					distancia[i] = Infinito;
					source[i] = -1;
				}
				pasados[i] = false;
		}
		distancia[inicio] = 0;
		pasados[inicio] = true;
		source[inicio] = inicio;
		
		for (int i = 0; i < A - 1; i++) {
			int u = minDistance(distancia, pasados);
			pasados[u] = true;
			
			for (int v = 0; v < A; v++) {
				if (distancia[u] != Infinito && grafo[u][v] != 0 && distancia[u] + grafo[u][v] < distancia[v]) {
					distancia[v] = distancia[u] + grafo[u][v];
					source[v] = u;
				}
			}
		}
		
		printSolution(distancia, source);

		
	}

	public static void printSolution(int distancia[], int S[]) {
		System.out.println("Vertex \t\t Distance from Source \t\t S");
		for (int i = 0; i < distancia.length; i++)
			if (distancia[i] < 0) {
				System.out.println("Ejecucion detenida, el grafo contiene ciclos negativos");
				break;
			} else
				System.out.println(i + " \t\t " + distancia[i] + " \t\t\t\t " + S[i]);
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escriba el vertice inicio");
		int inicio = entrada.nextInt();
		int graph[][] = { { Infinito, 3, 1, Infinito, Infinito, Infinito, Infinito },
				{ 3, Infinito, Infinito, 2, Infinito, 3, Infinito }, { 1, Infinito, Infinito, 4, 2, Infinito, 4 },
				{ Infinito, 2, 4, Infinito, Infinito, Infinito, Infinito },
				{ Infinito, Infinito, 2, Infinito, Infinito, 3, Infinito },
				{ Infinito, 3, Infinito, Infinito, 3, Infinito, 2 },
				{ Infinito, Infinito, 4, Infinito, Infinito, 2, Infinito } };
		dijkstra(graph, inicio);
		entrada.close();
	}

}
