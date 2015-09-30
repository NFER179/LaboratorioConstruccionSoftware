package ValidacionObjetosVista;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class WTable extends JTable {
 
		public WTable(DefaultTableModel modelPedidos){
			super(modelPedidos);
			getTableHeader().setReorderingAllowed(false);
		}
}
