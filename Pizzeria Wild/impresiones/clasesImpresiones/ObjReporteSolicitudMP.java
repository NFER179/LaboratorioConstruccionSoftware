package clasesImpresiones;

import java.util.ArrayList;

import dto.MateriaPrimaDTO;
import dto.ProveedorDTO;

public class ObjReporteSolicitudMP extends ObjImprimible {
	private static final int maxPag = 35;
	private static final String templatePath = "template_solicitud_mp";
	private ProveedorDTO proveedor;
	private ArrayList<MateriaPrimaDTO> materiasPrimas;

	public ObjReporteSolicitudMP(String nombreArchivo, String fecha, int id,
			ProveedorDTO pProveedor, ObjDatosCliente cliente,
			ArrayList<MateriaPrimaDTO> pMateriasPrimas) {
		super(nombreArchivo, fecha, templatePath, id, maxPag);
		this.proveedor = pProveedor;
		this.materiasPrimas = pMateriasPrimas;
	}

	public ObjReporteSolicitudMP(String fecha, int id, ProveedorDTO pProveedor) {
		super(pProveedor.getNombre(), fecha, templatePath, id, maxPag);
		this.proveedor = pProveedor;
		this.materiasPrimas = new ArrayList<MateriaPrimaDTO>();
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
