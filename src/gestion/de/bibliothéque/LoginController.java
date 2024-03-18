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

public class LoginController implements Initializable {

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
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
                    Parent root = loader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();

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
