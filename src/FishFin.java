import com.jogamp.opengl.GL2;


public class FishFin {

	private double ticks = 0;
	double x;
	double y;
	double height;
	double width;

	public FishFin(double x, double y, double width) {
		this.x = x;
		this.y = y;
		this.height = 0.08;
		this.width = width;
	}

	public void draw(GL2 gl) {
		// TODO Auto-generated method stub
		ticks++;

		gl.glBegin(GL2.GL_TRIANGLES);// Fish Fin on the left side
		gl.glColor3d(0.45f, 0.49f, 0.51f);
		gl.glVertex2d(x, y);
		gl.glVertex2d(x - width, y + height / 2 + Math.sin(ticks) * 0.03);

		gl.glVertex2d(x - 0.3 * width, y);

		gl.glVertex2d(x, y);
		gl.glVertex2d(x - 0.3 * width, y);
		gl.glVertex2d(x - width, y - height / 2 - Math.cos(ticks) * 0.03);

		gl.glEnd();

	}

}