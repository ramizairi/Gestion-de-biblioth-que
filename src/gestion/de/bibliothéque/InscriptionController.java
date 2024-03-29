package gestion.de.bibliothéque;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class InscriptionController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField adresse;
    @FXML
    private TextField telephone;
    @FXML
    private Button Quit_btn;
    @FXML
    private PasswordField password;
    @FXML
    private TextField email;
    @FXML
    private Button Sign_up;
    @FXML
    private Button Cancel;
    @FXML
    private PasswordField second_password;

    Inscription_service insc_serv = new Inscription_service();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void quitter(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void sign_up(MouseEvent event) {
        String telephoneText = telephone.getText();
        int telephoneInt = 0;
        int verif_tel = 0;
    
        try {
            telephoneInt = Integer.parseInt(telephoneText);
            verif_tel = 1;
    
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Numero invalide");
            alert.setHeaderText("Failure");
            alert.setContentText("Error " + e.getMessage());
            alert.showAndWait();
        }
        
        AbonneData new_abonne = new AbonneData(0, nom.getText(), prenom.getText(), telephoneInt, adresse.getText(), email.getText(), password.getText());
        if (nom.getText().isEmpty() == false && prenom.getText().isEmpty() == false && adresse.getText().isEmpty() == false && telephone.getText().isEmpty() == false && email.getText().isEmpty() == false && password.getText().isEmpty() == false && second_password.getText().isEmpty() == false && verif_tel == 1) {
            if (password.getText().equals(second_password.getText())) {
                if (email.getText().contains("@") && email.getText().contains(".")) {
                    insc_serv.add_abonee(new_abonne);
                    nom.setText("");
                    prenom.setText("");
                    adresse.setText("");
                    telephone.setText("");
                    email.setText("");
                    password.setText("");
                    second_password.setText("");

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Données invalides");
                    alert.setHeaderText("Failure");
                    alert.setContentText("Error : Veuillez verifier votre email");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Données invalides");
                alert.setHeaderText("Failure");
                alert.setContentText("Error : Veuillez saisir un mot de passe conforme");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Données invalides");
            alert.setHeaderText("Failure");
            alert.setContentText("Error : Veuillez remplir tous les champs");
            alert.showAndWait();
        }

    }

    @FXML
    private void cancel_sign_up(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Sign_in_page.fxml"));
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        Scene sc = new Scene(root);
        stage.setScene(sc);
        stage.show();

    }

}
