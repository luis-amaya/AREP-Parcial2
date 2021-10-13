package co.edu.escuelaing.parcial2;

public class Calculadora {

    public static Calculadora initCalculadora() {
        return new Calculadora();
    }

    public double arTan(Double value) {
        double res = 0;
        res = Math.atan(value);
        return res;
    }

    public double sin(Double value) {
        double res = 0;
        res = Math.sin(value);
        return res;
    }

}
