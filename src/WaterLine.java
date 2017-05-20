import com.jogamp.opengl.GL2;

public class WaterLine {
	double a = 0.1; // set side length
	double f = 10.0; // set fractal
	double b = 0.6; // set the water-line base
	double w = 0.01; // set wave
	double t = 0.01; // set time
	double b1 = 0.3; // set the water-line base when its changing the level

	public WaterLine() {

	}

	public void draw(GL2 gl) {
		t--;
		gl.glColor3f(0.35f, 0.77f, 0.98f);
		for (double i = -1; i <= 1; i += w) {
			gl.glBegin(GL2.GL_POLYGON);
			double x = i;
			double y = b + a * Math.abs(Math.cos(f * x + t));
			double x1 = i + w;

			double y1 = b + a * Math.abs(Math.cos(f * x1 + t));
			gl.glVertex2d(x, b);
			gl.glVertex2d(x1, b);
			gl.glVertex2d(x1, y1);
			gl.glVertex2d(x, y);
			gl.glEnd();
		}

		gl.glBegin(GL2.GL_POLYGON);// draw the water area
		gl.glColor3f(0.35f, 0.77f, 0.98f); // water color

		gl.glVertex2f(-1, -0.7f);
		gl.glVertex2d(-1, 0.6);
		gl.glVertex2d(1, 0.6);
		gl.glVertex2f(1, -0.7f);
		gl.glEnd();

	}
	
	/*water moves*/
	public void draw1(GL2 gl) {
		t--;
		gl.glColor3f(0.35f, 0.77f, 0.98f);
		double b1 = b + 0.3 * Math.abs(Math.sin(t * 0.1));
		for (double i = -1; i <= 1; i += w) {
			gl.glBegin(GL2.GL_POLYGON);
			double x = i;
			double y = b1 + a *Math.abs(Math.cos(f * x + t));
			double x1 = i + w;
			double y1 = b1 + a * Math.abs(Math.cos(f * x1 + t));
			gl.glVertex2d(x, b);
			gl.glVertex2d(x1, b);
			gl.glVertex2d(x1, y1);
			gl.glVertex2d(x, y);
			
			gl.glEnd();
		}
		
	}
}
