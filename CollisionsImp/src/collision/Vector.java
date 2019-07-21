package collision;
import java.awt.Color;

public class Vector {

	  private double x;
	    private double y;
	    private Color color;

	    public Vector(double x, double y, Color color) {
	        this.x = x;
	        this.y = y;
	        
	        this.color = color;
	    }
	    
		public double getX() {
	        return x;
	    }

	    public void setX(double x) {
	        this.x = x;
	    }

	    public double getY() {
	        return y;
	    }

	    public void setY(double y) {
	        this.y = y;
	    }
	    
	    public void incX(double x) {
	        this.x += x;
	    }

	    public void incY(double y) {
	        this.y += y;
	    }
	    
	    /*public Vector add(Vector v, Color color) {
	        return new Vector(x + v.x, y + v.y, color);
	    }*/
	    
	    public void add2(Vector v, Color color) {
	        x+=v.x;
	        y+=v.y;
	    }

	    public Vector sub(Vector v, Color color) {
	        return new Vector(x - v.x, y - v.y, color);
	    }
	    public void sub2(Vector v, Color color) {
	    	x-=v.x;
	        y-=v.y;
	    }


	    public void multiply(double f) {
	        x *= f;
	        y *= f;
	    }

	    public Vector multiply2(double f)
	    {
	    	return new Vector(x*f,y*f,color);
	    }
	    
	    public void setSize(double size) {
	        normalize();
	        multiply(size);
	    }
	    
	    public double getSize() {
	        return Math.sqrt(x * x + y * y);
	    }

	    public void normalize() {
	        double intensity = getSize();
	        x /= intensity;
	        y /= intensity;
	    }

	    public double dot(Vector v) {
	        return x * v.x + y * v.y;
	    }

	    public double adot(Vector v) {
	        return y * v.x - x * v.y;
	    }
	   
}
