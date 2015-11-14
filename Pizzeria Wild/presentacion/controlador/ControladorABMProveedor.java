package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import validacion.ValidacionABMProveedor;
import vista.ABMProveedorVista;
import vista.ProveedorVista;

public class ControladorABMProveedor implements ActionListener {

	private ControladorProveedor ctrProveedor;
	private ABMProveedorVista vtABMProveedor;
	private ValidacionABMProveedor vldABMProveedor; 
	
	public ControladorABMProveedor(ControladorProveedor Ctr, ProveedorVista Vista) {
		this.ctrProveedor = Ctr;
		
		this.vtABMProveedor = new ABMProveedorVista(Vista);
		this.vtABMProveedor.getBtnAgregarCategoria().addActionListener(this);
		this.vtABMProveedor.getBtnQuitarCategoria().addActionListener(this);
		this.vtABMProveedor.getBtnAgregarMT().addActionListener(this);
		this.vtABMProveedor.getBtnQuitarMT().addActionListener(this);
		this.vtABMProveedor.getBtnGuardar().addActionListener(this);
		this.vtABMProveedor.getBtnCancelar().addActionListener(this);
		
		this.vldABMProveedor = new ValidacionABMProveedor(this.vtABMProveedor);
	}
	
	public void Inicializar() {
		this.vtABMProveedor.Open();
	}
	
	public void InicializarModificacion() {
		this.CargarDatosProveedor();
		this.CargarCategoriasProveedor();
		this.CargarProductosProveedor();
		this.vtABMProveedor.Open();
	}
	
	private void CargarDatosProveedor() {
		
	}

	private void CargarCategoriasProveedor() {
		
	}

	private void CargarProductosProveedor() {
		
	}
	
	private void AgregarCategoria() {
		// TODO Auto-generated method stub
		
	}

	private void QuitarCategoria() {
		// TODO Auto-generated method stub
		
	}

	private void AgregarMateriaPrima() {
		// TODO Auto-generated method stub
		
	}

	private void QuitarMateriaPrima() {
		// TODO Auto-generated method stub
		
	}

	private void Guardar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.vtABMProveedor.getBtnAgregarCategoria()) {
			this.AgregarCategoria();
		}else if(arg0.getSource() == this.vtABMProveedor.getBtnQuitarCategoria()) {
			if(this.vldABMProveedor.QuitarCategoriaValido()){
				this.QuitarCategoria();
			}
		}else if(arg0.getSource() == this.vtABMProveedor.getBtnAgregarMT()) {
			this.AgregarMateriaPrima();
		}else if(arg0.getSource() == this.vtABMProveedor.getBtnQuitarMT()) {
			if(this.vldABMProveedor.QuitarMTValido()){
				this.QuitarMateriaPrima();
			}
		}else if(arg0.getSource() == this.vtABMProveedor.getBtnGuardar()) {
			if(this.vldABMProveedor.GuardarValido()){
				this.Guardar();
			}
		}else if(arg0.getSource() == this.vtABMProveedor.getBtnCancelar()) {
			this.vtABMProveedor.Close();
		}
	}
}