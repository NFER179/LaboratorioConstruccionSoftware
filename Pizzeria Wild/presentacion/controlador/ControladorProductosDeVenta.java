package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import utilidades.Msj;
import utilidades.Str;
import validacionesCampos.Valida;
import vista.ArmadoVentaVista;
import vista.ProductosDeVentasVista;
import dto.SaborDTO;
import modelo.*;

public class ControladorProductosDeVenta implements ActionListener {

	private ProductosDeVentasVista vtProPe;
	private List<SaborDTO> lstProducto;
	private SaborModelo mdlSabor;
	private ProductoModelo mdlProducto;
	private ControladorArmadoVenta ctrAP;
	private ArmadoVentaVista vtArmadoVenta;

	public ControladorProductosDeVenta(ControladorArmadoVenta CtrAP,
			ArmadoVentaVista vista) {
		this.vtArmadoVenta = vista;
		this.vtProPe = new ProductosDeVentasVista(vista);

		addListeners();

		this.ctrAP = CtrAP;
		this.mdlSabor = new SaborModelo();
		this.mdlProducto = new ProductoModelo();
	}

	public void Iniciar() {
		this.vtArmadoVenta.Close();
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
		this.lstProducto = this.mdlSabor.ObtenerSabores(textoIdProducto);
		for (SaborDTO sabor : this.lstProducto) {
			Object[] fila = { sabor.getNombre(), sabor.getPrecio() };
			vista.getModelSabores().addRow(fila);
		}
		this.vtProPe.getTable().setModel(tabla);
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
			this.vtArmadoVenta.Open();
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
		this.vtArmadoVenta.Open();
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