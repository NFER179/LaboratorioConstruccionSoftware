package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class CreacionUsuarioVista extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JPasswordField txtContra1;
	private JPasswordField txtContra2;
	private JButton okButton;

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JPasswordField getTxtContra1() {
		return txtContra1;
	}

	public void setTxtContra1(JPasswordField txtContra1) {
		this.txtContra1 = txtContra1;
	}

	public JPasswordField getTxtContra2() {
		return txtContra2;
	}

	public void setTxtContra2(JPasswordField txtContra2) {
		this.txtContra2 = txtContra2;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CreacionUsuarioVista dialog = new CreacionUsuarioVista();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CreacionUsuarioVista() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblBienvenidoAPizzera = new JLabel(
					"Bienvenido a Pizzer\u00EDa Wild.");
			lblBienvenidoAPizzera.setBounds(153, 11, 127, 33);
			contentPanel.add(lblBienvenidoAPizzera);
		}

		JLabel lblPorFavorElija = new JLabel(
				"Por favor, elija su usuario y contrase\u00F1a");
		lblPorFavorElija.setBounds(125, 37, 198, 14);
		contentPanel.add(lblPorFavorElija);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(194, 81, 86, 20);
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(153, 84, 46, 14);
		contentPanel.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(135, 124, 60, 14);
		contentPanel.add(lblContrasea);

		txtContra1 = new JPasswordField();
		txtContra1.setBounds(194, 121, 86, 20);
		contentPanel.add(txtContra1);

		JLabel lblRepitaLaContrasea = new JLabel("Repita la contrase\u00F1a:");
		lblRepitaLaContrasea.setBounds(92, 166, 103, 14);
		contentPanel.add(lblRepitaLaContrasea);

		txtContra2 = new JPasswordField();
		txtContra2.setBounds(194, 163, 86, 20);
		contentPanel.add(txtContra2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Guardar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	public JButton getOkButton() {
		return okButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}

	public void Close() {
		this.setVisible(false);
	}
}
