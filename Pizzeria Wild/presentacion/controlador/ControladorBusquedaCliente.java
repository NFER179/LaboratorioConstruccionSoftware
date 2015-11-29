package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.RowFilter;

import utilidades.Msj;
import vista.BusquedaClienteVista;
import dao.ClienteDAO;
import daoImplementacion.ClienteImp;
import dto.ClienteDTO;
import modelo.ClienteModelo;

public class ControladorBusquedaCliente implements ActionListener {

	private BusquedaClienteVista vtBusquedaCliente;
	private ControladorArmadoVenta ctrArmadoPedido;
	private List<ClienteDTO> lstCliente;
	private ClienteModelo mdlCliente;

	public ControladorBusquedaCliente(ControladorArmadoVenta CtrArmadoPedido,
			JDialog Dialog) {
		this.vtBusquedaCliente = new BusquedaClienteVista(Dialog);
		addListeners();

		this.ctrArmadoPedido = CtrArmadoPedido;
		this.mdlCliente = new ClienteModelo();
	}

	public void Iniciar() {
		CargarClientes();
		this.vtBusquedaCliente.Open();
	}

	private void addListeners() {
		this.vtBusquedaCliente.getBtnAceptar().addActionListener(this);
		this.vtBusquedaCliente.getBtnCancelar().addActionListener(this);
		this.vtBusquedaCliente.getBtnBuscar().addActionListener(this);
	}

	private void CargarClientes() {
		this.vtBusquedaCliente.getModelCliente().setRowCount(0);
		this.vtBusquedaCliente.getModelCliente().setColumnCount(0);
		this.vtBusquedaCliente.getModelCliente().setColumnIdentifiers(
				this.vtBusquedaCliente.getNombreColumnas());
		this.lstCliente = this.mdlCliente.ObtenerClientes();
		for (ClienteDTO c : this.lstCliente) {
			Object[] fila = { Integer.toString(c.getClienteId()),
					c.getApellido() + " " + c.getNombre() };
			this.vtBusquedaCliente.getModelCliente().addRow(fila);
		}
		this.vtBusquedaCliente.getTable().setModel(
				this.vtBusquedaCliente.getModelCliente());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtBusquedaCliente.getBtnAceptar()) {
			accionAceptar();
		} else if (arg0.getSource() == this.vtBusquedaCliente.getBtnCancelar()) {
			this.vtBusquedaCliente.Close();
		} else if (arg0.getSource() == this.vtBusquedaCliente.getBtnBuscar()) {
			accionBuscar();
		}
	}

	@SuppressWarnings("unchecked")
	private void accionBuscar() {
		String busqueda = this.vtBusquedaCliente.getTxtFiltro().getText();
		this.vtBusquedaCliente.getSorter().setRowFilter(
				RowFilter.regexFilter(busqueda));

	}

	private void accionAceptar() {
		JTable tabla = this.vtBusquedaCliente.getTable();
		int numColumnaCliente = 0;
		if (tabla.getSelectedRow() >= 0) {
			String idCliente = (String) (tabla.getValueAt(
					tabla.getSelectedRow(), numColumnaCliente));
			ClienteDAO cdao = new ClienteImp();
			this.ctrArmadoPedido.CargarDatosCliente(cdao.GetCliente(idCliente));
			this.vtBusquedaCliente.Close();
		} else {
			Msj.error("Error en la busqueda", "Debe Seleccionar un cliente");
		}
	}
}