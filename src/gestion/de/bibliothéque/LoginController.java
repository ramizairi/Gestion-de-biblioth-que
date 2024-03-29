package gestion.de.bibliothéque;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.sql.*;
import javafx.scene.Node;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController implements Initializable {

    private Connection connect;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;

    @FXML
    private TextField username;
    @FXML
    private Button Sign_in_btn;
    @FXML
    private Button Sign_up_btn;
    @FXML
    private Hyperlink forget_password;
    @FXML
    private Button Quit_btn;
    @FXML
    private PasswordField password;

    Login_service service = new Login_service();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void Login_clicked(MouseEvent event) throws IOException {
        int role = service.login(username.getText(), password.getText());
        switch (role) {
            case 0: {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Donneés non valides");
                alert.setContentText("Verifier vos données ");
                alert.showAndWait();
                break;
            }
            case 1: {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Welcome");
                alert.setHeaderText("Success");
                alert.setContentText("Welcome " + username.getText() + " to our library");
                alert.showAndWait();
                break;
            }
            case 2: {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Welcome");
                alert.setHeaderText("Success");
                alert.setContentText("Welcome " + username.getText() + " to our library");
                alert.showAndWait();

                try {
                    String operation_type = "Connexion";
                    String operation_desc = getData.fname + " " + getData.lname + " Est connecter";
                    logHistory(operation_type, operation_desc);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
                    Parent root = loader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));

                    stage.show();

                    // Hide the login window
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }

            case 3: {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("WelcomeSuper Admin");
                alert.setHeaderText("Success");
                alert.setContentText("Welcome " + username.getText() + " to your library");
                alert.showAndWait();
                break;
            }
            default:
                break;
        }

    }

    public void logHistory(String operation_type, String operation_desc) {
        String logSql = "INSERT INTO historique (id_manager, type_operation, desc_operation, date) VALUES (?, ?, ?, ?)";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(logSql);
            prepare.setInt(1, getData.id);
            prepare.setString(2, operation_type);
            prepare.setString(3, operation_desc);
            prepare.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            prepare.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (prepare != null) {
                    prepare.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void sign_up(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        Scene sc = new Scene(root);
        stage.setScene(sc);
        stage.show();
    }

    @FXML
    private void forget_password(MouseEvent event) {
        try {
            URI uri = new URI("https://www.youtube.com");
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    desktop.browse(uri);
                } else {
                    System.out.println("L'action d'ouverture d'URL n'est pas prise en charge.");
                }
            } else {
                System.out.println("Desktop n'est pas pris en charge sur cette plateforme.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void quitter(MouseEvent event) {
        System.exit(0);
    }

}
