package collision;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;


class Panel extends JPanel { // custom Panel

/**
* 
*/
private static final long serialVersionUID = 1L;


private DrawInterface di;
private BufferedImage bi;

public Panel(GuiInterface gui,DrawInterface di)
{
	this.di=di;
	 bi = new BufferedImage((int)(gui.getWidth()*0.82), gui.getHeight(), BufferedImage.TYPE_INT_ARGB);
	setPreferredSize(new Dimension((int)(0.82*gui.getWidth()),gui.getHeight()));
}

@Override
public void paintComponent(Graphics g) {
super.paintComponent(g);

di.draw(bi.getGraphics());
g.drawImage(bi, 0, 0, null);
}


}