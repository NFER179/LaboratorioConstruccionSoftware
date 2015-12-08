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
	private ABMRepartidorVista vtRepartidorABM;
	private ValidacionABMRepartidor vldABM;
	private RepartidorModelo mdlRepartidor;
	private boolean creacion;
	private RepartidorVista vtRepartidor;

	public ControladorABMRepartidor(ControladorRepartidor Ctr,
			RepartidorVista Vista) {
		this.ctrRepartidor = Ctr;
		this.vtRepartidor = Vista;
		this.vtRepartidorABM = new ABMRepartidorVista(Vista);
		this.vtRepartidorABM.getBtnGuardar().addActionListener(this);
		this.vtRepartidorABM.getBtnCancelar().addActionListener(this);

		this.vldABM = new ValidacionABMRepartidor(this.vtRepartidorABM);
		this.mdlRepartidor = new RepartidorModelo();
	}

	public void InicializarCreacion() {
		this.creacion = true;
		int numRepartidor = this.mdlRepartidor.ObtenerNumNuevoRepartidor();
		this.vtRepartidorABM.getTxtRepartidorid().setText(
				Integer.toString(numRepartidor));
		this.vtRepartidor.Close();
		this.vtRepartidorABM.Open();
	}

	public void InicializarModificacion(int idRepartidor) {
		this.creacion = false;
		RepartidorDTO r = this.mdlRepartidor.ObtenerRepartidor(idRepartidor);
		
		this.vtRepartidorABM.getTxtRepartidorid().setText(
				Integer.toString(r.getRepartidorId()));
		this.vtRepartidorABM.getTxtNombre().setText(r.getNombre());
		this.vtRepartidorABM.getTxtApellido().setText(r.getApellido());
		this.vtRepartidorABM.getTxtTel().setText(r.getTel());
		this.vtRepartidorABM.getTxtDireccion().setText(r.getDireccion());
		this.vtRepartidorABM.getTxtPatente().setText(r.getVehiculoId());
		this.vtRepartidorABM.getTxtTipo().setText(r.getModeloVehiculo());
		this.vtRepartidorABM.getTxtModelo().setText(r.getTipoVehiculo());
		this.vtRepartidorABM.getChckbxActivo().setSelected(r.isActivo());
		this.vtRepartidor.Close();
		this.vtRepartidorABM.Open();
	}

	private void Guardar() {

		int RepartidorId = Integer.parseInt(this.vtRepartidorABM
				.getTxtRepartidorid().getText().toString().trim());
		String Nombre = this.vtRepartidorABM.getTxtNombre().getText()
				.toString().trim();
		String Apellido = this.vtRepartidorABM.getTxtApellido().getText()
				.toString().trim();
		String Tel = this.vtRepartidorABM.getTxtTel().getText().toString()
				.trim();
		String Direccion = this.vtRepartidorABM.getTxtDireccion().getText()
				.toString().trim();
		String VehiculoId = this.vtRepartidorABM.getTxtPatente().getText()
				.toString().trim();
		String TipoVehiculo = this.vtRepartidorABM.getTxtTipo().getText()
				.toString().trim();
		String ModeloVehiculo = this.vtRepartidorABM.getTxtModelo().getText()
				.toString().trim();
		boolean Activo = this.vtRepartidorABM.getChckbxActivo().isSelected();

		RepartidorDTO r = new RepartidorDTO(RepartidorId, Nombre, Apellido,
				Tel, Direccion, VehiculoId, ModeloVehiculo, TipoVehiculo,
				Activo);
		// VALIDACION
		String mensaje = "";
		mensaje = validar(r, mensaje);
		if (Valida.esNullOVacio(mensaje)) {
			agregaOModifica(r);
			this.ctrRepartidor.ActualizarTabla();
			this.vtRepartidorABM.Close();
			this.ctrRepartidor.Return();
		} else {
			Msj.error("Error", mensaje);
		}
	}

	private String validar(RepartidorDTO r, String mensaje) {
		if (!Valida.esNullOVacio(r.getApellido())) {
			if (r.getApellido().length() > 30) {
				mensaje += "El apellido debe contener a lo sumo 30 caracteres";
			} else
				mensaje = validaNombre(r, mensaje);
		} else
			mensaje += "El apellido no puede ser vacio";
		return mensaje;
	}

	private String validaNombre(RepartidorDTO r, String mensaje) {
		if (!Valida.esNullOVacio(r.getNombre())) {
			if (r.getNombre().length() > 30) {
				mensaje += "El nombre debe contener a lo sumo 30 caracteres";
			} else {
				mensaje = validarDireccion(r, mensaje);
			}
		} else {
			mensaje += "El nombre no puede ser vacio";
		}
		return mensaje;
	}

	private String validarDireccion(RepartidorDTO r, String mensaje) {
		if (!Valida.esNullOVacio(r.getDireccion())) {
			if (r.getDireccion().length() > 30) {
				mensaje += "La direccion debe contener a lo sumo 30 caracteres";
			} else {
				mensaje = validaModeloVehiculo(r, mensaje);
			}
		} else {
			mensaje += "La direccion no puede ser vacia";
		}
		return mensaje;
	}

	private String validaModeloVehiculo(RepartidorDTO r, String mensaje) {
		if (!Valida.esNullOVacio(r.getModeloVehiculo())) {
			if (r.getModeloVehiculo().length() > 30)
				mensaje += "El modelo del vehiculo debe contener a lo sumo 30 caracteres";
			else
				mensaje = validaTipoVehiculo(r, mensaje);
		} else
			mensaje += "El modelo del vehiculo no puede ser vacio";

		return mensaje;
	}

	private String validaTipoVehiculo(RepartidorDTO r, String mensaje) {
		if (!Valida.esNullOVacio(r.getTipoVehiculo())) {
			if (r.getTipoVehiculo().length() > 20) {
				mensaje += "El tipo de vehiculo debe contener a lo sumo 20 caracteres";
			} else {
				mensaje = validaPatente(r, mensaje);
			}
		} else {
			mensaje += "El tipo de vehiculo no puede ser vacio";
		}
		return mensaje;
	}

	private String validaPatente(RepartidorDTO r, String mensaje) {
		if (!Valida.esNullOVacio(r.getVehiculoId())) {
			if (r.getVehiculoId().length() > 10) {
				mensaje += "La patente del vehiculo debe contener a lo sumo 10 caracteres";
			} else {
				mensaje = validaNumTel(r, mensaje);
			}
		} else {
			mensaje += "La patente del vehiculo no puede ser vacio";
		}
		return mensaje;
	}

	private String validaNumTel(RepartidorDTO r, String mensaje) {
		if (!Valida.esNullOVacio(r.getTel())) {
			if (r.getTel().length() > 14)
				mensaje += "El numero de telefono debe contener a lo sumo 14 caracteres";
			else {
				try {
					String telTemp = r.getTel().replace(" ", "")
							.replace("-", "");
					Long.parseLong(telTemp);

				} catch (Exception e) {
					mensaje += "Debe ingresar un numero de telefono valido";
				}
			}
		} else
			mensaje += "El numero de telefono no puede ser vacio";
		return mensaje;
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
		this.vtRepartidorABM.Close();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtRepartidorABM.getBtnGuardar()) {
			if (this.vldABM.GuardarValido()) {
				this.Guardar();
			}
		} else if (arg0.getSource() == this.vtRepartidorABM.getBtnCancelar()) {
			this.Cancelar();
		}
	}
}
