import java.util.Random;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import java.util.ArrayList;

public class SeaWeed {
	Random random = new Random();
	private ArrayList<Double> pointX = new ArrayList<Double>();
	private ArrayList<Double> pointY = new ArrayList<Double>();

	
	public double cx;
	public double cy;
	public double r;
	public double g;
	public double b;
	public double a;
	
	//Seaweed constructor
	public SeaWeed(double cx, double cy, double r, double g, double b, double a) {
		this.cx = cx;
		this.cy = cy;
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;

		for (double deg = 0; deg <= 361; deg += 0.3) {

			double dx = random.nextDouble() / 36;
			double dy = random.nextDouble() / 36;
			double x = cx + Math.cos(Math.toRadians(deg)) * 0.25 + dx;
			double y = cy + Math.sin(Math.toRadians(deg)) * 0.25 + dy;

			pointX.add(x);
			pointY.add(y);

		}

	}

	public void draw(GL2 gl) { // draw seaweed
		gl.glEnable(GL2.GL_BLEND);
		// set the blending mode
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
		gl.glVertex2d(cx, cy);
		gl.glBegin(GL2.GL_TRIANGLE_FAN);
		
		for (int i = 0; i < pointX.size(); i++) {
			double x = pointX.get(i);
			double y = pointY.get(i);
			gl.glColor4d(r, g, b, a);
			gl.glVertex2d(x, y);

		}
		gl.glEnd();

		gl.glDisable(GL2.GL_BLEND);

	}

}
