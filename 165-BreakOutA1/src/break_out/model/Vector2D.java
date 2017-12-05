package break_out.model;
import break_out.Constants;

public class Vector2D {
	private double dx = 1;
	private double dy = 1;

	
	public Vector2D() {
		this.dx = dx;
		this.dy = dy;
	}
	
		
	public Vector2D(double x, double y) {
		dx = x;
		dy = y;
	}
	
	
	
	public void rescale() {
		
		Constants constant = new Constants();
		
		Vector2D Richtungsvektor = new Vector2D();		
		
		Richtungsvektor.dx = 1;
		Richtungsvektor.dy = 1;
				
		this.dx = Richtungsvektor.dx * constant.BALL_SPEED;
		this.dy = Richtungsvektor.dy * constant.BALL_SPEED;		
		
	}
	
	
	public double getDX() {
		return dx;
	}
	
	public double getDY() {
		return dy;
	}
	
	public void setDX(double dx) {
		this.dx = dx;
	}
		
	public void setDY(double dy) {
		this.dy = dy;
	}
}
