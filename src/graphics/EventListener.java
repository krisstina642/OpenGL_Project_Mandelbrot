package graphics;

import World.World;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class EventListener implements GLEventListener {
    public static GL2 gl = null;

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        GL2 gl2 = glAutoDrawable.getGL().getGL2();
        gl2.glClearColor(1,0,0,1);
        System.out.println("sadasd");

        gl2.glEnable(GL2.GL_TEXTURE_2D);
        gl2.glEnable(GL2.GL_BLEND);
        gl2.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {
        System.exit(0);
    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {  //every frame
        gl = glAutoDrawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        reshape(glAutoDrawable,0,0,0,0);
        World.render();
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int x, int y, int width, int height) {
        GL2 gl = glAutoDrawable.getGL().getGL2();
        Renderer.unitsTall = Renderer.countUnitsTall();

        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        gl.glOrtho(Renderer.cameraX - Renderer.unitsWide / 2,Renderer.cameraX + Renderer.unitsWide / 2,Renderer.cameraY - Renderer.unitsTall / 2,Renderer.cameraY + Renderer.unitsTall / 2,-1,1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
    }
}
