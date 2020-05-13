package collision;

import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;

public class MainLoop extends TimerTask {

	private RepaintInterface ri;
	
	public MainLoop(RepaintInterface ri)
	{
		this.ri=ri;
	}
	
    @Override
    public void run() {
     ri.update();
        try {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    ri.repaint();
                }
            });
        } catch (Exception ex) {
            Logger.getLogger(AppLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}