package main;

import java.util.Calendar;
import java.util.List;

import dao.ClienteDAO;
import daoImplementacion.ClienteImp;
import dto.ClienteDTO;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar cal1 = Calendar.getInstance();
		
		System.out.println(""+ cal1.get(Calendar.DATE)+"/"+cal1.get(Calendar.MONTH)+"/"+cal1.get(Calendar.YEAR)+" " 
				+cal1.get(Calendar.HOUR)+":"
				+cal1.get(Calendar.MINUTE)+":"+cal1.get(Calendar.SECOND)+":"+cal1.get(Calendar.MILLISECOND));
	
		ClienteImp cliente = new ClienteImp();
		List<ClienteDTO> lc = cliente.GetClientes();
		
		for (ClienteDTO cl:lc){
			System.out.println(cl.getNombre());
		}
	}
}