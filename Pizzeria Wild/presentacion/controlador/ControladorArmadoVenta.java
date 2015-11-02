package controlador;

import utilidades.Fecha;
import utilidades.Msj; 
import validacion.ValidacionArmadoPedido; 
import vista.ArmadoVentaVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import javax.swing.JFrame;
import javax.swing.JTable; 

import modelo.VentaModelo;
import modelo.SaborModelo;

import dto.ClienteDTO;
import dto.VentaDTO;
import dto.ProductoEnVentaDTO;

public class ControladorArmadoVenta implements ActionListener {

	private ArmadoVentaVista vtArmadoPedido;
	private ControladorVenta ctrPedido;
	private SaborModelo mdlSabor;
	private VentaModelo mdlPedido;
	private ControladorVentasCocina ctrPedidoCocina;
	private ValidacionArmadoPedido vldArmado;

	public ControladorArmadoVenta(ControladorVenta ControladorPedido,
			JFrame Frame) {
		this.vtArmadoPedido = new ArmadoVentaVista(Frame);
		this.vtArmadoPedido.getTxtNumVenta().setText("NEXT");
		this.vtArmadoPedido.getBtnBusquedaCliente().addActionListener(this);
		this.vtArmadoPedido.getBtnAgregar().addActionListener(this);
		this.vtArmadoPedido.getBtnQuitar().addActionListener(this);
		this.vtArmadoPedido.getChckbxDelivery().addActionListener(this);
		this.vtArmadoPedido.getBtnArmar().addActionListener(this);
		this.vtArmadoPedido.getBtnCancelar().addActionListener(this);

		this.ctrPedido = ControladorPedido;
		this.mdlSabor = new SaborModelo();
		this.mdlPedido = new VentaModelo();
		this.ctrPedidoCocina = ControladorVentasCocina.GetInstancia();
		this.vldArmado = new ValidacionArmadoPedido(this.vtArmadoPedido);
	}

	public ControladorArmadoVenta(ControladorVenta ControladorPedido,
			JFrame Frame, String Fecha, int NumPedido) {
		this.vtArmadoPedido = new ArmadoVentaVista(Frame);
		this.vtArmadoPedido.getTxtFecha().setText(Fecha);
		this.vtArmadoPedido.getTxtNumVenta().setText(
				Integer.toString(NumPedido));

		this.vtArmadoPedido.getBtnBusquedaCliente().setEnabled(false);
		this.vtArmadoPedido.getBtnAgregar().addActionListener(this);
		this.vtArmadoPedido.getBtnQuitar().addActionListener(this);
		this.vtArmadoPedido.getChckbxDelivery().addActionListener(this);
		this.vtArmadoPedido.getBtnArmar().addActionListener(this);
		this.vtArmadoPedido.getBtnCancelar().addActionListener(this);

		this.ctrPedido = ControladorPedido;
		this.mdlSabor = new SaborModelo();
		this.mdlPedido = new VentaModelo();
		this.ctrPedidoCocina = ControladorVentasCocina.GetInstancia();
		this.vldArmado = new ValidacionArmadoPedido(this.vtArmadoPedido);
	}

	public void Inicializar() {
		/* ver de cambiar el pedido. */
		if (this.vtArmadoPedido.getTxtNumVenta().getText().equals("NEXT")) {
			this.CargarFecha();
			this.vtArmadoPedido.Open();
		} else {
			this.CargarPedido();
			this.vtArmadoPedido.Open();
		}
	}
	
	public void InicializarInformacion() {
		this.CargarPedido();
		this.AbrirModoInformacion();
		this.vtArmadoPedido.Open();
	}

	private void AbrirModoInformacion() {
		this.vtArmadoPedido.getTxtCliente().setEnabled(false);
		this.vtArmadoPedido.Quitar(this.vtArmadoPedido.getBtnBusquedaCliente());
		this.vtArmadoPedido.Quitar(this.vtArmadoPedido.getBtnAgregar());
		this.vtArmadoPedido.Quitar(this.vtArmadoPedido.getBtnQuitar());
		this.vtArmadoPedido.getTxtPrecio().setEnabled(false);
		this.vtArmadoPedido.getChckbxDelivery().setEnabled(false);
		this.vtArmadoPedido.getTxtDireccion().setEnabled(false);
		this.vtArmadoPedido.getTxtrObservacionDelivery().setEnabled(false);
		this.vtArmadoPedido.getTxtTel().setEnabled(false);
		this.vtArmadoPedido.getTxtrObservacion().setEnabled(false);
		this.vtArmadoPedido.Quitar(this.vtArmadoPedido.getBtnArmar());
		
		this.vtArmadoPedido.getBtnCancelar().setText("Volver");
	}

	private void CargarFecha() {
		this.vtArmadoPedido.getTxtFecha().setText(Fecha.CurrentDate());
		this.vtArmadoPedido.getTxtHora().setText(Fecha.CurrentTime());
	}

	private void CargarPedido() {
		String fechaVenta = this.vtArmadoPedido.getTxtFecha().getText().trim();
		String numVenta = this.vtArmadoPedido.getTxtNumVenta().getText().trim();
		int numeroPedido = Integer.parseInt(numVenta);
		VentaDTO nuevaVenta = this.mdlPedido.GetVenta(fechaVenta, numeroPedido);

		this.vtArmadoPedido.getTxtFecha().setText(nuevaVenta.getFecha());
		this.vtArmadoPedido.getTxtHora().setText(nuevaVenta.getHora());
		this.vtArmadoPedido.getTxtCliente().setText(nuevaVenta.getCliente());
		this.vtArmadoPedido.getTxtCliente().setEnabled(false);
		this.vtArmadoPedido.getChckbxDelivery().setSelected(
				nuevaVenta.isDelivery());
		this.vtArmadoPedido.getTxtDireccion()
				.setText(nuevaVenta.getDireccion());
		this.vtArmadoPedido.getTxtTel().setText(nuevaVenta.getTel());
		this.vtArmadoPedido.getTxtrObservacion().setText(
				nuevaVenta.getObservacion());

		/* Carga la tabla de los prductos. */
		this.vtArmadoPedido.getModelProductos().setRowCount(0);
		this.vtArmadoPedido.getModelProductos().setColumnCount(0);
		this.vtArmadoPedido.getModelProductos().setColumnIdentifiers(
				this.vtArmadoPedido.getNombreColumnas());
		for (ProductoEnVentaDTO pp : nuevaVenta.getProductos()) {
			int PrecioUnidad = this.mdlSabor.GetPrecio(pp.getProducto(),
					pp.getSabor());
			Object[] fila = {
					pp.getProducto(),
					pp.getSabor(),
					pp.getCantidad(),
					this.AgregarMoneda(Integer.toString(PrecioUnidad)),
					this.AgregarMoneda(Integer.toString(pp.getCantidad()
							* PrecioUnidad)) };
			this.vtArmadoPedido.getModelProductos().addRow(fila);
		}
		this.vtArmadoPedido.getTblProductos().setModel(
				this.vtArmadoPedido.getModelProductos());

		this.ActualizarPrecio();
	}

	public void CargarDatosCliente(ClienteDTO Cliente) {
		this.vtArmadoPedido.getTxtCliente().setText(
				Cliente.getApellido() + " " + Cliente.getNombre());
		this.vtArmadoPedido.getTxtDireccion().setText(Cliente.getDireccion());
		this.vtArmadoPedido.getTxtTel().setText(Cliente.getTel());
	}

	private boolean ProductoNoAgregado(String Producto, String Sabor,
			int Cantidad) {
		boolean productoNoAgregado = true;
		/** -> Inicio, NVR,04/10/2015 refactor */
		JTable tblProductos = this.vtArmadoPedido.getTblProductos();
		int cantidadFilas = tblProductos.getRowCount();
		for (int i = 0; i < cantidadFilas; i++) {

			String valorProducto = tblProductos.getValueAt(i, 0).toString()
					.trim();
			boolean productoRepetido = valorProducto.equals(Producto);
			String valorSabor = tblProductos.getValueAt(i, 1).toString().trim();
			boolean saborRepetido = valorSabor.equals(Sabor);
			if (productoRepetido && saborRepetido) {
				this.SumarProductos(i, Cantidad);
				productoNoAgregado = false;
			}
			// if (this.vtArmadoPedido.getTblProductos().getValueAt(i, 0)
			// .toString().equals(Producto))
			// if (this.vtArmadoPedido.getTblProductos().getValueAt(i, 1)
			// .toString().endsWith(Sabor)) {
			// productoAgregado = true;
			// }
			/** <- Fin, NVR,04/10/2015 refactor */
		}
		this.ActualizarPrecio();
		return productoNoAgregado;
	}

	private void SumarProductos(int Fila, int Cantidad) {
		/* Suma Cantidades. */
		JTable table = this.vtArmadoPedido.getTblProductos();
		int cantidadVieja = Integer.parseInt(table.getValueAt(Fila, 2)
				.toString().trim());
		String CantidadActual = Integer.toString(Cantidad + cantidadVieja);
		table.setValueAt(CantidadActual, Fila, 2);
		/* Calcula el precio de las cantidades por el precio unitario. */
		int precioPorCantidad = Integer.parseInt(this.QuitarMoneda(table
				.getValueAt(Fila, 3).toString().trim()))
				* Integer.parseInt(CantidadActual);
		table.setValueAt(
				this.AgregarMoneda(Integer.toString(precioPorCantidad)), Fila,
				4);
	}

	/**
	 * -> Inicio, Nicolas Fernandez, 07-Oct-2015, Se comenta porque se pone toda
	 * la funcionalidad de sumar productos ya cargados dentro del mismo ciclo
	 * para no estar haciendo ciclo inecesarios.
	 */
	// private void SumarCantidades(String Producto, String Sabor, int cantidad)
	// {
	// /** -> Inicio, NVR,04/10/2015 refactor */
	//
	// int filas = this.vtArmadoPedido.getTblProductos().getRowCount();
	// for (int i = 0; i < filas; i++) {
	// SumarProductos(Producto, Sabor, cantidad, i);
	// }
	// // for (int i = 0; i < tblProductos.getRowCount(); i++) {
	// // if (tblProductos.getValueAt(i, 0).toString().equals(Producto))
	// // if (tblProductos.getValueAt(i, 1).toString().endsWith(Sabor)) {
	// // int oldPrecio = Integer.parseInt(this.vtArmadoPedido
	// // .getTblProductos().getValueAt(i, 2).toString());
	// // int precioFinal = oldPrecio + cantidad;
	// // this.vtArmadoPedido.getTblProductos().setValueAt(
	// // Integer.toString(precioFinal), i, 2);
	// // }
	// // }
	// /** <- Fin, NVR,04/10/2015 refactor */
	// }
	//
	// private void SumarProductos(String Producto, String Sabor, int cantidad,
	// int i) {
	// JTable tblProductos = this.vtArmadoPedido.getTblProductos();
	// String valorActual = tblProductos.getValueAt(i, 0).toString();
	// boolean tieneRepetido = valorActual.equals(Producto);
	// if (tieneRepetido && valorActual.endsWith(Sabor)) {
	// int oldPrecio = Integer.parseInt(tblProductos.getValueAt(i, 2)
	// .toString());
	// String precioFinal = (oldPrecio + cantidad) + "";
	// tblProductos.setValueAt(precioFinal, i, 2);
	// }
	// }
	/** <- Fin, Nicolas Fernandez, 07-Oct-2015. **/

	public void AgregarProducto(String Producto, String Sabor, int Cantidad) {
		int PreUnid = this.mdlSabor.GetPrecio(Producto, Sabor);
		if (this.ProductoNoAgregado(Producto, Sabor, Cantidad)) {
			Object[] fila = { Producto, Sabor, Integer.toString(Cantidad),
					this.AgregarMoneda(Integer.toString(PreUnid)),
					this.AgregarMoneda(Integer.toString(Cantidad * PreUnid)) };
			this.vtArmadoPedido.getModelProductos().addRow(fila);
			this.vtArmadoPedido.getTblProductos().setModel(
					this.vtArmadoPedido.getModelProductos());
		}
		ActualizarPrecio();
	}

	private void ActualizarPrecio() {
		int precio = 0;
		/** -> Inicio, NVR,04/10/2015 refactor */
		JTable tblProducto = this.vtArmadoPedido.getTblProductos();
		int filas = tblProducto.getRowCount();
		for (int i = 0; i < filas; i++) {
			String nuevoPrecio = tblProducto.getValueAt(i, 4).toString();
			precio += Integer.parseInt(this.QuitarMoneda(nuevoPrecio));
		}
		/** <- Fin, NVR,04/10/2015 refactor */
		// this.vtArmadoPedido.getTblProductos().getRowCount(); i++) {
		// precio = precio
		// + Integer.parseInt(this.vtArmadoPedido.getTblProductos()
		// .getValueAt(i, 4).toString());
		// }
		this.vtArmadoPedido.getTxtPrecio().setText(
				this.AgregarMoneda(Integer.toString(precio)));
	}

	private void QuitarProducto() {
		int[] FilasBorrar = this.vtArmadoPedido.getTblProductos()
				.getSelectedRows();
		for (int i = FilasBorrar.length - 1; i >= 0; i--) {
			this.vtArmadoPedido.getModelProductos().removeRow(FilasBorrar[i]);
		}
		this.vtArmadoPedido.getTblProductos().setModel(
				this.vtArmadoPedido.getModelProductos());
		ActualizarPrecio();
	}

	private boolean CheckDelivery() {
		if (this.vtArmadoPedido.getChckbxDelivery().isSelected())
			return true;
		else
			return false;
	}

	private void ArmarPedido() {
		if (this.vtArmadoPedido.getTxtNumVenta().getText().equals("NEXT")) {
			String fecha = this.vtArmadoPedido.getTxtFecha().getText().trim();
			int numPedido = this.mdlPedido.GetNuevoNumeroVenta();
			this.vtArmadoPedido.getTxtNumVenta().setText(Integer.toString(numPedido));
			
			VentaDTO NewPedido = new VentaDTO(fecha, numPedido,
					this.vtArmadoPedido.getTxtCliente().getText(),
					this.vtArmadoPedido.getTxtDireccion().getText(),
					this.vtArmadoPedido.getTxtTel().getText(),
					Integer.parseInt(this.QuitarMoneda(this.vtArmadoPedido.getTxtPrecio().getText().trim())),
					this.vtArmadoPedido.getTxtHora().getText(), "Pendiente",
					this.vtArmadoPedido.getTxtrObservacion().getText(),
					CheckDelivery(), this.vtArmadoPedido.getTxtrObservacionDelivery().getText());

			for (int i = 0; i < this.vtArmadoPedido.getModelProductos().getRowCount(); i++) {
				NewPedido.agregarProducto(this.vtArmadoPedido.getTblProductos().getValueAt(i, 0).toString(),
						this.vtArmadoPedido.getTblProductos().getValueAt(i, 1).toString(),
						Integer.parseInt(this.vtArmadoPedido.getTblProductos().getValueAt(i, 2).toString()));
			}
			this.mdlPedido.AgregarVenta(NewPedido);
		} else {
			VentaDTO OldPedido = new VentaDTO(this.vtArmadoPedido.getTxtFecha()
					.getText().trim(), Integer.parseInt(this.vtArmadoPedido
					.getTxtNumVenta().getText().trim()), this.vtArmadoPedido
					.getTxtCliente().getText().trim(), this.vtArmadoPedido
					.getTxtDireccion().getText().trim(), this.vtArmadoPedido
					.getTxtTel().getText().trim(), Integer.parseInt(this
					.QuitarMoneda(this.vtArmadoPedido.getTxtPrecio().getText()
							.trim())), this.vtArmadoPedido.getTxtHora()
					.getText().trim(), "Pendiente", this.vtArmadoPedido
					.getTxtrObservacion().getText().trim(), CheckDelivery(),
					this.vtArmadoPedido.getTxtrObservacionDelivery().getText()
							.trim());

			for (int i = 0; i < this.vtArmadoPedido.getModelProductos().getRowCount(); i++) {
				OldPedido.agregarProducto(this.vtArmadoPedido.getTblProductos().getValueAt(i, 0).toString(),
						this.vtArmadoPedido.getTblProductos().getValueAt(i, 1).toString(),
						Integer.parseInt(this.vtArmadoPedido.getTblProductos().getValueAt(i, 2).toString()));
			}
			this.mdlPedido.ModificarVenta(OldPedido);
		}
	}

	private String AgregarMoneda(String Precio) {
		return "$ " + Precio;
	}

	private String QuitarMoneda(String Precio) {
		return Precio.replace("$", "").trim();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		/* Boton para realizar la busqueda de clientes. */
		if (arg0.getSource() == this.vtArmadoPedido.getBtnBusquedaCliente()) {

			ControladorBusquedaCliente ctrBusquedaCliente = new ControladorBusquedaCliente(
					this, this.vtArmadoPedido);
			ctrBusquedaCliente.Iniciar();
			/* Boton para agregar productos. */
		} else if (arg0.getSource() == this.vtArmadoPedido.getBtnAgregar()) {
			ControladorProductosDeVenta ctrPP = new ControladorProductosDeVenta(
					this, this.vtArmadoPedido);
			ctrPP.Iniciar();
			/* Boton para quitar productos. */
		} else if (arg0.getSource() == this.vtArmadoPedido.getBtnQuitar()) {
			if (vtArmadoPedido.getTblProductos().getSelectedRows().length < 1)
				Msj.error("Error Borrar Producto",
						"No hay Productos para eliminar");
			// JOptionPane.showMessageDialog(null,
			// "No hay Productos para eliminar",
			// "Error Borrar Producto", JOptionPane.WARNING_MESSAGE);
			else {
				QuitarProducto();
			}
			/* Verifica si la venta es a domicilio. */
		} else if (arg0.getSource() == this.vtArmadoPedido.getChckbxDelivery()) {
			this.PresionarCheck();
			/* Boton para terminar con el armado de la venta. */
		} else if (arg0.getSource() == this.vtArmadoPedido.getBtnArmar()) {
			// if (!vtArmadoPedido.getTxtCliente().getText().equals("")
			// && !vtArmadoPedido.getTxtDireccion().getText().equals("")
			// && !vtArmadoPedido.getTxtDireccion().getText().equals("")) {
			// if (this.vtArmadoPedido.getModelProductos().getRowCount() > 0) {
			// this.ArmarPedido();
			// this.ctrPedido.RecargarTabla();
			// this.ctrPedidoCocina.RecargarTablas();
			// this.vtArmadoPedido.Close();
			// } else {
			// JOptionPane.showMessageDialog(null,
			// "Debe Ingresar al Menos un Producto.");
			// }
			// } else {
			// JOptionPane.showMessageDialog(null,
			// "Ingrese un cliente nuevo o seleccione uno existente");
			// }
			if(this.vldArmado.ArmadoValido()){
				accionArmar();
			}
			/* Boton para salir del armado de la venta, sin crearla. */
		} else if (arg0.getSource() == this.vtArmadoPedido.getBtnCancelar()) {
			this.vtArmadoPedido.Close();
		}
	}

	private void PresionarCheck() {
		if (this.vtArmadoPedido.getChckbxDelivery().isSelected()) {
			this.vtArmadoPedido.getTxtrObservacionDelivery().setEditable(
					true);
			this.vtArmadoPedido.getTxtrObservacionDelivery().setEnabled(
					true);
		} else {
			this.vtArmadoPedido.getTxtrObservacionDelivery().setText("");
			this.vtArmadoPedido.getTxtrObservacionDelivery().setEditable(
					false);
			this.vtArmadoPedido.getTxtrObservacionDelivery().setEnabled(
					false);
		}
	}

	private void accionArmar() {
//		ArmadoVentaVista vista = this.vtArmadoPedido;
//		String textoCliente = Str.trim(vista.getTxtCliente().getText());
//		boolean textoClienteVacio = Valida.esNullOVacio(textoCliente);
//		if (!textoClienteVacio) {
			revisoDireccion();
//		} else {
//			Msj.advertencia("Atencion", "Debe ingresar el nombre del cliente");
//		}
	}

	private void revisoDireccion() {
		// ArmadoVentaVista vista = this.vtArmadoPedido;
		// String textoDireccion = Str.trim(vista.getTxtDireccion().getText());
		// boolean textoDireccionVacio = Valida.esNullOVacio(textoDireccion);
		// if (!textoDireccionVacio) {
		revisoProductos();
		// } else {
		// Msj.advertencia("Atencion",
		// "Debe ingresar la direccion del cliente");
		// }
	}

	private void revisoProductos() {
//		ArmadoVentaVista vista = this.vtArmadoPedido;
//		DefaultTableModel tabla = vista.getModelProductos();
//		boolean seleccionoProducto = tabla.getRowCount() > 0;
//		if (seleccionoProducto) {
			armarPedido();
//		} else {
//			Msj.advertencia("Atencion", "Debe Ingresar al Menos un Producto.");
//		}
	}

	private void armarPedido() {
		this.ArmarPedido();
		this.ctrPedido.RecargarTabla();
		this.ctrPedidoCocina.RecargarTablas();
		this.vtArmadoPedido.Close();
		this.mdlPedido.crearComanda(vtArmadoPedido);
	}
}
