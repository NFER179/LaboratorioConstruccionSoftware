package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JTable;

import dto.MateriaPrimaDTO;
import dto.MateriaPrimaSolicitudDTO;
import dto.ProveedorDTO;
import dto.SolicitudDTO;

import modelo.MateriaPrimaModelo;
import modelo.SolicitudModelo;

import validacion.ValidacionCreacionSolicitud;
import vista.CreacionSolicitudVista;
import vista.SolicitudCompraVista;

public class ControladorCreacionSolicitud implements ActionListener{

	private ControladorSolicitud ctrSolicitud;
	private CreacionSolicitudVista vtCreacionSolicitud;
	private ValidacionCreacionSolicitud vldCreacion;
	private SolicitudModelo mdlSolicitud;
	private MateriaPrimaModelo mdlMateriaPrima;
	
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
		this.mdlMateriaPrima = new MateriaPrimaModelo();
	}
	
	public void Inicializar() {
		this.CargarFecha();
		this.vtCreacionSolicitud.Open();
	}
	
	public void InicializarModificacion(String FechaSolicitud, String NumeroSolicitud) {
		this.vtCreacionSolicitud.getTxtFecha().setText(FechaSolicitud);
		this.vtCreacionSolicitud.getTxtNumpedido().setText(NumeroSolicitud);
		
		ProveedorDTO proveedor = this.mdlSolicitud.ObtenerProveedor(FechaSolicitud, NumeroSolicitud);
		
		this.vtCreacionSolicitud.getTxtIdproveedor().setText(proveedor.getProveedorId());
		this.vtCreacionSolicitud.getTxtDescrproveedor().setText(proveedor.getNombre());
		
		this.CargarTabla();
		
		this.vtCreacionSolicitud.Open();
	}
	
	private void CargarTabla() {
		this.vtCreacionSolicitud.getModelTable().setRowCount(0);
		this.vtCreacionSolicitud.getModelTable().setColumnCount(0);
		this.vtCreacionSolicitud.getModelTable().setColumnIdentifiers(this.vtCreacionSolicitud.getNombreColumnas());
		
		String fecha = this.vtCreacionSolicitud.getTxtFecha().getText().trim();
		String numPedido = this.vtCreacionSolicitud.getTxtNumpedido().getText().trim();
		
		for(MateriaPrimaSolicitudDTO m:this.mdlSolicitud.GetMateriasPrimas(fecha, numPedido)) {
			String unidad = this.mdlMateriaPrima.ObtenerUnidad(m.getMateriaPrima());
			Object[] fila = {m.getMateriaPrima(), m.getCantidad() + " " + unidad};
			this.vtCreacionSolicitud.getModelTable().addRow(fila);
		}
		this.vtCreacionSolicitud.getTable().setModel(this.vtCreacionSolicitud.getModelTable());
	}
	
	private void CargarFecha() {
		Calendar c = Calendar.getInstance();
		String fecha = Integer.toString(c.get(Calendar.YEAR));
		
		String mes = Integer.toString(c.get(Calendar.MONTH)); 
		if(mes.length() == 1)
			mes = "0" + mes;
		fecha = fecha + "-" + mes;
		
		String dia = Integer.toString(c.get(Calendar.DATE));
		if(dia.length() == 1)
			dia = "0" + dia;
			
		fecha = fecha + "-" + dia;
		
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
		String FechaCreacion = this.vtCreacionSolicitud.getTxtFecha().getText().trim();
		
		int NumPedido;
		if(this.vtCreacionSolicitud.getTxtNumpedido().getText().equals("NEXT")) {
			NumPedido = this.mdlSolicitud.ObtenerNumNuevaSolicitud(FechaCreacion);
		}
		else{
			NumPedido = Integer.parseInt(this.vtCreacionSolicitud.getTxtNumpedido().getText().trim());
		}
		
		String FechaEnvio = FechaCreacion;
		int referenciaNumeroPedido = NumPedido;
		
		SolicitudDTO sol = new SolicitudDTO(FechaCreacion, NumPedido, true, FechaEnvio, referenciaNumeroPedido);
		
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
	
	private void GuardarPedido() {
		String FechaCreacion = this.vtCreacionSolicitud.getTxtFecha().getText();
		
		int NumPedido;
		if(this.vtCreacionSolicitud.getTxtNumpedido().getText().equals("NEXT")) {
			NumPedido = this.mdlSolicitud.ObtenerNumNuevaSolicitud(FechaCreacion);
		}
		else{
			NumPedido = Integer.parseInt(this.vtCreacionSolicitud.getTxtNumpedido().getText().trim());
		}
		
		String FechaEnvio = FechaCreacion;
		int referenciaNumeroPedido = NumPedido;
		
		SolicitudDTO sol = new SolicitudDTO(FechaCreacion, NumPedido, false, FechaEnvio, referenciaNumeroPedido);
		
		String proveedor = this.vtCreacionSolicitud.getTxtIdproveedor().getText().trim();
		
		this.mdlSolicitud.GuardarSolicitud(sol, proveedor, this.GetMateriasPrimas());	
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
			this.ctrSolicitud.CargarTabla();
			this.vtCreacionSolicitud.Close();
		}
		
		else if(arg0.getSource() == this.vtCreacionSolicitud.getBtnGuardar()) {
			this.GuardarPedido();
			this.ctrSolicitud.CargarTabla();
			this.vtCreacionSolicitud.Close();
		}
		else if(arg0.getSource() == this.vtCreacionSolicitud.getBtnVolver()) {
			this.vtCreacionSolicitud.Close();
		}
	}
}