package softwaretermodinamica.equacoesdeestado;

/**
 *
 * @author Willian Belincanta Ribeiro
 */
public class RK extends EquacoesDeEstado {

    //pressao em Pa
    @Override
    public void calcularPressao() {
        double a = (0.42748 * R * R * Math.pow(RK.getTemperaturacritica(), 2.5)) / RK.getPressaocritica();
        double b = (0.08664 * R * RK.getTemperaturacritica()) / RK.getPressaocritica();

        this.setPressao(((R * this.getTemperatura()) / (this.getVolumemolar() - b)) - (a / (this.getVolumemolar() * (this.getVolumemolar() + b) * Math.pow(this.getTemperatura(), 0.5))));
    }

    // volume molar em m³/mol
    @Override
    public void calcularVolumeMolar() {
        double a = (0.42748 * R * R * Math.pow(RK.getTemperaturacritica(), 2.5)) / RK.getPressaocritica();
        double b = (0.08664 * R * RK.getTemperaturacritica()) / RK.getPressaocritica();

        double A = this.getPressao();
        double B = -(R * this.getTemperatura());
        double C = (a / Math.pow(this.getTemperatura(), 0.5)) - (R * this.getTemperatura() * b) - (b * b * this.getPressao());
        double D = -((a * b) / (Math.pow(this.getTemperatura(), 0.5)));

        MetodoMatsoukas.cubica(A, B, C, D);
    }

}
