package clasesImpresiones;

import java.util.ArrayList;

public class ObjSolicitudMP {
	String NombreArchivo;
	String fecha;
	String hora;
	String proveedor;
	int numSolicitud;
	ArrayList<ObjMateriaPrima> materiasPrimas;

	public ObjSolicitudMP() {
		this.materiasPrimas = new ArrayList<ObjMateriaPrima>();
	}

	public ObjSolicitudMP(String pNombreArchivo, String pFecha, String pHora, String pProveedor, int pNumSolicitud,
			ArrayList<ObjMateriaPrima> pMateriasPrimas) {
		this.NombreArchivo = pNombreArchivo;
		this.fecha = pFecha;
		this.hora = pHora;
		this.proveedor = pProveedor;
		this.numSolicitud = pNumSolicitud;
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

}
