package gestion.de.bibliothéque;

public class AbonneData {

    private int idAbonne;
    private String nom;
    private String prenom;
    private int numero;
    private String adresse;
    private String adresseMail;
    private String password;

    public AbonneData(String nom, String prenom, String adresse, int idAbonne, String adresseMail, String password) {
        this.idAbonne = idAbonne;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.adresse = adresse;
        this.adresseMail = adresseMail;
        this.password = password;
    }

    public int getIdAbonne() {
        return idAbonne;
    }

    public void setIdAbonne(int idAbonne) {
        this.idAbonne = idAbonne;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
