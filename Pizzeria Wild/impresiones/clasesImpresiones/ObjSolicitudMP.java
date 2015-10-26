package clasesImpresiones;

import java.util.ArrayList;

public class ObjSolicitudMP extends ObjModel {

	String fecha;
	String hora;
	String proveedor;
	int numSolicitud;
	ArrayList<ObjMateriaPrima> materiasPrimas;

	public ObjSolicitudMP(String nombreArchivo, String fecha,
			int id) {
		super(nombreArchivo, fecha, "SolicitudMP", id);
		this.materiasPrimas = new ArrayList<ObjMateriaPrima>();
	}

	public ObjSolicitudMP(String nombreArchivo, String fecha,
			int id, String pHora, String pProveedor, int pNumSolicitud,
			ArrayList<ObjMateriaPrima> pMateriasPrimas) {
		super(nombreArchivo, fecha, "SolicitudMP", id);
		this.hora = pHora;
		this.proveedor = pProveedor;
		this.materiasPrimas = pMateriasPrimas;
	}

	public void addMateriaPrima(String nombre, int cantidad) {
		this.materiasPrimas.add(new ObjMateriaPrima(nombre, cantidad));
	}

	public class ObjMateriaPrima {
		String nombre;
		int cantidad;

		public ObjMateriaPrima(String pNombre, int pCantidad) {
			this.nombre = pNombre;
			this.cantidad = pCantidad;
		}
	}

	@Override
	public String[] getParametros() {
		// TODO Auto-generated method stub
		return null;
	}

}
