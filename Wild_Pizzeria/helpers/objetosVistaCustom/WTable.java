package objetosVistaCustom;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class WTable extends JTable {
 
		public WTable(DefaultTableModel modelPedidos){
			super(modelPedidos);
			getTableHeader().setReorderingAllowed(false);
		}
}
