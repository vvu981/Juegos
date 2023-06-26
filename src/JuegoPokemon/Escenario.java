package JuegoPokemon;

public class Escenario {
	
	public Jugador Jugador;
	public Jugador Rival;
	public String clima;
	
	public Escenario(String clima, Jugador Jugador, Jugador Rival) {
		super();
		this.clima = clima;
		this.Jugador = Jugador;
		this.Rival = Rival;
	}

	public String Clima;

	public String getClima() {
		return Clima;
	}

	public void setClima(String clima) {
		Clima = clima;
	}
	
	
	
}
