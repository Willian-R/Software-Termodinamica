package softwaretermodinamica.equacoesdeestado;

/**
 *
 * @author Willian Belincanta Ribeiro
 */
public class PR extends EquacoesDeEstado {

    //pressao em Pa
    @Override
    public void calcularPressao() {
        float Tr = this.getTemperatura() / PR.getTemperaturacritica();
        double kappa = 0.37464 + (1.54226 * PR.getFatoracentrico()) - (0.26992 * PR.getFatoracentrico() * PR.getFatoracentrico());
        double alfa = Math.pow(1 + (kappa * (1 - (Math.pow(Tr, 0.5)))), 2);
        double a = ((0.45724 * R * R * PR.getTemperaturacritica() * PR.getTemperaturacritica() * alfa) / PR.getPressaocritica());
        double b = ((0.07780 * R * PR.getTemperaturacritica()) / PR.getPressaocritica());

        this.setPressao(((R * this.getTemperatura()) / (this.getVolumemolar() - b)) - (a / ((this.getVolumemolar() * (this.getVolumemolar() + b)) + (b * (this.getVolumemolar() - b)))));
    }

    // volume molar em m³/mol
    @Override
    public void calcularVolumeMolar() {
        float Tr = this.getTemperatura() / PR.getTemperaturacritica();
        double kappa = 0.37464 + (1.54226 * PR.getFatoracentrico()) - (0.26992 * PR.getFatoracentrico() * PR.getFatoracentrico());
        double alfa = Math.pow(1 + (kappa * (1 - (Math.pow(Tr, 0.5)))), 2);
        double a = ((0.45724 * R * R * PR.getTemperaturacritica() * PR.getTemperaturacritica() * alfa) / PR.getPressaocritica());
        double b = ((0.07780 * R * PR.getTemperaturacritica()) / PR.getPressaocritica());

        double A = -this.getPressao();
        double B = (R * this.getTemperatura()) - (this.getPressao() * b);
        double C = (2 * R * this.getTemperatura() * b) - (a) + (3 * b * b * this.getPressao());
        double D = -(b * b * b * this.getPressao()) - (R * this.getTemperatura() * b * b) + (a * b);

        MetodoMatsoukas.cubica(A, B, C, D);
    }

}
