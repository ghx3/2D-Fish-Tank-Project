
import com.jogamp.opengl.GL2;

public class Time {

	public double t;//set time variable 

	public void time(GL2 gl) { //time cycle condition
		double a;
		if (t < 0.5) {
			a = t * 2;

		} else if (t < 0.7 /* && t > 0.5 */) {
			a = 1.0;
		}

		else {
			a = 1 - (t - 0.7) / 0.5;

		}

		t += 0.01;
		if (t > 1) {
			t = t - 0.9;

		}

		gl.glEnable(GL2.GL_BLEND); //make the blending effect to cover the whole frame
		// set the blending mode
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);

		gl.glBegin(GL2.GL_POLYGON);
		gl.glColor4d(0, 0, 0, a);
		gl.glVertex2d(-1, 1);
		gl.glVertex2d(1, 1);
		gl.glVertex2d(1, -1);
		gl.glVertex2d(-1, -1);
		gl.glEnd();
		gl.glDisable(GL2.GL_BLEND);

	}

}
