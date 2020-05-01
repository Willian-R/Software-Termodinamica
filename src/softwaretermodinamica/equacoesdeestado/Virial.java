package softwaretermodinamica.equacoesdeestado;

/**
 *
 * @author Willian Belincanta Ribeiro
 */
public class Virial extends EquacoesDeEstado {

    // pressao em Pa
    @Override
    public void calcularPressao() {
        float Tr = this.getTemperatura() / Virial.getTemperaturacritica();
        double Bo = 0.083 - (0.422 / (Math.pow(Tr, 1.6)));
        double Bi = 0.139 - (0.172 / (Math.pow(Tr, 4.2)));
        double B = ((Bo + (Virial.getFatoracentrico() * Bi)) * R * Virial.getTemperaturacritica()) / Virial.getPressaocritica();
        this.setPressao((R * this.getTemperatura()) / (this.getVolumemolar() - B));
    }

    //volume molar em m³/mol
    @Override
    public void calcularVolumeMolar() {
        float Tr = this.getTemperatura() / Virial.getTemperaturacritica();
        double Bo = 0.083 - (0.422 / (Math.pow(Tr, 1.6)));
        double Bi = 0.139 - (0.172 / (Math.pow(Tr, 4.2)));
        double B = ((Bo + (Virial.getFatoracentrico() * Bi)) * R * Virial.getTemperaturacritica()) / Virial.getPressaocritica();
        this.setVolumemolar(((R * this.getTemperatura()) / this.getPressao()) + B);
    }

}
