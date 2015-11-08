package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dto.MateriaPrimaDTO;
import modelo.MateriaPrimaModelo;
import vista.MateriaPrimaVista;

public class ControladorMateriaPrima implements ActionListener{

	private ControladorVenta ctr;
	private MateriaPrimaVista vtMateriaPrima;
	private MateriaPrimaModelo mdlMateriaPrima;
	
	public ControladorMateriaPrima(ControladorVenta Controlador){
		this.vtMateriaPrima = new MateriaPrimaVista();
		this.vtMateriaPrima.getBtnAgregar().addActionListener(this);
		this.vtMateriaPrima.getBtnVolver().addActionListener(this);
		
		this.ctr = Controlador;
		this.mdlMateriaPrima = new MateriaPrimaModelo();
	}
	
	public void Inicializar() {
		this.CargarTabla();
		this.vtMateriaPrima.Open();
	}
	
	private void CargarTabla() {
		this.vtMateriaPrima.getModelTable().setRowCount(0);
		this.vtMateriaPrima.getModelTable().setColumnCount(0);
		this.vtMateriaPrima.getModelTable().setColumnIdentifiers(this.vtMateriaPrima.getNombreColumnas());
		for (MateriaPrimaDTO mt:this.mdlMateriaPrima.ObtenerMateriasPrimas()) {
			Object[] fila = {mt.getNombre(),mt.getUnidad()};
			this.vtMateriaPrima.getModelTable().addRow(fila);
		}
		this.vtMateriaPrima.getTable().setModel(this.vtMateriaPrima.getModelTable());
	}
	
	public void ActualizarTabla() {
		this.CargarTabla();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		/* Crear una nueva materia prima. */
		if (arg0.getSource() == this.vtMateriaPrima.getBtnAgregar()) {
			ControladorCreacionMateriaPrima ctrMP = new ControladorCreacionMateriaPrima(this, this.vtMateriaPrima);
			ctrMP.Inicializar();
		}
		/* Volver al menu principal. */
		else if (arg0.getSource() == this.vtMateriaPrima.getBtnVolver() ) {
			this.ctr.Return();
			this.vtMateriaPrima.Close();
		}
	}
}