package InterfazGrafica;

import java.awt.FlowLayout;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

public class Prueba_InterfazGrafica {
  public static void main (String[] args) {
    JFrame frame = new JFrame("Introduce un n�mero"); // Creamos un nuevo marco
    frame.setLayout(new FlowLayout()); // Establecemos un esquema de dise�o para el marco

    NumberFormatter formatter = new NumberFormatter(); // Creamos un formateador de n�meros
    formatter.setValueClass(Double.class); // Establecemos el tipo de clase de los valores que se pueden introducir en el campo de texto
    formatter.setMinimum(0.0); // Establecemos el valor m�nimo que se puede introducir en el campo de texto
    formatter.setMaximum(Double.MAX_VALUE); // Establecemos el valor m�ximo que se puede introducir en el campo de texto

    JTextField textField = new JTextField(10); // Creamos un campo de texto de 10 columnas
    AbstractDocument document = new NumberFormatterDocument(formatter); // Creamos un nuevo documento con el formateador de n�meros
    textField.setDocument(document); // Establecemos el tipo de contenido del campo de texto como double

    JLabel label = new JLabel("El n�mero introducido es: "); // Creamos una etiqueta
    label.setText(textField.getText()); // Establecemos el valor del campo de texto en la etiqueta

    frame.add(textField); // A�adimos el campo de texto al marco
    frame.add(label); // A�adimos la etiqueta al marco
    frame.pack(); // Empaquetamos el marco
    frame.setVisible(true); // Hacemos que el marco sea visible
  }
}