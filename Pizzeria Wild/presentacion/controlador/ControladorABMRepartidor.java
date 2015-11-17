package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.RepartidorDTO;

import modelo.RepartidorModelo;

import utilidades.Msj;
import validacion.ValidacionABMRepartidor;
import validacionesCampos.Valida;
import vista.ABMRepartidorVista;
import vista.RepartidorVista;

public class ControladorABMRepartidor implements ActionListener {

	private ControladorRepartidor ctrRepartidor;
	private ABMRepartidorVista vtRepartidor;
	private ValidacionABMRepartidor vldABM;
	private RepartidorModelo mdlRepartidor;
	private boolean creacion;

	public ControladorABMRepartidor(ControladorRepartidor Ctr,
			RepartidorVista Vista) {
		this.ctrRepartidor = Ctr;

		this.vtRepartidor = new ABMRepartidorVista(Vista);
		this.vtRepartidor.getBtnGuardar().addActionListener(this);
		this.vtRepartidor.getBtnCancelar().addActionListener(this);

		this.vldABM = new ValidacionABMRepartidor(this.vtRepartidor);
		this.mdlRepartidor = new RepartidorModelo();
	}

	public void InicializarCreacion() {
		this.creacion = true;
		int numRepartidor = this.mdlRepartidor.ObtenerNumNuevoRepartidor();
		this.vtRepartidor.getTxtRepartidorid().setText(
				Integer.toString(numRepartidor));

		this.vtRepartidor.Open();
	}

	public void InicializarModificacion(int idRepartidor) {
		this.creacion = false;
		RepartidorDTO r = this.mdlRepartidor.ObtenerRepartidor(idRepartidor);

		this.vtRepartidor.getTxtRepartidorid().setText(
				Integer.toString(r.getRepartidorId()));
		this.vtRepartidor.getTxtNombre().setText(r.getNombre());
		this.vtRepartidor.getTxtApellido().setText(r.getApellido());
		this.vtRepartidor.getTxtTel().setText(r.getTel());
		this.vtRepartidor.getTxtDireccion().setText(r.getDireccion());
		this.vtRepartidor.getTxtPatente().setText(r.getVehiculoId());
		this.vtRepartidor.getTxtTipo().setText(r.getTipoVehiculo());
		this.vtRepartidor.getTxtModelo().setText(r.getModeloVehiculo());
		this.vtRepartidor.getChckbxActivo().setSelected(r.isActivo());

		this.vtRepartidor.Open();
	}

	private void Guardar() {

		int RepartidorId = Integer.parseInt(this.vtRepartidor
				.getTxtRepartidorid().getText().toString().trim());
		String Nombre = this.vtRepartidor.getTxtNombre().getText().toString()
				.trim();
		String Apellido = this.vtRepartidor.getTxtApellido().getText()
				.toString().trim();
		String Tel = this.vtRepartidor.getTxtTel().getText().toString().trim();
		String Direccion = this.vtRepartidor.getTxtDireccion().getText()
				.toString().trim();
		String VehiculoId = this.vtRepartidor.getTxtPatente().getText()
				.toString().trim();
		String TipoVehiculo = this.vtRepartidor.getTxtTipo().getText()
				.toString().trim();
		String ModeloVehiculo = this.vtRepartidor.getTxtModelo().getText()
				.toString().trim();
		boolean Activo = this.vtRepartidor.getChckbxActivo().isSelected();

		RepartidorDTO r = new RepartidorDTO(RepartidorId, Nombre, Apellido,
				Tel, Direccion, VehiculoId, TipoVehiculo, ModeloVehiculo,
				Activo);
		// VALIDACION
		String mensaje = "";
		if (!Valida.esNullOVacio(r.getApellido())) {
			if (!Valida.esNullOVacio(r.getNombre())) {
				if (!Valida.esNullOVacio(r.getDireccion())) {
					if (!Valida.esNullOVacio(r.getModeloVehiculo())) {
						if (!Valida.esNullOVacio(r.getTipoVehiculo())) {
							if (!Valida.esNullOVacio(r.getTel())) {
								try {
									String telTemp = r.getTel()
											.replace(" ", "").replace("-", "");
									Integer.parseInt(telTemp);

								} catch (Exception e) {
									mensaje += "Debe ingresar un numero de telefono valido";
								}
							} else {
								mensaje += "El numero de telefono no puede ser vacio";
							}
						} else {
							mensaje += "El tipo de vehiculo no puede ser vacio";
						}
					} else {
						mensaje += "El modelo del vehiculo no puede ser vacio";
					}
				} else {
					mensaje += "La direccion no puede ser vacia";
				}
			} else {
				mensaje += "El nombre no puede ser vacio";
			}
		} else {
			mensaje += "El apellido no puede ser vacio";
		}
		if (Valida.esNullOVacio(mensaje)) {
			agregaOModifica(r);
			this.ctrRepartidor.ActualizarTabla();
			this.vtRepartidor.Close();
		} else {
			Msj.error("Error", mensaje);
		}
	}

	private void agregaOModifica(RepartidorDTO r) {
		if (this.creacion) {
			this.mdlRepartidor.CrearRepartidor(r);
		} else {
			this.mdlRepartidor.ModificarRepartidor(r);
		}
	}

	private void Cancelar() {
		this.ctrRepartidor.Return();
		this.vtRepartidor.Close();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtRepartidor.getBtnGuardar()) {
			if (this.vldABM.GuardarValido()) {
				this.Guardar();
			}
		} else if (arg0.getSource() == this.vtRepartidor.getBtnCancelar()) {
			this.Cancelar();
		}
	}
}
