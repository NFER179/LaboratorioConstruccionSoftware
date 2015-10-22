package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JTable;

import dto.MateriaPrimaDTO;
import dto.MateriaPrimaSolicitudDTO;
import dto.SolicitudDTO;

import modelo.SolicitudModelo;

import validacion.ValidacionCreacionSolicitud;
import vista.CreacionSolicitudVista;
import vista.SolicitudCompraVista;

public class ControladorCreacionSolicitud implements ActionListener{

	private ControladorSolicitud ctrSolicitud;
	private CreacionSolicitudVista vtCreacionSolicitud;
	private ValidacionCreacionSolicitud vldCreacion;
	private SolicitudModelo mdlSolicitud;
	
	public ControladorCreacionSolicitud(ControladorSolicitud Ctr, SolicitudCompraVista vista){
		this.vtCreacionSolicitud = new CreacionSolicitudVista(vista);
		this.vtCreacionSolicitud.getBtnBuscar().addActionListener(this);
		this.vtCreacionSolicitud.getBtnAgregar().addActionListener(this);
		this.vtCreacionSolicitud.getBtnQuitar().addActionListener(this);
		this.vtCreacionSolicitud.getBtnEnviar().addActionListener(this);
		this.vtCreacionSolicitud.getBtnGuardar().addActionListener(this);
		this.vtCreacionSolicitud.getBtnVolver().addActionListener(this);
		
		this.ctrSolicitud = Ctr;
		this.vldCreacion = new ValidacionCreacionSolicitud(this.vtCreacionSolicitud);
		this.mdlSolicitud = new SolicitudModelo();
	}
	
	public void Inicializar() {
		this.CargarFecha();
		this.vtCreacionSolicitud.Open();
	}
	
	private void CargarFecha() {
		Calendar c = Calendar.getInstance();
		String fecha = Integer.toString(c.get(Calendar.YEAR));
		
		String mes = Integer.toString(c.get(Calendar.MONTH)); 
		if(mes.length() == 1)
			mes = "0" + mes;
		fecha = fecha + "/" + mes;
		
		String dia = Integer.toString(c.get(Calendar.DATE));
		if(dia.length() == 1)
			dia = "0" + dia;
			
		fecha = fecha + "/" + dia;
		
		this.vtCreacionSolicitud.getTxtFecha().setText(fecha);
	}
	
	public String ObtenerProveedor() {
		return this.vtCreacionSolicitud.getTxtIdproveedor().getText().trim();
	}
	
	public void CargarProveedor(String ProveedorId, String Descripcion) {
		this.vtCreacionSolicitud.getTxtIdproveedor().setText(ProveedorId);
		this.vtCreacionSolicitud.getTxtDescrproveedor().setText(Descripcion);
		
		this.VaciarMateriasPrimas();
	}
	
	private void VaciarMateriasPrimas() {
		this.vtCreacionSolicitud.getModelTable().setRowCount(0);
		this.vtCreacionSolicitud.getModelTable().setColumnCount(0);
		this.vtCreacionSolicitud.getModelTable().setColumnIdentifiers(this.vtCreacionSolicitud.getNombreColumnas());
	}

	public void AgregarMateriaPrima(String MateriaPrima, String Cantidad, String Unidad) {
		if (this.MateriaNoPrimaAgregada(MateriaPrima, Cantidad)){
			Object[] fila = {MateriaPrima, Cantidad + " " + Unidad};
			this.vtCreacionSolicitud.getModelTable().addRow(fila);	
		}
	}
	
	private boolean MateriaNoPrimaAgregada(String MateriaPrima, String Cantidad){
		JTable tabla = this.vtCreacionSolicitud.getTable();
		int filas = tabla.getRowCount();
		for(int i = 0; i < filas; i++){
			String materiaPrima = tabla.getValueAt(i, 0).toString().trim();
			if(MateriaPrima.equals(materiaPrima)){
				String cantidad = tabla.getValueAt(i, 1).toString().trim().split(" ")[0];
				String unidad = tabla.getValueAt(i, 1).toString().trim().split(" ")[1];
				/* Suma las cantidades. */
				int cantidadResultate = Integer.parseInt(cantidad) + Integer.parseInt(Cantidad);
				
				tabla.setValueAt(Integer.toString(cantidadResultate) + " " + unidad, i, 1);
				
				return false;
			}
		}
			
		return true;
	}
	
	private void Quitar(){
		JTable tabla = this.vtCreacionSolicitud.getTable();
		int[] seleccion = tabla.getSelectedRows();
		
		for(int i = seleccion.length - 1; i >= 0; i--) {
			this.vtCreacionSolicitud.getModelTable().removeRow(seleccion[i]);
		}
	}
	
	private void EnviarSolicitud() {
		String Fecha = this.vtCreacionSolicitud.getTxtFecha().getText();
		
		int NumPedido;
		if(this.vtCreacionSolicitud.getTxtNumpedido().getText().equals("NEXT")) {
			NumPedido = this.mdlSolicitud.ObtenerNumNuevaSolicitud(Fecha);
		}
		else{
			NumPedido = Integer.parseInt(this.vtCreacionSolicitud.getTxtNumpedido().getText().trim());
		}
		
		SolicitudDTO sol = new SolicitudDTO(Fecha, NumPedido, true);
		
		String proveedor = this.vtCreacionSolicitud.getTxtIdproveedor().getText().trim();
		
		this.mdlSolicitud.EnviarSolicitud(sol, proveedor, this.GetMateriasPrimas());
	}
	
	private List<MateriaPrimaSolicitudDTO> GetMateriasPrimas() {
		List<MateriaPrimaSolicitudDTO> materiasPrimas = new ArrayList<MateriaPrimaSolicitudDTO>();
		JTable tabla = this.vtCreacionSolicitud.getTable();
		
		for(int i = 0; i<tabla.getRowCount(); i++) {
			String mt = tabla.getValueAt(i, 0).toString().trim();
			int cantidad = Integer.parseInt(tabla.getValueAt(i, 1).toString().split(" ")[0].trim());
			materiasPrimas.add(new MateriaPrimaSolicitudDTO(mt, cantidad));
		}
		
		return materiasPrimas;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.vtCreacionSolicitud.getBtnBuscar()) {
			ControladorSeleccionProveedor ctrSP = new ControladorSeleccionProveedor(this, this.vtCreacionSolicitud);
			ctrSP.Inicializar();
		}
		else if(arg0.getSource() == this.vtCreacionSolicitud.getBtnAgregar()) {
			if(this.vldCreacion.SeleccionMateriasPrimas()) {
				ControladorSeleccionMateriaPrimaSolicitud ctrSMPS = new ControladorSeleccionMateriaPrimaSolicitud(this, this.vtCreacionSolicitud);
				ctrSMPS.Inicializar();
			}
		}
		else if(arg0.getSource() == this.vtCreacionSolicitud.getBtnQuitar()) {
			if(this.vldCreacion.QuitarValido()){
				this.Quitar();
			}
		}
		else if(arg0.getSource() == this.vtCreacionSolicitud.getBtnEnviar()){
			this.EnviarSolicitud();
			this.vtCreacionSolicitud.Close();
		}
		
		else if(arg0.getSource() == this.vtCreacionSolicitud.getBtnGuardar()) {
			
		}
		else if(arg0.getSource() == this.vtCreacionSolicitud.getBtnVolver()) {
			this.vtCreacionSolicitud.Close();
		}
	}
}