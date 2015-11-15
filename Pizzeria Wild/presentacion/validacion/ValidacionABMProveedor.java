package validacion;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.ProveedorModelo;

import vista.ABMProveedorVista;

public class ValidacionABMProveedor {

	private ABMProveedorVista vtABMProveedor;
	private ProveedorModelo mdlProveedor;
	
	public ValidacionABMProveedor(ABMProveedorVista Vista) {
		this.vtABMProveedor = Vista;
		this.mdlProveedor = new ProveedorModelo();
	}

	public boolean QuitarCategoriaValido() {
		boolean valido = true;
		
		if(this.vtABMProveedor.getTblCategoria().getSelectedRowCount() == 0) {
			valido = false;
			String mensaje = "Debe Seleccionar Categorias Para Quitar.";
			String titulo = "No Selecciono Categoria";
			JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
		}
		
		return valido;
	}

	public boolean QuitarMTValido() {
		boolean valido = true;
		
		if(this.vtABMProveedor.getTblMateriaPrima().getSelectedRowCount() == 0) {
			valido = false;
			String mensaje = "Debe Seleccionar Materias Primas Para Quitar.";
			String titulo = "No Selecciono Materia Prima";
			JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
		}
		
		return valido;
	}

	public boolean GuardarValido(boolean Modificar) {
		boolean valido = true;
		
		this.SetBackgroundDefault();
		
		String mensaje = "";
		String titulo = "Campos sin Datos";
		
		String proveedor = this.vtABMProveedor.getTxtProveedorid().getText().trim();
		if(this.mdlProveedor.ExisteProvedor(proveedor) & !Modificar) {
			titulo = "Error de Duplicidad.";
			mensaje = "- El Id de Proveedor ya se Encuentra en uso.";
			this.vtABMProveedor.getTxtProveedorid().setBackground(Color.RED);
			valido = false;
		}
		else {
			if(this.vtABMProveedor.getTxtProveedorid().getText().trim().equals("")) {
				mensaje = mensaje + "- Debe Cargar un Id de Proveedor.\n";
				this.vtABMProveedor.getTxtProveedorid().setBackground(Color.RED);
				valido = false;
			}
			
			if(this.vtABMProveedor.getTxtNombreproveedor().getText().trim().equals("")) {
				mensaje = mensaje + "- Debe Ingresar un Nombre de Proveedor.\n";
				this.vtABMProveedor.getTxtNombreproveedor().setBackground(Color.RED);
				valido = false;
			}
			
			if(this.vtABMProveedor.getTxtTelefono().getText().trim().equals("")) {
				mensaje = mensaje + "- Debe Ingresar un Telefono Para Poder Contactar al Proveedor.\n";
				this.vtABMProveedor.getTxtTelefono().setBackground(Color.RED);
				valido = false;
			}
			
			if(this.vtABMProveedor.getTxtMail().getText().trim().equals("")){
				mensaje = mensaje + "- Debe Ingresar una Direccion de Mail Para poder Enviar las Solicitudes.\n";
				this.vtABMProveedor.getTxtMail().setBackground(Color.RED);
				valido = false;
			}
		}
		
		if(!valido)
			JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
		
		return valido;
	}

	private void SetBackgroundDefault() {
		JTextField b = new JTextField();
		Color colorDefault = b.getBackground();
		
		this.vtABMProveedor.getTxtProveedorid().setBackground(colorDefault);
		this.vtABMProveedor.getTxtNombreproveedor().setBackground(colorDefault);
		this.vtABMProveedor.getTxtTelefono().setBackground(colorDefault);
		this.vtABMProveedor.getTxtMail().setBackground(colorDefault);
	}
}
