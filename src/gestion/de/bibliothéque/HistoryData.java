package gestion.de.bibliothéque;

import java.util.Date;

import java.util.Date;

public class HistoryData {

    private int id_history;
    private int id_manager;
    private String operation_type;
    private String operation;
    private Date date;

    public HistoryData(int id_history, int id_manager, String operation_type, String operation, Date date) {
        this.id_history = id_history;
        this.id_manager = id_manager;
        this.operation_type = operation_type;
        this.operation = operation;
        this.date = date;
    }

    public int getId_history() {
        return id_history;
    }

    public void setId_history(int id_history) {
        this.id_history = id_history;
    }

    public int getId_manager() {
        return id_manager;
    }

    public void setId_manager(int id_manager) {
        this.id_manager = id_manager;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation_type() {
        return operation_type;
    }

    public void setOperation_type(String operation) {
        this.operation_type = operation_type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
