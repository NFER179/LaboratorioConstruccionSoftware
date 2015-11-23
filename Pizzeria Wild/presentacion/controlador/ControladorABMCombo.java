package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.ComboDTO;

import modelo.ComboModelo;
import modelo.SaborModelo;

import utilidades.Fecha;
import vista.ABMComboVista;
import vista.ComboVista;

public class ControladorABMCombo implements ActionListener {

	private ControladorCombo ctrCombo;
	private ABMComboVista vtCombo;
	private ComboModelo mdlCombo;
	private SaborModelo mdlSabor;
	private boolean creacion;
	
	public ControladorABMCombo(ControladorCombo Ctr, ComboVista Vista) {
		this.ctrCombo = Ctr;
		
		this.vtCombo = new ABMComboVista(Vista);
		this.vtCombo.getBtnEdit().addActionListener(this);
		this.vtCombo.getBtnAnterior().addActionListener(this);
		this.vtCombo.getBtnSiguiente().addActionListener(this);
		this.vtCombo.getBtnAgregarProducto().addActionListener(this);
		this.vtCombo.getBtnEliminarProducto().addActionListener(this);
		this.vtCombo.getBtnAgregar().addActionListener(this);
		this.vtCombo.getBtnModificar().addActionListener(this);
		this.vtCombo.getBtnEliminar().addActionListener(this);
		this.vtCombo.getBtnGuardar().addActionListener(this);
		this.vtCombo.getBtnCancelar().addActionListener(this);
		this.vtCombo.getBtnVolver().addActionListener(this);
		
		this.mdlCombo = new ComboModelo();
		this.mdlSabor = new SaborModelo();
	}
	
	public void InicializarCreacion() {
		this.creacion = true;
		
		int numCombo = this.mdlCombo.ObtenerNuevoIdCombo();
		this.vtCombo.getTxtIdcombo().setText(Integer.toString(numCombo));
		
		this.vtCombo.getTxtDescripcion().setEditable(true);
		this.vtCombo.getTxtDescripcion().setEnabled(true);
		
		this.vtCombo.EliminarComponente(this.vtCombo.getBtnEdit());
		
		this.vtCombo.getPanel().remove(this.vtCombo.getBtnAnterior());
		this.vtCombo.getLblFila().setText("1 / 1");
		this.vtCombo.getPanel().remove(this.vtCombo.getBtnSiguiente());
		
		this.vtCombo.getChckbxActivo().setEnabled(true);
		
		this.vtCombo.getTxtPrecio().setEditable(true);
		this.vtCombo.getTxtPrecio().setEnabled(true);
		
		this.vtCombo.EliminarComponente(this.vtCombo.getBtnAgregar());
		this.vtCombo.EliminarComponente(this.vtCombo.getBtnModificar());
		this.vtCombo.EliminarComponente(this.vtCombo.getBtnEliminar());
		this.vtCombo.EliminarComponente(this.vtCombo.getBtnVolver());
		
		this.vtCombo.Open();
	}
	
	public void InicializarInformacion(ComboDTO combo) {
		this.creacion = false;
		
		
		
		this.vtCombo.Open();
	}
	
	public void AgregarProductoALista(String producto, String sabor, int cantidad) {
		int precioparcial = this.mdlSabor.ObtenerPrecio(producto, sabor);
		
		int precioTotal = precioparcial * cantidad;
		
		Object[] fila = {producto, sabor, cantidad,"$ " + precioTotal};
		
		this.vtCombo.getModelTable().addRow(fila);
		this.vtCombo.getTable().setModel(this.vtCombo.getModelTable());
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.vtCombo.getBtnEdit()){
			this.EditarDescripcion();
		}
		else if(arg0.getSource() == this.vtCombo.getBtnAnterior()) {
			this.AnteriorEffdt();
		}
		else if(arg0.getSource() == this.vtCombo.getBtnSiguiente()) {
			this.SiguienteEffdt();
		}
		else if(arg0.getSource() == this.vtCombo.getBtnAgregarProducto()) {
			this.AgregarProducto();
		}
		else if(arg0.getSource() == this.vtCombo.getBtnEliminarProducto()) {
			this.EliminarProducto();
		}
		else if(arg0.getSource() == this.vtCombo.getBtnAgregar()) {
			this.AgregarEffdt();
		}
		else if(arg0.getSource() == this.vtCombo.getBtnModificar()) {
			this.ModificarEffdt();
		}
		else if(arg0.getSource() == this.vtCombo.getBtnEliminar()) {
			this.Eliminar();
		}
		else if(arg0.getSource() == this.vtCombo.getBtnGuardar()) {
			this.Guardar();
		}
		else if(arg0.getSource() == this.vtCombo.getBtnCancelar()) {
			this.Cancelar();
		}
		else if(arg0.getSource() == this.vtCombo.getBtnVolver()) {
			this.Volver();
		}
	}

	private void EditarDescripcion() {
		// TODO Auto-generated method stub
		
	}

	private void AnteriorEffdt() {
		// TODO Auto-generated method stub
		
	}

	private void SiguienteEffdt() {
		// TODO Auto-generated method stub
		
	}

	private void AgregarProducto() {
		ControladorBusquedaProductosCombos ctr = new ControladorBusquedaProductosCombos(this, this.vtCombo);
		ctr.Inicializar();
	}

	private void EliminarProducto() {
		// TODO Auto-generated method stub
		
	}

	private void AgregarEffdt() {
		// TODO Auto-generated method stub
		
	}

	private void ModificarEffdt() {
		// TODO Auto-generated method stub
		
	}

	private void Eliminar() {
		// TODO Auto-generated method stub
		
	}

	private void Guardar() {
		// TODO Auto-generated method stub
	}

	private void Cancelar() {
		// TODO Auto-generated method stub
		
	}

	private void Volver() {
		// TODO Auto-generated method stub
		
	}
}