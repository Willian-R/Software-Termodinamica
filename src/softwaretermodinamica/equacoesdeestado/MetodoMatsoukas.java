package softwaretermodinamica.equacoesdeestado;

/**
 *
 * @author Willian Belincanta Ribeiro
 */
//metodo para encontrar as raizes de equacao cubica
public class MetodoMatsoukas {

    final static double PI_DOIS = Math.PI * 2;
    final static double PI_QUATRO = Math.PI * 4;
    public static double x1;
    public static double x2;
    public static double x3;
    public static int aux;
    public static double xmaior;
    public static double xmenor;

    public static void cubica(double a, double b, double c, double d) {
        //normalizar os coeficientes
        double denom = a;
        a = b / denom;
        b = c / denom;
        c = d / denom;

        //inicio da solução
        double a_sobre_3 = a / 3;
        double Q = (3 * b - a * a) / 9;
        double Q_cubo = Q * Q * Q;
        double R = (9 * a * b - 27 * c - 2 * a * a * a) / 54;
        double R_quad = R * R;
        double D = Q_cubo + R_quad;

        if (D < 0) { //tres raizes reais
            aux = 3;
            double teta = Math.acos(R / Math.sqrt(-Q_cubo));
            double raizq_Q = Math.sqrt(-Q);
            x1 = 2 * raizq_Q * Math.cos(teta / 3) - a_sobre_3;
            x2 = 2 * raizq_Q * Math.cos((teta + PI_DOIS) / 3) - a_sobre_3;
            x3 = 2 * raizq_Q * Math.cos((teta + PI_QUATRO) / 3) - a_sobre_3;

            //ordenar as raizes de forma crescente
            if (x1 > x2 && x1 > x3) {
                xmaior = x1;
            } else if (x2 > x1 && x2 > x3) {
                xmaior = x2;
            } else {
                xmaior = x3;
            }

            if (x1 < x2 && x1 < x3) {
                xmenor = x1;
            } else if (x2 < x1 && x2 < x3) {
                xmenor = x2;
            } else {
                xmenor = x3;
            }
            
        } else if (D > 0) { // somente uma raiz real
            aux = 1;
            double raizq_D = Math.sqrt(D);
            double S = Math.cbrt(R + raizq_D);
            double T = Math.cbrt(R - raizq_D);
            x1 = (S + T) - a_sobre_3;
        } else { //tres raizes reais ao menos dois iguais
            double R_raizc = Math.cbrt(R);
            x1 = 2 * R_raizc - a_sobre_3;
            x2 = x3 = R_raizc - a_sobre_3;

        }
    }
}
