package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import backUp.BackUp;

import utilidades.Msj;
import vista.BackUpVista;
import vista.VentasVista;

public class ControladorBackUp implements ActionListener {

	private BackUpVista vista;
	private String extension = ".sql";
	@SuppressWarnings("unused")
	private VentasVista vtVentas;

	public ControladorBackUp(VentasVista vtVenta) {
		this.vtVentas = vtVenta;
		this.vista = new BackUpVista();
		addListeners();
	}

	public void Inicializar() {
//		this.vtVentas.Close();
		this.vista.Open();
	}

	private void addListeners() {
		this.vista.getBtnCrearCopiaDe().addActionListener(this);
		this.vista.getBtnRestaurar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (source == vista.getBtnCrearCopiaDe()) {
			accionBackUp();
		} else if (source == vista.getBtnRestaurar()) {
			accionRestaurar();
		} else {
			System.out.println("Estado ilegal");
		}
	}

	private void accionRestaurar() {
		try {
			String path = abrir();

			if (path != null && path != "") {
				int respuesta = JOptionPane
						.showConfirmDialog(
								null,
								"¿Esta seguro de restaurar los datos de la apliacacion?",
								"Restaurar base de datos",
								JOptionPane.YES_NO_OPTION);

				if (respuesta == JOptionPane.YES_OPTION) {
					BackUp.restore(path);
					Msj.info("Informacion",
							"Back Up realizado correctamente, debe reiniciar la aplicacion");
					this.vista.Close();
				} else
					return;

			}
		} catch (Exception e) {
			Msj.error("Error", "Error inesperado al restaurar el backup");
		}
	}

	private void accionBackUp() {
		try {
			String path = guardar();
			if (path != null) {
				if (path != "") {
					BackUp.backUp(path);
					Msj.info("Exito",
							"Copia de seguridad realizada correctamente");

				} else {
					Msj.error("Error de extension",
							"El backUp debe guardarse en un archivo .sql");
				}
			}
		} catch (Exception e) {
			Msj.error("Error", "Error inesperado al generar el backup");
		}
	}

	private String abrir() {
		String path = "";
		JFileChooser file = getFileChooser();
		int estado = file.showOpenDialog(this.vista);
		if (estado == JFileChooser.APPROVE_OPTION) {
			path = getPath(file);
			if (!path.contains(extension)) {
				return "";
			} else {
				// path += extension;
				return path;
			}
		}
		return null;
	}

	private String guardar() {
		String path = "";
		JFileChooser file = getFileChooser();
		int estado = file.showSaveDialog(this.vista);
		if (estado == JFileChooser.APPROVE_OPTION) {
			path = getPath(file);
			if ((path.contains(".") && !path.contains(extension))
					|| masDeUnPunto(path)) {
				file.cancelSelection();
				return "";
			}
			path = (path.contains(extension)) ? path : path + extension;
			return path;
		}
		return null;
	}

	private JFileChooser getFileChooser() {
		JFileChooser file = new JFileChooser();
		FileFilter filtro = new FileNameExtensionFilter("TEXT FILES", "sql");
		file.setFileFilter(filtro);
		return file;
	}

	private String getPath(JFileChooser file) {
		String path;
		path = file.getSelectedFile().getAbsolutePath();
		return path;
	}

	private boolean masDeUnPunto(String path) {
		return contadorPuntos(path) > 1;
	}

	private int contadorPuntos(String path) {
		int ret = 0;
		for (int i = 0; i < path.length(); i++)
			if (path.charAt(i) == '.')
				ret++;
		return ret;
	}
}
