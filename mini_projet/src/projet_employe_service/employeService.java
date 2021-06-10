package projet_employe_service;

import projet_connexion.connexion;
import projet_employe.employe;
import projet_employe_Iinterroger.Iemploye;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class employeService implements Iemploye<employe> {
    public static int i=0;
    @Override
    public boolean create(employe e) {
        try {
            i++;
            e.setNumero(i);
            String req = "insert into employe (Nom,prenom,titre,affectation,niveau_poste,salaire) values ('" + e.getNom() + "', '" + e.getPrenom() + "','"+e.getTitre()+"', '" + e.getAffectation() + "','" + e.getNiveaux_poste() + "','"+e.getSalaire()+"')";
            Statement st = connexion.getCn().createStatement();
            if (st.executeUpdate(req) == 1)
            {
                return true;
            }
        }
        catch (SQLException ex) {
            System.out.println("Erreur SQL"+ex.getMessage());
        }
        return false;
    }
    @Override
    public boolean update(int id,employe e){
        try {
            i++;
            e.setNumero(i);
            String req = "update employe set Nom='" + e.getNom() + "',prenom='" + e.getPrenom() + "',titre='"+e.getTitre()+"',affectation='" + e.getAffectation() + "',niveau_poste='" + e.getNiveaux_poste() + "',salaire='"+String.valueOf(e.getSalaire())+"' where numero="+id;
            Statement st = connexion.getCn().createStatement();
            if (st.executeUpdate(req) == 1)
            {
                return true;
            }
        }
        catch (SQLException ex) {
            System.out.println("Erreur SQL"+ex.getMessage());
        }
        return false;
    }
    @Override
    public ArrayList<employe> trouverParDep(String departement){
        try {
            String req = "select * from employe where affectation='"+departement+"'";
            Statement st = connexion.getCn().createStatement();
            ResultSet res = st.executeQuery(req);
            ArrayList<employe> l = new ArrayList<employe>();
            while(res.next()){
                employe e = new employe(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getDouble(7));
                l.add(e);
            }
            return l;
        } catch (SQLException ex) {
            System.out.println("SQL erreur"+ ex.getMessage());
        }
        return null;
    }
    @Override
    public ArrayList<employe> trouverParCategorie(String nv){
        try {
            String req = "select * from employe where LEFT(niveau_poste, 1)='"+nv+"'";
            Statement st = connexion.getCn().createStatement();
            ResultSet res = st.executeQuery(req);
            ArrayList<employe> l = new ArrayList<employe>();
            while(res.next()){
                employe e = new employe(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getDouble(7));
                l.add(e);
            }
            return l;
        } catch (SQLException ex) {
            System.out.println("SQL erreur"+ ex.getMessage());
        }
        return null;
    }
    @Override
    public employe trouverParNumero(int n){
        try {
            String req = "select * from employe where numero="+n+"";
            Statement st = connexion.getCn().createStatement();
            ResultSet res = st.executeQuery(req);
            res.next();
            employe e = new employe(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getDouble(7));

            return e;
        } catch (SQLException ex) {
            System.out.println("SQL erreur"+ ex.getMessage());
        }
        return null;
    }
    @Override
    public ArrayList<employe> trouverTous(){
        try {
            String req = "select * from employe";
            Statement st = connexion.getCn().createStatement();
            ResultSet res = st.executeQuery(req);
            ArrayList<employe> l = new ArrayList<employe>();
            while(res.next()){
                employe e = new employe(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getDouble(7));
                l.add(e);
            }
            return l;
        } catch (SQLException ex) {
            System.out.println("SQL erreur"+ ex.getMessage());
        }
        return null;
    }
    @Override
    public ArrayList<employe> trouverEntreDeuxNv(String nv1,String nv2){
        try {
            String req = "select * from employe where STRCMP(niveau_poste,'"+nv1+"')>=0 AND STRCMP(niveau_poste,'"+nv2+"')<=0";
            Statement st = connexion.getCn().createStatement();
            ResultSet res = st.executeQuery(req);
            ArrayList<employe> l = new ArrayList<employe>();
            while(res.next()){
                employe e = new employe(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getDouble(7));
                l.add(e);
            }
            return l;
        } catch (SQLException ex) {
            System.out.println("SQL erreur"+ ex.getMessage());
        }
        return null;
    }
}
