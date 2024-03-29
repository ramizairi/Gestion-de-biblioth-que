package gestion.de.bibliothéque;

import java.util.Date;


public class ReservationData {

    private int idRes;
    private int idLivre;
    private int idAbonne;
    private Date dateRes;
    private Date dateRetourPrevue;
    private Date dateRetourReel;
    private String code;
    private int status;

    public ReservationData(int idRes, int idLivre, int idAbonne, Date dateRes, Date dateRetourPrevue, Date dateRetourReel, String code, int status) {
        this.idRes = idRes;
        this.idLivre = idLivre;
        this.idAbonne = idAbonne;
        this.dateRes = dateRes;
        this.dateRetourPrevue = dateRetourPrevue;
        this.dateRetourReel = dateRetourReel;
        this.code = code;
        this.status = status;
    }

    public int getIdRes() {
        return idRes;
    }

    public void setIdRes(int idRes) {
        this.idRes = idRes;
    }


    public int getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(int idLivre) {
        this.idLivre = idLivre;
    }

    public int getIdAbonne() {
        return idAbonne;
    }

    public void setIdAbonne(int idAbonne) {
        this.idAbonne = idAbonne;
    }

    public Date getDateRes() {
        return dateRes;
    }

    public void setDateRes(Date dateRes) {
        this.dateRes = dateRes;
    }

    public Date getDateRetourPrevue() {
        return dateRetourPrevue;
    }

    public void setDateRetourPrevue(Date dateRetourPrevue) {
        this.dateRetourPrevue = dateRetourPrevue;
    }

    public Date getDateRetourReel() {
        return dateRetourReel;
    }

    public void setDateRetourReel(Date dateRetourReel) {
        this.dateRetourReel = dateRetourReel;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
