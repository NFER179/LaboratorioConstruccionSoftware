package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.RepartidorModelo;

import dto.RepartidorDTO;

import vista.BuscadorRepartidorVista;

public class ControladorBuscadorRepartidor implements ActionListener {

	private BuscadorRepartidorVista vtBuscadorRepartidor;
	private List<RepartidorDTO> lRepartidor;
	private RepartidorModelo mdlRepartidor;
	private ControladorAsignacionRepartidor ctrAsignacionRep;

	public ControladorBuscadorRepartidor(ControladorAsignacionRepartidor Ctr,
			JDialog Dialog) {
		this.vtBuscadorRepartidor = new BuscadorRepartidorVista(Dialog);
		this.lRepartidor = new ArrayList<RepartidorDTO>();
		this.mdlRepartidor = new RepartidorModelo();
		addListeners();
		this.ctrAsignacionRep = Ctr;
	}

	public void Inicializar() {
		this.CargarTabla();
		this.vtBuscadorRepartidor.Open();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		/** JNVR BEGIN CLEAN CODE */
		Object source = arg0.getSource();
		BuscadorRepartidorVista vista = this.vtBuscadorRepartidor;
		if (source == vista.getBtnAceptar())
			accionAceptar();
		else if (source == vista.getBtnCancelar())
			accionCancelar();
		else
			System.out.println("ESTADO ILEGAL");
		/** JNVR END CLEAN CODE */
	}

	private void addListeners() {
		this.vtBuscadorRepartidor.getBtnAceptar().addActionListener(this);
		this.vtBuscadorRepartidor.getBtnCancelar().addActionListener(this);
	}

	private void CargarTabla() {
		/** JNVR BEGIN CLEAN CODE */
		DefaultTableModel tablaActual = inicializarTableModel();
		inicializarRepartidores();
		llenarTablaActual();
		setearTableModel(tablaActual);
		/** JNVR END CLEAN CODE */
	}

	private void setearTableModel(DefaultTableModel tablaActual) {
		BuscadorRepartidorVista vista = this.vtBuscadorRepartidor;
		vista.getTable().setModel(tablaActual);
	}

	private void inicializarRepartidores() {
		this.lRepartidor = this.mdlRepartidor.ObtenerTodosLosRepartidores();
	}

	private DefaultTableModel inicializarTableModel() {
		BuscadorRepartidorVista vista = this.vtBuscadorRepartidor;
		DefaultTableModel tablaActual = getModelTable();
		tablaActual.setRowCount(0);
		tablaActual.setColumnCount(0);
		tablaActual.setColumnIdentifiers(vista.getNombreColumnas());
		return tablaActual;
	}

	private void llenarTablaActual() {
		DefaultTableModel tablaActual = getModelTable();
		for (RepartidorDTO r : this.lRepartidor) {
			Object[] fila = { Integer.toString(r.getRepartidorId()),
					r.getNombre() };
			tablaActual.addRow(fila);
		}
	}

	private void accionCancelar() {
		this.ctrAsignacionRep.Inicializar();
		this.vtBuscadorRepartidor.Close();
	}

	private void accionAceptar() {
		JTable tabla = getTable();
		int[] filasSeleccionadas = tabla.getSelectedRows();
		boolean seleccionoFila = filasSeleccionadas.length == 1;
		if (seleccionoFila)
			agregarRepartidor();
		this.vtBuscadorRepartidor.Close();
	}

	private void agregarRepartidor() {
		JTable tabla = getTable();
		String fila = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
		int valorFila = Integer.parseInt(fila);
		RepartidorDTO repartidorSeleccionado = this.mdlRepartidor
				.ObtenerRepartidor(valorFila);
		this.ctrAsignacionRep.CargarRepartidor(repartidorSeleccionado);
	}

	private JTable getTable() {
		return this.vtBuscadorRepartidor.getTable();
	}

	private DefaultTableModel getModelTable() {
		return this.vtBuscadorRepartidor.getModelTable();
	}
}