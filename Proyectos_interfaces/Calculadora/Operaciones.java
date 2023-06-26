package Calculadora;

public class Operaciones {

	public double Sumar(double num1, double num2) {
		return num1+num2;
	}
	
	public double Restar(double num1, double num2) {
		return num1-num2;
	}
	
	public double Mult(double num1, double num2) {
		return num1*num2;
	}
	
	public String Div(double num1, double num2) {
		if (num2!=0) return "" + num1/num2;
		else return "Error: No se puede dividir por 0";
	}
	
	public String Ec(double num1, double num2, double num3) {
		double raiz = num2*num2-4*num1*num3;
		
		if (raiz >= 0) {
			double resultado1 = (-num2+Math.sqrt(raiz))/(2*num1);
			double resultado2 = (-num2-Math.sqrt(raiz))/(2*num1);
			if (resultado1 != resultado2) {
				return "x = " + resultado1 + ", x = " + resultado2;
			} else 
				return "x = " + resultado1;
		} else return "Error";
	}
}
