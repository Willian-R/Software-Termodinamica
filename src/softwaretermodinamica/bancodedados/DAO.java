package softwaretermodinamica.bancodedados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Willian Belincanta Ribeiro
 */
public class DAO {

    // metodo para adicionar na tabela
    public void adicionar(PropriedadesDeEspeciesPuras ab) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO propriedades_de_especies_puras (composto, omega, Tc, Pc, Zc,  Vc) VALUES (?,?,?,?,?,?)");
            stmt.setString(1, ab.getComposto());
            stmt.setFloat(2, ab.getOmega());
            stmt.setFloat(3, ab.getTc());
            stmt.setFloat(4, ab.getPc());
            stmt.setFloat(5, ab.getZc());
            stmt.setDouble(6, ab.getVc());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar","ERRO",JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.closeConnection(con);
        }
    }

    //metodo de pesquisa na tabela propriedade de especies puras
    public static void buscar(String composto) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM propriedades_de_especies_puras WHERE composto = ?");
            stmt.setString(1, composto);
            rs = stmt.executeQuery();

            while (rs.next()) {
                PropriedadesDeEspeciesPuras propriedade = new PropriedadesDeEspeciesPuras();
                propriedade.setOmega(rs.getFloat("omega"));
                propriedade.setPc(rs.getFloat("Pc"));
                propriedade.setTc(rs.getFloat("Tc"));
                propriedade.setVc(rs.getDouble("Vc"));
                propriedade.setZc(rs.getFloat("Zc"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con);
        }
    }

    //metodo de pesquisa tabela antoine
    public static void buscarAntoine(String composto) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM antoine WHERE composto = ?");
            stmt.setString(1, composto);
            rs = stmt.executeQuery();

            while (rs.next()) {
                TabelaAntoine ta = new TabelaAntoine();
                ta.setA(rs.getFloat("A"));
                ta.setB(rs.getFloat("B"));
                ta.setC(rs.getFloat("C"));
                ta.setTmin(rs.getFloat("Tmin"));
                ta.setTmax(rs.getFloat("Tmax"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con);
        }
    }

    public List<TabelaAntoine> leituraAntoine() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<TabelaAntoine> composto = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM antoine");
            rs = stmt.executeQuery();
            while (rs.next()) {
                TabelaAntoine antoine = new TabelaAntoine();
                antoine.setComposto(rs.getString("composto"));
                antoine.setA(rs.getFloat("A"));
                antoine.setB(rs.getFloat("B"));
                antoine.setC(rs.getFloat("C"));
                antoine.setTmax(rs.getFloat("Tmax"));
                antoine.setTmin(rs.getFloat("Tmin"));
                composto.add(antoine);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con);
        }
        return composto;
    }

    public List<PropriedadesDeEspeciesPuras> leituraPropriedades() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<PropriedadesDeEspeciesPuras> composto = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM propriedades_de_especies_puras");
            rs = stmt.executeQuery();
            while (rs.next()) {
                PropriedadesDeEspeciesPuras pp = new PropriedadesDeEspeciesPuras();
                pp.setComposto(rs.getString("composto"));
                pp.setOmega(rs.getFloat("omega"));
                pp.setPc(rs.getFloat("Pc"));
                pp.setTc(rs.getFloat("Tc"));
                pp.setVc(rs.getDouble("Vc"));
                pp.setZc(rs.getFloat("Zc"));
                composto.add(pp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con);
        }
        return composto;
    }
}
