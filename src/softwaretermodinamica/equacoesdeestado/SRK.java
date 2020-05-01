package softwaretermodinamica.equacoesdeestado;

/**
 *
 * @author Willian Belincanta Ribeiro
 */
public class SRK extends EquacoesDeEstado {

    //pressao em Pa
    @Override
    public void calcularPressao() {
        float Tr = this.getTemperatura() / SRK.getTemperaturacritica();
        double kappa = 0.480 + (1.574 * SRK.getFatoracentrico()) - (0.176 * SRK.getFatoracentrico() * SRK.getFatoracentrico());
        double alfa = Math.pow(1 + (kappa * (1 - (Math.pow(Tr, 0.5)))), 2);
        double a = (0.42748 * R * R * SRK.getTemperaturacritica() * SRK.getTemperaturacritica() * alfa) / SRK.getPressaocritica();
        double b = (0.08664 * R * SRK.getTemperaturacritica()) / SRK.getPressaocritica();

        this.setPressao(((R * this.getTemperatura()) / (this.getVolumemolar() - b)) - (a / (this.getVolumemolar() * (this.getVolumemolar() + b))));
    }

    //volume molar em m³/mol
    @Override
    public void calcularVolumeMolar() {
        float Tr = this.getTemperatura() / SRK.getTemperaturacritica();
        double kappa = 0.480 + (1.574 * SRK.getFatoracentrico()) - (0.176 * SRK.getFatoracentrico() * SRK.getFatoracentrico());
        double alfa = Math.pow(1 + (kappa * (1 - (Math.pow(Tr, 0.5)))), 2);
        double a = (0.42748 * R * R * SRK.getTemperaturacritica() * SRK.getTemperaturacritica() * alfa) / SRK.getPressaocritica();
        double b = (0.08664 * R * SRK.getTemperaturacritica()) / SRK.getPressaocritica();

        double A = this.getPressao();
        double B = -(R * this.getTemperatura());
        double C = (a - (R * this.getTemperatura() * b) - (b * b * this.getPressao()));
        double D = -(a * b);

        MetodoMatsoukas.cubica(A, B, C, D);
    }

}
