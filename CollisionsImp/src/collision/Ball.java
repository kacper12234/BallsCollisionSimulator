package collision;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

    double m;
    int d;
    private Vector p;
    private Vector v;
    private Color color;
    private AppHandler handler;
    private GuiInterface gui;
 	
    public Ball(int px, int py, double vx, double vy, int d,double m, Color color,AppHandler handler,GuiInterface gui) {
 
        this.d = d;
        this.m=m;
        p = new Vector(px, py, Color.BLACK);
        v = new Vector(vx, vy, Color.BLACK);
        this.color = color;
        this.gui=gui;
        this.handler=handler;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int) (getP().getX() - d / 2), (int) (getP().getY() - d / 2), (int) d, (int) d);    
    }

    public boolean collides(Ball b) {
        return getP().sub(b.getP(), color).getSize()<=(d/2+b.d/2);
    }

    public void transferEnergy(Ball b) {  
        
        Vector nv2 = b.getP().sub(getP(), color);
        double dl=nv2.getSize();
     
        nv2.normalize();  
        double dt=(d/2+b.d/2-dl)/(v.dot(nv2)-b.v.dot(nv2));
      
       double optimizedP =v.dot(nv2)+ (2 * (b.v.dot(nv2) -v.dot(nv2))) / (1+m/b.m);
       double optimizedP2 =b.v.dot(nv2)+ (2 * (v.dot(nv2) -b.v.dot(nv2))) / (1+b.m/m);
        
double vb1=v.adot(nv2);
double vb2=b.v.adot(nv2);

if(dl<(d/2+b.d/2))
{

getP().sub2(v.multiply2(dt), color);
b.getP().sub2(b.v.multiply2(dt), color);

}
        b.v = new Vector(optimizedP2*nv2.getX()-vb2*nv2.getY(),optimizedP2*nv2.getY()+vb2*nv2.getX(),color);                
        v =new Vector (optimizedP*nv2.getX()-vb1*nv2.getY(),optimizedP*nv2.getY()+vb1*nv2.getX(),color);   
    }
 
    
    public void update() {
        // Com CCD	
        getP().setX(getP().getX() + v.getX());
        getP().setY(getP().getY() + v.getY());
        for (Ball b : handler.getBalls()) {
        	if(this !=b && collides(b))
        	{
        		if(v.getX()*b.v.getX()>0 && Math.abs(b.v.getX())>Math.abs(v.getX()))
        		b.getP().setX(b.getP().getX() + b.v.getX());
        		if(v.getY()*b.v.getY()>0 && Math.abs(b.v.getY())>Math.abs(v.getY()))
                b.getP().setY(b.getP().getY() + b.v.getY());

        		if ( collides(b)) {
                getP().setX(getP().getX() - v.getX());
                getP().setY(getP().getY() - v.getY());

                transferEnergy(b);
                break;
            }
        	}
        }
        updateWallCollision();
       applyTableFriction();
    }
    
    public void updateWallCollision() {    
    
        if (getP().getX()-d/2<-gui.getWidth()/2){
            v.setX(Math.abs(v.getX()));
        }
        else if (getP().getX()+d/2>gui.getWidth()*0.3){
            v.setX(-Math.abs(v.getX()));
        }
        if (getP().getY()-d/2<-gui.getHeight()/2+30){
            v.setY(Math.abs(v.getY()));
        }
        else if (getP().getY()+d/2>gui.getHeight()/2){
            v.setY(-Math.abs(v.getY()));
        }
    }
    
    public void applyTableFriction() {  
    	if(v.getX()!=0)
    	if(v.getX()>0)
        v.setX(v.getX()-handler.getF()*9.81/d*2/200);
    	else
    		v.setX(v.getX()+handler.getF()*9.81/d*2/200 );
    	if(v.getY()!=0)
    		if(v.getY()>0)
        v.setY(v.getY()-handler.getF()*9.81/d*2/200 );
    		else
    			v.setY(v.getY()+handler.getF()*9.81/d*2/200 );
    }

	public Vector getP() {
		return p;
	}
}