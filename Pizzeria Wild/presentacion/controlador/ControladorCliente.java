package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import dto.ClienteDTO;

import modelo.ClienteModelo;

import utilidades.Msj;
import vista.ClienteVista;

public class ControladorCliente implements ActionListener {

	private ControladorVenta ctrVenta;
	private ClienteVista vtCliente;
	private ClienteModelo mdlCliente;

	public ControladorCliente(ControladorVenta Ctr) {
		this.ctrVenta = Ctr;

		this.vtCliente = new ClienteVista();
		this.vtCliente.getBtnCrear().addActionListener(this);
		this.vtCliente.getBtnModificar().addActionListener(this);
		this.vtCliente.getBtnVolver().addActionListener(this);

		this.mdlCliente = new ClienteModelo();
	}

	public void Iniciarlizar() {
		this.CargarTabla();
		this.vtCliente.Open();
	}

	private void CargarTabla() {
		this.vtCliente.getModelTable().setRowCount(0);
		this.vtCliente.getModelTable().setColumnCount(0);
		this.vtCliente.getModelTable().setColumnIdentifiers(
				this.vtCliente.getNombreColumna());
		for (ClienteDTO c : this.mdlCliente.ObtenerClientes()) {
			Object[] fila = { c.getClienteId(),
					c.getApellido() + " " + c.getNombre() };
			this.vtCliente.getModelTable().addRow(fila);
		}
		this.vtCliente.getTable().setModel(this.vtCliente.getModelTable());
	}

	public void ActualizarTabla() {
		this.CargarTabla();
	}

	private void Crear() {
		ControladorABMCliente ctr = new ControladorABMCliente(this,
				this.vtCliente);
		ctr.InicializarCreacion();
	}

	private void Modificar() {
		JTable t = this.vtCliente.getTable();
		int select = t.getSelectedRow();
		if (select >= 0) {
			String clienteId = t.getValueAt(select, 0).toString().trim();
			ClienteDTO c = this.mdlCliente.ObtenerCliente(clienteId);

			ControladorABMCliente ctr = new ControladorABMCliente(this,
					this.vtCliente);
			ctr.InicializarModificacion(c);
		} else {
			Msj.error("Error de seleccion",
					"Debe seleccionar un cliente a modificar");
		}
	}

	private void Volver() {
		this.ctrVenta.Return();
		this.vtCliente.Close();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtCliente.getBtnCrear()) {
			this.Crear();
		} else if (arg0.getSource() == this.vtCliente.getBtnModificar()) {
			this.Modificar();
		} else if (arg0.getSource() == this.vtCliente.getBtnVolver()) {
			this.Volver();
		}
	}
}
