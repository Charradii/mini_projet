package projet_employe_Iinterroger;

import projet_employe.employe;

import java.util.List;

public interface Iemploye<T> {
    public boolean create(T o);
    public boolean update(int id,T o);
    public List<T> trouverParDep(String affectation);
    public List<T> trouverParCategorie(String nv);
    public List<T> trouverTous();
    public List<T> trouverEntreDeuxNv(String nv1,String nv2);
    public employe trouverParNumero(int n);
}
