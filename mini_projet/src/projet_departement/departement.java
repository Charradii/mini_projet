package projet_departement;

import projet_employe.employe;

public class departement {
    private int id_dep;
    private String libelle;
    private int id_ges_resp;

    public departement(int id_dep, String libelle, int id_ges_resp) {
        this.id_dep = id_dep;
        this.libelle = libelle;
        this.id_ges_resp = id_ges_resp;
    }
    public departement(String libelle, int id_ges_resp) {

        this.libelle = libelle;
        this.id_ges_resp = id_ges_resp;
    }

    public int getId_dep() {
        return id_dep;
    }

    public String getLibelle() {
        return libelle;
    }

    public int getId_ges_resp() {
        return id_ges_resp;
    }

    public void setId_dep(int id_dep) {
        this.id_dep = id_dep;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setId_ges_resp(int id_ges_resp) {
        this.id_ges_resp = id_ges_resp;
    }

    @Override
    public String toString() {
        return "departement{" +
                "id_dep='" + id_dep + '\'' +
                ", libelle='" + libelle + '\'' +
                ", id_ges_resp=" + id_ges_resp +
                '}';
    }
}
