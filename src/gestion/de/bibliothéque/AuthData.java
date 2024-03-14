package gestion.de.bibliothéque;

public class AuthData {

    private int id;
    private String Fname;
    private String Lname;
    private String Nationality;

    public AuthData(int id, String Fname, String Lname, String Nationality) {
        this.id = id;
        this.Fname = Fname;
        this.Lname = Lname;
        this.Nationality = Nationality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String Nationality) {
        this.Nationality = Nationality;
    }
}
