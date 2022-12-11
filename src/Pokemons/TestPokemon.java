package Pokemons;

import java.text.DecimalFormat;
import java.util.*;

public class TestPokemon {

	public static void mostrarArrayPokemon(Pokemon[] pokemons) {

		for (int i = 0; i < pokemons.length; i++) {
			System.out.println(i + ". " + pokemons[i].nombre + " ");
		}

	}

	public static void mostrarAtaques(Ataque[] a, Pokemon p) {
		for (int b = 0; b < a.length; b++) {
			System.out.print(b + ". " + a[b].nombre + " (" + a[b].PP + ")");
		}

	}

	public static void verAtaques(Ataque[] a, int max) {
		for (int j = 0; j < max; j++) {
			System.out.println(j + ". " + a[j].nombre);
		}

	}

	public static Pokemon eligeRival(Pokemon[] p, int a) {
	
		int k = -1;
		while (k != a) {
			double rnd = Math.random() * 100;
			if (rnd < 17) {
				k = 0;
			} else if (rnd < 36) {
				k = 1;
			} else if (rnd < 54) {
				k = 2;

			} else if (rnd < 75) {
				k = 3;
			} else if (rnd < 87) {
				k = 4;
			} else {
				k = 5;
			}
			if (k!=a) break;
		}
		return p[k];

	}

	public static int coincideTipo(Ataque[] a, Pokemon p) {
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if ((a[i].tipo.equals(p.tipo1) || a[i].tipo.equals(p.tipo2))
					|| (a[i].nombre.equals("Terremoto") && p.nombre.equals("Snorlax"))) {
				j++;
			}

		}
		return j;
	}

	public static void iniciarJuego() {

		System.out.println("Combate: ");
		Scanner entrada = new Scanner(System.in);

		//
		//

		/*
		 * p = propio c = contrario Especie: 2 -> +0.5 at P 3 -> +0.5 def P 1 -> +0.5
		 * vel P -3 -> -0.33 def P -2 -> -0.33 at P -1 -> -0.33 vel P 5 -> -0.33 vel c 6
		 * -> -0.33 at c 7 -> -0.33 def c 4 -> +50%vida p 12 -> +1 at P 13 -> +1 def P
		 * 10 -> +1 vel P -12 -> -0.5 at P -13 -> -0.5 def P -10 -> -0.5 vel P -5 ->
		 * -0.5 vel c -6 -> -0.5 at c -7 -> -0.5 def c
		 */

		Ataque vacio = new Ataque("", 0, "", 0, 0, 0, 0, "", 0, 0, "Fisico", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		Ataque[] vacios = { new Ataque(vacio), new Ataque(vacio), new Ataque(vacio), new Ataque(vacio) };
		/*
		 * Ataques: nombre, poder, tipo, prioridad, precision, probCrit,
		 * probabCambioEstado, cambioEstado, probabCambioEstadistica, probRetr,
		 * tipoAtaque, cambAtFisicoP, cambAtEspecialP, cambDefFisicaP, cambDefEspecialP,
		 * cambVelP, cambAtFisicoR, cambAtEspecialR, cambDefFisicaR, cambDefEspecialR,
		 * cambVelR, cambPrecisionP, cambPrecisionR, PP
		 */
		// ataque normal
		Ataque Descanso = new Ataque("Descanso", 0, "Normal", 1, 100, 0, 100, "Dormir", 0, 0, "", 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 10);
		Ataque Ronquido = new Ataque("Ronquido", 50, "Normal", 1, 100, 5, 0, "", 0, 0, "Especial", 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 15);
		Ataque Bomba_huevo = new Ataque("Bomba_huevo", 100, "Normal", 1, 50, 5, 0, "", 0, 0, "Especial", 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 10);
		// ataque ditto

		// Ataques PokemonFuego
		Ataque Ascuas = new Ataque("Ascuas", 70, "Fuego", 1, 100, 5, 10, "Quemar", 0, 0, "Especial", 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 25);
		Ataque Llamarada = new Ataque("Llamarada", 85, "Fuego", 1, 85, 5, 30, "Quemar", 0, 0, "Especial", 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 5);
		Ataque A_Bocajarro = new Ataque("A bocajarro", 100, "Lucha", 1, 100, 5, 0, "", 0, 0, "Fisico", -1, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 5);
		Ataque Danza_Espada = new Ataque("Danza Espada", 0, "Normal", 1, 100, 0, 0, "", 100, 0, "", 2, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 20);

		// Ataques PokemonAgua
		Ataque Pistola_agua = new Ataque("Pistola agua", 72, "Agua", 1, 100, 5, 0, "", 0, 0, "Especial", 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 25);
		Ataque Hidrobomba = new Ataque("Hidrobomba", 80, "Agua", 1, 80, 5, 0, "", 0, 0, "Especial", 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 5);

		Ataque Aqua_jet = new Ataque("Aqua jet", 40, "Agua", 2, 100, 5, 0, "", 0, 0, "Fisico", 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 20);
		Ataque Hidrocanon = new Ataque("Hidrocañón", 150, "Agua", 1, 90, 5, 0, "", 0, 0, "Especial", 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 5);

		// Ataques PokemonPlanta
		Ataque Hoja_afilada = new Ataque("Hoja afilada", 55, "Planta", 1, 95, 35, 0, "", 0, 0, "Especial", 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 25);
		Ataque Tormenta_floral = new Ataque("Tormenta floral", 90, "Planta", 1, 100, 5, 0, "", 0, 0, "Especial", 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15);
		Ataque Sintesis = new Ataque("Sintesis", 0, "Planta", 1, 100, 0, 0, "", 0, 0, "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 5);

		Ataque Drenadoras = new Ataque("Drenadoras", 0, "Planta", 1, 90, 0, 0, "", 0, 0, "Especial", 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 10);

		// Ataques Veneno
		Ataque Toxico = new Ataque("Toxico", 0, "Veneno", 1, 85, 0, 100, "Envenenar", 0, 0, "Especial", 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 10);
		Ataque Picotazo_venenoso = new Ataque("Picotazo Venenoso", 15, "Veneno", 1, 100, 5, 30, "Envenenar", 0, 0,
				"Fisico", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 35);
		Ataque Lanza_mugre = new Ataque("Lanza mugre", 120, "Veneno", 1, 70, 5, 30, "Envenenar", 0, 0, "Especial", 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5);
		Ataque Polvo_Veneno = new Ataque("Polvo veneno", 0, "Veneno", 1, 75, 0, 100, "Envenenar", 0, 0, "Especial", 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 35);

		// Ataques Volador
		Ataque Respiro = new Ataque("Respiro", 0, "Volador", 1, 100, 0, 0, "", 0, 0, "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 10);
		Ataque Danza_pluma = new Ataque("Danza pluma", 0, "Volador", 1, 100, 0, 0, "", 100, 0, "", 0, 0, 0, 0, 0, -2, 0,
				0, 0, 0, 0, 0, 15);
		Ataque Aerochorro = new Ataque("Aerochorro", 180, "Volador", 1, 95, 12.5, 0, "", 0, 0, "", 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 5);
		Ataque Ala_bis = new Ataque("Ala bis", 80, "Volador", 1, 90, 5, 0, "", 0, 0, "Fisico", 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 10);
		// Ataques Siniestro
		Ataque Juego_sucio = new Ataque("Juego sucio", 95, "Siniestro", 1, 100, 5, 0, "", 0, 0, "Fisico", 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 100);
		Ataque Tajo_umbrio = new Ataque("Tajo umbrío", 75, "Siniestro", 1, 100, 5, 0, "", 0, 0, "Especial", 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 15);
		Ataque Pulso_noche = new Ataque("Pulso noche", 85, "Siniestro", 1, 95, 5, 0, "", 40, 0, "Especial", 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, -1, 10);
		Ataque Pulso_umbrio = new Ataque("Pulso umbrio", 80, "Siniestro", 1, 100, 5, 20, "", 0, 0, "Especial", 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 15);
		Ataque Mordisco = new Ataque("Mordisco", 90, "Siniestro", 1, 100, 5, 0, "", 0, 0, "Fisico", 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 25);
		// Ataques Hada

		// Ataque tierra
		Ataque Terremoto = new Ataque("Terremoto", 100, "Tierra", 1, 100, 5, 0, "", 0, 0, "Fisico", 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 10);

		// Array todos ataques
		Ataque[] todos = { new Ataque(Ascuas), new Ataque(Llamarada), new Ataque(A_Bocajarro), new Ataque(Danza_Espada),
				new Ataque(Pistola_agua), new Ataque(Hidrobomba), new Ataque(Mordisco), new Ataque(Aqua_jet),
				new Ataque(Hoja_afilada), new Ataque(Tormenta_floral), new Ataque(Sintesis), new Ataque(Polvo_Veneno),
				new Ataque(Toxico), new Ataque(Picotazo_venenoso), new Ataque(Lanza_mugre), new Ataque(Juego_sucio),
				new Ataque(Tajo_umbrio), new Ataque(Respiro), new Ataque(Danza_pluma), new Ataque(Aerochorro),
				new Ataque(Descanso), new Ataque(Ala_bis), new Ataque(Pulso_noche), new Ataque(Drenadoras),
				new Ataque(Pulso_umbrio), new Ataque(Ronquido), new Ataque(Bomba_huevo), new Ataque(Terremoto),
				new Ataque(Hidrocanon) };

		// vacios

		Ataque[] ataquesJugador = { new Ataque(vacio), new Ataque(vacio), new Ataque(vacio), new Ataque(vacio) };
		Ataque[] ataquesRival = { new Ataque(vacio), new Ataque(vacio), new Ataque(vacio), new Ataque(vacio) };

		Pokemon Jugador = new Pokemon("", "", "", 0, vacios, 0, 0, 0, 0, 0, "", 0);
		Pokemon Rival = new Pokemon("", "", "", 0, vacios, 0, 0, 0, 0, 0, "", 0);

		// Pokemons
		// Pokemon: nombre, tipo, vida, ataques[], ataqueF, ataqueEsp, defensaF,
		// defensaEsp, vel, estado
		Pokemon Charizard = new Pokemon("Charizard", "Fuego", "Volador", 385, vacios, 163, 165, 146, 150, 167, "Bien",
				0);
		Pokemon Blastoise = new Pokemon("Blastoise", "Agua", "", 386, vacios, 149, 155, 170, 165, 143, "Bien", 0);
		Pokemon Venasaur = new Pokemon("Venasaur", "Planta", "Veneno", 385, vacios, 155, 160, 165, 149, 176, "Bien", 0);
		Pokemon Zubat = new Pokemon("Zubat", "Veneno", "Volador", 347, vacios, 106, 90, 95, 101, 117, "Bien", 0);
		Pokemon Snorlax = new Pokemon("Snorlax", "Normal", "", 467, vacios, 178, 128, 128, 178, 90, "Bien", 0);
		Pokemon Rayquaza = new Pokemon("Rayquaza", "Dragon", "Volador", 412, vacios, 222, 222, 156, 156, 161, "Bien",
				0);
		Pokemon Chansey = new Pokemon("Chansey", "Normal", "", 557, vacios, 62, 95, 62, 172, 112, "Bien", 0);
		Pokemon[] pokemon = { new Pokemon(Charizard), new Pokemon(Blastoise), new Pokemon(Venasaur), new Pokemon(Zubat),
				new Pokemon(Snorlax), new Pokemon(Rayquaza), new Pokemon(Chansey) };

		mostrarArrayPokemon(pokemon);
		// leer que pokemon quiere el usuario
		int i;

		System.out.println("Elija con que pokemon quiere jugar:");
		i = entrada.nextInt();

		Jugador = pokemon[i];
		int max = coincideTipo(todos, Jugador);
		Ataque[] je = new Ataque[max];
		System.out.println("Ahora elija 4 de los ataques posibles:");
		int u = 0;
		for (int b = 0; b < todos.length; b++) {

			if (((todos[b].tipo.equals(Jugador.tipo1) || todos[b].tipo.equals(Jugador.tipo2))
					|| (todos[b].nombre.equals("Terremoto") && Jugador.nombre.equals("Snorlax")))) {
				je[u] = todos[b];
				u++;
			}
		}
		Rival = eligeRival(pokemon, i);

		verAtaques(je, max);
		/*
		 * for (int y = 0; y < je.length-1; y++) { System.out.println(y);
		 * System.out.println(y + ". " + je[y].nombre); } mostrarAtaques(je, Jugador);
		 */

		// seleccionar los ataques
		int ataque1 = entrada.nextInt();
		int ataque2 = entrada.nextInt();
		int ataque3 = entrada.nextInt();
		int ataque4 = entrada.nextInt();
		ataquesJugador[0] = je[ataque1];
		ataquesJugador[1] = je[ataque2];
		ataquesJugador[2] = je[ataque3];
		ataquesJugador[3] = je[ataque4];

		Jugador.setAtaques(ataquesJugador);
		int c = 0;
		Ataque[] nuevo = new Ataque[coincideTipo(todos, Rival)];
		for (int up = 0; up < todos.length; up++) {
			if (!todos[up].nombre.equals("Transformacion")) {
				if ((((todos[up].tipo.equals(Rival.tipo1) || todos[up].tipo.equals(Rival.tipo2)))
						|| (todos[up].nombre.equals("Terremoto") && (Rival.nombre.equals("Snorlax"))))) {
					nuevo[c] = todos[up];
					c++;
				}
			}
		}
		ataquesRival[0] = nuevo[0];
		ataquesRival[1] = nuevo[1];
		ataquesRival[2] = nuevo[2];
		ataquesRival[3] = nuevo[3];
		Rival.setAtaques(ataquesRival);

		// todos los ataques posibles

		double vidaTotal = Jugador.vida;
		double vida2 = Rival.vida;

		double est_AFInicial1 = Jugador.Est_ataque;
		double est_AEInicial1 = Jugador.Est_ataqueEspecial;
		double est_DFInicial1 = Jugador.Est_defensa;
		double est_DEInicial1 = Jugador.Est_defensaEspecial;
		double est_Vel1 = Jugador.velocidad;

		double est_AFInicial2 = Rival.Est_ataque;
		double est_AEInicial2 = Rival.Est_ataqueEspecial;
		double est_DFInicial2 = Rival.Est_defensa;
		double est_DEInicial2 = Rival.Est_defensaEspecial;
		double est_Vel2 = Rival.velocidad;
		System.out.println();
		String a = "¡El rival será " + Rival.nombre + "!";
		for (int h = 0; h < a.length() + 5; h++) {
			if (h != 0)
				System.out.print("-");
			else
				System.out.print(" ");
		}
		System.out.println();
		System.out.println(" | " + a + " |");
		for (int h = 0; h < a.length() + 5; h++) {
			if (h != 0)
				System.out.print("-");
			else
				System.out.print(" ");
		}
		System.out.println();
		System.out.println();
		int Num_ataque;
		int turno = 1;
		while (Jugador.vida > 0 && Rival.vida > 0) {
			System.out.println("Elija un ataque: ");
			mostrarAtaques(Jugador);
			Num_ataque = entrada.nextInt();
			System.out.println();
			System.out.println("---------------------------------------------------\n\t\t   Turno: " + turno
					+ "\n---------------------------------------------------");
			llamadaAtacar(Jugador, Rival, Jugador.ataques, Rival.ataques, Num_ataque, vidaTotal, vida2, est_AFInicial1,
					est_AEInicial1, est_DFInicial1, est_DEInicial1, est_Vel1, est_AEInicial2, est_AFInicial2,
					est_DFInicial2, est_DEInicial2, est_Vel2);

			System.out.println();
			if (Jugador.vida <= 0) {
				System.out.println(Jugador.nombre + " ha perdido");
			} else if (Rival.vida <= 0) {
				System.out.println(Rival.nombre + " ha perdido");
			}
			turno++;
		}

		entrada.close();

	}

	public static String est_Cambiada(double est_AFInicial1, double est_AEInicial1, double est_DFInicial1,
			double est_DEInicial1, double est_Vel1, Pokemon jugador) {

		String cambio = "";
		double calc = 0;
		DecimalFormat df = new DecimalFormat("#.00");
		df.format(calc);
		if (est_AFInicial1 != jugador.Est_ataque) {
			calc = jugador.Est_ataque / est_AFInicial1;
			cambio = "(x" + df.format(calc) + " At.) ";
		}
		if (est_AEInicial1 != jugador.Est_ataqueEspecial) {
			System.out.println("Holaaa");
			System.out.println(jugador.Est_ataque);
			System.out.println(est_AEInicial1);
			calc = jugador.Est_ataqueEspecial / est_AEInicial1;
			System.out.println(calc);
			cambio = "(x" + df.format(calc) + " At Esp.) ";
		}
		if (est_Vel1 != jugador.velocidad) {
			calc = jugador.velocidad / est_Vel1;
			cambio = "(x" + df.format(calc) + " Vel) ";
		}
		if (est_DFInicial1 != jugador.Est_defensa) {
			calc = jugador.Est_defensa / est_DFInicial1;
			cambio = "(x" + df.format(calc) + " Def.) ";
		}
		if (est_DEInicial1 != jugador.Est_defensaEspecial) {
			calc = jugador.Est_defensaEspecial / est_DEInicial1;
			cambio = "(x" + df.format(calc) + " Def. Esp.) ";
		}
		return cambio;

	}

	static int cambiado = 0;

	public static void llamadaAtacar(Pokemon jugador, Pokemon rival, Ataque[] atJug, Ataque[] atRiv, int numAtaque,
			double vidaTotal, double vida2, double est_AFInicial1, double est_AEInicial1, double est_DFInicial1,
			double est_DEInicial1, double est_Vel1, double est_AEInicial2, double est_AFInicial2, double est_DFInicial2,
			double est_DEInicial2, double est_Vel2) {

		/*
		 * Atacar(jugador, rival, jugador.ataques, numAtaque); double vidaB =
		 * rival.vida; double diferencia = vidaA - vidaB;
		 * System.out.println(rival.nombre + " ha perdido " + diferencia);
		 */
		DecimalFormat df = new DecimalFormat("#.00");

		double R = Math.random() * 100;
		int numAtaqueRival = (int) R;
		double vidaA = 0;
		double vidaB = 0;
		double diferencia = 0;
		int jk = 0;

		if (!rival.nombre.equals("Ditto")) {
			if (numAtaqueRival < 20) {
				jk = 0;
			} else if (numAtaqueRival < 40) {
				jk = 1;
			} else if (numAtaqueRival < 60) {
				jk = 2;

			} else {
				jk = 3;

			}
			System.out.println(rival.ataques[jk].nombre);
		} else
			jk = 0;

		if (jugador.estado.equals(Bien)) {
			js = 0.06;
		}
		if (rival.estado.equals(Bien)) {
			is = 0.06;
		}

		if (jugador.ataques[numAtaque].prioridad > rival.ataques[jk].prioridad) {
			System.out.println(jugador.ataques[numAtaque].nombre + " - Prioridad jugador: "
					+ jugador.ataques[numAtaque].prioridad);
			System.out.println(rival.ataques[jk].nombre + " - Prioridad rival: " + rival.ataques[jk].prioridad);
			System.out.println("Prioridad jugador > prioridad rival");

			if ((jugador.ataques[numAtaque].nombre.equals(Sintesis)
					|| jugador.ataques[numAtaque].nombre.equals("Respiro")) && jugador.vida < vidaTotal) { // ataca
																											// jugador
				// despues
				for (int h = 0; (h < vidaTotal / 2 && jugador.vida < vidaTotal); h++) {
					jugador.vida++;
				}
				System.out.println(jugador.nombre + " ha recuperado vida");

				String cadena1 = barraVida(jugador, vidaTotal);
				String cadena2 = barraVida(rival, vida2);
				String Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1, est_Vel1,
						jugador);
				String Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2, est_Vel2,
						rival);

				System.out.println(jugador.nombre + Est1);
				System.out.println(cadena1);
				System.out.println();
				System.out.println(rival.nombre + Est2);
				System.out.println(cadena2);
				System.out.println();
			} else if ((jugador.ataques[numAtaque].nombre.equals(Sintesis)
					|| jugador.ataques[numAtaque].nombre.equals("Respiro")) && jugador.vida >= vidaTotal) {
				System.out.println(jugador.nombre + " ya tiene la vida al máximo");
				String cadena1 = barraVida(jugador, vidaTotal);
				String cadena2 = barraVida(rival, vida2);
				String Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1, est_Vel1,
						jugador);
				String Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2, est_Vel2,
						rival);

				System.out.println(jugador.nombre + Est1);
				System.out.println(cadena1);
				System.out.println();
				System.out.println(rival.nombre + Est2);
				System.out.println(cadena2);
				System.out.println();
			} else {
				vidaA = rival.vida;
				Atacar(jugador, rival, jugador.ataques, numAtaque, vidaTotal);
				String cadena1 = barraVida(jugador, vidaTotal);
				String cadena2 = barraVida(rival, vida2);
				String Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1, est_Vel1,
						jugador);
				String Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2, est_Vel2,
						rival);
				System.out.println(jugador.nombre + Est1);
				System.out.println(cadena1);
				System.out.println();
				System.out.println(rival.nombre + Est2);
				System.out.println(cadena2);
				System.out.println();
				vidaB = rival.vida;
				diferencia = vidaA - vidaB;
			}
			if (rival.comprobarVivo()) {
				if (R > jugador.ataques[numAtaque].probRetr) {
					if ((rival.ataques[jk].nombre.equals(Sintesis) || rival.ataques[jk].nombre.equals("Respiro"))
							&& rival.vida < vida2) { // ataca rival por
						// prioridad
						for (int h = 0; (h < vida2 / 2 && rival.vida < vida2); h++) {
							rival.vida++;
						}
						System.out.println(rival.nombre + " ha recuperado vida");

						String cadena1 = barraVida(jugador, vidaTotal);
						String cadena2 = barraVida(rival, vida2);
						String Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1,
								est_Vel1, jugador);
						String Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2,
								est_Vel2, rival);
						System.out.println(jugador.nombre + Est1);
						System.out.println(cadena1);
						System.out.println();
						System.out.println(rival.nombre + Est2);
						System.out.println(cadena2);
						System.out.println();
					} else if ((rival.ataques[jk].nombre.equals(Sintesis) || rival.ataques[jk].nombre.equals("Respiro"))
							&& rival.vida >= vida2) {
						System.out.println(rival.nombre + " ya tiene la vida al máximo");
						String cadena1 = barraVida(jugador, vidaTotal);
						String cadena2 = barraVida(rival, vida2);
						String Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1,
								est_Vel1, jugador);
						String Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2,
								est_Vel2, rival);

						System.out.println(jugador.nombre + Est1);
						System.out.println(cadena1);
						System.out.println();
						System.out.println(rival.nombre + Est2);
						System.out.println(cadena2);
						System.out.println();
					} else {
						vidaA = jugador.vida;
						Atacar(rival, jugador, rival.ataques, jk, vida2);
						String cadena1 = barraVida(jugador, vidaTotal);
						String cadena2 = barraVida(rival, vida2);
						String Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1,
								est_Vel1, jugador);
						String Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2,
								est_Vel2, rival);
						System.out.println(jugador.nombre + Est1);
						System.out.println(cadena1);
						System.out.println();
						System.out.println(rival.nombre + Est2);
						System.out.println(cadena2);
						System.out.println();
						vidaB = jugador.vida;
						diferencia = vidaA - vidaB;
					}

				} else
					System.out.println(rival.nombre + " ha retrocedido");

				if (rival.estado.equals(Quemado)) {
					System.out.println("La quemadura le produjo daños");
					rival.vida -= rival.vida * 0.05;
					rival.setVida(rival.vida);

				} else if (rival.estado.equals(Envenenado)) {
					System.out.println("El envenenamiento le produjo daños");
					rival.vida -= rival.vida * is;
					rival.setVida(rival.vida);
					double j = is * 100;
					System.out
							.println(rival.nombre + " ha sido dañado un " + j + "% debido a que está " + rival.estado);
					is += 0.06;

				}

				if (jugador.estado.equals(Quemado)) {
					System.out.println("La quemadura le produjo daños");
					jugador.vida -= jugador.vida * 0.05;

				} else if (jugador.estado.equals(Envenenado)) {
					System.out.println("El envenenamiento le produjo daños");
					double j = js * 100;
					jugador.vida -= jugador.vida * js;
					jugador.setVida(jugador.vida);
					System.out.println(
							jugador.nombre + " ha sido dañado un " + j + "% debido a que está " + jugador.estado);
					js += 0.06;
				}
			} else
				System.out.println(rival.nombre + " ha muerto");

		} else if (jugador.ataques[numAtaque].prioridad < rival.ataques[jk].prioridad) {
			System.out.println("Prioridad rival > prioridad jugador");
			if ((rival.ataques[jk].nombre.equals(Sintesis) || rival.ataques[jk].nombre.equals("Respiro"))
					&& rival.vida < vida2) { // ataca rival por prioridad
				for (int h = 0; (h < vida2 / 2 && rival.vida < vida2); h++) {
					rival.vida++;
				}
				System.out.println(rival.nombre + " ha recuperado vida");

				String cadena1 = barraVida(jugador, vidaTotal);
				String cadena2 = barraVida(rival, vida2);
				String Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1, est_Vel1,
						jugador);
				String Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2, est_Vel2,
						rival);
				System.out.println(jugador.nombre + Est1);
				System.out.println(cadena1);
				System.out.println();
				System.out.println(rival.nombre + Est2);
				System.out.println(cadena2);
				System.out.println();
			} else if ((rival.ataques[jk].nombre.equals(Sintesis) || rival.ataques[jk].nombre.equals("Respiro"))
					&& rival.vida >= vida2) {
				System.out.println(rival.nombre + " ya tiene la vida al máximo");
				String cadena1 = barraVida(jugador, vidaTotal);
				String cadena2 = barraVida(rival, vida2);
				String Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1, est_Vel1,
						jugador);
				String Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2, est_Vel2,
						rival);

				System.out.println(jugador.nombre + Est1);
				System.out.println(cadena1);
				System.out.println();
				System.out.println(rival.nombre + Est2);
				System.out.println(cadena2);
				System.out.println();
			} else {
				vidaA = jugador.vida;
				Atacar(rival, jugador, rival.ataques, jk, vida2);
				String cadena1 = barraVida(jugador, vidaTotal);
				String cadena2 = barraVida(rival, vida2);
				String Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1, est_Vel1,
						jugador);
				String Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2, est_Vel2,
						rival);
				System.out.println(jugador.nombre + Est1);
				System.out.println(cadena1);
				System.out.println();
				System.out.println(rival.nombre + Est2);
				System.out.println(cadena2);
				System.out.println();
				vidaB = jugador.vida;
				diferencia = vidaA - vidaB;

				if (jugador.comprobarVivo()) {
					if (R > rival.ataques[jk].probRetr) {
						if ((jugador.ataques[numAtaque].nombre.equals(Sintesis)
								|| jugador.ataques[numAtaque].nombre.equals("Respiro")) && jugador.vida < vidaTotal) { // ataca
							// jugador
							// despues
							for (int h = 0; (h < vidaTotal / 2 && jugador.vida < vidaTotal); h++) {
								jugador.vida++;
							}
							System.out.println(jugador.nombre + " ha recuperado vida");

							cadena1 = barraVida(jugador, vidaTotal);
							cadena2 = barraVida(rival, vida2);
							Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1,
									est_Vel1, jugador);
							Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2,
									est_Vel2, rival);
							System.out.println(jugador.nombre + Est1);
							System.out.println(cadena1);
							System.out.println();
							System.out.println(rival.nombre + Est2);
							System.out.println(cadena2);
							System.out.println();
						} else if ((jugador.ataques[numAtaque].nombre.equals(Sintesis)
								|| jugador.ataques[numAtaque].nombre.equals("Respiro")) && jugador.vida >= vidaTotal) {
							System.out.println(jugador.nombre + " ya tiene la vida al máximo");
							cadena1 = barraVida(jugador, vidaTotal);
							cadena2 = barraVida(rival, vida2);
							Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1,
									est_Vel1, jugador);
							Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2,
									est_Vel2, rival);

							System.out.println(jugador.nombre + Est1);
							System.out.println(cadena1);
							System.out.println();
							System.out.println(rival.nombre + Est2);
							System.out.println(cadena2);
							System.out.println();
						} else {
							vidaA = rival.vida;
							Atacar(jugador, rival, jugador.ataques, numAtaque, vidaTotal);
							cadena1 = barraVida(jugador, vidaTotal);
							cadena2 = barraVida(rival, vida2);
							Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1,
									est_Vel1, jugador);
							Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2,
									est_Vel2, rival);
							System.out.println(jugador.nombre + Est1);
							System.out.println(cadena1);
							System.out.println();
							System.out.println(rival.nombre + Est2);
							System.out.println(cadena2);
							System.out.println();
							System.out.println("10");
							vidaB = rival.vida;
							diferencia = vidaA - vidaB;
						}
					} else
						System.out.println(jugador.nombre + " ha retrocedido");
					if (rival.estado.equals(Quemado)) {
						System.out.println("La quemadura le produjo daños");
						rival.vida -= rival.vida * 0.05;
						rival.setVida(rival.vida);

					} else if (rival.estado.equals(Envenenado)) {
						System.out.println("El envenenamiento le produjo daños");
						rival.vida -= rival.vida * is;
						rival.setVida(rival.vida);

						double j = is * 100;
						System.out.println(
								rival.nombre + " ha sido dañado un " + j + "% debido a que está " + rival.estado);
						is += 0.06;

					}

					if (jugador.estado.equals(Quemado)) {
						System.out.println("La quemadura le produjo daños");
						jugador.vida -= jugador.vida * 0.05;
						jugador.setVida(jugador.vida);

					} else if (jugador.estado.equals(Envenenado)) {
						System.out.println("El envenenamiento le produjo daños");
						double j = js * 100;
						jugador.setVida(jugador.vida);

						System.out.println(
								jugador.nombre + " ha sido dañado un " + j + "% debido a que está " + jugador.estado);
						js += 0.06;
					}
				} else
					System.out.println(jugador.nombre + " ha muerto");
			}

			System.out.println("Turno de " + jugador.nombre); // ha terminado de atacar el rival
			if (jugador.comprobarVivo()) {
				if (R > rival.ataques[jk].probRetr) {
					if ((jugador.ataques[numAtaque].nombre.equals(Sintesis)
							|| jugador.ataques[numAtaque].nombre.equals("Respiro")) && jugador.vida < vidaTotal) { // ataca
						// jugador
						// despues
						for (int h = 0; (h < vidaTotal / 2 && jugador.vida < vidaTotal); h++) {
							jugador.vida++;
						}
						System.out.println(jugador.nombre + " ha recuperado vida");

						String cadena1 = barraVida(jugador, vidaTotal);
						String cadena2 = barraVida(rival, vida2);
						String Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1,
								est_Vel1, jugador);
						String Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2,
								est_Vel2, rival);
						System.out.println(jugador.nombre + Est1);
						System.out.println(cadena1);
						System.out.println();
						System.out.println(rival.nombre + Est2);
						System.out.println(cadena2);
						System.out.println();
					} else if ((jugador.ataques[numAtaque].nombre.equals(Sintesis)
							|| jugador.ataques[numAtaque].nombre.equals("Respiro")) && jugador.vida >= vidaTotal) {
						System.out.println(jugador.nombre + " ya tiene la vida al máximo");
						String cadena1 = barraVida(jugador, vidaTotal);
						String cadena2 = barraVida(rival, vida2);
						String Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1,
								est_Vel1, jugador);
						String Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2,
								est_Vel2, rival);

						System.out.println(jugador.nombre + Est1);
						System.out.println(cadena1);
						System.out.println();
						System.out.println(rival.nombre + Est2);
						System.out.println(cadena2);
						System.out.println();
					} else {
						vidaA = rival.vida;
						Atacar(jugador, rival, jugador.ataques, numAtaque, vidaTotal);
						String cadena1 = barraVida(jugador, vidaTotal);
						String cadena2 = barraVida(rival, vida2);
						String Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1,
								est_Vel1, jugador);
						String Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2,
								est_Vel2, rival);
						System.out.println(jugador.nombre + Est1);
						System.out.println(cadena1);
						System.out.println();
						System.out.println(rival.nombre + Est2);
						System.out.println(cadena2);
						System.out.println();
						System.out.println("10");
						vidaB = rival.vida;
						diferencia = vidaA - vidaB;
					}
				} else
					System.out.println(jugador.nombre + " ha retrocedido2");
				if (rival.estado.equals(Quemado)) {
					System.out.println("La quemadura le produjo daños");
					rival.vida -= rival.vida * 0.05;
					rival.setVida(rival.vida);

				} else if (rival.estado.equals(Envenenado)) {
					System.out.println("El envenenamiento le produjo daños");
					rival.vida -= rival.vida * is;
					rival.setVida(rival.vida);

					double j = is * 100;
					System.out
							.println(rival.nombre + " ha sido dañado un " + j + "% debido a que está " + rival.estado);
					is += 0.06;

				}

				if (jugador.estado.equals(Quemado)) {
					System.out.println("La quemadura le produjo daños");
					jugador.vida -= jugador.vida * 0.05;
					jugador.setVida(jugador.vida);

				} else if (jugador.estado.equals(Envenenado)) {
					System.out.println("El envenenamiento le produjo daños");
					double j = js * 100;
					jugador.setVida(jugador.vida);

					System.out.println(
							jugador.nombre + " ha sido dañado un " + j + "% debido a que está " + jugador.estado);
					js += 0.06;
				}
			} else
				System.out.println(jugador.nombre + " ha muerto");
		} else {

			if (jugador.velocidad > rival.velocidad) {
				System.out.println("Velocidad jugador > rival");

				if ((jugador.ataques[numAtaque].nombre.equals(Sintesis)
						|| jugador.ataques[numAtaque].nombre.equals("Respiro")) && jugador.vida < vidaTotal) { // ataca
																												// jugador
					for (int h = 0; (h < vidaTotal / 2 && jugador.vida < vidaTotal); h++) {
						jugador.vida++;
					}
					System.out.println(jugador.nombre + " ha recuperado vida");

					String cadena1 = barraVida(jugador, vidaTotal);
					String cadena2 = barraVida(rival, vida2);
					String Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1, est_Vel1,
							jugador);
					String Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2, est_Vel2,
							rival);
					System.out.println(jugador.nombre + Est1);
					System.out.println(cadena1);
					System.out.println();
					System.out.println(rival.nombre + Est2);
					System.out.println(cadena2);
					System.out.println();

				} else if ((jugador.ataques[numAtaque].nombre.equals(Sintesis)
						|| jugador.ataques[numAtaque].nombre.equals("Respiro")) && jugador.vida >= vidaTotal) {
					System.out.println(jugador.nombre + " ya tiene la vida al máximo");
					String cadena1 = barraVida(jugador, vidaTotal);
					String cadena2 = barraVida(rival, vida2);
					String Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1, est_Vel1,
							jugador);
					String Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2, est_Vel2,
							rival);

					System.out.println(jugador.nombre + Est1);
					System.out.println(cadena1);
					System.out.println();
					System.out.println(rival.nombre + Est2);
					System.out.println(cadena2);
					System.out.println();
				} else {
					vidaA = rival.vida;
					Atacar(jugador, rival, jugador.ataques, numAtaque, vidaTotal);
					String cadena1 = barraVida(jugador, vidaTotal);
					String cadena2 = barraVida(rival, vida2);
					String Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1, est_Vel1,
							jugador);
					String Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2, est_Vel2,
							rival);
					System.out.println(jugador.nombre + Est1);
					System.out.println(cadena1);
					System.out.println();
					System.out.println(rival.nombre + Est2);
					System.out.println(cadena2);
					System.out.println();
					vidaB = rival.vida;
					diferencia = vidaA - vidaB;
				}
				if (rival.comprobarVivo()) {
					if (R > jugador.ataques[numAtaque].probRetr) {
						if ((rival.ataques[jk].nombre.equals(Sintesis) || rival.ataques[jk].nombre.equals("Respiro"))
								&& rival.vida < vida2) { // ataca rival
							System.out.println("ataca");
							for (int h = 0; (h < vida2 / 2 && rival.vida < vida2); h++) {
								rival.vida++;
							}
							System.out.println(rival.nombre + " ha recuperado vida");

							String cadena1 = barraVida(jugador, vidaTotal);
							String cadena2 = barraVida(rival, vida2);
							String Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1,
									est_Vel1, jugador);
							String Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2,
									est_Vel2, rival);
							System.out.println(jugador.nombre + Est1);
							System.out.println(cadena1);
							System.out.println();
							System.out.println(rival.nombre + Est2);
							System.out.println(cadena2);
							System.out.println();
						} else if ((rival.ataques[jk].nombre.equals(Sintesis)
								|| rival.ataques[jk].nombre.equals("Respiro")) && rival.vida >= vida2) {
							System.out.println(rival.nombre + " ya tiene la vida al máximo");
							String cadena1 = barraVida(jugador, vidaTotal);
							String cadena2 = barraVida(rival, vida2);
							String Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1,
									est_Vel1, jugador);
							String Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2,
									est_Vel2, rival);

							System.out.println(jugador.nombre + Est1);
							System.out.println(cadena1);
							System.out.println();
							System.out.println(rival.nombre + Est2);
							System.out.println(cadena2);
							System.out.println();
						} else {
							vidaA = jugador.vida;
							Atacar(rival, jugador, rival.ataques, jk, vida2);
							String cadena1 = barraVida(jugador, vidaTotal);
							String cadena2 = barraVida(rival, vida2);
							String Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1,
									est_Vel1, jugador);
							String Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2,
									est_Vel2, rival);
							System.out.println(jugador.nombre + Est1);
							System.out.println(cadena1);
							System.out.println();
							System.out.println(rival.nombre + Est2);
							System.out.println(cadena2);
							System.out.println();
							vidaB = jugador.vida;
							diferencia = vidaA - vidaB;
							System.out.println("4");

						}
					} else
						System.out.println(rival.nombre + " ha retrocedido3");
					if (rival.estado.equals(Quemado)) {
						System.out.println("La quemadura le produjo daños");
						rival.vida -= rival.vida * 0.05;
						rival.setVida(rival.vida);

					} else if (rival.estado.equals(Envenenado)) {
						System.out.println("El envenenamiento le produjo daños");
						rival.vida -= rival.vida * is;
						rival.setVida(rival.vida);

						double j = is * 100;
						System.out.println(
								rival.nombre + " ha sido dañado un " + j + "% debido a que está " + rival.estado);
						is += 0.06;

					}

					if (jugador.estado.equals(Quemado)) {
						System.out.println("La quemadura le produjo daños");
						jugador.vida -= jugador.vida * 0.05;
						jugador.setVida(jugador.vida);

					} else if (jugador.estado.equals(Envenenado)) {
						System.out.println("El envenenamiento le produjo daños");
						double j = js * 100;
						jugador.setVida(jugador.vida);

						System.out.println(
								jugador.nombre + " ha sido dañado un " + j + "% debido a que está " + jugador.estado);
						js += 0.06;
					}
				} else
					System.out.println(rival.nombre + " ha muerto");

			} else {
				System.out.println("velocidad rival > jugador");

				if ((rival.ataques[jk].nombre.equals(Sintesis) || rival.ataques[jk].nombre.equals("Respiro"))
						&& rival.vida < vida2) { // ataca rival
					for (int h = 0; (h < vida2 / 2 && rival.vida < vida2); h++) {
						rival.vida++;
					}
					System.out.println(rival.nombre + " ha recuperado vida");

					String cadena1 = barraVida(jugador, vidaTotal);
					String cadena2 = barraVida(rival, vida2);
					String Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1, est_Vel1,
							jugador);
					String Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2, est_Vel2,
							rival);
					System.out.println(jugador.nombre + Est1);
					System.out.println(cadena1);
					System.out.println();
					System.out.println(rival.nombre + Est2);
					System.out.println(cadena2);
					System.out.println();
				} else if ((rival.ataques[jk].nombre.equals(Sintesis) || rival.ataques[jk].nombre.equals("Respiro"))
						&& rival.vida >= vida2) {
					System.out.println(rival.nombre + " ya tiene la vida al máximo");
					String cadena1 = barraVida(jugador, vidaTotal);
					String cadena2 = barraVida(rival, vida2);
					String Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1, est_Vel1,
							jugador);
					String Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2, est_Vel2,
							rival);

					System.out.println(jugador.nombre + Est1);
					System.out.println(cadena1);
					System.out.println();
					System.out.println(rival.nombre + Est2);
					System.out.println(cadena2);
					System.out.println();
				} else {
					vidaA = jugador.vida;
					Atacar(rival, jugador, rival.ataques, jk, vida2);
					String cadena1 = barraVida(jugador, vidaTotal);
					String cadena2 = barraVida(rival, vida2);
					String Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1, est_Vel1,
							jugador);
					String Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2, est_Vel2,
							rival);
					System.out.println(jugador.nombre + Est1);
					System.out.println(cadena1);
					System.out.println();
					System.out.println(rival.nombre + Est2);
					System.out.println(cadena2);
					System.out.println();
					vidaB = jugador.vida;
					diferencia = vidaA - vidaB;
					System.out.println("8");

				}
				if (jugador.comprobarVivo()) {
					if (R > rival.ataques[jk].probRetr) {
						if ((jugador.ataques[numAtaque].nombre.equals(Sintesis)
								|| jugador.ataques[numAtaque].nombre.equals("Respiro")) && jugador.vida < vidaTotal) { // ataca
							// jugador
							for (int h = 0; (h < vidaTotal / 2 && jugador.vida < vidaTotal); h++) {
								jugador.vida++;
							}

							System.out.println(jugador.nombre + " ha recuperado vida");
							String cadena1 = barraVida(jugador, vidaTotal);
							String cadena2 = barraVida(rival, vida2);
							String Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1,
									est_Vel1, jugador);
							String Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2,
									est_Vel2, rival);
							System.out.println(jugador.nombre + Est1);
							System.out.println(cadena1);
							System.out.println();
							System.out.println(rival.nombre + Est2);
							System.out.println(cadena2);
							System.out.println();
						} else if ((jugador.ataques[numAtaque].nombre.equals(Sintesis)
								|| jugador.ataques[numAtaque].nombre.equals("Respiro")) && jugador.vida >= vidaTotal) {
							System.out.println(jugador.nombre + " ya tiene la vida al máximo");
							String cadena1 = barraVida(jugador, vidaTotal);
							String cadena2 = barraVida(rival, vida2);
							String Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1,
									est_Vel1, jugador);
							String Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2,
									est_Vel2, rival);

							System.out.println(jugador.nombre + Est1);
							System.out.println(cadena1);
							System.out.println();
							System.out.println(rival.nombre + Est2);
							System.out.println(cadena2);
							System.out.println();
						} else {
							vidaA = rival.vida;
							Atacar(jugador, rival, jugador.ataques, numAtaque, vidaTotal);

							String cadena1 = barraVida(jugador, vidaTotal);
							String cadena2 = barraVida(rival, vida2);
							String Est1 = est_Cambiada(est_AFInicial1, est_AEInicial1, est_DFInicial1, est_DEInicial1,
									est_Vel1, jugador);
							String Est2 = est_Cambiada(est_AFInicial2, est_AEInicial2, est_DFInicial2, est_DEInicial2,
									est_Vel2, rival);
							System.out.println(jugador.nombre + Est1);
							System.out.println(cadena1);
							System.out.println();
							System.out.println(rival.nombre + Est2);
							System.out.println(cadena2);
							System.out.println();
							vidaB = rival.vida;
							diferencia = vidaA - vidaB;
							System.out.println("7");

						}
					} else
						System.out.println(jugador.nombre + " ha retrocedido");
					if (rival.estado.equals(Quemado)) {
						System.out.println("La quemadura le produjo daños");
						rival.vida -= vida2 * 0.05;
						rival.setVida(rival.vida);

					} else if (rival.estado.equals(Envenenado)) {
						System.out.println("El envenenamiento le produjo daños");
						rival.vida -= vida2 * is;
						rival.setVida(rival.vida);

						double j = is * 100;
						System.out.println(
								rival.nombre + " ha sido dañado un " + j + "% debido a que está " + rival.estado);
						is += 0.06;

					}

					if (jugador.estado.equals(Quemado)) {
						System.out.println("La quemadura le produjo daños");
						jugador.vida -= vidaTotal * 0.05;
						jugador.setVida(jugador.vida);

					} else if (jugador.estado.equals(Envenenado)) {
						jugador.vida -= vidaTotal * js;
						System.out.println("El envenenamiento le produjo daños");
						jugador.setVida(jugador.vida);

						double j = js * 100;
						System.out.println(
								jugador.nombre + " ha sido dañado un " + j + "% debido a que está " + jugador.estado);
						js += 0.06;

					}
				} else
					System.out.println(jugador.nombre + " ha muerto");

			}

		}
		if (jugador.Drenadoras == 1) {
			double danoDrenadoras = vidaTotal * 0.06;
			jugador.vida -= danoDrenadoras;
			System.out.println(jugador.nombre + " ha perdido vida por las drenadoras");
			rival.vida += danoDrenadoras;
			System.out.println();
			if (rival.comprobarVivo())
				System.out.println(rival.nombre + " ha recuperado vida por las drenadoras");
		}

		if (rival.Drenadoras == 1) {
			double danoDrenadoras = vida2 * 0.06;
			rival.vida -= danoDrenadoras;
			System.out.println(rival.nombre + " ha perdido vida por las drenadoras");
			jugador.vida = danoDrenadoras;
			System.out.println();
			if (jugador.comprobarVivo())
				System.out.println(jugador.nombre + " ha recuperado vida por las drenadoras");
		}

	}

	static String Fisico = "Fisico";
	static String Especial = "Especial";

	// Tipos
	static String Fuego = "Fuego";
	static String Agua = "Agua";
	static String Planta = "Planta";
	static String Electrico = "Electrico";
	static String Acero = "Acero";
	static String Siniestro = "Siniestro";
	static String Dragon = "Dragon";
	static String Hielo = "Hielo";
	static String Volador = "Volador";
	static String Tierra = "Tierra";
	static String Roca = "Roca";
	static String Hada = "Hada";
	static String Bicho = "Bicho";
	static String Fantasma = "Fantasma";
	static String Lucha = "Lucha";
	static String Psiquico = "Psiquico";
	static String Veneno = "Veneno";
	static String Normal = "Normal";

	// Estados
	static String Bien = "Bien";
	static String Congelado = "Congelado";
	static String Envenenado = "Envenenado";
	static String Paralizado = "Paralizado";
	static String Dormido = "Dormido";
	static String Quemado = "Quemado";

	// Cambiar los estados
	String Curar = "Curar";
	String Congelar = "Congelar";
	String Envenenar = "Envenenar";
	String Paralizar = "Paralizar";
	String Dormir = "Dormir";
	String Quemar = "Quemar";

	static String Venasaur = "Venasaur";
	static String Sintesis = "Sintesis";

	public static void mostrarPokemons(Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3) {
		System.out.println("Los Pokemons son: " + pokemon1.nombre + ", " + pokemon2.nombre + ", " + pokemon3.nombre);

	}

	public static void mostrarAtaques(Pokemon pokemon) {
		for (int te = 0; te < 4; te++) {
			System.out.println(te + ". " + pokemon.ataques[te].nombre + " (" + pokemon.ataques[te].PP + " PP)");
		}
	}

	/*
	 * EfectTipo1: 2 si es *2 1 si es normal 0,5 si es poco efectivo 0 si no afecta
	 */
	public static double compareTipo1(Ataque ataque, Pokemon rival) {
		double Efectipo = 1;
		double mitad = 0.5;
		double doble = 2;
		if (ataque.tipo.equals(Acero) && rival.tipo1.equals(Acero)) { // Acero
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Acero) && rival.tipo1.equals(Agua)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Acero) && rival.tipo1.equals(Electrico)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Acero) && rival.tipo1.equals(Fuego)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Acero) && rival.tipo1.equals(Hada)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Acero) && rival.tipo1.equals(Hielo)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Acero) && rival.tipo1.equals(Roca)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Agua) && rival.tipo1.equals(Agua)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Agua) && rival.tipo1.equals(Dragon)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Agua) && rival.tipo1.equals(Fuego)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Agua) && rival.tipo1.equals(Planta)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Agua) && rival.tipo1.equals(Roca)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Agua) && rival.tipo1.equals(Fuego)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Bicho) && rival.tipo1.equals(Acero)) { // Bicho
			Efectipo = doble;
		} else if (ataque.tipo.equals(Bicho) && rival.tipo1.equals(Acero)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Bicho) && rival.tipo1.equals(Fantasma)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Bicho) && rival.tipo1.equals(Fuego)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Bicho) && rival.tipo1.equals(Hada)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Bicho) && rival.tipo1.equals(Lucha)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Bicho) && rival.tipo1.equals(Planta)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Bicho) && rival.tipo1.equals(Psiquico)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Bicho) && rival.tipo1.equals(Siniestro)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Bicho) && rival.tipo1.equals(Veneno)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Bicho) && rival.tipo1.equals(Volador)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Dragon) && rival.tipo1.equals(Acero)) { // Dragon
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Dragon) && rival.tipo1.equals(Dragon)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Dragon) && rival.tipo1.equals(Acero)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Dragon) && rival.tipo1.equals(Hada)) {
			Efectipo = 0;
		} else if (ataque.tipo.equals(Electrico) && rival.tipo1.equals(Agua)) { // Electrico
			Efectipo = doble;
		} else if (ataque.tipo.equals(Electrico) && rival.tipo1.equals(Dragon)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Electrico) && rival.tipo1.equals(Electrico)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Electrico) && rival.tipo1.equals(Planta)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Electrico) && rival.tipo1.equals(Tierra)) {
			Efectipo = 0;
		} else if (ataque.tipo.equals(Electrico) && rival.tipo1.equals(Volador)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Fantasma) && rival.tipo1.equals(Fantasma)) { // Fantasma
			Efectipo = doble;
		} else if (ataque.tipo.equals(Fantasma) && rival.tipo1.equals(Psiquico)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Fantasma) && rival.tipo1.equals(Siniestro)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Fuego) && rival.tipo1.equals(Agua)) { // Fuego
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Fuego) && rival.tipo1.equals(Acero)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Fuego) && rival.tipo1.equals(Bicho)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Fuego) && rival.tipo1.equals(Dragon)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Fuego) && rival.tipo1.equals(Fuego)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Fuego) && rival.tipo1.equals(Hielo)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Fuego) && rival.tipo1.equals(Planta)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Fuego) && rival.tipo1.equals(Roca)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Fuego) && rival.tipo1.equals(Tierra)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Hada) && rival.tipo1.equals(Acero)) { // Hada
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Hada) && rival.tipo1.equals(Dragon)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Hada) && rival.tipo1.equals(Fuego)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Hada) && rival.tipo1.equals(Lucha)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Hada) && rival.tipo1.equals(Siniestro)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Hada) && rival.tipo1.equals(Veneno)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Hielo) && rival.tipo1.equals(Acero)) { // Hielo
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Hielo) && rival.tipo1.equals(Agua)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Hielo) && rival.tipo1.equals(Dragon)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Hielo) && rival.tipo1.equals(Fuego)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Hielo) && rival.tipo1.equals(Hielo)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Hielo) && rival.tipo1.equals(Planta)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Hielo) && rival.tipo1.equals(Tierra)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Hielo) && rival.tipo1.equals(Volador)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Lucha) && rival.tipo1.equals(Acero)) { // Lucha
			Efectipo = doble;
		} else if (ataque.tipo.equals(Lucha) && rival.tipo1.equals(Bicho)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Lucha) && rival.tipo1.equals(Fantasma)) {
			Efectipo = 0;
		} else if (ataque.tipo.equals(Lucha) && rival.tipo1.equals(Hada)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Lucha) && rival.tipo1.equals(Hielo)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Lucha) && rival.tipo1.equals(Normal)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Lucha) && rival.tipo1.equals(Psiquico)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Lucha) && rival.tipo1.equals(Roca)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Lucha) && rival.tipo1.equals(Siniestro)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Lucha) && rival.tipo1.equals(Volador)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Lucha) && rival.tipo1.equals(Veneno)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Normal) && rival.tipo1.equals(Acero)) { // Normal
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Normal) && rival.tipo1.equals(Fantasma)) {
			Efectipo = 0;
		} else if (ataque.tipo.equals(Normal) && rival.tipo1.equals(Roca)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Planta) && rival.tipo1.equals(Acero)) { // Planta
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Planta) && rival.tipo1.equals(Agua)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Planta) && rival.tipo1.equals(Bicho)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Planta) && rival.tipo1.equals(Dragon)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Planta) && rival.tipo1.equals(Fuego)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Planta) && rival.tipo1.equals(Planta)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Planta) && rival.tipo1.equals(Roca)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Planta) && rival.tipo1.equals(Tierra)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Planta) && rival.tipo1.equals(Veneno)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Planta) && rival.tipo1.equals(Volador)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Psiquico) && rival.tipo1.equals(Acero)) { // Psiquico
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Psiquico) && rival.tipo1.equals(Lucha)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Psiquico) && rival.tipo1.equals(Psiquico)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Psiquico) && rival.tipo1.equals(Siniestro)) {
			Efectipo = 0;
		} else if (ataque.tipo.equals(Psiquico) && rival.tipo1.equals(Veneno)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Roca) && rival.tipo1.equals(Acero)) { // Roca
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Roca) && rival.tipo1.equals(Bicho)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Roca) && rival.tipo1.equals(Fuego)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Roca) && rival.tipo1.equals(Lucha)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Roca) && rival.tipo1.equals(Hielo)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Roca) && rival.tipo1.equals(Lucha)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Roca) && rival.tipo1.equals(Tierra)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Roca) && rival.tipo1.equals(Volador)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Siniestro) && rival.tipo1.equals(Hada)) { // Siniestro
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Siniestro) && rival.tipo1.equals(Fantasma)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Siniestro) && rival.tipo1.equals(Lucha)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Siniestro) && rival.tipo1.equals(Psiquico)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Siniestro) && rival.tipo1.equals(Siniestro)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Tierra) && rival.tipo1.equals(Acero)) { // Tierra
			Efectipo = doble;
		} else if (ataque.tipo.equals(Tierra) && rival.tipo1.equals(Bicho)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Tierra) && rival.tipo1.equals(Electrico)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Tierra) && rival.tipo1.equals(Fuego)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Tierra) && rival.tipo1.equals(Normal)) {
			Efectipo = 0;
		} else if (ataque.tipo.equals(Tierra) && (rival.tipo1.equals(Roca) || rival.tipo1.equals(Veneno))) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Tierra) && rival.tipo1.equals(Volador)) {
			Efectipo = 0;
		} else if (ataque.tipo.equals(Veneno) && (rival.tipo1.equals(Hada) || rival.tipo1.equals(Planta))) { // Veneno
			Efectipo = doble;
		} else if (ataque.tipo.equals(Veneno) && (rival.tipo1.equals(Fantasma) || rival.tipo1.equals(Roca)
				|| rival.tipo1.equals(Tierra) || rival.tipo1.equals(Veneno))) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Veneno) && rival.tipo1.equals(Acero)) {
			Efectipo = 0;
		} else if (ataque.tipo.equals(Volador) && rival.tipo1.equals(Acero)) { // Volador
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Volador) && rival.tipo1.equals(Bicho)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Volador) && rival.tipo1.equals(Electrico)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Volador) && rival.tipo1.equals(Lucha)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Volador) && rival.tipo1.equals(Planta)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Volador) && rival.tipo1.equals(Roca)) {
			Efectipo = mitad;
		}

		return Efectipo;
	}

	public static double compareTipo2(Ataque ataque, Pokemon rival) {
		double Efectipo = 1;
		double mitad = 0.5;
		double doble = 2;
		if (ataque.tipo.equals(Acero) && rival.tipo2.equals(Acero)) { // Acero
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Acero) && rival.tipo2.equals(Agua)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Acero) && rival.tipo2.equals(Electrico)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Acero) && rival.tipo2.equals(Fuego)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Acero) && rival.tipo2.equals(Hada)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Acero) && rival.tipo2.equals(Hielo)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Acero) && rival.tipo2.equals(Roca)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Agua) && rival.tipo2.equals(Agua)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Agua) && rival.tipo2.equals(Dragon)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Agua) && rival.tipo2.equals(Fuego)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Agua) && rival.tipo2.equals(Planta)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Agua) && rival.tipo2.equals(Roca)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Agua) && rival.tipo2.equals(Fuego)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Bicho) && rival.tipo2.equals(Acero)) { // Bicho
			Efectipo = doble;
		} else if (ataque.tipo.equals(Bicho) && rival.tipo2.equals(Acero)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Bicho) && rival.tipo2.equals(Fantasma)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Bicho) && rival.tipo2.equals(Fuego)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Bicho) && rival.tipo2.equals(Hada)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Bicho) && rival.tipo2.equals(Lucha)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Bicho) && rival.tipo2.equals(Planta)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Bicho) && rival.tipo2.equals(Psiquico)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Bicho) && rival.tipo2.equals(Siniestro)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Bicho) && rival.tipo2.equals(Veneno)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Bicho) && rival.tipo2.equals(Volador)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Dragon) && rival.tipo2.equals(Acero)) { // Dragon
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Dragon) && rival.tipo2.equals(Dragon)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Dragon) && rival.tipo2.equals(Acero)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Dragon) && rival.tipo2.equals(Hada)) {
			Efectipo = 0;
		} else if (ataque.tipo.equals(Electrico) && rival.tipo2.equals(Agua)) { // Electrico
			Efectipo = doble;
		} else if (ataque.tipo.equals(Electrico) && rival.tipo2.equals(Dragon)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Electrico) && rival.tipo2.equals(Electrico)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Electrico) && rival.tipo2.equals(Planta)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Electrico) && rival.tipo2.equals(Tierra)) {
			Efectipo = 0;
		} else if (ataque.tipo.equals(Electrico) && rival.tipo2.equals(Volador)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Fantasma) && rival.tipo2.equals(Fantasma)) { // Fantasma
			Efectipo = doble;
		} else if (ataque.tipo.equals(Fantasma) && rival.tipo2.equals(Psiquico)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Fantasma) && rival.tipo2.equals(Siniestro)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Fuego) && rival.tipo2.equals(Agua)) { // Fuego
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Fuego) && rival.tipo2.equals(Acero)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Fuego) && rival.tipo2.equals(Bicho)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Fuego) && rival.tipo2.equals(Dragon)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Fuego) && rival.tipo2.equals(Fuego)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Fuego) && rival.tipo2.equals(Hielo)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Fuego) && rival.tipo2.equals(Planta)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Fuego) && rival.tipo2.equals(Roca)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Fuego) && rival.tipo2.equals(Tierra)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Hada) && rival.tipo2.equals(Acero)) { // Hada
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Hada) && rival.tipo2.equals(Dragon)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Hada) && rival.tipo2.equals(Fuego)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Hada) && rival.tipo2.equals(Lucha)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Hada) && rival.tipo2.equals(Siniestro)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Hada) && rival.tipo2.equals(Veneno)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Hielo) && rival.tipo2.equals(Acero)) { // Hielo
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Hielo) && rival.tipo2.equals(Agua)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Hielo) && rival.tipo2.equals(Dragon)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Hielo) && rival.tipo2.equals(Fuego)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Hielo) && rival.tipo2.equals(Hielo)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Hielo) && rival.tipo2.equals(Planta)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Hielo) && rival.tipo2.equals(Tierra)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Hielo) && rival.tipo2.equals(Volador)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Lucha) && rival.tipo2.equals(Acero)) { // Lucha
			Efectipo = doble;
		} else if (ataque.tipo.equals(Lucha) && rival.tipo2.equals(Bicho)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Lucha) && rival.tipo2.equals(Fantasma)) {
			Efectipo = 0;
		} else if (ataque.tipo.equals(Lucha) && rival.tipo2.equals(Hada)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Lucha) && rival.tipo2.equals(Hielo)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Lucha) && rival.tipo2.equals(Normal)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Lucha) && rival.tipo2.equals(Psiquico)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Lucha) && rival.tipo2.equals(Roca)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Lucha) && rival.tipo2.equals(Siniestro)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Lucha) && rival.tipo2.equals(Volador)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Lucha) && rival.tipo2.equals(Veneno)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Normal) && rival.tipo2.equals(Acero)) { // Normal
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Normal) && rival.tipo2.equals(Fantasma)) {
			Efectipo = 0;
		} else if (ataque.tipo.equals(Normal) && rival.tipo2.equals(Roca)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Planta) && rival.tipo2.equals(Acero)) { // Planta
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Planta) && rival.tipo2.equals(Agua)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Planta) && rival.tipo2.equals(Bicho)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Planta) && rival.tipo2.equals(Dragon)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Planta) && rival.tipo2.equals(Fuego)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Planta) && rival.tipo2.equals(Planta)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Planta) && rival.tipo2.equals(Roca)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Planta) && rival.tipo2.equals(Tierra)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Planta) && rival.tipo2.equals(Veneno)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Planta) && rival.tipo2.equals(Volador)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Psiquico) && rival.tipo2.equals(Acero)) { // Psiquico
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Psiquico) && rival.tipo2.equals(Lucha)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Psiquico) && rival.tipo2.equals(Psiquico)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Psiquico) && rival.tipo2.equals(Siniestro)) {
			Efectipo = 0;
		} else if (ataque.tipo.equals(Psiquico) && rival.tipo2.equals(Veneno)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Roca) && rival.tipo2.equals(Acero)) { // Roca
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Roca) && rival.tipo2.equals(Bicho)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Roca) && rival.tipo2.equals(Fuego)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Roca) && rival.tipo2.equals(Lucha)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Roca) && rival.tipo2.equals(Hielo)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Roca) && rival.tipo2.equals(Lucha)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Roca) && rival.tipo2.equals(Tierra)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Roca) && rival.tipo2.equals(Volador)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Siniestro) && rival.tipo2.equals(Hada)) { // Siniestro
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Siniestro) && rival.tipo2.equals(Fantasma)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Siniestro) && rival.tipo2.equals(Lucha)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Siniestro) && rival.tipo2.equals(Psiquico)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Siniestro) && rival.tipo2.equals(Siniestro)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Tierra) && rival.tipo2.equals(Acero)) { // Tierra
			Efectipo = doble;
		} else if (ataque.tipo.equals(Tierra) && rival.tipo2.equals(Bicho)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Tierra) && rival.tipo2.equals(Electrico)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Tierra) && rival.tipo2.equals(Fuego)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Tierra) && rival.tipo2.equals(Normal)) {
			Efectipo = 0;
		} else if (ataque.tipo.equals(Tierra) && (rival.tipo2.equals(Roca) || rival.tipo2.equals(Veneno))) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Tierra) && rival.tipo2.equals(Volador)) {
			Efectipo = 0;
		} else if (ataque.tipo.equals(Veneno) && (rival.tipo2.equals(Hada) || rival.tipo2.equals(Planta))) { // Veneno
			Efectipo = doble;
		} else if (ataque.tipo.equals(Veneno) && (rival.tipo2.equals(Fantasma) || rival.tipo2.equals(Roca)
				|| rival.tipo2.equals(Tierra) || rival.tipo2.equals(Veneno))) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Veneno) && rival.tipo2.equals(Acero)) {
			Efectipo = 0;
		} else if (ataque.tipo.equals(Volador) && rival.tipo2.equals(Acero)) { // Volador
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Volador) && rival.tipo2.equals(Bicho)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Volador) && rival.tipo2.equals(Electrico)) {
			Efectipo = mitad;
		} else if (ataque.tipo.equals(Volador) && rival.tipo2.equals(Lucha)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Volador) && rival.tipo2.equals(Planta)) {
			Efectipo = doble;
		} else if (ataque.tipo.equals(Volador) && rival.tipo2.equals(Roca)) {
			Efectipo = mitad;
		}

		return Efectipo;
	}

	static int i = 0;

	// acciones
	/*
	 * Daño (PS) = {([{(2 * Nv. / 5 + 2) * Ataque * Poder / Defensa} / 50] + 2) *
	 * STAB * Efec.Tipo#1 * Rnd / 100} * CH
	 * 
	 * EfectTipo1: 2 si es *2 1 si es normal 0,5 si es poco efectivo 0 si no afecta
	 * 
	 * Rnd: numero random entre 85 y 100
	 * 
	 * STAB: si el tipo del ataque coincide con el del pokemon
	 * 
	 * CH Critical hit
	 * 
	 */
	static double is = 0.06;
	static double js = 0.06;
	static int mal = 0;
	static int Descanso = 0;

	public static void Atacar(Pokemon jugador, Pokemon rival, Ataque[] ataques, int ataque, double vidaTotal) {
		System.out.println("¡" + jugador.nombre + " ha usado " + ataques[ataque].nombre + "!");
		Random rd = new Random();
		int RndPrec = rd.nextInt(101);
		double Dano;
		int nuevaVel;
		int p = 0;
		if (jugador.estado.equals(Paralizado)) {
			nuevaVel = (int) jugador.velocidad - jugador.velocidad / 4;
			jugador.setVelocidad(nuevaVel);
			p = 1;
		}
		if (rival.estado.equals(Paralizado)) {
			nuevaVel = (int) rival.velocidad - rival.velocidad / 4;
			rival.setVelocidad(nuevaVel);
		}

		if (!jugador.estado.equals(Congelado) && !jugador.estado.equals(Dormido)) {

			if (jugador.estado.equals(Bien) || jugador.estado.equals(Envenenado) || jugador.estado.equals(Quemado)) {
				if (!jugador.nombre.equals("Ditto")) {
					if (ataques[ataque].PP > 0) {
						if (ataques[ataque].precision > RndPrec) {
							if (ataques[ataque].Poder != 0) {
								double STAB = 1; // 1,5 si el tipo coincide o 1 en cualquier otro caso
								double Nv = 50;

								if (ataques[ataque].tipo.equals(jugador.tipo1)
										|| ataques[ataque].tipo.equals(jugador.tipo2)) {
									STAB = 1.5;
								}

								double Rnd = 0;
								double CH = 1;
								double ayudaCH = Math.random() * 100;
								double EfecTipo1 = compareTipo1(ataques[ataque], rival);
								double EfecTipo2 = compareTipo2(ataques[ataque], rival);

								if (!jugador.tipo2.equals("")) {
									if (EfecTipo1 == 0.5 && EfecTipo2 == 0.5) {
										System.out.println("Es poco efectivo...");
									} else if (EfecTipo1 == 0.5 && EfecTipo2 == 1) {
										System.out.println("Es poco efectivo...");
									} else if (EfecTipo1 == 2 && EfecTipo2 == 1) {
										System.out.println("¡Es muy efectivo!");
										// System.out.println(ataques[ataque].nombre + " no afecta a " + rival.nombre);
									} else if (EfecTipo1 == 1 && EfecTipo2 == 0.5) {
										System.out.println("Es poco efectivo...");

									} else if (EfecTipo1 == 2 && EfecTipo2 == 2) {
										System.out.println("¡Es muy eficaz!");
									} else if (EfecTipo1 == 2 && EfecTipo2 == 1) {
										System.out.println("¡Es muy eficaz!");
									} else if (EfecTipo1 == 0 || EfecTipo2 == 0) {
										System.out.println(ataques[ataque].nombre + " no afecta a " + rival.nombre);
									}
								} else {
									if (EfecTipo1 == 0.5) {
										System.out.println("Es poco efectivo...");
									} else if (EfecTipo1 == 2) {
										System.out.println("¡Es muy efectivo!");
									} else if (EfecTipo1 == 0) {
										System.out.println(ataques[ataque].nombre + " no afecta a " + rival.nombre);
									}
								}

								if (ayudaCH < ataques[ataque].probCrit) {
									System.out.println("¡GOLPE CRÍTICO!");
									CH = 2;

								}

								while (Rnd < 0.85)
									Rnd = Math.random();
								Rnd *= 100;
								if (ataques[ataque].tipoAtaque.equals(Fisico)
										&& !ataques[ataque].nombre.equals("Juego sucio")) {
									Dano = (((((2 * Nv / 5 + 2) * jugador.Est_ataque * ataques[ataque].Poder
											/ rival.Est_defensa) / 50) + 2) * STAB * EfecTipo1 * EfecTipo2 * Rnd / 100)
											* CH;
									rival.vida = rival.vida - Dano;
								} else if (ataques[ataque].tipoAtaque.equals(Especial)
										&& !ataques[ataque].nombre.equals("Juego sucio")) {
									Dano = (((((2 * Nv / 5 + 2) * jugador.Est_ataqueEspecial * ataques[ataque].Poder
											/ rival.Est_defensaEspecial) / 50) + 2) * STAB * EfecTipo1 * EfecTipo2 * Rnd
											/ 100) * CH;
									rival.vida = rival.vida - Dano;
								} else if (ataques[ataque].nombre.equals("Juego sucio")) {
									Dano = (((((2 * Nv / 5 + 2) * rival.Est_ataque * ataques[ataque].Poder
											/ rival.Est_defensaEspecial) / 50) + 2) * STAB * EfecTipo1 * EfecTipo2 * Rnd
											/ 100) * CH;
									rival.vida = rival.vida - Dano;
								}

								if (ataques[ataque].probabCambioEstado != 0) {

								}

							} else if (ataques[ataque].nombre.equals("Drenadoras")) {
								rival.setDrenadoras(1);
							} else if (ataques[ataque].nombre.equals("Descanso")) {
								jugador.setEstado(Dormido);
								System.out.println(jugador.nombre + " ha recuperado su vida");
								jugador.setVida(vidaTotal);
								Descanso++;
							}
							double cambEstado = Math.random() * 10;
							if (rival.comprobarBien(rival)) {
								p = 0;
							} else
								p = 1;
							if (cambEstado < ataques[ataque].probabCambioEstado && rival.comprobarBien(rival)
									&& !ataques[ataque].nombre.equals("Descanso")) {
								switch (ataques[ataque].cambioEstado) {
								case "Envenenar":
									rival.setEstado(Envenenado);
									System.out.println(rival.nombre + " ha sido envenenado gravemente");
									break;
								case "Quemar":
									rival.setEstado(Quemado);
									System.out.println(rival.nombre + " ha sido quemado gravemente");
									break;
								case "Congelar":
									rival.setEstado(Congelado);

									System.out.println(rival.nombre + " ha sido congelado gravemente");
									break;
								case "Paralizar":
									rival.setEstado(Paralizado);
									System.out.println(rival.nombre + " ha sido paralizado gravemente");
									break;
								case "Dormir":
									rival.setEstado(Dormido);
									System.out.println(rival.nombre + " se ha dormido profundamente");
									break;

								}

							} else if (!rival.comprobarBien(rival) && p != 0) {
								System.out.println(rival.nombre + " ya está " + rival.estado);
							}

							ataques[ataque].PP--;
							jugador.ataques[ataque].setPP(ataques[ataque].PP);
						} else {
							System.out.println("¡El ataque ha fallado!");

						}
					} else {
						System.out.println("No quedan PP");
					}
				}

				modificaEst(ataque, jugador, rival, vidaTotal);

			} else if (jugador.estado.equals(Paralizado)) {
				System.out.println(jugador.nombre + " no se ha podido mover debido a la parálisis");
			}
		} else if (jugador.estado.equals(Congelado)) {
			System.out.println(jugador.nombre + " no se ha podido mover debido a la congelación");
		} else if (jugador.estado.equals(Dormido)) {
			System.out.println(jugador.nombre + " está dormido...");
		}

		if (jugador.estado.equals(Congelado) || jugador.estado.equals(Dormido)) {
			double rndm = Math.random() * 100;
			if (rndm <= 30) {
				jugador.setEstado(Bien);
			}
		}
		if (Descanso <= 3) {
			if (ataques[ataque].nombre.equals("Ronquido") && jugador.estado.equals(Dormido)) { // Ronquido
				double STAB = 1; // 1,5 si el tipo coincide o 1 en cualquier otro caso
				double Nv = 50;
				if (ataques[ataque].tipo.equals(jugador.tipo1) || ataques[ataque].tipo.equals(jugador.tipo2)) {
					STAB = 1.5;
				}

				double Rnd = 0;
				double CH = 1;
				double ayudaCH = Math.random() * 100;
				double EfecTipo1 = compareTipo1(ataques[ataque], rival);
				double EfecTipo2 = compareTipo2(ataques[ataque], rival);

				if (!jugador.tipo2.equals("")) {
					if (EfecTipo1 == 0.5 && EfecTipo2 == 0.5) {
						System.out.println("Es poco efectivo...");
					} else if (EfecTipo1 == 0.5 && EfecTipo2 == 1) {
						System.out.println("Es poco efectivo...");
					} else if (EfecTipo1 == 2 && EfecTipo2 == 1) {
						System.out.println("¡Es muy efectivo!");
						// System.out.println(ataques[ataque].nombre + " no afecta a " + rival.nombre);
					} else if (EfecTipo1 == 1 && EfecTipo2 == 0.5) {
						System.out.println("Es poco efectivo...");

					} else if (EfecTipo1 == 2 && EfecTipo2 == 2) {
						System.out.println("¡Es muy eficaz!");
					} else if (EfecTipo1 == 2 && EfecTipo2 == 1) {
						System.out.println("¡Es muy eficaz!");
					} else if (EfecTipo1 == 0 || EfecTipo2 == 0) {
						System.out.println(ataques[ataque].nombre + " no afecta a " + rival.nombre);
					}
				} else {
					if (EfecTipo1 == 0.5) {
						System.out.println("Es poco efectivo...");
					} else if (EfecTipo1 == 2) {
						System.out.println("¡Es muy efectivo!");
					} else if (EfecTipo1 == 0) {
						System.out.println(ataques[ataque].nombre + " no afecta a " + rival.nombre);
					}
				}

				if (ayudaCH < ataques[ataque].probCrit) {
					System.out.println("¡GOLPE CRÍTICO!");
					CH = 2;

				}

				while (Rnd < 0.85)
					Rnd = Math.random();
				Rnd *= 100;
				if (ataques[ataque].tipoAtaque.equals(Fisico) && !ataques[ataque].nombre.equals("Juego sucio")) {
					Dano = (((((2 * Nv / 5 + 2) * jugador.Est_ataque * ataques[ataque].Poder / rival.Est_defensa) / 50)
							+ 2) * STAB * EfecTipo1 * EfecTipo2 * Rnd / 100) * CH;
					rival.vida = rival.vida - Dano;
				} else if (ataques[ataque].tipoAtaque.equals(Especial)
						&& !ataques[ataque].nombre.equals("Juego sucio")) {
					Dano = (((((2 * Nv / 5 + 2) * jugador.Est_ataqueEspecial * ataques[ataque].Poder
							/ rival.Est_defensaEspecial) / 50) + 2) * STAB * EfecTipo1 * EfecTipo2 * Rnd / 100) * CH;
					rival.vida = rival.vida - Dano;
				} else if (ataques[ataque].nombre.equals("Juego sucio")) {
					Dano = (((((2 * Nv / 5 + 2) * rival.Est_ataque * ataques[ataque].Poder / rival.Est_defensaEspecial)
							/ 50) + 2) * STAB * EfecTipo1 * EfecTipo2 * Rnd / 100) * CH;
					rival.vida = rival.vida - Dano;
				}

				System.out.println(jugador.nombre + " ha usado Ronquido");

			}
		} else {
			jugador.setEstado(Bien);
			System.out.println(jugador.nombre + " se ha despertado");
		}
		double rndPar = Math.random() * 100;
		if (rndPar < 30 && (jugador.estado.equals("Paralizado") || jugador.estado.equals(Congelado))) {
			jugador.setEstado(Bien);
			System.out.println(jugador.nombre + " se ha recuperado");
			if (Descanso == 3) {
				jugador.setEstado(Bien);
			}
		}

		if (rival.estado.equals(Bien)) {
			Descanso = 0;

		}

	}

	public static void modificaEst(int ataque, Pokemon jugador, Pokemon rival, double vidaTotal) {
		double rnd = Math.random() * 100;
		if (rnd <= jugador.ataques[ataque].probabCambioEstadistica) {
			if (jugador.ataques[ataque].cambAtEspecialP != 0) {
				switch (jugador.ataques[ataque].cambAtEspecialP) {
				case -2:
					jugador.Est_ataqueEspecial -= jugador.Est_ataqueEspecial / 2;
					jugador.setEst_ataqueEspecial(jugador.Est_ataqueEspecial);
					break;
				case -1:
					jugador.Est_ataqueEspecial -= jugador.Est_ataqueEspecial / 3;
					jugador.setEst_ataqueEspecial(jugador.Est_ataqueEspecial);
					break;
				case 2:
					jugador.Est_ataqueEspecial *= 2;
					jugador.setEst_ataqueEspecial(jugador.Est_ataqueEspecial);
					break;
				case 1:
					jugador.Est_ataqueEspecial += jugador.Est_ataqueEspecial / 2;
					jugador.setEst_ataqueEspecial(jugador.Est_ataqueEspecial);
					break;
				}
			}

			if (jugador.ataques[ataque].cambAtFisicoP != 0) {

				switch (jugador.ataques[ataque].cambAtFisicoP) {
				case -2:
					jugador.Est_ataque -= jugador.Est_ataque / 2;
					jugador.setEst_ataque(jugador.Est_ataque);
					break;
				case -1:
					jugador.Est_ataque -= jugador.Est_ataque / 3;
					jugador.setEst_ataque(jugador.Est_ataque);
					break;
				case 2:
					System.out.println("Ataque:");
					System.out.println(jugador.Est_ataque);
					jugador.Est_ataque *= 2;
					jugador.setEst_ataque(jugador.Est_ataque);
					System.out.println(jugador.Est_ataque);
					break;
				case 1:
					jugador.Est_ataque += jugador.Est_ataque / 2;
					jugador.setEst_ataque(jugador.Est_ataque);
					break;
				}
			}

			if (jugador.ataques[ataque].cambDefEspecialP != 0) {
				switch (jugador.ataques[ataque].cambDefEspecialP) {
				case -2:
					jugador.Est_defensaEspecial -= jugador.Est_defensaEspecial / 2;
					jugador.setEst_defensaEspecial(jugador.Est_defensaEspecial);
					break;
				case -1:
					jugador.Est_defensaEspecial -= jugador.Est_defensaEspecial / 3;
					jugador.setEst_defensaEspecial(jugador.Est_defensaEspecial);
					break;
				case 2:
					jugador.Est_defensaEspecial *= 2;
					jugador.setEst_defensaEspecial(jugador.Est_defensaEspecial);
					break;
				case 1:
					jugador.Est_defensaEspecial += jugador.Est_defensaEspecial / 2;
					jugador.setEst_defensaEspecial(jugador.Est_defensaEspecial);
					break;
				}
			}

			if (jugador.ataques[ataque].cambDefFisicaP != 0) {

				switch (jugador.ataques[ataque].cambDefFisicaP) {
				case -2:
					jugador.Est_defensa -= jugador.Est_defensa / 2;
					jugador.setEst_defensa(jugador.Est_defensa);
					break;
				case -1:
					jugador.Est_defensa -= jugador.Est_defensa / 3;
					jugador.setEst_defensa(jugador.Est_defensa);
					break;
				case 2:
					jugador.Est_defensa *= 2;
					jugador.setEst_defensa(jugador.Est_defensa);
					break;
				case 1:
					jugador.Est_defensa += jugador.Est_defensa / 2;
					jugador.setEst_defensa(jugador.Est_defensa);
					break;
				}
			}

			if (jugador.ataques[ataque].cambVelP != 0) {
				switch (jugador.ataques[ataque].cambVelP) {
				case -2:
					jugador.velocidad -= jugador.velocidad / 2;
					jugador.setVelocidad(jugador.velocidad);
					break;
				case -1:
					jugador.velocidad -= jugador.velocidad / 3;
					jugador.setVelocidad(jugador.velocidad);
					break;
				case 2:
					jugador.velocidad *= 2;
					jugador.setVelocidad(jugador.velocidad);
					break;
				case 1:
					jugador.velocidad += jugador.velocidad / 2;
					jugador.setVelocidad(jugador.velocidad);
					break;
				}
			}

			// Rival

			if (jugador.ataques[ataque].cambAtEspecialP != 0) {
				switch (jugador.ataques[ataque].cambAtEspecialP) {
				case -2:
					jugador.Est_ataqueEspecial -= jugador.Est_ataqueEspecial / 2;
					jugador.setEst_ataqueEspecial(jugador.Est_ataqueEspecial);
					break;
				case -1:
					jugador.Est_ataqueEspecial -= jugador.Est_ataqueEspecial / 3;
					jugador.setEst_ataqueEspecial(jugador.Est_ataqueEspecial);
					break;
				case 2:
					jugador.Est_ataqueEspecial *= 2;
					jugador.setEst_ataqueEspecial(jugador.Est_ataqueEspecial);
					break;
				case 1:
					jugador.Est_ataqueEspecial += jugador.Est_ataqueEspecial / 2;
					jugador.setEst_ataqueEspecial(jugador.Est_ataqueEspecial);
					break;
				}
			}

			if (jugador.ataques[ataque].cambAtFisicoR != 0) {

				switch (jugador.ataques[ataque].cambAtFisicoR) {
				case -2:
					rival.Est_ataque -= rival.Est_ataque / 2;
					rival.setEst_ataque(rival.Est_ataque);
					break;
				case -1:
					rival.Est_ataque -= rival.Est_ataque / 3;
					rival.setEst_ataque(rival.Est_ataque);
					break;
				case 2:
					rival.Est_ataque *= 2;
					rival.setEst_ataqueEspecial(rival.Est_ataque);
					break;
				case 1:
					rival.Est_ataque += rival.Est_ataque / 2;
					rival.setEst_ataque(rival.Est_ataque);
					break;
				}
			}

			if (jugador.ataques[ataque].cambDefEspecialR != 0) {
				switch (jugador.ataques[ataque].cambDefEspecialR) {
				case -2:
					rival.Est_defensaEspecial -= rival.Est_defensaEspecial / 2;
					rival.setEst_defensaEspecial(rival.Est_defensaEspecial);
					break;
				case -1:
					rival.Est_defensaEspecial -= rival.Est_defensaEspecial / 3;
					rival.setEst_defensaEspecial(rival.Est_defensaEspecial);
					break;
				case 2:
					rival.Est_defensaEspecial *= 2;
					rival.setEst_defensaEspecial(rival.Est_defensaEspecial);
					break;
				case 1:
					rival.Est_defensaEspecial += rival.Est_defensaEspecial / 2;
					rival.setEst_defensaEspecial(jugador.Est_defensaEspecial);
					break;
				}
			}

			if (jugador.ataques[ataque].cambDefFisicaR != 0) {

				switch (jugador.ataques[ataque].cambDefFisicaR) {
				case -2:
					rival.Est_defensa -= rival.Est_defensa / 2;
					rival.setEst_defensa(rival.Est_defensa);
					break;
				case -1:
					rival.Est_defensa -= rival.Est_defensa / 3;
					rival.setEst_defensa(rival.Est_defensa);
					break;
				case 2:
					rival.Est_defensa *= 2;
					rival.setEst_defensa(rival.Est_defensa);
					break;
				case 1:
					rival.Est_defensa += rival.Est_defensa / 2;
					rival.setEst_defensa(rival.Est_defensa);
					break;
				}
			}

			if (jugador.ataques[ataque].cambVelR != 0) {
				switch (jugador.ataques[ataque].cambVelR) {
				case -2:
					rival.velocidad -= rival.velocidad / 2;
					rival.setVelocidad(rival.velocidad);
					break;
				case -1:
					rival.velocidad -= rival.velocidad / 3;
					rival.setVelocidad(rival.velocidad);
					break;
				case 2:
					rival.velocidad *= 2;
					rival.setVelocidad(rival.velocidad);
					break;
				case 1:
					rival.velocidad += rival.velocidad / 2;
					rival.setVelocidad(rival.velocidad);
					break;
				}
			}

			if (jugador.ataques[ataque].cambPrecisionP != 0) {
				switch (jugador.ataques[ataque].cambPrecisionP) {
				case -2:
					rival.velocidad -= rival.velocidad / 2;
					rival.setVelocidad(rival.velocidad);
					break;
				case -1:
					rival.velocidad -= rival.velocidad / 3;
					rival.setVelocidad(rival.velocidad);
					break;
				case 2:
					rival.velocidad *= 2;
					rival.setVelocidad(rival.velocidad);
					break;
				case 1:
					rival.velocidad += rival.velocidad / 2;
					rival.setVelocidad(rival.velocidad);
					break;
				}
			}
		}
	}

	public static String verEstado(Pokemon jugador) {
		String cadena = "";
		switch (jugador.estado) {
		case "Dormido":
			cadena += "(Dor.)";
			break;
		case "Envenenado":
			cadena += "(Env.)";
			break;
		case "Paralizado":
			cadena += "(Par.)";
			break;
		case "Congelado":
			cadena += "(Cong.)";
			break;
		case "Quemado":
			cadena += "(Quem.)";
		}
		return cadena;

	}

	public static String barraVida(Pokemon jugador, double VidaTotal) {

		System.out.println();
		double porc = (jugador.vida * 100) / VidaTotal;

		String cadena = "";
		if (porc <= 0) {
			cadena += "[                    ]" + verEstado(jugador);
		} else if (porc < 15) {
			cadena += "[===                 ]" + verEstado(jugador);
		} else if (porc < 20) {
			cadena += "[====                ]" + verEstado(jugador);
		} else if (porc < 25) {
			cadena += "[=====               ]" + verEstado(jugador);
		} else if (porc < 30) {
			cadena += "[======              ]" + verEstado(jugador);
		} else if (porc < 35) {
			cadena += "[=======             ]" + verEstado(jugador);
		} else if (porc < 40) {
			cadena += "[========            ]" + verEstado(jugador);
		} else if (porc < 45) {
			cadena += "[=========           ]" + verEstado(jugador);
		} else if (porc < 50) {
			cadena += "[==========          ]" + verEstado(jugador);
		} else if (porc < 55) {
			cadena += "[===========         ]" + verEstado(jugador);
		} else if (porc < 60) {
			cadena += "[============        ]" + verEstado(jugador);
		} else if (porc < 65) {
			cadena += "[=============       ]" + verEstado(jugador);
		} else if (porc < 70) {
			cadena += "[==============      ]" + verEstado(jugador);
		} else if (porc < 75) {
			cadena += "[===============     ]" + verEstado(jugador);
		} else if (porc < 80) {
			cadena += "[================    ]" + verEstado(jugador);
		} else if (porc < 85) {
			cadena += "[=================   ]" + verEstado(jugador);
		} else if (porc < 90) {
			cadena += "[==================  ]" + verEstado(jugador);
		} else if (porc < 95) {
			cadena += "[=================== ]" + verEstado(jugador);
		} else if (porc < 1000)
			cadena += "[====================]" + verEstado(jugador);
		return cadena;
	}

}