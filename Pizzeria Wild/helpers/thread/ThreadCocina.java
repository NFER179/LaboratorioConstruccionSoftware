package thread;

import javax.swing.JScrollBar;
import javax.swing.JTable;

import vista.CocinaVista;

public class ThreadCocina extends Thread {

	private JScrollBar vbar;
	
	public ThreadCocina(JScrollBar Vbar){
		this.vbar = Vbar;
	}
	
	@Override
	public void run(){
		int pos = this.vbar.getMinimum();
		while(true) {
			
			this.vbar.setValue(pos);
			this.vbar.paint(this.vbar.getGraphics());
//			this.vtCocina.getTblPedido3().scrollRectToVisible(this.vtCocina.getTblPedido3().getVisibleRect());
//			this.vtCocina.getTblPedido3().paint(this.vtCocina.getTblPedido3().getGraphics());
			try {
				if(pos == this.vbar.getMinimum())
					sleep(5000);
				sleep(150);
			} catch (InterruptedException ex) {
				ex.printStackTrace();//Logger.getLogger(ScrollTextView.class.getName()).log(Level.SEVERE, null, ex);
			}
			
			pos++;
			if(pos >= this.vbar.getMaximum())
				pos = this.vbar.getMinimum();
			System.out.println(pos);
		}
	}
}
