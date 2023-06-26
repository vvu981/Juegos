package Calculadora_Interfaz;

public class OperacionesMatematicas {

	public double Suma(double num1, double num2) {
		return (num1 + num2);
	}

	public double Resta(double num1, double num2) {
		return (num1 - num2);
	}

	public double Mult(double num1, double num2) {
		return (num1 * num2);
	}

	public String Div(double num1, double num2) {
		if (num2 != 0)
			return "" + num1 / num2;
		else
			return "No se puede dividir entre 0";
	}

}
