package Repository;
import Config.DbConnection;
import Entity.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QueryRepository {

    public HashMap<Annesso,Integer> query1() {
        HashMap<Annesso,Integer> listaAnnessi = new HashMap<>();
        String query =
                "SELECT tipo, COUNT(tipo) AS numeroDiBox " +
                        "FROM Annessi " +
                        "WHERE tipo ='Box' " +
                        "GROUP BY tipo; ";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                Annesso annesso = new Annesso();
                annesso.setTipo(rs.getString("tipo"));
                int numeroDiBox = rs.getInt("numeroDiBox");
                listaAnnessi.put(annesso,numeroDiBox);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaAnnessi;
    }

    public HashMap<Immobile,Integer> query2() {
        HashMap<Immobile,Integer> listaImmobili = new HashMap<>();
        String query =
                "SELECT i.tipo, COUNT(i.tipo) AS numeroDiVilleConGiardino " +
                        "FROM Immobili i " +
                        "JOIN Annessi a ON i.id = a.idImmobile " +
                        "WHERE i.tipo='Villa' AND a.tipo='Giardino' " +
                        "GROUP BY i.tipo; ";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                Immobile immobile = new Immobile();
                immobile.setTipo(rs.getString("tipo"));
                int numeroDiVilleConGiardino = rs.getInt("numeroDiVilleConGiardino");
                listaImmobili.put(immobile,numeroDiVilleConGiardino);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaImmobili;
    }

    public HashMap<Proprietario,Integer> query3(int idScelto) {
        HashMap<Proprietario,Integer> listaProprietari = new HashMap<>();
        String query =
                "SELECT p.cognome, p.nome, SUM(i.supp) AS superficiePosseduta " +
                        "FROM Proprietari p " +
                        "JOIN Immobili i ON p.id = i.idProprietario " +
                        "WHERE p.id = " + idScelto  + " " +
                        "GROUP BY p.cognome,p.nome";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                Proprietario proprietario = new Proprietario();
                proprietario.setNome(rs.getString("nome"));
                proprietario.setCognome(rs.getString("cognome"));
                int superficiePosseduta = rs.getInt("superficiePosseduta");
                listaProprietari.put(proprietario,superficiePosseduta);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaProprietari;
    }

    public List<Proprietario> query4() {
        List<Proprietario> listaProprietari = new ArrayList<>();
        String query =
                "SELECT p.cognome, p.nome " +
                        "FROM Proprietari p " +
                        "JOIN Immobili i ON p.id = i.idProprietario " +
                        "WHERE i.tipo='Villa' " +
                        "GROUP BY p.cognome,p.nome;";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                Proprietario proprietario = new Proprietario();
                proprietario.setNome(rs.getString("nome"));
                proprietario.setCognome(rs.getString("cognome"));
                listaProprietari.add(proprietario);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaProprietari;
    }

    public List<Proprietario> query5() {
        List<Proprietario> listaProprietari = new ArrayList<>();
        String query =
                "SELECT p.cognome, p.nome " +
                        "FROM Proprietari p " +
                        "JOIN Immobili i ON p.id = i.idProprietario " +
                        "JOIN Annessi a ON i.id = a.idImmobile " +
                        "WHERE a.tipo='Box' AND i.tipo='Appartamento' " +
                        "GROUP BY p.cognome,p.nome;";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                Proprietario proprietario = new Proprietario();
                proprietario.setNome(rs.getString("nome"));
                proprietario.setCognome(rs.getString("cognome"));
                listaProprietari.add(proprietario);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaProprietari;
    }

    public List<Proprietario> query6() {
        List<Proprietario> listaProprietari = new ArrayList<>();
        String query =
                "SELECT p.cognome, p.nome, i.anno " +
                        "FROM Proprietari p " +
                        "JOIN Immobili i ON p.id = i.idProprietario " +
                        "WHERE i.anno>1996 " +
                        "GROUP BY p.cognome,p.nome,i.anno;";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Proprietario proprietario = new Proprietario();
                proprietario.setNome(rs.getString("nome"));
                proprietario.setCognome(rs.getString("cognome"));

                Immobile immobile = new Immobile();
                immobile.setAnno(rs.getInt("anno"));
                proprietario.addImmobile(immobile);

                listaProprietari.add(proprietario);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaProprietari;
    }

    public HashMap<Proprietario,Integer> query7() {
        HashMap<Proprietario,Integer> listaProprietari = new HashMap<>();
        String query =
                "SELECT p.cognome, p.nome, SUM(i.vani) AS vaniDisponibili " +
                        "FROM Proprietari p " +
                        "JOIN Immobili i ON p.id = i.idProprietario " +
                        "WHERE i.tipo = 'Appartamento' " +
                        "GROUP BY p.cognome,p.nome;";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                Proprietario proprietario = new Proprietario();
                proprietario.setNome(rs.getString("nome"));
                proprietario.setCognome(rs.getString("cognome"));
                int vaniDisponibili = rs.getInt("vaniDisponibili");
                listaProprietari.put(proprietario,vaniDisponibili);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaProprietari;
    }

    public HashMap<Proprietario,Integer> query8() {
        HashMap<Proprietario,Integer> listaProprietari = new HashMap<>();
        String query =
                "SELECT p.cognome, p.nome, SUM(i.supp) AS superficieTotalePosseduta " +
                        "FROM Proprietari p " +
                        "JOIN Immobili i ON p.id = i.idProprietario " +
                        "WHERE i.supp > 400 " +
                        "GROUP BY p.cognome,p.nome;";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                Proprietario proprietario = new Proprietario();
                proprietario.setNome(rs.getString("nome"));
                proprietario.setCognome(rs.getString("cognome"));
                int superficieTotalePosseduta = rs.getInt("superficieTotalePosseduta");
                listaProprietari.put(proprietario,superficieTotalePosseduta);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaProprietari;
    }


}
