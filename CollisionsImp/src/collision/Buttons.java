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
		setPreferredSize(new Dimension(300,gui.getHeight()));
		setLayout(null);
		setBackground(Color.ORANGE.darker());
		Font f=new Font("default", Font.BOLD, 12 );
		Font f2=new Font("default", Font.BOLD, 16 );

		m1=new SpinnerNumberModel(42,10,300,1);
		m2=new SpinnerNumberModel(0,-20,20,0.1);
		m2b=new SpinnerNumberModel(0,-20,20,0.1);
		m3=new SpinnerNumberModel(0,-550,550,1);
		m4=new SpinnerNumberModel(0,-400,400,1);
		m5=new SpinnerNumberModel(1,0.1,500,0.1);
		m6=new SpinnerNumberModel(0,0,10,0.1);

		spdx=new JLabel("Podaj prędkość poziomą ");
		spdx.setBounds(80, 90, 300, 40);
		spdx.setFont(f);
		spdx.setVisible(true);
		add(spdx);
		spdy=new JLabel("Podaj prędkość pionową ");
		spdy.setBounds(80, 170, 300, 40);
		spdy.setFont(f);
		spdy.setVisible(true);
		add(spdy);
		pozx=new JLabel("Podaj współrzędną x ");
		pozx.setBounds(90, 250, 300, 40);
		pozx.setFont(f);
		pozx.setVisible(true);
		add(pozx);
		pozy=new JLabel("Podaj współrzędną y ");
		pozy.setBounds(90, 320, 300, 40);
		pozy.setFont(f);
		pozy.setVisible(true);
		add(pozy);
		sr=new JLabel("Podaj średnicę ");
		sr.setBounds(107, 10, 300, 40);
		sr.setFont(f);
		sr.setVisible(true);
		add(sr);
		t=new JLabel("Podaj współczynnik tarcia");
		t.setBounds(80, 590, 300, 40);
		t.setFont(f);
		t.setVisible(true);
		add(t);
		t2=new JLabel("(zmiana po zatrzymaniu i wznowieniu)");
		t2.setBounds(45, 610, 300, 40);
		t2.setFont(f);
		t2.setVisible(true);
		add(t2);
		ms=new JLabel("Podaj masę");
		ms.setBounds(120, 390, 300, 40);
		ms.setFont(f);
		ms.setVisible(true);
		add(ms);
		Add=new JButton("+");
		Add.setBounds(75,480,70,50);
		Add.setFont(f2);
		Add.setForeground(Color.GREEN.darker().darker());
		Add.setVisible(true);
		add(Add);
		Remove=new JButton("-");
		Remove.setBounds(155,480,70,50);
		Remove.setFont(f2);
		Remove.setForeground(Color.RED);
		Remove.setVisible(true);
		add(Remove);
		Start=new JButton("Start");
		Start.setBounds(100,700,100,50);
		Start.setVisible(true);
		Start.setForeground(Color.GREEN.darker().darker());
		Start.setFont(f2);
		add(Start);
		Pause=new JButton("Pauza");
		Pause.setBounds(100,700,100,50);
		Pause.setFont(f2);
		Pause.setForeground(Color.BLUE);
		add(Pause);
		Clear=new JButton("Wyczyść");
		Clear.setBounds(100,540,100,50);
		Clear.setVisible(true);
		Clear.setFont(f);
		add(Clear);
		speedx=new JSpinner(m2);
		speedx.setBounds(100, 130, 100, 30);
		speedx.setVisible(true);  
		add(speedx); 
		speedy=new JSpinner(m2b);
		speedy.setBounds(100, 210, 100, 30);
		speedy.setVisible(true);  
		add(speedy); 
		posx=new JSpinner(m3);
		posx.setBounds(100, 290, 100, 30);
		posx.setVisible(true);  
		add(posx);  
		posy=new JSpinner(m4);
		posy.setBounds(100, 360, 100, 30);
		posy.setVisible(true);  
		add(posy); 
		m=new JSpinner(m5);
		m.setBounds(100, 430, 100, 30);
		m.setVisible(true); 
		add(m);
		d=new JSpinner(m1);
		d.setBounds(100, 50, 100, 30);
		d.setVisible(true);  
		add(d); 
		ft=new JSpinner(m6);
		ft.setBounds(100, 650, 100, 30);
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
