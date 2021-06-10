package projet_departement_service;

import projet_connexion.connexion;
import projet_departement.departement;
import projet_departement.direction;
import projet_departement_Iinterroger.Idirection;
import projet_employe.employe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class directionService implements Idirection<direction>{
    @Override
    public ArrayList<direction> listerDir(){
        try {
            String req = "select * from direction";
            Statement st = connexion.getCn().createStatement();
            ResultSet res = st.executeQuery(req);
            ArrayList<direction> l = new ArrayList<direction>();
            while(res.next()){
                direction d = new direction(res.getInt(1),res.getString(2),res.getInt(3),res.getInt(4));
                l.add(d);
            }
            return l;
        } catch (SQLException ex) {
            System.out.println("SQL erreur"+ ex.getMessage());
        }
        return null;
    }
    @Override
    public boolean ajouterDir(direction d){
        int i=0;
        try {
            i++;
            d.setId_dir(i);
            String req = "insert into direction (libelle,id_ges_resp,id_dep) values ('" + d.getLibelle() + "', " + d.getId_ges_resp() + ",'"+d.getId_dep()+"')";
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
    public direction findDir(int id){
        try {

            String req = "select * from direction where id_dir="+id+"";
            Statement st = connexion.getCn().createStatement();
            ResultSet res = st.executeQuery(req);
            res.next();
            direction e = new direction(res.getInt(1),res.getString(2),res.getInt(3),res.getInt(4));

            return e;
        } catch (SQLException ex) {
            System.out.println("SQL erreur"+ ex.getMessage());
        }
        return null;
    }
    @Override
    public boolean updateDir(direction d){
        try {
            String req = "update direction set libelle='" + d.getLibelle() + "',id_ges_resp="+d.getId_ges_resp()+",id_dep="+d.getId_dep()+" where id_dep="+d.getId_dir();
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
    public employe listerResponsable(int id){
        try {
            String req = "select numero,nom,prenom,titre,affectation,niveau_poste,salaire from direction d, employe e where d.id_dir="+id+" AND d.id_ges_resp=e.numero";
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
    public ArrayList<direction> findDirParDep( int id){
        try {
            String req = "select * from direction where id_dep="+id;
            Statement st = connexion.getCn().createStatement();
            ResultSet res = st.executeQuery(req);
            ArrayList<direction> l = new ArrayList<direction>();
            while(res.next()){
                direction d = new direction(res.getInt(1),res.getString(2),res.getInt(3),res.getInt(4));
                l.add(d);
            }
            return l;
        } catch (SQLException ex) {
            System.out.println("SQL erreur"+ ex.getMessage());
        }
        return null;
    }
}
