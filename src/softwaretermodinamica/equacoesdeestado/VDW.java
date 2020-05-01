package softwaretermodinamica.equacoesdeestado;

/**
 *
 * @author Willian Belincanta Ribeiro
 */
public class VDW extends EquacoesDeEstado {

    //pressao em Pa
    @Override
    public void calcularPressao() {
        double a = (27 * R * R * VDW.getTemperaturacritica() * VDW.getTemperaturacritica()) / (64 * VDW.getPressaocritica());
        double b = (R * VDW.getTemperaturacritica()) / (8 * VDW.getPressaocritica());

        this.setPressao(((R * this.getTemperatura()) / (this.getVolumemolar() - b)) - (a / (this.getVolumemolar() * this.getVolumemolar())));
    }

    //volume molar em m³/mol
    @Override
    public void calcularVolumeMolar() {
        double a = (27 * R * R * VDW.getTemperaturacritica() * VDW.getTemperaturacritica()) / (64 * VDW.getPressaocritica());
        double b = (R * VDW.getTemperaturacritica()) / (8 * VDW.getPressaocritica());

        double A = this.getPressao();
        double B = -((this.getPressao() * b) + (R * this.getTemperatura()));
        double C = a;
        double D = -(a * b);

        MetodoMatsoukas.cubica(A, B, C, D);
    }

}
