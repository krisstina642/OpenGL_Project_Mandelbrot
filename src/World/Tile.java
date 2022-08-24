package World;

import graphics.Graphics;
import graphics.Renderer;

import java.awt.*;

public class Tile {

    public float x;
    public float y;

    public float width = Renderer.STEP;
    public float height = Renderer.STEP;
    public float red=1;
    public float green=1;
    public float blue=1;
    public float a=1;

    public Tile(){
    }

    public Tile(float x, float y){
        this.x=x;
        this.y=y;
    }

    protected static int HSVToColor( float hsv[]) {
        int rgb = Color.HSBtoRGB(hsv[0] / 360, hsv[1], hsv[2]);
        return rgb;
    }

    public void update(){
        int iterations = Renderer.MAX_NUM_OF_ITTERATIONS - mand();
        if (iterations == 0){
            red = 0;
            green = 0;
            blue = 0;
            return;
        }

        float[] arr= new float[3];
        arr[0] = 240;
        arr[1] = iterations * 1.0f / Renderer.MAX_NUM_OF_ITTERATIONS;
        arr[2] = (1 - arr[1]) * 0.7f + 0.3f;
        Color c = new Color(HSVToColor(arr));
        red = c.getRed() / 255f;
        green = c.getGreen() / 255f;
        blue = c.getBlue() / 255f;
    }

    public int mand() {
        Complex n1 = new Complex(0,0);
        Complex c = new Complex(x,y);
        for (int t = 0; t < Renderer.MAX_NUM_OF_ITTERATIONS; t++) {
            if (Complex.magnitude(n1) > 2.0) return t;
            n1 = Complex.add(Complex.square(n1),c);
        }
        return Renderer.MAX_NUM_OF_ITTERATIONS;
    }

    public void render() {
        Graphics.setColor(red, green, blue, a);
        Graphics.fillRect(x, y, width, height);
    }
}
