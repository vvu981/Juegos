package SSOO_Teoria;

public class Pregunta {

	/*
	 * Los pasos para implementar las dos clases estan en la clase Main
	 */
	
	public String pregunta;
	public String respuesta;
	
	public Pregunta(String pregunta, String respuesta) {
		this.pregunta = pregunta;
		this.respuesta = respuesta;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
}
