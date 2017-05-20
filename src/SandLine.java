import com.jogamp.opengl.GL2;

public class SandLine {
	double a = 0.1;// line length
	double b = -0.7;// sand-line base height
	double f = 10.0;// fractal
	double w = 0.01; // wave frequency

	public SandLine() {

	}

	public void draw(GL2 gl) {

		gl.glColor3f(0.91f, 0.75f, 0.57f);

		for (double i = -1; i <= 1; i += w) {
			gl.glBegin(GL2.GL_POLYGON);
			double x = i;
			double y = b + a * Math.abs(Math.cos(f * x));
			double x1 = i + w;
			double y1 = b + a * Math.abs(Math.cos(f * x1));
			gl.glVertex2d(x, b);
			gl.glVertex2d(x1, b);
			gl.glVertex2d(x1, y1);
			gl.glVertex2d(x, y);
			gl.glEnd();
		}
	}
}
