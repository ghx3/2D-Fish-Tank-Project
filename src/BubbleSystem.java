import java.util.ArrayList;

import com.jogamp.opengl.GL2;

public class BubbleSystem {
	double time = 0;
	private ArrayList<Bubble> Bubbles;
	private double roundLocation[] = {-0.9, -0.7};
	

    public BubbleSystem() {
        Bubbles = new ArrayList<Bubble>();
    }

    public void addBubble(double x, double y)
    {
        Bubbles.add(new Bubble(x, y));
    }

    public void addBubble(double x, double y, double dx, double dy)
    {
        Bubbles.add(new Bubble(x, y, dx, dy));
    }

    public void animate() {
        time += 0.01;
        roundLocation [0] += 0;
        roundLocation [1] += 0.1;
    	for ( Bubble p : Bubbles )
        {
            // age Bubble
            p.age += time;
           
            // move Bubble
            p.x   += p.dx * time;
            p.y   += p.dy * time;
            
            // apply gravity
            p.dy  -= 1.0 * time;

            // let Bubbles bounce off walls
            if ( roundLocation[1] > -0.5  )
            {
            	roundLocation[0] = -0.85;
            	roundLocation[1] = -0.9;
               // p.dx = -p.dx * 0.9f;
               // p.x += p.dx * time; // step back into the boundary
            }
            
            if ( Math.abs(p.y) > 1.0 )
            {
                p.dy = -p.dy * 0.9f;
                p.y += p.dy * time; // step backward into the boundary
            }
        }

        // remove the oldest Bubble
        // (which should be sitting at the beginning of the list)
        if ( Bubbles.size() > 0 )
        {
            Bubble p = Bubbles.get(0);
            if ( p.age > p.ageMax )
            {
                Bubbles.remove(p);
            }
        }
    }

    public void draw(GL2 gl) {
        gl.glEnable(GL2.GL_BLEND);
        gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
        gl.glPointSize(4.0f);
        gl.glBegin(GL2.GL_LINE_LOOP);
            for ( Bubble p : Bubbles )
            {
            	
                double f = p.age / p.ageMax;
                gl.glColor4d(1, 1 - f, 0, 1.0 -f);
                gl.glVertex2d(p.x -0.35, p.y-0.9);
            }
        gl.glEnd();
        gl.glDisable(GL2.GL_BLEND);
    }

}