package collision;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Events implements ActionListener{


	private Buttons panel;
	
	
	public Events(Buttons buttons)
	{
		panel=buttons;
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
			panel.getGui().getAppLogic().newBall();
			panel.getGui().repaint();
		}
		if(o==panel.getStart())
		{
			panel.getGui().getAppLogic().setF(Double.parseDouble(panel.getFt().getValue().toString()));
			panel.getGui().getAppLogic().startT();
			panel.getStart().setVisible(false);
			panel.getPause().setVisible(true);
		}
		if(o==panel.getPause())
		{
			panel.getGui().getAppLogic().pauseT();
			panel.getStart().setVisible(true);
			panel.getPause().setVisible(false);
		}
		if(o==panel.getClear())
		{
			panel.getGui().getAppLogic().getBalls().clear();
			panel.getGui().getAppLogic().setL(0);
			panel.getGui().repaint();
		}
		if(o==panel.getRemove() && panel.getGui().getAppLogic().getL()>0)
		{
			
			panel.getGui().getAppLogic().setL(panel.getGui().getAppLogic().getL()-1);
			panel.getGui().getAppLogic().getBalls().remove(panel.getGui().getAppLogic().getL());
			panel.getGui().repaint();
		}
		}
		

	public void ErrorMsg(String e)
	{
		JOptionPane.showMessageDialog(new JFrame(),e,"Błąd",JOptionPane.ERROR_MESSAGE);	
		}
		

}
