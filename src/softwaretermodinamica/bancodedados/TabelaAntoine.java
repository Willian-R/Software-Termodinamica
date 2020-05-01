package softwaretermodinamica.bancodedados;

import softwaretermodinamica.pressaodesaturacao.Antoine;

/**
 *
 * @author Willian Belincanta Ribeiro
 */
//classe da tabela Antoine do livro do Van Ness
public class TabelaAntoine {

    private String composto;
    private float A;
    private float B;
    private float C;
    private float Tmin;
    private float Tmax;

    public String getComposto() {
        return composto;
    }

    public void setComposto(String composto) {
        this.composto = composto;
    }

    public float getA() {
        return A;
    }

    public void setA(float A) {
        this.A = A;
        Antoine.setA(this.A);
    }

    public float getB() {
        return B;
    }

    public void setB(float B) {
        this.B = B;
        Antoine.setB(this.B);
    }

    public float getC() {
        return C;
    }

    public void setC(float C) {
        this.C = C;
        Antoine.setC(this.C);
    }

    public float getTmin() {
        return Tmin;
    }

    public void setTmin(float Tmin) {
        this.Tmin = Tmin;
        Antoine.setTmin(this.Tmin);
    }

    public float getTmax() {
        return Tmax;
    }

    public void setTmax(float Tmax) {
        this.Tmax = Tmax;
        Antoine.setTmax(this.Tmax);
    }

    @Override
    public String toString() {
        return getComposto();
    }
}
