package collision;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class GUI extends JFrame implements GuiInterface{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
private Panel Graphic;
private Buttons buttons;
private AppLogic al;


public GUI()
{
	Dimension scrsize=Toolkit.getDefaultToolkit().getScreenSize();
	final int h=(int)(scrsize.height*0.74);
	final int w=(int)(h*1.7);
setSize(w,h);
setTitle("Symulator zderzeń");
 setResizable (false);
 setLayout(new BorderLayout());
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 buttons=new Buttons(this);
 buttons.setVisible(true);
 add(buttons, BorderLayout.EAST);
 al=new AppLogic(this,buttons);
 Graphic=new Panel(this,al);
 Graphic.setVisible(true);
 add(Graphic, BorderLayout.WEST);
 new Events(buttons,al);
 
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
        new GUI().setVisible(true);
}

}