package InterfazGrafica;

import java.awt.event.ActionEvent;

public interface ActionListener {

	public default void actionPerformed(ActionEvent e) {
		System.out.println("Se ha producido una accion");
	}
	
}
