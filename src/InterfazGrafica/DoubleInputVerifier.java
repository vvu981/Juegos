package InterfazGrafica;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

public class DoubleInputVerifier extends InputVerifier{

	@Override
	public boolean verify(JComponent input) {
		String text = ((JTextComponent) input).getText();
		try {
			Double.parseDouble(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
}
