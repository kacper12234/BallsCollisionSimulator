package collision;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class AppLogic {

	
	private List <Ball> balls=new ArrayList <Ball>();
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

	public class Ball {

        double d,m;
        Vector p;
        Vector v;
        Color color;

        private Ball(double px, double py, double vx, double vy, double d,double m, Color color) {
     
            this.d = d;
            this.m=m;
            p = new Vector(px, py, Color.BLACK);
            v = new Vector(vx, vy, Color.BLACK);
      
            this.color = color;
        }

        public void draw(Graphics g) {
            g.setColor(color);
            g.fillOval((int) (p.getX() - d / 2), (int) (p.getY() - d / 2), (int) d, (int) d);    
        }

        public boolean collides(Ball b) {
            return p.sub(b.p, color).getSize()<=(d/2+b.d/2);
        }

        public void transferEnergy(Ball b) {  
            
            Vector nv2 = b.p.sub(p, color);
            double dl=nv2.getSize();
         
            nv2.normalize();  
            double dt=(d/2+b.d/2-dl)/(v.dot(nv2)-b.v.dot(nv2));
          
           double optimizedP =v.dot(nv2)+ (2 * (b.v.dot(nv2) -v.dot(nv2))) / (1+m/b.m);
           double optimizedP2 =b.v.dot(nv2)+ (2 * (v.dot(nv2) -b.v.dot(nv2))) / (1+b.m/m);
            
double vb1=v.adot(nv2);
double vb2=b.v.adot(nv2);

if(dl<(d/2+b.d/2))
{

p.sub2(v.multiply2(dt), color);
b.p.sub2(b.v.multiply2(dt), color);

}
            b.v = new Vector(optimizedP2*nv2.getX()-vb2*nv2.getY(),optimizedP2*nv2.getY()+vb2*nv2.getX(),color);                   //vx2*(cosa)^2-vy2*cosa*sina+vx1*(sina)^2+vy1*cosa*sina
            v =new Vector (optimizedP*nv2.getX()-vb1*nv2.getY(),optimizedP*nv2.getY()+vb1*nv2.getX(),color);   
        }
     
        
        public void update() {
            // Com CCD	
            p.setX(p.getX() + v.getX());
            p.setY(p.getY() + v.getY());
            for (Ball b : balls) {
            	if(this !=b && collides(b))
            	{
            		if(v.getX()*b.v.getX()>0 && Math.abs(b.v.getX())>Math.abs(v.getX()))
            		b.p.setX(b.p.getX() + b.v.getX());
            		if(v.getY()*b.v.getY()>0 && Math.abs(b.v.getY())>Math.abs(v.getY()))
                    b.p.setY(b.p.getY() + b.v.getY());
 
            		if ( collides(b)) {
                    p.setX(p.getX() - v.getX());
                    p.setY(p.getY() - v.getY());
    
                    transferEnergy(b);
                    break;
                }
            	}
            }
            updateWallCollision();
           applyTableFriction();
        }
        
        private void updateWallCollision() {    //ustawianie kolizji ze scianą
            // borda
            if (p.getX()-d/2<-gui.getWidth()/2){
                v.setX(Math.abs(v.getX()));
            }
            else if (p.getX()+d/2>gui.getWidth()*0.32){
                v.setX(-Math.abs(v.getX()));
            }
            if (p.getY()-d/2<-gui.getHeight()/2+30){
                v.setY(Math.abs(v.getY()));
            }
            else if (p.getY()+d/2>gui.getHeight()/2){
                v.setY(-Math.abs(v.getY()));
            }
        }
        
        private void applyTableFriction() {  //wytracanie prędkości
        	if(v.getX()!=0)
        	if(v.getX()>0)
            v.setX(v.getX()-f*9.81/d*2/200);
        	else
        		v.setX(v.getX()+f*9.81/d*2/200 );
        	if(v.getY()!=0)
        		if(v.getY()>0)
            v.setY(v.getY()-f*9.81/d*2/200 );
        		else
        			v.setY(v.getY()+f*9.81/d*2/200 );
        }
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
		for (Ball b : gui.getAppLogic().getBalls())	
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
				Double.parseDouble(gui.getButtons().getD().getValue().toString()),Double.parseDouble(gui.getButtons().getM().getValue().toString()), new Color(rand.nextInt(0x1000000))));
		}
		else
		gui.ErrorMsg("Podany obszar był zajęty");
		}
		else
		gui.ErrorMsg("Część kuli znajduje się poza obszarem. Zmień współrzędne.");
		}
   
    public class MainLoop extends TimerTask {

        @Override
        public void run() {
            update();
            try {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        gui.repaint();
                    }
                });
            } catch (Exception ex) {
                Logger.getLogger(AppLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void startT()
    {
    	timer = new Timer();
    	timer.scheduleAtFixedRate(new MainLoop(), 0, 5);
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
    }
