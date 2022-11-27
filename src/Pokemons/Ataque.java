package Pokemons;

public class Ataque {
	
	public String nombre;
	public double Poder;
	public String tipo;
	public int especie;
	public int prioridad;
	public int cambAtFisicoP;
	public int cambAtEspecialP;
	public int cambDefFisicaP;
	public int cambDefEspecialP;
	public int cambVelP;
	public int cambAtFisicoR;
	public int cambAtEspecialR;
	public int cambDefFisicaR;
	public int cambDefEspecialR;
	public int cambVelR;
	public double precision;
	public double probCrit;
	public double probabCambioEstado;
	public String cambioEstado;
	public double probRetr;
	public String tipoAtaque;
	public double probabCambioEstadistica;
	public int cambPrecisionP;
	public int cambPrecisionR;
	public int PP;
	/*
	 * especie es para ver si hace daño o no
	 * 		0: No hace daño -> Sube defensa
	 * 		-1: No hace daño -> Sube ataque
	 * 		1: Hace daño
	 * 		2: No hace daño -> Sube velocidad
	 */
	public Ataque(String nombre, double poder, String tipo, int prioridad, double precision, double probCrit, double probabCambioEstado, String cambioEstado, double probabCambioEstadistica, double probRetr, String tipoAtaque,  int cambAtFisicoP, int cambAtEspecialP,  int cambDefFisicaP, int cambDefEspecialP, int cambVelP,
			 int cambAtFisicoR, int cambAtEspecialR,  int cambDefFisicaR, int cambDefEspecialR, int cambVelR, int cambPrecisionP, int cambPrecisionR, int PP) {
		super();
		this.nombre = nombre;
		Poder = poder;
		this.tipo = tipo;
		this.prioridad = prioridad;
		this.precision = precision;
		this.probCrit = probCrit;
		this.probabCambioEstado = probabCambioEstado;
		this.cambioEstado = cambioEstado;
		this.probRetr = probRetr;
		this.tipoAtaque = tipoAtaque;
		this.probabCambioEstadistica = probabCambioEstadistica;
		
		this.cambAtEspecialP = cambAtEspecialP;
		this.cambAtFisicoP = cambAtFisicoP;
		this.cambAtEspecialR = cambAtEspecialR;
		this.cambAtFisicoR = cambAtFisicoR;
		this.cambDefEspecialP = cambDefEspecialP;
		this.cambDefFisicaP = cambDefFisicaP;
		this.cambDefEspecialR = cambDefEspecialR;
		this.cambDefFisicaR = cambDefFisicaR;
		this.cambVelP = cambVelP;
		this.cambVelR = cambVelR;
		this.cambPrecisionP = cambPrecisionP;
		this.cambPrecisionR = cambPrecisionR;
		this.PP = PP;
	}
	
	public Ataque(Ataque ataque) {
		this.nombre = ataque.nombre;
		this.Poder = ataque.Poder;
		this.tipo = ataque.tipo;
		this.prioridad = ataque.prioridad;
		this.precision = ataque.precision;
		this.probCrit = ataque.probCrit;
		this.probabCambioEstado = ataque.probabCambioEstado;
		this.cambioEstado = ataque.cambioEstado;
		this.probRetr = ataque.probRetr;
		this.tipoAtaque = ataque.tipoAtaque;
		this.probabCambioEstadistica = ataque.probabCambioEstadistica;

		
		this.cambAtEspecialP = ataque.cambAtEspecialP;
		this.cambAtFisicoP = ataque.cambAtFisicoP;
		this.cambAtEspecialR = ataque.cambAtEspecialR;
		this.cambAtFisicoR = ataque.cambAtFisicoR;
		this.cambDefEspecialP = ataque.cambDefEspecialP;
		this.cambDefFisicaP = ataque.cambDefFisicaP;
		this.cambDefEspecialR = ataque.cambDefEspecialR;
		this.cambDefFisicaR = ataque.cambDefFisicaR;
		this.cambVelP = ataque.cambVelP;
		this.cambVelR = ataque.cambVelR;
		this.cambPrecisionP = ataque.cambPrecisionP;
		this.PP = ataque.PP;
		this.cambPrecisionR = ataque.cambPrecisionR;
	}

	public String getTipoAtaque() {
		return tipoAtaque;
	}
	
	
	public double getPoder() {
		return Poder;
	}

	public double getProbabCambioEstado() {
		return probabCambioEstado;
	}
	
	public void setProbabCambioEstado(double probabCambioEstado) {
		this.probabCambioEstado = probabCambioEstado;
	}
	
	public void setPoder(double poder) {
		Poder = poder;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEspecie() {
		return especie;
	}

	public void setEspecie(int especie) {
		this.especie = especie;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public double getPrecision() {
		return precision;
	}

	public void setPrecision(double precision) {
		this.precision = precision;
	}

	public double getProbCrit() {
		return probCrit;
	}

	public void setProbCrit(double probCrit) {
		this.probCrit = probCrit;
	}

	public String getCambioEstado() {
		return cambioEstado;
	}

	public void setCambioEstado(String cambioEstado) {
		this.cambioEstado = cambioEstado;
	}

	public double getProbRetr() {
		return probRetr;
	}

	public void setProbRetr(double probRetr) {
		this.probRetr = probRetr;
	}

	
	public void setTipoAtaque(String tipoAtaque) {
		this.tipoAtaque = tipoAtaque;
	}


	public int getCambAtFisicoP() {
		return cambAtFisicoP;
	}

	public void setCambAtFisicoP(int cambAtFisicoP) {
		this.cambAtFisicoP = cambAtFisicoP;
	}

	public int getCambAtEspecialP() {
		return cambAtEspecialP;
	}

	public void setCambAtEspecialP(int cambAtEspecialP) {
		this.cambAtEspecialP = cambAtEspecialP;
	}

	public int getCambDefFisicaP() {
		return cambDefFisicaP;
	}

	public void setCambDefFisicaP(int cambDefFisicaP) {
		this.cambDefFisicaP = cambDefFisicaP;
	}

	public int getCambDefEspecialP() {
		return cambDefEspecialP;
	}

	public void setCambDefEspecialP(int cambDefEspecialP) {
		this.cambDefEspecialP = cambDefEspecialP;
	}

	public int getCambVelP() {
		return cambVelP;
	}

	public void setCambVelP(int cambVelP) {
		this.cambVelP = cambVelP;
	}

	public int getCambAtFisicoR() {
		return cambAtFisicoR;
	}

	public void setCambAtFisicoR(int cambAtFisicoR) {
		this.cambAtFisicoR = cambAtFisicoR;
	}

	public int getCambAtEspecialR() {
		return cambAtEspecialR;
	}

	public void setCambAtEspecialR(int cambAtEspecialR) {
		this.cambAtEspecialR = cambAtEspecialR;
	}

	public int getCambDefFisicaR() {
		return cambDefFisicaR;
	}

	public void setCambDefFisicaR(int cambDefFisicaR) {
		this.cambDefFisicaR = cambDefFisicaR;
	}

	public int getCambDefEspecialR() {
		return cambDefEspecialR;
	}

	public void setCambDefEspecialR(int cambDefEspecialR) {
		this.cambDefEspecialR = cambDefEspecialR;
	}

	public int getCambVelR() {
		return cambVelR;
	}

	public void setCambVelR(int cambVelR) {
		this.cambVelR = cambVelR;
	}

	public double getProbabCambioEstadistica() {
		return probabCambioEstadistica;
	}

	public void setProbabCambioEstadistica(double probabCambioEstadistica) {
		this.probabCambioEstadistica = probabCambioEstadistica;
	}

	public int getCambPrecisionP() {
		return cambPrecisionP;
	}

	public void setCambPrecisionP(int cambPrecisionP) {
		this.cambPrecisionP = cambPrecisionP;
	}

	public int getCambPrecisionR() {
		return cambPrecisionR;
	}

	public void setCambPrecisionR(int cambPrecisionR) {
		this.cambPrecisionR = cambPrecisionR;
	}

	public int getPP() {
		return PP;
	}

	public void setPP(int pP) {
		this.PP = pP;
	}
}