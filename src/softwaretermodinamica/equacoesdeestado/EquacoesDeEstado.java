package softwaretermodinamica.equacoesdeestado;

/**
 *
 * @author Willian Belincanta Ribeiro
 */
public abstract class EquacoesDeEstado {

    private static double pressao; //Pa
    private static float temperatura; //K
    private static double volumemolar; //m³/mol
    private static float temperaturacritica; //K
    private static float pressaocritica; //Pa
    private static float fatoracentrico;
    private static double volumemolarcritico; //m³/mol
    private static float fatorcompcritico;
    final float R = 8.314f;

    public static double getPressao() {
        return pressao;
    }

    public static void setPressao(double pressao) {
        EquacoesDeEstado.pressao = pressao;
    }

    public static float getTemperatura() {
        return temperatura;
    }

    public static void setTemperatura(float temperatura) {
        EquacoesDeEstado.temperatura = temperatura;
    }

    public static double getVolumemolar() {
        return volumemolar;
    }

    public static void setVolumemolar(double volumemolar) {
        EquacoesDeEstado.volumemolar = volumemolar;
    }

    public static float getTemperaturacritica() {
        return temperaturacritica;
    }

    public static void setTemperaturacritica(float temperaturacritica) {
        EquacoesDeEstado.temperaturacritica = temperaturacritica;
    }

    public static float getPressaocritica() {
        return pressaocritica;
    }

    public static void setPressaocritica(float pressaocritica) {
        EquacoesDeEstado.pressaocritica = pressaocritica;
    }

    public static float getFatoracentrico() {
        return fatoracentrico;
    }

    public static void setFatoracentrico(float fatoracentrico) {
        EquacoesDeEstado.fatoracentrico = fatoracentrico;
    }

    public static double getVolumemolarcritico() {
        return volumemolarcritico;
    }

    public static void setVolumemolarcritico(double volumemolarcritico) {
        EquacoesDeEstado.volumemolarcritico = volumemolarcritico;
    }

    public static float getFatorcompcritico() {
        return fatorcompcritico;
    }

    public static void setFatorcompcritico(float fatorcompcritico) {
        EquacoesDeEstado.fatorcompcritico = fatorcompcritico;
    }

    public abstract void calcularPressao();

    public abstract void calcularVolumeMolar();
}
