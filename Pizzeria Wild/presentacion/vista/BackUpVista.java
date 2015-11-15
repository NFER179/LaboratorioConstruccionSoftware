package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;

public class BackUpVista extends JDialog {

	private JButton btnRestaurar;
	private JButton btnCrearCopiaDe;

	public BackUpVista() {
		setTitle("BackUp");
		setBounds(100, 100, 308, 79);
		btnRestaurar = new JButton("Restaurar");
		getContentPane().add(btnRestaurar, BorderLayout.SOUTH);
		btnCrearCopiaDe = new JButton("Crear Copia de Seguridad");
		getContentPane().add(btnCrearCopiaDe, BorderLayout.CENTER);
	}

	public JButton getBtnRestaurar() {
		return btnRestaurar;
	}

	public void setBtnRestaurar(JButton btnRestaurar) {
		this.btnRestaurar = btnRestaurar;
	}

	public JButton getBtnCrearCopiaDe() {
		return btnCrearCopiaDe;
	}

	public void setBtnCrearCopiaDe(JButton btnCrearCopiaDe) {
		this.btnCrearCopiaDe = btnCrearCopiaDe;
	}

	public void Open() {
		this.setVisible(true);
	}

	public void Close() {
		this.setVisible(false);
	}

}
