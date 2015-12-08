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
		this.vtRepartidorABM.getTxtTipo().setText(r.getTipoVehiculo());
		this.vtRepartidorABM.getTxtModelo().setText(r.getModeloVehiculo());
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
			this.vtRepartidorABM.Close();
			this.ctrRepartidor.Return();
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
