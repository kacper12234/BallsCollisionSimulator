package collision;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Events implements ActionListener{


	private ButtonsInterface panel;
	private LogicInterface alInterface;

	
	public Events(ButtonsInterface buttons,LogicInterface alInterface)
	{
		panel=buttons;
		this.alInterface=alInterface;
		panel.getAdd().addActionListener(this);
		panel.getPause().addActionListener(this);
		panel.getClear().addActionListener(this);
		panel.getRemove().addActionListener(this);
		panel.getStart().addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		Object o=a.getSource();

		if(o==panel.getAdd())
		{
			alInterface.newBall();
			alInterface.repaint();
		}
		if(o==panel.getStart())
		{
			alInterface.setFriction(panel.getFtValue());
			alInterface.start();
			panel.getStart().setVisible(false);
			panel.getPause().setVisible(true);
		}
		if(o==panel.getPause())
		{
			alInterface.pause();
			panel.getStart().setVisible(true);
			panel.getPause().setVisible(false);
		}
		if(o==panel.getClear())
		{
			alInterface.clear();
			alInterface.repaint();
		}
		if(o==panel.getRemove())
		{
			alInterface.remove();
			alInterface.repaint();
		}
		}
		

}
