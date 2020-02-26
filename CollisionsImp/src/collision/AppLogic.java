package collision;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class AppLogic {

	
	private ArrayList <Ball> balls=new ArrayList <Ball>();
	private Color bgcolor = Color.BLACK;
	private GUI gui;
	private Timer timer;
	private Random rand;
	private double f;
	private int l=0;
	private boolean w;
	
	public AppLogic(GUI parentgui)
	{
		gui=parentgui;
	}


    public void update() {
        for (Ball b : balls) {
            b.update();
        }
    }
   
    public void draw(Graphics g) {
        ((Graphics2D) g).setBackground(bgcolor);
        g.clearRect(0, 0, gui.getWidth(), gui.getHeight());

        g.translate(gui.getWidth() / 2, gui.getHeight() / 2);
        ((Graphics2D) g).scale(1, -1);

        for (Ball b : balls) {
            b.draw(g);
        }
    }

    public void newBall() {
		if(Math.abs(Integer.parseInt(gui.getButtons().getPosx().getValue().toString()))+Integer.parseInt(gui.getButtons().getD().getValue().toString())/2<=550
				&& Math.abs(Integer.parseInt(gui.getButtons().getPosy().getValue().toString()))+Integer.parseInt(gui.getButtons().getD().getValue().toString())/2<=400)
		{
		rand = new Random();

		Vector n = new Vector(Integer.parseInt(gui.getButtons().getPosx().getValue().toString())-0.1*gui.getWidth(), Integer.parseInt(gui.getButtons().getPosy().getValue().toString()) ,Color.BLACK);
		w=true;
		for (Ball b : balls)	
		{
			if(n.sub(b.p, Color.BLACK).getSize() < (Integer.parseInt(gui.getButtons().getD().getValue().toString())/2 + b.d / 2))
			{
			w=false;
			break;
			}
		}
		if(w)
		{
		l++;
		balls.add(new Ball( Integer.parseInt(gui.getButtons().getPosx().getValue().toString())-0.1*gui.getWidth(), Integer.parseInt(gui.getButtons().getPosy().getValue().toString()),
				Double.parseDouble(gui.getButtons().getSpeedx().getValue().toString()), Double.parseDouble(gui.getButtons().getSpeedy().getValue().toString()), 
				Double.parseDouble(gui.getButtons().getD().getValue().toString()),Double.parseDouble(gui.getButtons().getM().getValue().toString()), new Color(rand.nextInt(0x1000000)),this));
		}
		else
		gui.ErrorMsg("Podany obszar był zajęty");
		}
		else
		gui.ErrorMsg("Część kuli znajduje się poza obszarem. Zmień współrzędne.");
		}
   
    
    
    public void startT()
    {
    	timer = new Timer();
    	timer.scheduleAtFixedRate(new MainLoop(gui), 0, 5);
    }

    public void pauseT()
    {
    	timer.cancel();
    }
    
    public List<Ball> getBalls() {
		return balls;
	}
   
    public void setL(int l) {
		this.l = l;
	}

	public int getL() {
		return l;
	}

	public void setF(double f) {
		this.f = f;
	}

	public double getF() {
		return f;
	}


	public GUI getGui() {
		return gui;
	}
	
    }
