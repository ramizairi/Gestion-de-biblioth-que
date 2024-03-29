package gestion.de.bibliothéque;

public class ManagerData {

    private int idManager;
    private String nom;
    private String prenom;
    private int numero;
    private String adresse;
    private String adresseMail;
    private String password;

        public ManagerData(int idManager, String nom, String prenom,int numero, String adresse, String adresseMail, String password) {
            this.idManager = idManager;
            this.nom = nom;
            this.prenom = prenom;
            this.numero = numero;
            this.adresse = adresse;
            this.adresseMail = adresseMail;
            this.password = password;
        }

        public int getIdManager() {
            return idManager;
        }

        public void setIdManager(int idManager) {
            this.idManager = idManager;
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

        public int getNumero() {
            return numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

        public String getAdresse() {
            return adresse;
        }

        public void setAdresse(String adresse) {
            this.adresse = adresse;
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
