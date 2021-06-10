package projet_departement_Iinterroger;

import projet_employe.employe;

import java.util.List;

public interface Idirection <T>{
    public List<T> listerDir();
    public boolean ajouterDir(T d);
    public T findDir(int id);
    public boolean updateDir(T d);
    public employe listerResponsable(int id);
    public List<T> findDirParDep(int id);
}
