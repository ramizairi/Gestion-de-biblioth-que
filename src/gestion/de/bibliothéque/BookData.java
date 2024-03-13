package gestion.de.bibliothéque;

public class BookData {

    private int idLivre;
    private String titre;
    private int idAuteur;
    private String genre;
    private int nbCopies;
    private String imagePath;
    private String description;
    private int price;

    public BookData(int idLivre, String titre, int idAuteur, String genre, int nbCopies, String imagePath, String description, int price) {
        this.idLivre = idLivre;
        this.titre = titre;
        this.idAuteur = idAuteur;
        this.genre = genre;
        this.nbCopies = nbCopies;
        this.imagePath = imagePath;
        this.description = description;
        this.price = price;
    }

    public int getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(int idLivre) {
        this.idLivre = idLivre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getIdAuteur() {
        return idAuteur;
    }

    public void setIdAuteur(int idAuteur) {
        this.idAuteur = idAuteur;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getNbCopies() {
        return nbCopies;
    }

    public void setNbCopies(int nbCopies) {
        this.nbCopies = nbCopies;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescripton(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setprice(int price) {
        this.price = price;
    }

}
