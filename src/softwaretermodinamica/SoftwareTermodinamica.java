package softwaretermodinamica;

import java.util.logging.Level;
import java.util.logging.Logger;
import softwaretermodinamica.telas.Menu;
import softwaretermodinamica.telas.TelaInicial;

/**
 *
 * @author Willian Belincanta Ribeiro
 */
public class SoftwareTermodinamica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TelaInicial telainicial = new TelaInicial();
        telainicial.setLocationRelativeTo(null);
        telainicial.setVisible(true);
        //splash screen
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SoftwareTermodinamica.class.getName()).log(Level.SEVERE, null, ex);
        }
        telainicial.dispose();
        Menu menu = new Menu();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

}
