package JuegoPokemon;

import Pokemons.Ataque;

public class Pokemon {

	String Fuego = "Fuego";
	String Agua = "Agua";
	String Planta = "Planta";
	String Electrico = "Electrico";
	String Acero = "Acero";
	String Siniestro = "Siniestro";
	String Dragon = "Dragon";
	String Hielo = "Hielo";
	String Volador = "Volador";
	String Tierra = "Tierra";
	String Roca = "Roca";
	String Hada = "Hada";
	String Bicho = "Bicho";
	String Fantasma = "Fantasma";
	String Lucha = "Lucha";
	String Psiquico = "Psiquico";
	String Veneno = "Veneno";
	String Normal = "Normal";

	// Estados
	String Bien = "Bien";
	String Congelado = "Congelado";
	String Envenenado = "Envenenado";
	String Paralizado = "Paralizado";
	String Dormido = "Dormido";
	String Quemado = "Quemado";

	// Cambiar los estados
	String Curar = "Curar";
	String Congelar = "Congelar";
	String Envenenar = "Envenenar";
	String Paralizar = "Paralizar";
	String Dormir = "Dormir";
	String Quemar = "Quemar";

	public int velocidad;
	public String nombre;
	public String tipo1;
	public String tipo2;
	public double vida;
	public Ataque ataque;
	public JuegoPokemon.Ataque[] ataques;
	public double Est_ataque;
	public double Est_defensa;
	public String estado;
	public double Est_ataqueEspecial;
	public double Est_defensaEspecial;
	public int Drenadoras;
	public double Precision;
	public Pokemon(String nombre, String tipo1, String tipo2, double vida, JuegoPokemon.Ataque[] vacios, double Est_ataque, double Est_ataqueEspecial, double Est_defensa, double Est_defensaEspecial,
			int velocidad, String estado, int Drenadoras, double Precision) {
		super();
		this.velocidad = velocidad;
		this.nombre = new String(nombre);
		this.tipo1 = new String(tipo1);
		this.tipo2 = new String(tipo2);
		this.vida = vida;
		this.Est_ataque = Est_ataque;
		this.Est_ataqueEspecial = Est_ataqueEspecial;
		this.Est_defensaEspecial = Est_defensaEspecial;
		this.Est_defensa = Est_defensa;
		this.ataques = vacios;
		
		this.estado = new String(estado);
		this.Drenadoras = Drenadoras;
		this.Precision = Precision;
	}

	
	
	// Getters y setters
	
	public Pokemon(Pokemon pokemon) {
		super();
		this.velocidad = pokemon.velocidad;
		this.nombre = pokemon.nombre;
		this.tipo1 = pokemon.tipo1;
		this.tipo2 = pokemon.tipo2;
		this.vida = pokemon.vida;
		this.Est_ataque = pokemon.Est_ataque;
		this.Est_ataqueEspecial = pokemon.Est_ataqueEspecial;
		this.Est_defensaEspecial = pokemon.Est_defensaEspecial;
		this.Est_defensa = pokemon.Est_defensa;
		this.ataques = pokemon.ataques;
		
		this.estado = pokemon.estado;
		this.Drenadoras = pokemon.Drenadoras;
		this.Precision = pokemon.Precision;
	}

	public String getTipo2() {
		return tipo2;
	}

	public void setTipo2(String tipo2) {
		this.tipo2 = tipo2;
	}	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipo1() {
		return tipo1;
	}

	public void setTipo(String tipo1) {
		this.tipo1 = tipo1;
	}

	public double getVida() {
		return vida;
	}

	public void setVida(double vida) {
		this.vida = vida;
	}

	public JuegoPokemon.Ataque[] getAtaques() {
		return ataques;
	}

	public void setAtaques(JuegoPokemon.Ataque[] ataquesJugador) {
		this.ataques = ataquesJugador;
	}

	public double getEst_ataqueEspecial() {
		return Est_ataqueEspecial;
	}

	public void setEst_ataqueEspecial(double est_ataqueEspecial) {
		Est_ataqueEspecial = est_ataqueEspecial;
	}

	public double getEst_defensaEspecial() {
		return Est_defensaEspecial;
	}

	public void setEst_defensaEspecial(double est_defensaEspecial) {
		Est_defensaEspecial = est_defensaEspecial;
	}
	
	public double getEst_ataque() {
		return Est_ataque;
	}

	public void setEst_ataque(double est_ataque) {
		Est_ataque = est_ataque;
	}

	public double getEst_defensa() {
		return Est_defensa;
	}

	public void setEst_defensa(double est_defensa) {
		Est_defensa = est_defensa;
	}

	public void setVelocidad(int velocidad) {
		velocidad = velocidad;
	}

	public int getVelocidad() {
		return velocidad;
	}
	// fin getters y setters

	/*
	 * Estados: 1->Congelado 2->Envenenado 3->paralizado 4->Dormido
	 */
	
	public boolean comprobarVivo() {
		if (this.vida <= 0) {
			return false;
		} else return true;
	}
	public boolean compruebaEstado(Pokemon jugador) {
		boolean estado = true;

		if (this.estado.equals(Congelado)) {
			estado = false;
		} else if (this.estado.equals(Envenenado)) {
			estado = false;
		} else if (this.estado.equals(Paralizado)) {
			estado = true;
		} else if (this.estado.equals(Dormido)) {
			estado = true;
		} else if (this.estado.equals(Bien)) {
			estado = false;
		}

		return estado;

	}
		
	public boolean comprobarBien(Pokemon pokemon) {
		boolean bien = false;
		if (pokemon.estado.equals(Bien)) {
			bien = true;
		}
		return bien;
	}
	
	public void cambiarEstado(Ataque ataque, Pokemon jugador, Pokemon rival) {
		double rnd = Math.random() * 100;
		if (rival.estado.equals(Bien)) {
			if (ataque.cambioEstado.equals(Quemar)) {
				if (rnd < ataque.precision) {
					if (rival.estado.equals(Bien)) {

						rival.setEstado(Quemado);
						System.out.println(rival.nombre + " ha sido quemado");
					} else
						System.out.println("No se puede cambiar el estado, ya esta " + rival.estado);
				}else if (ataque.especie != 4)
					System.out.println("El ataque ha fallado!");

			} else if (ataque.cambioEstado.equals(Congelar)) {
				if (rnd < ataque.precision) {
					if (rival.estado.equals(Bien)) {

						rival.setEstado(Congelado);
						System.out.println(rival.nombre + " ha sido congelado");
					} else
						System.out.println("No se puede cambiar el estado, ya esta " + rival.estado);
				}else if (ataque.especie != 4)
					System.out.println("El ataque ha fallado!");
			} else if (ataque.cambioEstado.equals(Envenenar)) {
				if (rnd < ataque.precision) {
					if (rival.estado.equals(Bien)) {

						rival.setEstado(Envenenado);
						System.out.println(rival.nombre + " ha sido envenenado");
					} else
						System.out.println("No se puede cambiar el estado, ya esta " + rival.estado);
				}else if (ataque.especie != 4)
					System.out.println("El ataque ha fallado!");
			} else if (ataque.cambioEstado.equals(Paralizar)) {
				if (rnd < ataque.precision) {
					if (rival.estado.equals(Bien)) {

						rival.setEstado(Paralizado);
						System.out.println(rival.nombre + " ha sido paralizado");
					} else
						System.out.println("No se puede cambiar el estado, ya esta " + rival.estado);
				}else if (ataque.especie != 4)
					System.out.println("El ataque ha fallado!");
			} else if (ataque.cambioEstado.equals(Dormir)) {
				if (rnd < ataque.precision) {
					if (rival.estado.equals(Bien)) {

						rival.setEstado(Dormido);
						System.out.println(rival.nombre + " ha sido dormido");
					} else
						System.out.println("No se puede cambiar el estado, ya esta " + rival.estado);
				}else if (ataque.especie != 4)
					System.out.println("El ataque ha fallado!");

			} else if (ataque.cambioEstado.equals(Curar)) {
				if (!rival.estado.equals(Bien))
					jugador.setEstado(Bien);
				else
					System.out.println("No se puede cambiar el estado, ya esta " + rival.estado);
			}

		} else
			System.out.println("No se puede cambiar el estado, ya esta " + rival.estado);
	}

	public int getDrenadoras() {
		return Drenadoras;
	}

	public void setDrenadoras(int drenadoras) {
		Drenadoras = drenadoras;
	}

	public void setTipo1(String tipo1) {
		this.tipo1 = tipo1;
	}

	public boolean equals(Pokemon p) {
		if (this.nombre != p.nombre) {
			return false;
		}
		
		if (this.ataques != p.ataques) return false;
			
		if (this.Est_ataque != p.Est_ataque) return false;
		if (this.Est_ataqueEspecial != p.Est_ataqueEspecial) return false;
		
		return true;
	}
	
}