package clasesImpresiones;

import java.util.ArrayList;

import dto.MateriaPrimaDTO;
import dto.ProveedorDTO;

public class ObjSolicitudMP extends ObjImprimible {
	private static final int maxPag = 20;
	private static final String tipo = "template_solicitud_mp";
	private ProveedorDTO proveedor;
	private ArrayList<MateriaPrimaDTO> materiasPrimas;

	public ObjSolicitudMP(String nombreArchivo, String fecha, int id) {
		super(nombreArchivo, fecha, tipo, id, maxPag);
		this.materiasPrimas = new ArrayList<MateriaPrimaDTO>();
	}

	public ObjSolicitudMP(String nombreArchivo, String fecha, int id,
			ProveedorDTO pProveedor, int pNumSolicitud,
			ArrayList<MateriaPrimaDTO> pMateriasPrimas) {
		super(nombreArchivo, fecha, tipo, id, maxPag);
		this.proveedor = pProveedor;
		this.materiasPrimas = pMateriasPrimas;
	}

	public ArrayList<MateriaPrimaDTO> getMateriasPrimas() {
		return materiasPrimas;
	}

	public void setMateriasPrimas(ArrayList<MateriaPrimaDTO> materiasPrimas) {
		this.materiasPrimas = materiasPrimas;
	}

	public void addMateriaPrima(String nombre, String unidad) {
		this.materiasPrimas.add(new MateriaPrimaDTO(nombre, unidad));
	}

	public int getCantidadHojas() {
		return (int) Math.ceil(getMateriasPrimas().size()
				/ (getMaxPaginacion() * 1.0));
	}

	public ProveedorDTO getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorDTO proveedor) {
		this.proveedor = proveedor;
	}

}
