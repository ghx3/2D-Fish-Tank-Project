
import com.jogamp.opengl.GL2;

public class Fish {

	double x;
	double y;
	double cirX;
	double cirY;
	double startX;
	double startY;
	double r;
	double g;
	double b;

	double m;// side movement
	double m1;

	public Fish(double x, double y, double startX, double startY, double r, double g, double b, double m, double m1) {
		this.x = x;
		this.y = y;
		this.startX = startX;
		this.startY = startY;
		this.r = r;
		this.g = g;
		this.b = b;

		this.m = m;
		this.m1 = m1;

		for (double cir = 0; cir < 361; cir++) {
			double rad = Math.toRadians(cir);
			cirX = m + x * Math.cos(rad);
			cirY = m1 + y * Math.sin(rad);
		}
	}

	public void draw(GL2 gl) { //draw fish
		// TODO Auto-generated method stub

		gl.glBegin(GL2.GL_TRIANGLE_FAN);// Fish body
		gl.glColor3d(r, g, b);
		gl.glVertex2d(startX, startY);
		for (int cir = 0; cir < 361; cir++) {
			double rad = Math.toRadians(cir);
			cirX = m + x * Math.cos(rad);
			cirY = m1 + y * Math.sin(rad);

			gl.glVertex2d(cirX, cirY);
		}
		gl.glEnd();

	}

}
