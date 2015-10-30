package clasesImpresiones;

import java.util.ArrayList;

public class ObjSolicitudMP extends ObjImprimible {
	private static final int maxPag = 20;
	private static final String tipo = "Solicitud de MP";
	String fecha;
	String hora;
	String proveedor;
	ArrayList<ObjMateriaPrima> materiasPrimas;

	public ObjSolicitudMP(String nombreArchivo, String fecha, int id) {
		super(nombreArchivo, fecha, tipo, id, maxPag);
		this.materiasPrimas = new ArrayList<ObjMateriaPrima>();
	}

	public ObjSolicitudMP(String nombreArchivo, String fecha, int id,
			String pHora, String pProveedor, int pNumSolicitud,
			ArrayList<ObjMateriaPrima> pMateriasPrimas) {
		super(nombreArchivo, fecha, tipo, id, maxPag);
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

	public int getCantidadHojas() {
		return 0;
	}

}
