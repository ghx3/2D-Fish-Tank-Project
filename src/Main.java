import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

public class Main implements GLEventListener {
	static int windowWidth = 800;
	static int windowHeight = 600;
	Random rand = new Random();

	boolean time = false;
	boolean time1 = false;
	boolean time2 = false;
	boolean time3 = false;
	boolean time4 = false;
	
	SeaWeed sw = new SeaWeed(-0.35, -0.9, 0.75, 0.35, 0.4, 0.5);
	SeaWeed sw1 = new SeaWeed(-0.6, -1, 0.35, 0.55, 0.4, 0.5);
	
	
	Fish f = new Fish(0.1, 0.3, 0, 0, 0.88, 0.15, 0.14, 0, 0);
	Fish f1 = new Fish(0.05, 0.03, 0, -0.15, 0, 0, 0, 0, -0.15);
	Fish f2 = new Fish(0.03, 0.08, -0.1, 0, 1, 1, 1, -0.1, 0);
	Fish f3 = new Fish(0.03, 0.08, 0.1, 0, 1, 1, 1, 0.1, 0);
	Fish f4 = new Fish(0.015, 0.03, -0.1, 0, 0, 0, 0, -0.1, 0);
	Fish f5 = new Fish(0.015, 0.03, 0.1, 0, 0, 0, 0, 0.1, 0);

	FishFin ff = new FishFin(-0.09, -0.15, 0.1);
	FishFin ff1 = new FishFin(0.09, -0.15, -0.1);

	Button b = new Button(0.125, 0.79, 0.5, -0.95, 0.8, -0.95, 0.95, -0.65, 0.95, -0.65, 0.8, 0.73, 0.81, 0.17, -0.85,
			0.85, "Bubbles");
	Button b1 = new Button(0.125, 0.79, 0.5, -0.55, 0.8, -0.55, 0.95, -0.25, 0.95, -0.25, 0.8, 0.73, 0.81, 0.17, -0.43,
			0.85, "Time");
	Button b2 = new Button(0.125, 0.79, 0.5, -0.15, 0.8, -0.15, 0.95, 0.15, 0.95, 0.15, 0.8, 0.73, 0.81, 0.17, -0.05,
			0.85, "Plankton");
	Button b3 = new Button(0.125, 0.79, 0.5, 0.25, 0.8, 0.25, 0.95, 0.55, 0.95, 0.55, 0.8, 0.73, 0.81, 0.17, 0.35, 0.85,
			"Breath");
	Button b4 = new Button(0.125, 0.79, 0.5, 0.65, 0.8, 0.65, 0.95, 0.95, 0.95, 0.95, 0.8, 0.73, 0.81, 0.17, 0.75, 0.85,
			"Move");

	Time t = new Time();
	Plankton p = new Plankton(rand.nextFloat(), rand.nextFloat(), rand.nextFloat(), rand.nextFloat() * 2 - 1,
			rand.nextFloat() * 1 - 0.4);

	WaterLine w = new WaterLine();// create the water wave
	SandLine sl = new SandLine();// create the sand curve
	//Bubble bb = new Bubble(0, 0);
	BubbleSystem bs = new BubbleSystem();
	//FishBubbles fb = new FishBubbles();
	//ParticleSystem ps = new ParticleSystem();
	@Override
	public void display(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		GL2 gl = drawable.getGL().getGL2();
		gl.glClearColor(1, 1, 1, 1); // white background
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

		gl.glBegin(GL2.GL_POLYGON);// draw the sand area
		gl.glColor3f(0.91f, 0.75f, 0.57f); // Sand Color

		gl.glVertex2f(-1, -1);
		gl.glVertex2f(-1, -0.7f);
		gl.glVertex2f(1, -0.7f);
		gl.glVertex2f(1, -1);
		gl.glEnd();

		w.draw(gl);// draw the water-line
		sl.draw(gl);// draw the sand-line

		// draw seaweed
		sw.draw(gl);
		sw1.draw(gl);

		// draw the fish
		f.draw(gl);
		f1.draw(gl);
		f2.draw(gl);
		f3.draw(gl);
		f4.draw(gl);
		f5.draw(gl);

		// make the fish fins
		ff.draw(gl);
		ff1.draw(gl);
		gl.glBegin(GL2.GL_TRIANGLES);// Fish Fin on the top
		gl.glColor3d(0.45f, 0.49f, 0.51f);
		gl.glVertex2d(0, 0.3);
		gl.glVertex2d(0.01, 0.37);
		gl.glVertex2d(-0.01, 0.37);
		gl.glEnd();

		// to create the button on the top white area
		gl.glBegin(GL2.GL_POLYGON);
		b.draw(gl);
		b1.draw(gl);
		b2.draw(gl);
		b3.draw(gl);
		b4.draw(gl);
		gl.glEnd();

		if (b1.clicked == true) {
			time = !time;
			b1.clicked = false;

		}

		if (time == true) {
			t.time(gl);
			f1.draw(gl);
			f2.draw(gl);
			f3.draw(gl);
			f4.draw(gl);
			f5.draw(gl);
		}

		// random colorful points in sea area
		gl.glBegin(GL2.GL_POINT);
		if (b2.clicked == true) {
			time1 = !time1;
			b2.clicked = false;
		}

		if (time1 == true && t.t > 0.7 && t.t < 1 && t.t > 0.5) {
			p.draw(gl);
		}
		gl.glEnd();

		if (b.clicked == true) {
			time2 = !time2;
			b.clicked = false;
		}
		if (time2 == true) {
			
			bs.animate();
			bs.addBubble(0, -0.7,0.15,1);
			bs.draw(gl);
			
		}

		if (b4.clicked == true) {
			time3 = !time3;
			b4.clicked = false;
		}
		if (time3 == true) {
			w.draw1(gl);
		}
		
		
		if (b3.clicked == true) {
			time4 = !time4;
			b3.clicked = false;
		}

		if (time4 == true ) {
			//fb.draw(gl,0.5);
		}
		gl.glFlush();

	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reshape(GLAutoDrawable arg0, int x, int y, int width, int height) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		Frame frame = new Frame("Assignment1");// draw frame

		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);
		GLCanvas canvas = new GLCanvas(capabilities);
		Main ma = new Main();
		canvas.addGLEventListener(ma);

		frame.add(canvas);
		canvas.addMouseListener(ma.b);
		canvas.addMouseListener(ma.b1);
		canvas.addMouseListener(ma.b2);
		canvas.addMouseListener(ma.b3);
		canvas.addMouseListener(ma.b4);

		frame.setSize(windowWidth, windowHeight);// set the frame size
		final FPSAnimator animator = new FPSAnimator(10);// set the frame change frequency
															
		animator.add(canvas);
		animator.start(); // start the animation
		canvas.requestFocusInWindow();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

				new Thread(new Runnable() {

					public void run() {
						animator.stop();
						System.exit(0);
					}
				}).start();
			}
		});

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		canvas.requestFocusInWindow();
	}

}
