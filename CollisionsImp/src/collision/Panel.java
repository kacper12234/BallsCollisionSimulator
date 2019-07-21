package collision;


import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;


class Panel extends JPanel { // custom Panel

/**
* 
*/
private static final long serialVersionUID = 1L;


private GUI gui;

public Panel(GUI parentgui)
{
	gui=parentgui;
	setPreferredSize(new Dimension(1100,gui.getHeight()));
	
}

@Override
public void paintComponent(Graphics g) {
super.paintComponent(g);

gui.getAppLogic().draw(gui.getBi().getGraphics());
g.drawImage(gui.getBi(), 0, 0, null);
}


}