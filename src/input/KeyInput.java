package input;
import World.World;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import graphics.Renderer;

public class KeyInput implements KeyListener {
    public static float LastStep = Renderer.STEP;

    @Override
    public void keyPressed(KeyEvent keyEvent) {


        // +
        if (keyEvent.getKeyCode() == 139 && Renderer.MAX_NUM_OF_ITTERATIONS < 100){
            Renderer.MAX_NUM_OF_ITTERATIONS++;
            System.out.println("MAX_NUM_OF_ITTERATIONS = " + Renderer.MAX_NUM_OF_ITTERATIONS);
            if (LastStep!=Renderer.STEP) Renderer.drawImage();
            else World.update();
            LastStep=Renderer.STEP;
        }
        // -
        if (keyEvent.getKeyCode() == 140 && Renderer.MAX_NUM_OF_ITTERATIONS > 1){
            Renderer.MAX_NUM_OF_ITTERATIONS--;
            System.out.println("MAX_NUM_OF_ITTERATIONS = " + Renderer.MAX_NUM_OF_ITTERATIONS);
            Renderer.drawImage();
            if (LastStep!=Renderer.STEP) Renderer.drawImage();
            else World.update();
            LastStep=Renderer.STEP;
        }
        // num 8
        if (keyEvent.getKeyCode() == 136 || keyEvent.getKeyCode() == 150){
            Renderer.STEP /= 2;
            System.out.println("STEP = " + Renderer.STEP);
            Renderer.drawImage();

        }
        // num 2
        if (keyEvent.getKeyCode() == 130 || keyEvent.getKeyCode() == 152){
            Renderer.STEP *= 2;
            System.out.println("STEP = " + Renderer.STEP);
            Renderer.drawImage();

        }
    }
    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
