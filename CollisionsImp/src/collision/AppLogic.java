package collision;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.util.Random;


public class AppLogic implements LogicInterface,DrawInterface{

	
	private Color bgcolor = Color.BLACK;
	private GuiInterface gui;
	private Timer timer;
	private Random rand;
	private boolean areaNotBusy;
	private InputValues buttons;
	private AppHandler handler;
	
	public AppLogic(GUI parentgui,InputValues buttons)
	{
		gui=parentgui;
		this.buttons=buttons;
		handler=new AppHandler();
	}

    public void update() {
        for (Ball b : handler.getBalls()) {
            b.update();
        }
    }
   @Override
   public void draw(Graphics g) {
        ((Graphics2D) g).setBackground(bgcolor);
        g.clearRect(0, 0, gui.getWidth(), gui.getHeight());

        g.translate(gui.getWidth() / 2, gui.getHeight() / 2);
        ((Graphics2D) g).scale(1, -1);

        for (Ball b : handler.getBalls()) {
            b.draw(g);
        }
    }

	@Override
    public void newBall() {
		if(Math.abs(buttons.getPosxValue())+buttons.getDiamValue()/2<=550
				&& Math.abs(buttons.getPosyValue())+buttons.getDiamValue()/2<=400)
		{
		rand = new Random();

		Vector n = new Vector(buttons.getPosxValue()-0.1*gui.getWidth(), buttons.getPosyValue() ,Color.BLACK);
		areaNotBusy=true;
		for (Ball b : handler.getBalls())	
		{
			if(n.sub(b.getP(), Color.BLACK).getSize() < (buttons.getDiamValue()/2 + b.d / 2))
			{
			areaNotBusy=false;
			break;
			}
		}
		if(areaNotBusy)
		{
		handler.setL(handler.getL()+1);
		handler.add(new Ball( buttons.getPosxValue()-gui.getWidth()/10, buttons.getPosyValue(),
				buttons.getSpeedxValue(), buttons.getSpeedyValue(), 
				buttons.getDiamValue(),buttons.getMassValue(), new Color(rand.nextInt(0x1000000)),handler,gui));
		}
		else
		ErrorMsg("Podany obszar był zajęty");
		}
		else
		ErrorMsg("Część kuli znajduje się poza obszarem. Zmień współrzędne.");
		}
   
	public void ErrorMsg(String e)
	{
		JOptionPane.showMessageDialog(new JFrame(),e,"Błąd",JOptionPane.ERROR_MESSAGE);	
	}
    
    @Override
    public void start()
    {
    	timer = new Timer();
    	timer.scheduleAtFixedRate(new MainLoop(this), 0, 8);
    }

    @Override
    public void clear()
    {
    	handler.clear();
		handler.setL(0);
    }
    
    @Override
    public void remove()
    {
    	if(handler.getL()>0)
    	{
    	handler.setL(handler.getL()-1);
		handler.remove(handler.getL());
    	}
    }
    
    @Override
    public void setFriction(double value)
    {
    	handler.setF(value);
    }
    
    @Override
    public void pause()
    {
    	timer.cancel();
    }

	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		gui.repaint();
	}
    }
