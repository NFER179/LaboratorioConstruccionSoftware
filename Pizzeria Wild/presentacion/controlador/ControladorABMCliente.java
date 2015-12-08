package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.ClienteDTO;

import modelo.ClienteModelo;

import utilidades.Msj;
import validacionesCampos.Valida;
import vista.ABMClienteVista;
import vista.ClienteVista;

public class ControladorABMCliente implements ActionListener {

	private ControladorCliente ctrCliente;
	private ABMClienteVista vtClienteABM;
	private ClienteModelo mdlCliente;
	boolean crear;
	private ClienteVista vtCliente;

	public ControladorABMCliente(ControladorCliente Ctr, ClienteVista Vista) {
		this.ctrCliente = Ctr;
		this.vtCliente = Vista;
		this.vtClienteABM = new ABMClienteVista(Vista);
		this.vtClienteABM.getBtnGuardar().addActionListener(this);
		this.vtClienteABM.getBtnCancalar().addActionListener(this);

		this.mdlCliente = new ClienteModelo();
	}

	public void InicializarCreacion() {
		int NumCliente = this.mdlCliente.ObtenerNuevoId();
		this.vtClienteABM.getTxtIdcliente().setText(
				Integer.toString(NumCliente));

		this.crear = true;
		this.vtCliente.Close();
		this.vtClienteABM.Open();
	}

	public void InicializarModificacion(ClienteDTO Cliente) {
		this.vtClienteABM.getTxtIdcliente().setText(
				Integer.toString(Cliente.getClienteId()));
		this.vtClienteABM.getTxtNombres().setText(Cliente.getNombre());
		this.vtClienteABM.getTxtApellido().setText(Cliente.getApellido());
		this.vtClienteABM.getTxtDireccion().setText(Cliente.getDireccion());
		this.vtClienteABM.getTxtTel().setText(Cliente.getTel());

		this.crear = false;

		this.vtCliente.Close();
		this.vtClienteABM.Open();
	}

	private void Guardar() {
		int ClienteId = Integer.parseInt(this.vtClienteABM.getTxtIdcliente()
				.getText().trim());
		String Nombre = this.vtClienteABM.getTxtNombres().getText().trim();
		String Apellido = this.vtClienteABM.getTxtApellido().getText().trim();
		String Direccion = this.vtClienteABM.getTxtDireccion().getText().trim();
		String Tel = this.vtClienteABM.getTxtTel().getText().trim();

		ClienteDTO Cliente = new ClienteDTO(ClienteId, Nombre, Apellido,
				Direccion, Tel);
		String mensaje = "";
		if (Valida.esNullOVacio(Cliente.getNombre())) {
			mensaje += "El nombre no puede ser vacio";
		} else {
			this.vtClienteABM.getTxtNombres().setText(Cliente.getNombre());
			if (Valida.esNullOVacio(Cliente.getApellido())) {
				mensaje += "El apellido no puede ser vacio";
			} else {
				this.vtClienteABM.getTxtApellido().setText(
						Cliente.getApellido());
				if (Valida.esNullOVacio(Cliente.getDireccion())) {
					mensaje += "La direccion no puede ser vacia";
				} else {
					this.vtClienteABM.getTxtDireccion().setText(
							Cliente.getDireccion());
					if (Valida.esNullOVacio(Cliente.getTel())) {
						mensaje += "El numero de telefono no puede ser vacio";
					} else {
						try {
							String telTemp = Cliente.getTel().replace(" ", "")
									.replace("-", "");
							Integer.parseInt(telTemp);
							this.vtClienteABM.getTxtTel().setText(
									Cliente.getTel());
						} catch (Exception e) {
							mensaje += "Debe ingresar un numero de telefono valido";
						}

					}
				}
			}
		}
		if (Valida.esNullOVacio(mensaje)) {
			if (this.crear) {
				this.mdlCliente.CrearCliente(Cliente);
			} else {
				this.mdlCliente.ModificarCliente(Cliente);
			}
			this.ctrCliente.ActualizarTabla();
			this.vtClienteABM.Close();
			this.ctrCliente.Return();
		} else {
			Msj.error("Error", mensaje);
		}
	}

	private void Cancelar() {
		this.ctrCliente.Return();
		this.vtClienteABM.Close();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtClienteABM.getBtnGuardar()) {
			this.Guardar();
		} else if (arg0.getSource() == this.vtClienteABM.getBtnCancalar()) {
			this.Cancelar();
		}
	}
}
