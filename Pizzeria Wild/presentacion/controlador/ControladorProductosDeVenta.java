package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import utilidades.Msj;
import utilidades.Str;
import validacionesCampos.Valida;
import vista.ProductosDeVentasVista;
import dto.SaborDTO;
import modelo.*;

public class ControladorProductosDeVenta implements ActionListener {

	private ProductosDeVentasVista vtProPe;
	private List<SaborDTO> lstProducto;
	private SaborModelo mdlSabor;
	private ProductoModelo mdlProducto;
	private ControladorArmadoVenta ctrAP;

	public ControladorProductosDeVenta(ControladorArmadoVenta CtrAP,
			JDialog Dialog) {
		this.vtProPe = new ProductosDeVentasVista(Dialog);

		addListeners();

		this.ctrAP = CtrAP;
		this.mdlSabor = new SaborModelo();
		this.mdlProducto = new ProductoModelo();
	}

	public void Iniciar() {
		this.vtProPe.Open();
	}

	public void CargarProducto(String Producto) {
		this.vtProPe.getTxtIdproducto().setText(Producto);
		String descripcion = this.mdlProducto.ObtenerDescr(Producto);
		this.vtProPe.getTxtDescrProducto().setText(descripcion);
	}

	/** JNVR - Clean code */
	public void ActualizarTabla() {
		ProductosDeVentasVista vista = this.vtProPe;
		DefaultTableModel tabla = vista.getModelSabores();
		tabla.setRowCount(0);
		tabla.setColumnCount(0);
		tabla.setColumnIdentifiers(vista.getNombreColunmnas());
		String textoIdProducto = vista.getTxtIdproducto().getText();
		this.lstProducto = this.mdlSabor.GetSabores(textoIdProducto);
		for (SaborDTO sabor : this.lstProducto) {
			Object[] fila = { sabor.getNombre(), sabor.getPrecio() };
			vista.getModelSabores().addRow(fila);
		}
		this.vtProPe.getTable().setModel(tabla);
	}

	public void ActualizarTablaOLD() {
		this.vtProPe.getModelSabores().setRowCount(0);
		this.vtProPe.getModelSabores().setColumnCount(0);
		this.vtProPe.getModelSabores().setColumnIdentifiers(
				this.vtProPe.getNombreColunmnas());
		this.lstProducto = this.mdlSabor.GetSabores(this.vtProPe
				.getTxtIdproducto().getText());
		for (SaborDTO sabor : this.lstProducto) {
			Object[] fila = { sabor.getNombre(), sabor.getPrecio() };
			this.vtProPe.getModelSabores().addRow(fila);
		}
		this.vtProPe.getTable().setModel(this.vtProPe.getModelSabores());
	}

	/**
	 * JNVR - Lo dejo para que vean lo criptico que es. Anda a encontrar un bug
	 * aca ¬¬
	 */
	public void actionPerformedOLD(ActionEvent arg0) {
		if (arg0.getSource() == this.vtProPe.getBtnBusqueda()) {
			accionBuscar();
		} else if (arg0.getSource() == this.vtProPe.getBtnAceptar()) {
			/* Si selccciona una fila y pone un cantidad */
			if (!this.vtProPe.getTxtIdproducto().getText().trim().equals("")) {
				if (this.vtProPe.getTable().getSelectedRow() >= 0) {
					// JNVR REVISA DOS VECES LO MISMO!
					// SI la cantidad tiene texto...
					if (this.vtProPe.getTxtCantidad().getText().trim().length() > 0) {
						// Si la cantidad es un entero positivo...
						if (Valida.esEnteroPositivo(vtProPe.getTxtCantidad()
								.getText())) {
							// LA CLASE QUE VALIDA HACE LAS DOS COSAS DE UNA
							// VEZ.
							// NO HACE FALTA PREGUNTAR POR LOS DOS
							this.ctrAP.AgregarProducto(
									this.vtProPe.getTxtIdproducto().getText(),
									this.vtProPe
											.getTable()
											.getValueAt(
													this.vtProPe.getTable()
															.getSelectedRow(),
													0).toString(),
									Integer.parseInt(this.vtProPe
											.getTxtCantidad().getText()));
							this.vtProPe.Close();
						} else {
							JOptionPane.showMessageDialog(null,
									"Debe Ingresar una cantidad valida",
									"Error Formato Cantidad",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Debe ingresar una cantidad.",
								"Error Cantidad", JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Debe seleccionar sabor.", "Error seleccion sabor",
							JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Debe seleccionar un producto.",
						"Error de seleccion de producto.",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (arg0.getSource() == this.vtProPe.getBtnCancelar()) {
			this.vtProPe.Close();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		ProductosDeVentasVista vista = this.vtProPe;
		if (source == vista.getBtnBusqueda()) {
			accionBuscar();
		} else if (source == vista.getBtnAceptar()) {
			accionAceptar();
		} else if (source == vista.getBtnCancelar()) {
			vista.Close();
		} else {
			System.out.println("Estado Ilegal");
		}
	}

	/**
	 * JNVR - Es invocado cuando se quiere agregar un producto a una venta. En
	 * caso de que se cumplan las siguientes condiciones se agrega un producto a
	 * la venta: (1) Selecciono un producto. (2) Tenga un sabor marcado. (3)
	 * Tenga una cantidad (valida) ingresada.
	 */
	private void accionAceptar() {
		ProductosDeVentasVista vista = this.vtProPe;
		String textoIdProducto = Str.trim(vista.getTxtIdproducto().getText());
		boolean tengoProducto = !Valida.esNullOVacio(textoIdProducto);
		if (tengoProducto) {
			revisarSaborMarcado();
		} else
			Msj.error("Error de seleccion de producto.",
					"Debe seleccionar un producto.");
	}

	/**
	 * JNVR - Revisa que se haya mancado un sabor, muestra un mensaje de error
	 * en caso negativo
	 */
	private void revisarSaborMarcado() {
		ProductosDeVentasVista vista = this.vtProPe;
		boolean tengoSaborElegido = vista.getTable().getSelectedRow() >= 0;
		if (tengoSaborElegido) {
			revisarCantidadIngresada();
		} else {
			Msj.advertencia("Error seleccion sabor", "Debe seleccionar sabor.");
		}
	}

	/**
	 * JNVR - Revisa que la cantidad ingresada es un numero entero positivo,
	 * muestra un mensaje de error en caso opuesto.
	 */
	private void revisarCantidadIngresada() {
		ProductosDeVentasVista vista = this.vtProPe;
		String textoCantidad = vista.getTxtCantidad().getText();
		boolean ingresoCantidad = Valida.esEnteroPositivo(textoCantidad);
		if (ingresoCantidad) {
			agregarProducto();
		} else {
			Msj.error("Error Formato Cantidad",
					"Debe Ingresar una cantidad valida");
		}
	}

	/**
	 * JNVR - Por contrato, todos los campos deben estar en correcto formato
	 * para su correcto funcionamiento
	 */
	private void agregarProducto() {
		ProductosDeVentasVista vista = this.vtProPe;
		JTable tabla = vista.getTable();

		int numColumnaSabor = 0;
		int numFilaMarcada = tabla.getSelectedRow();

		String producto = Str.trim(vista.getTxtIdproducto().getText());
		String sabor = Str.trim(tabla.getValueAt(numFilaMarcada,
				numColumnaSabor));
		int cantidad = Str.toInt(this.vtProPe.getTxtCantidad().getText());

		this.ctrAP.AgregarProducto(producto, sabor, cantidad);
		vista.Close();
	}

	/** JNVR - Construye el controlador de busqueda de productos y lo inicializa */
	private void accionBuscar() {
		ControladorProductoBusqueda cpb = new ControladorProductoBusqueda(this,
				this.vtProPe);
		cpb.Iniciar();
	}

	private void addListeners() {
		this.vtProPe.getBtnBusqueda().addActionListener(this);
		this.vtProPe.getBtnAceptar().addActionListener(this);
		this.vtProPe.getBtnCancelar().addActionListener(this);
	}
}