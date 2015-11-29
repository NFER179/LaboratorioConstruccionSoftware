package vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class BackUpVista extends JDialog {
	private static final long serialVersionUID = 1L;
	private JButton btnRestaurar;
	private JButton btnCrearCopiaDe;

	public BackUpVista() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				BackUpVista.class.getResource("/Iconos/pizza_1.PNG")));
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("BackUp");
		setBounds(100, 100, 419, 255);
		getContentPane().setLayout(null);
		btnRestaurar = new JButton("Restaurar");
		btnRestaurar.setBounds(165, 115, 220, 80);
		btnRestaurar.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(btnRestaurar);
		btnCrearCopiaDe = new JButton("Crear Copia de Seguridad");
		btnCrearCopiaDe.setBounds(165, 24, 220, 80);
		btnCrearCopiaDe.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCrearCopiaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getContentPane().add(btnCrearCopiaDe);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BackUpVista.class
				.getResource("/Iconos/Database.png")));
		lblNewLabel.setBounds(23, 24, 96, 158);
		getContentPane().add(lblNewLabel);
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
