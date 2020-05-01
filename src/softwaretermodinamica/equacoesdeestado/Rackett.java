package softwaretermodinamica.equacoesdeestado;

/**
 *
 * @author Willian Belincanta Ribeiro
 */
public class Rackett extends EquacoesDeEstado {

    //volume molar em m³/mol
    @Override
    public void calcularVolumeMolar() {
        float Tr = Rackett.getTemperatura() / Rackett.getTemperaturacritica();

        Rackett.setVolumemolar(Rackett.getVolumemolarcritico() * (Math.pow(Rackett.getFatorcompcritico(), Math.pow((1 - Tr), (0.2857142857142857)))));
    }

    @Override
    public void calcularPressao() { 
        //nao se calcula pressao com a equacao de Rackett
    }

}
