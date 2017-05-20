
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.jogamp.opengl.GL2;

import com.jogamp.opengl.util.gl2.GLUT;

public class Button implements MouseListener {
	private int font = GLUT.BITMAP_TIMES_ROMAN_24;

	double x, x1, x2, x3, x4;
	double y, y1, y2, y3, y4;

	private double r, r1;
	private double g, g1;
	private double b, b1;

	double openglX;
	double openglY;
	double mouseX;
	double mouseY;
	
	//condition for button clicked 
	public boolean clicked = false;

	String text;
	
	//constructor for button
	public Button(double r, double g, double b, double x1, double y1, double x2, double y2, double x3, double y3,
			double x4, double y4, double r1, double g1, double b1, double x, double y, String text) {

		this.x = x;
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.x4 = x4;
		this.y = y;
		this.y1 = y1;
		this.y2 = y2;
		this.y3 = y3;
		this.y4 = y4;
		this.r = r;
		this.r1 = r1;
		this.g = g;
		this.g1 = g1;
		this.b = b;
		this.b1 = b1;
		this.text = text;
	}

	public void draw(GL2 gl) { // draw button
		// TODO Auto-generated method stub

		GLUT glut = new GLUT();
		
		//change button color
		if (clicked) {	
			gl.glBegin(GL2.GL_POLYGON);
			gl.glColor3d(0.45f, 0.49f, 0.51f);
			gl.glVertex2d(x1, y1);
			gl.glVertex2d(x2, y2);
			gl.glVertex2d(x3, y3);
			gl.glVertex2d(x4, y4);
			gl.glEnd();

			gl.glColor3d(r1, g1, b1);

			gl.glRasterPos2d(x, y);
			glut.glutBitmapString(font, text);
		} else {
			gl.glBegin(GL2.GL_POLYGON);
			gl.glColor3d(r, g, b);
			gl.glVertex2d(x1, y1);
			gl.glVertex2d(x2, y2);
			gl.glVertex2d(x3, y3);
			gl.glVertex2d(x4, y4);
			gl.glEnd();

			gl.glColor3d(r1, g1, b1);

			gl.glRasterPos2d(x, y);
			glut.glutBitmapString(font, text);
		}

	}

	@Override
	//mouse clicked action
	public void mouseClicked(MouseEvent e) { 
		mouseX = e.getX();

		mouseY = Main.windowHeight - e.getY();

		openglX = 2.0 * (mouseX / Main.windowWidth) - 1.0;

		openglY = 2.0 * (mouseY / Main.windowHeight) - 1.0;
		

		if (openglX >= x1 && openglX <= x3 && openglY >= y1 && openglY <= y2 ) {
			clicked = true;
		}

		

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
