package projet_departement_service;

import projet_connexion.connexion;
import projet_departement.departement;
import projet_departement.direction;
import projet_departement_Iinterroger.Idepartement;
import projet_employe.employe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class departementService implements Idepartement<departement>{
    @Override
    public boolean ajouterDep(departement d){
        int i=0;
        try {
            i++;
            d.setId_dep(i);
            String req = "insert into departement (libelle,id_ges_resp) values ('" + d.getLibelle() + "', " + d.getId_ges_resp()+")";
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
    public departement findDep(int id){
        try {

            String req = "select * from departement where id_dep="+id+"";
            Statement st = connexion.getCn().createStatement();
            ResultSet res = st.executeQuery(req);
            res.next();
            departement e = new departement(res.getInt(1),res.getString(2),res.getInt(3));

            return e;
        } catch (SQLException ex) {
            System.out.println("SQL erreur"+ ex.getMessage());
        }
        return null;
    }
    public boolean updateDep(departement d){
        try {
            String req = "update departement set libelle='" + d.getLibelle() + "',id_ges_resp="+d.getId_ges_resp()+" where id_dep="+d.getId_dep();
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
    public ArrayList<departement> listerDep(){
        try {
            String req = "select * from departement";
            Statement st = connexion.getCn().createStatement();
            ResultSet res = st.executeQuery(req);
            ArrayList<departement> l = new ArrayList<departement>();
            while(res.next()){
                departement d = new departement(res.getInt(1),res.getString(2),res.getInt(3));
                l.add(d);
            }
            return l;
        } catch (SQLException ex) {
            System.out.println("SQL erreur"+ ex.getMessage());
        }
        return null;
    }
    @Override
    public employe listerResponsable(int id){
        try {
            String req = "select numero,nom,prenom,titre,affectation,niveau_poste,salaire from departement d, employe e where d.id_dep="+id+" AND d.id_ges_resp=e.numero";
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
    public int getID(String lib){
        try {
            String req = "select id_dep from departement  where libelle='"+lib+"'";
            Statement st = connexion.getCn().createStatement();
            ResultSet res = st.executeQuery(req);
            res.next();
            return res.getInt(1);

        } catch (SQLException ex) {
            System.out.println("SQL erreur"+ ex.getMessage());
        }
        return 0;
    }
    @Override
    public String getLib(int id){
        try {
            String req = "select Libelle from departement  where id_dep="+id;
            Statement st = connexion.getCn().createStatement();
            ResultSet res = st.executeQuery(req);
            res.next();
            return res.getString(1);

        } catch (SQLException ex) {
            System.out.println("SQL erreur"+ ex.getMessage());
        }
        return null;
    }
}
