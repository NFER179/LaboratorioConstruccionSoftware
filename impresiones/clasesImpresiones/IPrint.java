package clasesImpresiones;

public interface IPrint {

	void ImprimirComanda(String NombreArchivo, ObjComanda comanda);

	void ImprimirTicketCliente(String NombreArchivo,
			ObjTicketCliente ticketCliente);

	void ImprimirItinerario(String NombreArchivo, ObjItinerario itinerario);

	void ImprimirReporteDiario(String NombreArchivo, ObjReporte reporte);

	void ImprimirSolicitudMP(String NombreArchivo, ObjItinerario itinerario);

}
