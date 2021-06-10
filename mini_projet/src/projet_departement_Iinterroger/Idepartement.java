package projet_departement_Iinterroger;

import projet_departement.departement;
import projet_employe.employe;

import java.util.ArrayList;
import java.util.List;

public interface Idepartement <T>{
    public boolean ajouterDep(T d);
    public departement findDep(int id);
    public boolean updateDep(T d);
    public List<T> listerDep();
    public employe listerResponsable(int id);
    public int getID(String lib);
    public String getLib(int id);
    /*public boolean deleteDep(String d);
    */

}
