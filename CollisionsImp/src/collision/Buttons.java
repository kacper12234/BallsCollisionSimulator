package collision;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;

public class Buttons extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton Add;
	private JButton Start;
	private JButton Pause;
	private JButton Clear;
	private JButton Remove;
	private JSpinner speedx;
	private JSpinner speedy;
	private JSpinner posx;
	private JSpinner posy;
	private JSpinner m;
	private JSpinner d;
	private JSpinner ft;
	private JLabel spdx;
	private JLabel spdy;
	private JLabel pozx;
	private JLabel pozy;
	private JLabel sr;
	private JLabel ms;
	private JLabel t,t2;
	private SpinnerModel m1,m2,m3,m4,m5,m6,m2b;
	private GUI gui;
	
	public Buttons(GUI parentgui)
	{
		gui=parentgui;
		int w=(int)(0.2*gui.getWidth());
		int h=gui.getHeight();
		setPreferredSize(new Dimension(w,h));
		setLayout(null);
		setBackground(Color.ORANGE.darker());
		 UIManager.put("Label.font", new Font("default", Font.BOLD, (int)(0.045*w) ));
		Font f2=new Font("default", Font.BOLD, (int)(0.06*w) );

		m1=new SpinnerNumberModel((int)(0.158*w),10,300,1);
		m2=new SpinnerNumberModel(0,-20,20,0.1);
		m2b=new SpinnerNumberModel(0,-20,20,0.1);
		m3=new SpinnerNumberModel(0,-550,550,1);
		m4=new SpinnerNumberModel(0,-400,400,1);
		m5=new SpinnerNumberModel(1,0.1,500,0.1);
		m6=new SpinnerNumberModel(0,0,10,0.1);

		spdx=new JLabel("Podaj prędkość poziomą ");
		spdx.setBounds((int)(0.3*w), (int)(0.11*h), 300, 40);
		spdx.setVisible(true);
		add(spdx);
		spdy=new JLabel("Podaj prędkość pionową ");
		spdy.setBounds((int)(0.3*w), (int)(0.21*h), 300, 40);
		spdy.setVisible(true);
		add(spdy);
		pozx=new JLabel("Podaj współrzędną x ");
		pozx.setBounds((int)(0.34*w), (int)(0.31*h), 300, 40);
		pozx.setVisible(true);
		add(pozx);
		pozy=new JLabel("Podaj współrzędną y ");
		pozy.setBounds((int)(0.34*w), (int)(0.4*h), 300, 40);
		pozy.setVisible(true);
		add(pozy);
		sr=new JLabel("Podaj średnicę ");
		sr.setBounds((int)(0.4*w), (int)(0.01*h), 300, 40);
		sr.setVisible(true);
		add(sr);
		t=new JLabel("Podaj współczynnik tarcia");
		t.setBounds((int)(0.3*w), (int)(0.74*h), 300, 40);
		t.setVisible(true);
		add(t);
		t2=new JLabel("(zmiana po zatrzymaniu i wznowieniu)");
		t2.setBounds((int)(0.15*w), (int)(0.765*h), 300, 40);
		t2.setVisible(true);
		add(t2);
		ms=new JLabel("Podaj masę");
		ms.setBounds((int)(0.42*w), (int)(0.49*h), 300, 40);
		ms.setVisible(true);
		add(ms);
		Add=new JButton("+");
		Add.setBounds((int)(0.28*w),(int)(0.602*h),(int)(0.26*w),(int)(0.065*h));
		Add.setFont(f2);
		Add.setForeground(Color.GREEN.darker().darker());
		Add.setVisible(true);
		add(Add);
		Remove=new JButton("-");
		Remove.setBounds((int)(0.57*w),(int)(0.602*h),(int)(0.26*w),(int)(0.065*h));
		Remove.setFont(f2);
		Remove.setForeground(Color.RED);
		Remove.setVisible(true);
		add(Remove);
		Start=new JButton("Start");
		Start.setBounds((int)(0.37*w),(int)(0.877*h),(int)(0.37*w),(int)(0.065*h));
		Start.setVisible(true);
		Start.setForeground(Color.GREEN.darker().darker());
		Start.setFont(f2);
		add(Start);
		Pause=new JButton("Pauza");
		Pause.setBounds((int)(0.37*w),(int)(0.877*h),(int)(0.37*w),(int)(0.065*h));
		Pause.setFont(f2);
		Pause.setForeground(Color.BLUE);
		add(Pause);
		Clear=new JButton("Wyczyść");
		Clear.setBounds((int)(0.37*w),(int)(0.678*h),(int)(0.37*w),(int)(0.065*h));
		Clear.setVisible(true);
		Clear.setFont(new Font("default", Font.BOLD, (int)(0.045*w) ));
		add(Clear);
		speedx=new JSpinner(m2);
		speedx.setBounds((int)(0.37*w), (int)(0.16*h), (int)(0.37*w), (int)(0.04*h));
		speedx.setVisible(true);  
		add(speedx); 
		speedy=new JSpinner(m2b);
		speedy.setBounds((int)(0.37*w), (int)(0.26*h), (int)(0.37*w), (int)(0.04*h));
		speedy.setVisible(true);  
		add(speedy); 
		posx=new JSpinner(m3);
		posx.setBounds((int)(0.37*w), (int)(0.36*h), (int)(0.37*w), (int)(0.04*h));
		posx.setVisible(true);  
		add(posx);  
		posy=new JSpinner(m4);
		posy.setBounds((int)(0.37*w), (int)(0.45*h), (int)(0.37*w), (int)(0.04*h));
		posy.setVisible(true);  
		add(posy); 
		m=new JSpinner(m5);
		m.setBounds((int)(0.37*w), (int)(0.54*h), (int)(0.37*w), (int)(0.04*h));
		m.setVisible(true); 
		add(m);
		d=new JSpinner(m1);
		d.setBounds((int)(0.37*w), (int)(0.06*h), (int)(0.37*w), (int)(0.04*h));
		d.setVisible(true);  
		add(d); 
		ft=new JSpinner(m6);
		ft.setBounds((int)(0.37*w), (int)(0.815*h), (int)(0.37*w), (int)(0.04*h));
		ft.setVisible(true);  
		add(ft);
		new Events(this);
	}
	
	public JSpinner getFt() {
		return ft;
	}

	public JButton getStart() {
		return Start;
	}

	public JButton getPause() {
		return Pause;
	}

	public JButton getAdd() {
		return Add;
	}

	public JButton getRemove() {
		return Remove;
	}

	public JButton getClear() {
		return Clear;
	}

	public JSpinner getSpeedx() {
		return speedx;
	}

	public JSpinner getSpeedy() {
		return speedy;
	}

	public JSpinner getPosx() {
		return posx;
	}

	public JSpinner getPosy() {
		return posy;
	}

	public JSpinner getM() {
		return m;
	}

	public JSpinner getD() {
		return d;
	}

	public GUI getGui() {
		return gui;
	}
}
