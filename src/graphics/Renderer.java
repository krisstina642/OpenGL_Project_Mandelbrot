package graphics;

import World.Tile;
import World.World;
import com.jogamp.nativewindow.WindowClosingProtocol;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;
import input.KeyInput;
import input.MouseInput;

public class Renderer {
    private static GLWindow window = null;

    public static int screenWidth = 1080;
    public static int screenHeight = 680;

    public static float unitsWide = 6;
    public static float unitsTall;

    public static float STEP = 1/30f;  //1/180f
    public static int MAX_NUM_OF_ITTERATIONS = 10; //20

    public static float cameraX = 0;
    public static float cameraY = 0;

    private static GLEventListener eventListener;

    public static float countUnitsTall(){
        unitsTall =  Renderer.getWindowHeight() / ( Renderer.getWindowWidth() / Renderer.unitsWide );
        return unitsTall;
    }

    public static void init(){
        unitsTall =  screenHeight / ( screenWidth / unitsWide );
        GLProfile.initSingleton();
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities caps = new GLCapabilities(profile);

        window = GLWindow.create(caps);
        window.setSize(screenWidth, screenHeight);
        window.setResizable(false);
        eventListener = new EventListener();
        window.addGLEventListener(eventListener);
        window.addMouseListener(new MouseInput());
        window.addKeyListener(new KeyInput());
        window.setDefaultCloseOperation(WindowClosingProtocol.WindowClosingMode.DISPOSE_ON_CLOSE);

        FPSAnimator animator = new FPSAnimator(window, 60);
        animator.start();

        window.setVisible(true);
    }

    public static void main(String[] args) {
        init();
        drawImage();
    }

    public static void drawImage(){
        for (int y = Math.round((Renderer.cameraY - Renderer.unitsTall / 2) / Renderer.STEP); y < Math.round((Renderer.cameraY + Renderer.unitsTall / 2) / Renderer.STEP + 1); y++){
            for (int x = Math.round((Renderer.cameraX - Renderer.unitsWide / 2) / Renderer.STEP); x < Math.round((Renderer.cameraX + Renderer.unitsWide / 2) / Renderer.STEP + 1); x++){
                Tile tile = new Tile();
                tile.x = tile.width * x;
                tile.y = tile.height * y;
                World.addTile(tile);
            }
        }
        World.update();
    }

    public static int getWindowWidth(){
        return window.getWidth();
    }

    public static int getWindowHeight(){
        return window.getHeight();
    }
}
