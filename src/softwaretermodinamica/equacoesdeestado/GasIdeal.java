package softwaretermodinamica.equacoesdeestado;

/**
 *
 * @author Willian Belincanta Ribeiro
 */
public class GasIdeal extends EquacoesDeEstado {

    //pressao em Pa
    @Override
    public void calcularPressao() {
        this.setPressao((R * this.getTemperatura()) / this.getVolumemolar());
    }

    // volume molar em m³/mol
    @Override
    public void calcularVolumeMolar() {
        this.setVolumemolar((R * this.getTemperatura()) / this.getPressao());
    }

}
