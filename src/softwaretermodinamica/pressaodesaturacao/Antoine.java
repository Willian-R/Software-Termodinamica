package softwaretermodinamica.pressaodesaturacao;

import javax.swing.JOptionPane;

/**
 *
 * @author Willian Belincanta Ribeiro
 */
public class Antoine {

    private static float A;
    private static float B;
    private static float C;
    private static float temperatura; //Celsius
    private static double pressao; //kPa
    private static float Tmin;
    private static float Tmax;

    public static double getPressao() {
        return pressao;
    }

    public static void setPressao(double pressao) {
        Antoine.pressao = pressao;
    }

    public static float getA() {
        return A;
    }

    public static void setA(float A) {
        Antoine.A = A;
    }

    public static float getB() {
        return B;
    }

    public static void setB(float B) {
        Antoine.B = B;
    }

    public static float getC() {
        return C;
    }

    public static void setC(float C) {
        Antoine.C = C;
    }

    public static float getTemperatura() {
        return temperatura;
    }

    public static void setTemperatura(float temperatura) {
        Antoine.temperatura = temperatura;
    }

    public static float getTmin() {
        return Tmin;
    }

    public static void setTmin(float Tmin) {
        Antoine.Tmin = Tmin;
    }

    public static float getTmax() {
        return Tmax;
    }

    public static void setTmax(float Tmax) {
        Antoine.Tmax = Tmax;
    }

    //metodo para calcular pressao de saturacao por Antoine - temperatura em graus Celsius e pressao em kPa
    public static void calcularPressao() {
        if (Antoine.getTemperatura() >= Antoine.getTmin() && Antoine.getTemperatura() <= Antoine.getTmax()) {
            Antoine.setPressao(Math.exp(Antoine.getA() - (Antoine.getB() / (Antoine.getTemperatura() + Antoine.getC()))));

        } else {
            //janela de aviso para temperatura fora da faixa do uso da equacao de Antoine
            JOptionPane.showMessageDialog(null, "A temperatura está fora do intervalo para o uso da equação de Antoine", "", JOptionPane.ERROR_MESSAGE);
        }
    }
}
