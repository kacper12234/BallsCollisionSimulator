package collision;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

    double d,m;
    Vector p;
    Vector v;
    Color color;
    AppLogic al;
 	
    public Ball(double px, double py, double vx, double vy, double d,double m, Color color,AppLogic al) {
 
        this.d = d;
        this.m=m;
        p = new Vector(px, py, Color.BLACK);
        v = new Vector(vx, vy, Color.BLACK);
        this.color = color;
        
        this.al=al;
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
        b.v = new Vector(optimizedP2*nv2.getX()-vb2*nv2.getY(),optimizedP2*nv2.getY()+vb2*nv2.getX(),color);                
        v =new Vector (optimizedP*nv2.getX()-vb1*nv2.getY(),optimizedP*nv2.getY()+vb1*nv2.getX(),color);   
    }
 
    
    public void update() {
        // Com CCD	
        p.setX(p.getX() + v.getX());
        p.setY(p.getY() + v.getY());
        for (Ball b : al.getBalls()) {
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
    
    public void updateWallCollision() {    
    
        if (p.getX()-d/2<-al.getGui().getWidth()/2){
            v.setX(Math.abs(v.getX()));
        }
        else if (p.getX()+d/2>al.getGui().getWidth()*0.32){
            v.setX(-Math.abs(v.getX()));
        }
        if (p.getY()-d/2<-al.getGui().getHeight()/2+30){
            v.setY(Math.abs(v.getY()));
        }
        else if (p.getY()+d/2>al.getGui().getHeight()/2){
            v.setY(-Math.abs(v.getY()));
        }
    }
    
    public void applyTableFriction() {  
    	if(v.getX()!=0)
    	if(v.getX()>0)
        v.setX(v.getX()-al.getF()*9.81/d*2/200);
    	else
    		v.setX(v.getX()+al.getF()*9.81/d*2/200 );
    	if(v.getY()!=0)
    		if(v.getY()>0)
        v.setY(v.getY()-al.getF()*9.81/d*2/200 );
    		else
    			v.setY(v.getY()+al.getF()*9.81/d*2/200 );
    }
}