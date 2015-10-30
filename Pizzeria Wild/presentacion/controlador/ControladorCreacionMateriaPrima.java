package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.MateriaPrimaDTO;

import modelo.MateriaPrimaModelo;

import validacion.ValidacionCreacionMateriaPrima;
import vista.CreacionMateriaPrimaVista;
import vista.MateriaPrimaVista;

public class ControladorCreacionMateriaPrima implements ActionListener {

	private ValidacionCreacionMateriaPrima vldMT;
	private CreacionMateriaPrimaVista vtCreacion;
	private MateriaPrimaModelo mdlMateriaPrima;
	private ControladorMateriaPrima ctrMateriaPrima;
	
	public ControladorCreacionMateriaPrima (ControladorMateriaPrima CtrMP, MateriaPrimaVista MPV) {
		this.vtCreacion = new CreacionMateriaPrimaVista(MPV);
		this.vtCreacion.getBtnCrear().addActionListener(this);
		this.vtCreacion.getBtnCancelar().addActionListener(this);
		
		this.vldMT = new ValidacionCreacionMateriaPrima(this.vtCreacion);
		this.mdlMateriaPrima = new MateriaPrimaModelo();
		this.ctrMateriaPrima = CtrMP;
	}
	
	public void Inicializar() {
		this.vtCreacion.Open();
	}
	
	private void CargarNuevaMateriaPrima() {
		String nombre = this.vtCreacion.getTxtMateriaprima().getText().trim();
		String unidad = this.vtCreacion.getComboBox().getSelectedItem().toString().trim();
		
		MateriaPrimaDTO mt = new MateriaPrimaDTO(nombre, unidad);
		
		this.mdlMateriaPrima.RegistrarMateriaPrima(mt);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtCreacion.getBtnCrear()) {
			if(this.vldMT.CreacionValida()){
				this.CargarNuevaMateriaPrima();
				this.ctrMateriaPrima.ActualizarTabla();
				this.vtCreacion.Close();
			}
		}
		else if (arg0.getSource() == this.vtCreacion.getBtnCancelar()) {
			this.vtCreacion.Close();
		}
	}
}