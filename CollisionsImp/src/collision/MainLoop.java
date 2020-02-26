package collision;

import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;

public class MainLoop extends TimerTask {

	private GUI gui;
	
	public MainLoop(GUI parentgui)
	{
		gui=parentgui;
	}
	
    @Override
    public void run() {
      gui.getAppLogic().update();
        try {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    gui.repaint();
                }
            });
        } catch (Exception ex) {
            Logger.getLogger(AppLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}