package projet_departement;

public class direction {
    private int id_dir;
    private String libelle;
    private int id_ges_resp;
    private int id_dep;

    public direction(int id_dir, String libelle, int id_ges_resp, int id_dep) {
        this.id_dir = id_dir;
        this.libelle = libelle;
        this.id_ges_resp = id_ges_resp;
        this.id_dep = id_dep;
    }
    public direction(String libelle, int id_ges_resp, int id_dep) {
        this.libelle = libelle;
        this.id_ges_resp = id_ges_resp;
        this.id_dep = id_dep;
    }

    public int getId_dir() {
        return id_dir;
    }

    public void setId_dir(int id_dir) {
        this.id_dir = id_dir;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getId_ges_resp() {
        return id_ges_resp;
    }

    public void setId_ges_resp(int id_ges_resp) {
        this.id_ges_resp = id_ges_resp;
    }

    public int getId_dep() {
        return id_dep;
    }

    public void setId_dep(int id_dep) {
        this.id_dep = id_dep;
    }

    @Override
    public String toString() {
        return "direction{" +
                "id_dir='" + id_dir + '\'' +
                ", libelle='" + libelle + '\'' +
                ", id_ges_resp=" + id_ges_resp +
                ", id_dep='" + id_dep + '\'' +
                '}';
    }
}
