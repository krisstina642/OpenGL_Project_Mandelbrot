package World;

public class Complex{
    public float x;
    public float y;
    public Complex(float my_real, float my_imag){
        this.x = my_real;
        this.y = my_imag;
    }
    public static Complex add(Complex n1, Complex n2){
        Complex temp = new Complex(0.0f, 0.0f);
        temp.x = n1.x + n2.x;
        temp.y = n1.y + n2.y;
        return(temp);
    }
    public static Complex mul(Complex n1, Complex n2) {
        float r0 = n1.x, r1 = n1.x;
        float i0 = n1.y, i1 = n2.y;
        return new Complex(r0 * r1 - i0 * i1, r0 * i1 + r1 * i0);
    }
    public static Complex square(Complex n1){
        return mul(n1,n1);
    }

    public static float magnitude(Complex c){
        return (float) Math.sqrt(Math.pow(c.y, 2) + Math.pow(c.x, 2));
    }
}