package softwaretermodinamica.pressaodesaturacao;

/**
 *
 * @author Willian Belincanta Ribeiro
 */
public class CorrelacaoLeeKesler {

    private static float temperatura; //K
    private static float temperaturacritica; //K
    private static double pressao; //Pa
    private static float pressaocritica; //Pa
    private static float fatoracentrico;

    public static float getTemperatura() {
        return temperatura;
    }

    public static void setTemperatura(float temperatura) {
        CorrelacaoLeeKesler.temperatura = temperatura;
    }

    public static double getPressao() {
        return pressao;
    }

    public static void setPressao(double pressao) {
        CorrelacaoLeeKesler.pressao = pressao;
    }

    public static float getTemperaturacritica() {
        return temperaturacritica;
    }

    public static void setTemperaturacritica(float temperaturacritica) {
        CorrelacaoLeeKesler.temperaturacritica = temperaturacritica;
    }

    public static float getPressaocritica() {
        return pressaocritica;
    }

    public static void setPressaocritica(float pressaocritica) {
        CorrelacaoLeeKesler.pressaocritica = pressaocritica;
    }

    public static float getFatoracentrico() {
        return fatoracentrico;
    }

    public static void setFatoracentrico(float fatoracentrico) {
        CorrelacaoLeeKesler.fatoracentrico = fatoracentrico;
    }

    //pressao calculada em Pa pelo fato da pressao critica ter sido convertida para Pa
    public static void calcularPressao() {
        float Tr = CorrelacaoLeeKesler.getTemperatura() / CorrelacaoLeeKesler.getTemperaturacritica();
        double lnPr0 = 5.92714 - (6.09648 / Tr) - (1.28862 * Math.log(Tr)) + (0.169347 * Math.pow(Tr, 6));
        double lnPr1 = 15.2518 - (15.6875 / Tr) - (13.4721 * Math.log(Tr)) + (0.43577 * Math.pow(Tr, 6));
        double Pr = Math.exp(lnPr0 + (CorrelacaoLeeKesler.getFatoracentrico() * lnPr1));
        CorrelacaoLeeKesler.setPressao(Pr * CorrelacaoLeeKesler.getPressaocritica());
    }
}
