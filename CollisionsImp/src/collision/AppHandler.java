package collision;

import java.util.ArrayList;

public class AppHandler {

	private ArrayList <Ball> balls;
	private double f;
	private int l=0;
	
	public AppHandler()
	{
		balls=new ArrayList <Ball>();
	}

	public double getF() {
		return f;
	}

	public void setF(double f) {
		this.f = f;
	}

	public ArrayList<Ball> getBalls() {
		return balls;
	}

	public boolean add(Ball arg0) {
		return balls.add(arg0);
	}

	public void clear() {
		balls.clear();
	}

	public void remove(int i) {
		balls.remove(i);
	}

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}
	
	
	
}
