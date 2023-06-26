package JuegoPokemon;

import java.util.Random;
import java.util.Scanner;
import JuegoPokemon.*;


public class Juego {

	//Climas
	static String Despejado = "Despejado";
	static String Soleado = "Soleado";
	static String Tormenta_Arena = "Tormenta de arena";
	static String Granizo = "Granizo";
	static String Lluvioso = "Lluvioso";
	static String Niebla = "Niebla";
	
	public void iniciarJuego() {
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

		Ataque vacio = new Ataque("", 0, "", 0, 0, 0, 0, "", 0, 0, 0, 0, "Fisico", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, "");
		Ataque[] vacios = { new Ataque(vacio), new Ataque(vacio), new Ataque(vacio), new Ataque(vacio) };

		/*
		 * String nombre; double Poder; String tipo; int especie;int prioridad int
		 * cambAtFisicoP;int cambAtEspecialP; int cambDefFisicaP; int cambDefEspecialP;
		 * int cambVelP; int cambAtFisicoR; int cambAtEspecialR; int cambDefFisicaR; int
		 * cambDefEspecialR; int cambVelR; double precision; double probCrit; double
		 * probabCambioEstado; String cambioEstado; double probRetr; String tipoAtaque;
		 * double probabCambioEstadistica; int cambPrecisionP; int cambPrecisionR; int
		 * probBajarVidaP; int probBajarVidaR; int PP; String definicion;
		 */
		// ataque normal
		Ataque Descanso = new Ataque(/* nombre */"Descanso", /* Poder */ 0, /* Tipo */"Normal", /* Prioridad */0,
				/* Precision */ 100, /* ProbCritico */ 0, /* probabCambioEstado */100, /* cambioEstado */"Dormir",
				/* probBajarVidaP */ 0, /* probBajarVidaR */0, /* probabCambioEstadistica */ 0, /* probRetr */ 0,
				"Estado", /* cambAtFisicoP */ 0, /* cambAtEspecialP */ 0, /* cambDefFisicaP */0,
				/* cambDefEspecialP */ 0, /* cambVelP */0, /* cambAtFisicoR */ 0, /* cambAtEspecialR */ 0,
				/* cambDefFisicaR */ 0, /* cambDefEspecialR */0, /* cambVelR */ 0, /* cambPrecisionP */0,
				/* cambPrecisionR */ 0, /* PP */10,
				"Descanso hace que el usuario se duerma y recupere la totalidad de los PS, curando en el proceso cualquier problema de estado.");

		Ataque Ronquido = new Ataque("Ronquido", 50, "Normal", 0, 100, 5, 0, "", 0, 0, 0, 0, "Especial", 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 15,
				"Ronquido es un movimiento de sonido que causa daño y tiene una probabilidad del 30% de hacer retroceder al objetivo. Este movimiento solamente puede usarse mientras el usuario está dormido, en caso contrario fallará.");
		Ataque Bomba_huevo = new Ataque("Bomba_huevo", 100, "Normal", 0, 50, 5, 0, "", 0, 0, 0, 0, "Especial", 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 10, "Bomba huevo causa daño y no tiene ningún efecto secundario.");
		// ataque ditto

		// Ataques PokemonFuego
		Ataque Ascuas = new Ataque("Ascuas", 70, "Fuego", 0, 100, 5, 10, "Quemar", 0, 0, 0, 0, "Especial", 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 25,
				"Ascuas causa daño y tiene una probabilidad del 10% de quemar al objetivo.");
		Ataque Llamarada = new Ataque("Llamarada", 85, "Fuego", 0, 85, 5, 30, "Quemar", 0, 0, 0, 0, "Especial", 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 5,
				"El enemigo es atacado con una intensa explosión de fuego que todo lo consume. También puede dejar al objetivo con una quemadura.");
		Ataque A_Bocajarro = new Ataque("A bocajarro", 100, "Lucha", 0, 100, 5, 0, "", 0, 0, 0, 0, "Fisico", -1, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 5,
				"El usuario lucha contra el enemigo de cerca sin protegerse. También acorta la Defensa y la Defensa Especial del usuario."
						+ "");
		Ataque Danza_Espada = new Ataque("Danza Espada", 0, "Normal", 0, 100, 0, 0, "", 0, 0, 100, 0, "Estado", 2, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 20,
				"Una danza frenética para elevar el espíritu de lucha. Aumenta drásticamente la estadística de ataque del usuario.");

		// Ataques PokemonAgua
		Ataque Pistola_agua = new Ataque("Pistola agua", 72, "Agua", 0, 100, 5, 0, "", 0, 0, 0, 0, "Especial", 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 25, "El enemigo es atacado con un fuerte disparo de agua.");
		Ataque Hidrobomba = new Ataque("Hidrobomba", 110, "Agua", 0, 80, 5, 0, "", 0, 0, 0, 0, "Especial", 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 5,
				"El enemigo es atacado por un gran volumen de agua lanzado bajo una gran presión");

		Ataque Aqua_jet = new Ataque("Aqua jet", 40, "Agua", 1, 100, 5, 0, "", 0, 0, 0, 0, "Fisico", 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 20,
				"El usuario se lanza sobre el enemigo a una velocidad que lo hace casi invisible. Es seguro golpear primero.");
		Ataque Hidrocanon = new Ataque("Hidrocañón", 150, "Agua", 0, 90, 5, 0, "", 0, 0, 0, 0, "Especial", 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 5, "El enemigo es golpeado con una explosión acuosa.");

		// Ataques PokemonPlanta
		Ataque Hoja_afilada = new Ataque("Hoja afilada", 55, "Planta", 0, 95, 35, 0, "", 0, 0, 0, 0, "Especial", 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25,
				"Se lanza una hoja afilada para acuchillar al enemigo. Tiene una alta proporción de golpes críticos.");
		Ataque Tormenta_floral = new Ataque("Tormenta floral", 90, "Planta", 0, 100, 5, 0, "", 0, 0, 0, 0, "Especial",
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15,
				"El usuario desata un intenso vendaval de pétalos que daña a los Pokémon a su alrededor.");
		Ataque Sintesis = new Ataque("Sintesis", 0, "Planta", 0, 100, 0, 0, "", 0, 0, 0, 0, "Estado", 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 5, "El usuario restaura su propio HP.");

		Ataque Drenadoras = new Ataque("Drenadoras", 0, "Planta", 0, 90, 0, 0, "", 0, 0, 0, 0, "Especial", 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 10,
				"Se planta una semilla en el enemigo. Roba algo de HP del enemigo para curar al usuario en cada turno.");

		// Ataques Veneno
		Ataque Toxico = new Ataque("Toxico", 0, "Veneno", 0, 85, 0, 100, "Envenenar", 0, 0, 0, 0, "Especial", 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 10,
				"Un movimiento que deja al objetivo gravemente envenenado. El daño de su veneno empeora cada vez.");
		Ataque Picotazo_venenoso = new Ataque("Picotazo Venenoso", 15, "Veneno", 0, 100, 5, 30, "Envenenar", 0, 0, 0, 0,
				"Fisico", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 35,
				"El enemigo es apuñalado con una púa venenosa de algún tipo. También puede envenenar al objetivo.");
		Ataque Lanza_mugre = new Ataque("Lanza mugre", 120, "Veneno", 0, 70, 5, 30, "Envenenar", 0, 0, 0, 0, "Especial",
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5,
				"El usuario dispara basura sucia al enemigo para atacar. También puede envenenar al objetivo.");
		Ataque Polvo_Veneno = new Ataque("Polvo veneno", 0, "Veneno", 0, 75, 0, 100, "Envenenar", 0, 0, 0, 0,
				"Especial", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 35,
				"Una nube de polvo venenoso se esparce sobre el enemigo. Puede envenenar al objetivo.");

		// Ataques Volador
		Ataque Respiro = new Ataque("Respiro", 0, "Volador", 0, 100, 0, 0, "", 0, 0, 0, 0, "Estado", 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 10,
				"El usuario aterriza y descansa su cuerpo. Restaura el HP del usuario hasta la mitad de su HP máximo");
		Ataque Danza_pluma = new Ataque("Danza pluma", 0, "Volador", 0, 100, 0, 0, "", 0, 0, 100, 0, "Estado", 0, 0, 0,
				0, 0, -2, 0, 0, 0, 0, 0, 0, 15,
				"El usuario cubre al enemigo con una masa de plumón que reduce drásticamente la estadística de Ataque");
		Ataque Aerochorro = new Ataque("Aerochorro", 180, "Volador", 0, 95, 12.5, 0, "", 0, 0, 0, 0, "Especial", 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5,
				"Se dispara un vórtice de aire al enemigo para infligir daño. Tiene una alta proporción de golpes críticos.");
		Ataque Ala_bis = new Ataque("Ala bis", 80, "Volador", 0, 90, 5, 0, "", 0, 0, 0, 0, "Fisico", 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 10, "");
		Ataque Pajaro_osado = new Ataque("Pájaro osado", 120, "Volador", 1, 100, 5, 0, "", 100, 0, 0, 0, "Fisico", 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15,
				"El usuario pliega sus alas y carga desde una altura baja. El usuario también sufre daños graves.");
		// Ataques Siniestro
		Ataque Juego_sucio = new Ataque("Juego sucio", 95, "Siniestro", 0, 100, 5, 0, "", 0, 0, 0, 0, "Fisico", 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 100, "Utiliza la fuerza del oponente.");
		Ataque Tajo_umbrio = new Ataque("Tajo umbrío", 75, "Siniestro", 0, 100, 5, 0, "", 0, 0, 0, 0, "Especial", 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15,
				"El usuario corta al enemigo en el instante en que surge la oportunidad. Tiene una alta proporción de golpes críticos.");
		Ataque Pulso_noche = new Ataque("Pulso noche", 85, "Siniestro", 0, 95, 5, 0, "", 0, 0, 40, 0, "Especial", 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 10,
				"Envía ondas de choque de oscuridad volando. Puede reducir la precisión de los oponentes.");
		Ataque Pulso_umbrio = new Ataque("Pulso umbrio", 80, "Siniestro", 0, 100, 5, 20, "", 0, 0, 0, 0, "Especial", 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15,
				"El usuario libera un aura horrible imbuida de pensamientos oscuros. También puede hacer que el objetivo se estremezca.");
		Ataque Mordisco = new Ataque("Mordisco", 90, "Siniestro", 0, 100, 5, 0, "", 0, 0, 0, 0, "Fisico", 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 25,
				"El enemigo es mordido con colmillos terriblemente afilados. Puede hacer que el objetivo se estremezca.");
		// Ataques Hada

		// Ataque tierra
		Ataque Terremoto = new Ataque("Terremoto", 100, "Tierra", 0, 100, 5, 0, "", 0, 0, 0, 0, "Fisico", 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 10,
				"El usuario desencadena un terremoto que golpea a todos los Pokémon en la batalla.");

		// Array todos ataques
		Ataque[] todos = { new Ataque(Ascuas), new Ataque(Llamarada), new Ataque(A_Bocajarro), new Ataque(Danza_Espada),
				new Ataque(Pistola_agua), new Ataque(Hidrobomba), new Ataque(Mordisco), new Ataque(Aqua_jet),
				new Ataque(Hoja_afilada), new Ataque(Tormenta_floral), new Ataque(Sintesis), new Ataque(Polvo_Veneno),
				new Ataque(Toxico), new Ataque(Picotazo_venenoso), new Ataque(Lanza_mugre), new Ataque(Juego_sucio),
				new Ataque(Tajo_umbrio), new Ataque(Respiro), new Ataque(Danza_pluma), new Ataque(Aerochorro),
				new Ataque(Descanso), new Ataque(Ala_bis), new Ataque(Pulso_noche), new Ataque(Drenadoras),
				new Ataque(Pulso_umbrio), new Ataque(Ronquido), new Ataque(Bomba_huevo), new Ataque(Terremoto),
				new Ataque(Hidrocanon), new Ataque(Pajaro_osado) };

		// vacios

		Ataque[] ataquesJugador = { new Ataque(vacio), new Ataque(vacio), new Ataque(vacio), new Ataque(vacio) };
		Ataque[] ataquesRival = { new Ataque(vacio), new Ataque(vacio), new Ataque(vacio), new Ataque(vacio) };

		Pokemon Jugador = new Pokemon("", "", "", 0, vacios, 0, 0, 0, 0, 0, "", 0, 0);
		Pokemon Rival = new Pokemon("", "", "", 0, vacios, 0, 0, 0, 0, 0, "", 0, 0);

		// Pokemons
		// Pokemon: nombre, tipo, vida, ataques[], ataqueF, ataqueEsp, defensaF,
		// defensaEsp, vel, estado
		Pokemon Charizard = new Pokemon("Charizard", "Fuego", "Volador", 385, vacios, 163, 165, 146, 150, 167, "Bien",
				0, 100);
		Pokemon Blastoise = new Pokemon("Blastoise", "Agua", "", 386, vacios, 149, 155, 170, 165, 143, "Bien", 0, 100);
		Pokemon Venasaur = new Pokemon("Venasaur", "Planta", "Veneno", 385, vacios, 155, 160, 165, 149, 176, "Bien", 0,
				100);
		Pokemon Zubat = new Pokemon("Zubat", "Veneno", "Volador", 347, vacios, 106, 90, 95, 101, 117, "Bien", 0, 100);
		Pokemon Snorlax = new Pokemon("Snorlax", "Normal", "", 467, vacios, 178, 128, 128, 178, 90, "Bien", 0, 100);
		Pokemon Rayquaza = new Pokemon("Rayquaza", "Dragon", "Volador", 412, vacios, 222, 222, 156, 156, 161, "Bien", 0,
				100);
		Pokemon Chansey = new Pokemon("Chansey", "Normal", "", 557, vacios, 62, 95, 62, 172, 112, "Bien", 0, 100);
		Pokemon Scolipede = new Pokemon("Scolipede", "Bicho", "Veneno", 324, vacios, 167, 117, 155, 133, 180, "Bien", 0, 100);
		Pokemon Haxorus = new Pokemon("Haxorus", "Dragon", "", 356, vacios, 218, 123, 156, 134, 163, "Bien", 0, 100);
		
		
		Pokemon[] pokemon = { new Pokemon(Charizard), new Pokemon(Blastoise), new Pokemon(Venasaur), new Pokemon(Zubat),
				new Pokemon(Snorlax), new Pokemon(Rayquaza), new Pokemon(Chansey), new Pokemon(Scolipede), new Pokemon(Haxorus)};

		mostrarArrayPokemon(pokemon);
		// leer que pokemon quiere el usuario
		int i;

		System.out.println("Elija con que pokemon quiere jugar:");
		i = entrada.nextInt();

		Jugador = pokemon[i];
		System.out.println("Desea ver las estadisticas de tu pokemon? (Y/N)");
		String pl = entrada.next();
		if (pl.equals("Y")) {
			System.out.println("Ataque: " + (int) Jugador.Est_ataque);
			System.out.println("Defensa: " + (int) Jugador.Est_defensa);
			System.out.println("Ataque Esp: " + (int) Jugador.Est_ataqueEspecial);
			System.out.println("Defensa Esp: " + (int) Jugador.Est_defensaEspecial);
			System.out.println("Velocidad: " + (int) Jugador.velocidad);
			System.out.println();
		}

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

		// aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
		Random rand = new Random();

		Rival = pokemon[rand.nextInt(pokemon.length)];
		if (Rival.equals(Jugador)) {
			while (Rival.equals(Jugador))
				Rival = pokemon[rand.nextInt(pokemon.length)];
		}

		verAtaques(je, max);

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
		//Escenario escenario = new Escenario("", Jugador, Rival);
		String[] climas = { Despejado, Soleado, Tormenta_Arena, Granizo, Lluvioso, Niebla };
		String clima = climas[rand.nextInt(climas.length)];
		System.out.println();
		System.out.println("Se jugará con un clima: " + clima);
		System.out.println();
		//escenario.setClima(clima);
		int Num_ataque;
		int turno = 1;
		while (Jugador.vida > 0 && Rival.vida > 0) {
			System.out.println("Desea ver las estadisticas de los ataques? (Y/N)");
			String l = entrada.next();
			if (l.equals("Y") || l.equals("y")) {
				for (int o = 0; o < Jugador.ataques.length; o++) {
					if (Jugador.ataques[o].Poder != 0)
						System.out.println(Jugador.ataques[o].nombre + ": " + Jugador.ataques[o].definicion
								+ "\nPoder: " + (int) Jugador.ataques[o].Poder + "\nTipo: " + Jugador.ataques[o].tipo
								+ "\nTipo de ataque: " + Jugador.ataques[o].tipoAtaque);
					else
						System.out.println(Jugador.ataques[o].nombre + ": " + Jugador.ataques[o].definicion
								+ "\nPoder: --\nTipo: " + Jugador.ataques[o].tipo + "\nTipo de ataque: "
								+ Jugador.ataques[o].tipoAtaque);

					System.out.println();
				}
			}
			
		
			
			System.out.println("Elija un ataque: ");
			mostrarAtaques(Jugador);
			Num_ataque = entrada.nextInt();
			System.out.println();
			System.out.println("---------------------------------------------------\n\t\t   Turno: " + turno
					+ "\n---------------------------------------------------");
			/*
			 * llamadaAtacar(Jugador, Rival, Jugador.ataques, Rival.ataques, Num_ataque, vidaTotal, vida2, est_AFInicial1,
					est_AEInicial1, est_DFInicial1, est_DEInicial1, est_Vel1, est_AEInicial2, est_AFInicial2,
					est_DFInicial2, est_DEInicial2, est_Vel2, escenario);
			 */
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
	
	public static void mostrarArrayPokemon(Pokemon[] pokemons) {

		for (int i = 0; i < pokemons.length; i++) {
			System.out.println(i + ". " + pokemons[i].nombre + " ");
		}

	}
	
	public static void mostrarAtaques(Pokemon pokemon) {
		for (int te = 0; te < 4; te++) {
			System.out.println(te + ". " + pokemon.ataques[te].nombre + " (" + pokemon.ataques[te].PP + " PP)");
		}
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
	
	public static void verAtaques(Ataque[] a, int max) {
		for (int j = 0; j < max; j++) {
			System.out.println(j + ". " + a[j].nombre);
		}

	}
	
	public static void llamadaAtacar() {
		
	}
	
}
