/**Created to Diego 29-9-2015  Tabla con formato finally, todos los datos no se modifican**/
package ValidacionObjetosVista;

import javax.swing.table.DefaultTableModel;

public class WDefaultTableModel extends DefaultTableModel {
	public WDefaultTableModel(Object[][] object, String[] nombreColumnas) {
		super( object, nombreColumnas);
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
