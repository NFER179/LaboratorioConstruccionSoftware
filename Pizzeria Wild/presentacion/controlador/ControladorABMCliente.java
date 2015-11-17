package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.ClienteDTO;

import modelo.ClienteModelo;

import utilidades.Msj;
import utilidades.Str;
import validacionesCampos.Valida;
import vista.ABMClienteVista;
import vista.ClienteVista;

public class ControladorABMCliente implements ActionListener {

	private ControladorCliente ctrCliente;
	private ABMClienteVista vtCliente;
	private ClienteModelo mdlCliente;
	boolean crear;

	public ControladorABMCliente(ControladorCliente Ctr, ClienteVista Vista) {
		this.ctrCliente = Ctr;

		this.vtCliente = new ABMClienteVista(Vista);
		this.vtCliente.getBtnGuardar().addActionListener(this);
		this.vtCliente.getBtnCancalar().addActionListener(this);

		this.mdlCliente = new ClienteModelo();
	}

	public void InicializarCreacion() {
		int NumCliente = this.mdlCliente.ObtenerNuevoId();
		this.vtCliente.getTxtIdcliente().setText(Integer.toString(NumCliente));

		this.crear = true;

		this.vtCliente.Open();
	}

	public void InicializarModificacion(ClienteDTO Cliente) {
		this.vtCliente.getTxtIdcliente().setText(
				Integer.toString(Cliente.getClienteId()));
		this.vtCliente.getTxtNombres().setText(Cliente.getNombre());
		this.vtCliente.getTxtApellido().setText(Cliente.getApellido());
		this.vtCliente.getTxtDireccion().setText(Cliente.getDireccion());
		this.vtCliente.getTxtTel().setText(Cliente.getTel());

		this.crear = false;

		this.vtCliente.Open();
	}

	private void Guardar() {
		int ClienteId = Integer.parseInt(this.vtCliente.getTxtIdcliente()
				.getText().trim());
		String Nombre = this.vtCliente.getTxtNombres().getText().trim();
		String Apellido = this.vtCliente.getTxtApellido().getText().trim();
		String Direccion = this.vtCliente.getTxtDireccion().getText().trim();
		String Tel = this.vtCliente.getTxtTel().getText().trim();

		ClienteDTO Cliente = new ClienteDTO(ClienteId, Nombre, Apellido,
				Direccion, Tel);
		String mensaje = "";
		if (Valida.esNullOVacio(Cliente.getNombre())) {
			mensaje += "El nombre no puede ser vacio";
		} else {
			this.vtCliente.getTxtNombres().setText(Cliente.getNombre());
			if (Valida.esNullOVacio(Cliente.getApellido())) {
				mensaje += "El apellido no puede ser vacio";
			} else {
				this.vtCliente.getTxtApellido().setText(Cliente.getApellido());
				if (Valida.esNullOVacio(Cliente.getDireccion())) {
					mensaje += "La direccion no puede ser vacia";
				} else {
					this.vtCliente.getTxtDireccion().setText(
							Cliente.getDireccion());
					if (Valida.esNullOVacio(Cliente.getTel())) {
						mensaje += "El numero de telefono no puede ser vacio";
					} else {
						try {
							String telTemp = Cliente.getTel().replace(" ", "")
									.replace("-", "");
							Integer.parseInt(telTemp);
							this.vtCliente.getTxtTel()
									.setText(Cliente.getTel());
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
			this.vtCliente.Close();
		} else {
			Msj.error("Error", mensaje);
		}
	}

	private void Cancelar() {
		this.vtCliente.Close();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtCliente.getBtnGuardar()) {
			this.Guardar();
		} else if (arg0.getSource() == this.vtCliente.getBtnCancalar()) {
			this.Cancelar();
		}
	}
}
