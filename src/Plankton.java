import java.util.Random;

import com.jogamp.opengl.GL2;

public class Plankton {
	float r ;
	float g;
	float b;
	double x;
	double y;
	Random rand = new Random();
	
	public Plankton(float r, float g, float b, double x, double y){
		this.r = r;
		this.g = g;
		this.b = b;
		this.x = x;
		this.y = y;
		
	}
	public void draw(GL2 gl) {
		
		gl.glPointSize(4);// set the point size
		gl.glBegin(GL2.GL_POINTS);// create the random points
		for (int i = 0; i < 100; i++) {
			r= rand.nextFloat();
			g= rand.nextFloat();
			b= rand.nextFloat();
			x =rand.nextFloat() * 2 - 1;
			y= rand.nextFloat() * 1 - 0.4;
			gl.glVertex2d(x, y);
			gl.glColor3f(r, g, b);
			
		}
		gl.glEnd();

		gl.glFlush();
	}

}
