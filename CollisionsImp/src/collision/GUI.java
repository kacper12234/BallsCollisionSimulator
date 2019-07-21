package collision;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class GUI extends JFrame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
private Panel Graphic;
private Buttons buttons;
private AppLogic appLogic;
private BufferedImage bi;

public GUI()
{
	appLogic=new AppLogic(this);
setSize(1400,800);
setTitle("Symulator zderzeń");
 setResizable (false);
 setLayout(new BorderLayout());
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 Graphic=new Panel(this);
 Graphic.setVisible(true);
 add(Graphic, BorderLayout.WEST);
 buttons=new Buttons(this);
 buttons.setVisible(true);
 add(buttons, BorderLayout.EAST);
  bi = new BufferedImage(1100, getHeight(), BufferedImage.TYPE_INT_ARGB);
setResizable(false);
}

public static void main(String args[]) {

try {
    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            javax.swing.UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (ClassNotFoundException ex) {
    java.util.logging.Logger.getLogger(AppLogic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (InstantiationException ex) {
    java.util.logging.Logger.getLogger(AppLogic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (IllegalAccessException ex) {
    java.util.logging.Logger.getLogger(AppLogic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (javax.swing.UnsupportedLookAndFeelException ex) {
    java.util.logging.Logger.getLogger(AppLogic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
}

java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
        new GUI().setVisible(true);
    }
});
}
public BufferedImage getBi() {
	return bi;
}

public AppLogic getAppLogic() {
	return appLogic;
}

public Buttons getButtons() {
	return buttons;
}

}