package projet_employe;



public class employe {
    private int numero;
    private String nom;
    private String prenom;
    private String titre;
    private String affectation;
    private String niveaux_poste;
    private double salaire;

    public employe( String nom, String prenom, String titre, String affectation, String niveaux_poste, double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.titre = titre;
        this.affectation = affectation;
        this.niveaux_poste = niveaux_poste;
        this.salaire = salaire;
    }
    public employe(int numero, String nom, String prenom, String titre, String affectation, String niveaux_poste, double salaire) {
        this.numero=numero;
        this.nom = nom;
        this.prenom = prenom;
        this.titre = titre;
        this.affectation = affectation;
        this.niveaux_poste = niveaux_poste;
        this.salaire = salaire;
    }
    public employe(){}
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAffectation() {
        return affectation;
    }

    public void setAffectation(String affectation) {
        this.affectation = affectation;
    }

    public String getNiveaux_poste() {
        return niveaux_poste;
    }

    public void setNiveaux_poste(String niveaux_poste) {
        this.niveaux_poste = niveaux_poste;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "employe{" +
                "numero=" + numero +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", titre='" + titre + '\'' +
                ", affectation=" + affectation.toString() +
                ", niveaux_poste=" + niveaux_poste.toString() +
                ", salaire=" + salaire +
                '}';
    }
}
