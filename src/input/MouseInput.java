package input;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import graphics.Renderer;

public class MouseInput implements MouseListener {

    private static boolean pressed = false;
    private static int pressed_x ;
    private static int pressed_y ;
    private static float dx;
    private static float dy;
    private static float rendX;
    private static float rendY;

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println(mouseEvent.getX()+ " "+mouseEvent.getY());
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        pressed = true;
        pressed_x = mouseEvent.getX();
        pressed_y = mouseEvent.getY();
        rendX = Renderer.cameraX;
        rendY = Renderer.cameraY;
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        pressed = false;
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        if(!pressed) return;
        dx = (mouseEvent.getX() - pressed_x) * Renderer.unitsWide / (float) Renderer.screenWidth;
        dy = (mouseEvent.getY() - pressed_y) * Renderer.unitsTall / (float) Renderer.screenHeight;
        Renderer.cameraX = rendX - dx;
        Renderer.cameraY = rendY + dy;
        Renderer.drawImage();
    }

    @Override
    public void mouseWheelMoved(MouseEvent mouseEvent) {
        float x = mouseEvent.getX();
        float y = mouseEvent.getY();
        float direction = mouseEvent.getRotation()[1] > 0 ? 0.9f : 1.1f;
        Renderer.unitsWide *= direction;
        Renderer.STEP *= direction;
        dx = (mouseEvent.getX() - Renderer.screenWidth/2) * Renderer.unitsWide / (float) Renderer.screenWidth;
        dy = (mouseEvent.getY() - Renderer.screenHeight/2) * Renderer.unitsTall / (float) Renderer.screenHeight;
        Renderer.cameraX = Renderer.cameraX+dx*(1-direction);
        Renderer.cameraY = Renderer.cameraY-dy*(1-direction);
        Renderer.drawImage();
    }
}
