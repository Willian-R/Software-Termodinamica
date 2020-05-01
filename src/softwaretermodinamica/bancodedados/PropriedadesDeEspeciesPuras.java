package softwaretermodinamica.bancodedados;

import softwaretermodinamica.equacoesdeestado.EquacoesDeEstado;
import softwaretermodinamica.pressaodesaturacao.CorrelacaoLeeKesler;

/**
 *
 * @author Willian Belincanta Ribeiro
 */
//classe da tabela propriedade de especies puras do livro Van Ness
public class PropriedadesDeEspeciesPuras {

    private String composto;
    private float omega;
    private float Tc;
    private float Pc;
    private float Zc;
    private double Vc;

    public String getComposto() {
        return composto;
    }

    public void setComposto(String composto) {
        this.composto = composto;
    }

    public float getOmega() {
        return omega;
    }

    public void setOmega(float omega) {
        this.omega = omega;
        EquacoesDeEstado.setFatoracentrico(this.omega);
        CorrelacaoLeeKesler.setFatoracentrico(this.omega);
    }

    public float getTc() {
        return Tc;
    }

    public void setTc(float Tc) {
        this.Tc = Tc;
        EquacoesDeEstado.setTemperaturacritica(this.Tc);
        CorrelacaoLeeKesler.setTemperaturacritica(this.Tc);
    }

    public float getPc() {
        return Pc;
    }

    public void setPc(float Pc) {
        //convertido de bar para Pa
        this.Pc = Pc * 100000;
        EquacoesDeEstado.setPressaocritica(this.Pc);
        CorrelacaoLeeKesler.setPressaocritica(this.Pc);
    }

    public float getZc() {
        return Zc;
    }

    public void setZc(float Zc) {
        this.Zc = Zc;
        EquacoesDeEstado.setFatorcompcritico(this.Zc);
    }

    public double getVc() {
        return Vc;
    }

    public void setVc(double Vc) {
        //convertido de cm³/mol para m³/mol 
        this.Vc = Vc * 0.000001;
        EquacoesDeEstado.setVolumemolarcritico(this.Vc);
    }

    @Override
    public String toString() {
        return getComposto();
    }

}
