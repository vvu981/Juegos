package Practica_03;

import java.io.IOException;
import java.util.Scanner;


public class Dijkstra2 {

	static int Infinito = Integer.MAX_VALUE/2;
	
	public static int minDistance(int[] distancia, Boolean[] pasados) {
		int min = Integer.MAX_VALUE, min_index = -1;
		for (int v = 0; v < distancia.length; v++) {
			if (pasados[v] == false && distancia[v] <= min) {
				min = distancia[v];
				min_index = v;
				System.out.println("Entra: " + v);
			}
		}
		
		return min_index;
	}
	
	public static void printSolution(int[] distancia, int[] source) {
		System.out.println("Vertice\t\tDistancia desde source\t\tSource");
		for (int i = 0; i < distancia.length; i++) {
			if (distancia[i] < 0) {
				System.out.println("El grafo tiene ciclos negativos");
				break;
			} else {
				System.out.println(i + "\t\t" + distancia[i] + "\t\t" + source[i]);
			}
		}
		
	}
	
	public static void dijkstra(int[][] grafo, int inicio) {
		
		int tamGrafo = grafo.length;
		Boolean[] pasados = new Boolean[tamGrafo];
		int[] distancia = new int[tamGrafo];
		int[] source = new int[tamGrafo];
		for (int i = 0; i < tamGrafo; i++) {
			if (grafo[inicio][i] != 0)
				distancia[i] = grafo[inicio][i];
			else
				distancia[i] = Integer.MAX_VALUE;

			pasados[i] = false;
			if (grafo[inicio][i] != 0)
				source[i] = inicio;
			else
				source[i] = -1;
		}
		
		pasados[inicio] = true;
		source[inicio] = inicio;
		distancia[inicio] = 0;
		
		for (int cont = 0; cont < tamGrafo-1; cont++) {
			int u = minDistance(distancia, pasados);
			pasados[u] = true;
			
			for (int v = 0; v < tamGrafo; v++) {
				if (!pasados[v] && grafo[u][v] != 0 && grafo[u][v] + distancia[u] < distancia[v] && distancia[u] != Integer.MAX_VALUE) {
					distancia[v] = grafo[u][v] + distancia[u];
					source[v] = u;
				}
			}
		}
		
		printSolution(source, distancia);
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
