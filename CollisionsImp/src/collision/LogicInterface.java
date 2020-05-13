package collision;


public interface LogicInterface extends RepaintInterface{

	public void newBall();
	public void start();
	public void pause();
	public void clear();
	public void remove();
	public void setFriction(double value);
}
