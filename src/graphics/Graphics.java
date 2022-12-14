package graphics;

import com.jogamp.opengl.GL2;

public class Graphics {

    private static float red = 1;
    private static float green = 1;
    private static float blue = 1;
    private static float alpha = 1;

    private static float rotation = 0;

    //centar u tezistu
    public static void fillRect(float x, float y, float width, float height){
        GL2 gl = EventListener.gl;

        gl.glTranslated( x, y,0 );
        gl.glRotated(rotation,0,0, 1);

        gl.glColor4f(red, green, blue, alpha);
        gl.glBegin(GL2.GL_QUADS);
            gl.glVertex2d(-width/2,-height/2);
            gl.glVertex2d(+width/2,-height/2);
            gl.glVertex2d(+width/2,+height/2);
            gl.glVertex2d(-width/2,+height/2);
        gl.glEnd();
        gl.glFlush();

        gl.glRotated(-rotation,0,0,1 );
        gl.glTranslated( -x, -y,0 );
    }

    public static void setColor(float r, float g, float b, float a){
        red = Math.max(0,Math.min(1,r));
        green = Math.max(0,Math.min(1,g));
        blue = Math.max(0,Math.min(1,b));
        alpha = Math.max(0,Math.min(1,a));
    }
}
