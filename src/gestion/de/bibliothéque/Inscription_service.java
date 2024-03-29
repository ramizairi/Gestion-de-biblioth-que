package gestion.de.bibliothéque;

import java.sql.*;
import javafx.scene.control.Alert;
import org.mindrot.jbcrypt.BCrypt;

public class Inscription_service implements Inscription_Interface {

    @Override
    public void add_abonee(AbonneData abonne) {
        try (Connection connection = database.connectDb(); PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO abonne (nom, prenom, adresse, numero, adresse_mail, mot_de_passe) VALUES (?, ?, ?, ?, ?, ?)")) {
            String hashedPassword = BCrypt.hashpw(abonne.getPassword(), BCrypt.gensalt());
            statement.setString(1, abonne.getNom());
            statement.setString(2, abonne.getPrenom());
            statement.setString(3, abonne.getAdresse());
            statement.setInt(4, abonne.getNumero());
            statement.setString(5, abonne.getAdresseMail());
            statement.setString(6, hashedPassword);
            statement.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Operation done");
            alert.setHeaderText("Success");
            alert.setContentText("Abonne added successfully");
            alert.showAndWait();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Operation failed");
            alert.setHeaderText("Failure");
            alert.setContentText("Error " + e.getMessage());
            alert.showAndWait();
            e.printStackTrace();
        }
    }

}
