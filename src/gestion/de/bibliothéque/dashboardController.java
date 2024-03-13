package gestion.de.bibliothéque;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.sun.tools.javac.Main;
import static gestion.de.bibliothéque.dashboardController.RandomGenerator.generateRandomMAJ;
import java.io.File;
import java.io.FileInputStream;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

public class dashboardController implements Initializable {

    @FXML
    private TextField AddBook_Auth;

    @FXML
    private TableView<BookData> AddBook_tableview;

    @FXML
    private TableColumn<BookData, String> AddBook_Col_Desc;

    @FXML
    private TableColumn<BookData, String> AddBook_Col_Genre;

    @FXML
    private TableColumn<BookData, String> AddBook_Col_ID;

    @FXML
    private TableColumn<BookData, String> AddBook_Col_IDAuth;

    @FXML
    private TableColumn<BookData, String> AddBook_Col_NbCopie;

    @FXML
    private TableColumn<BookData, String> AddBook_Col_Price;

    @FXML
    private TableColumn<BookData, String> AddBook_Col_Titre;

    @FXML
    private JFXComboBox<?> AddBook_Genre;

    @FXML
    private TextField AddBook_Desc;

    @FXML
    private TextField AddBook_Price;

    @FXML
    private TextField AddBook_ID;

    @FXML
    private TextField AddBook_NbCopie;

    @FXML
    private TextField AddBook_Titre;

    @FXML
    private ImageView AddBook_image;

    @FXML
    private TextField AddClient_Ady;

    @FXML
    private TableView<AbonneData> AddClient_tableview;

    @FXML
    private TableColumn<AbonneData, Integer> AddClient_Col_ID;

    @FXML
    private TableColumn<AbonneData, String> AddClient_Col_Fname;

    @FXML
    private TableColumn<AbonneData, String> AddClient_Col_Lname;

    @FXML
    private TableColumn<AbonneData, String> AddClient_Col_Ady;

    @FXML
    private TableColumn<AbonneData, Integer> AddClient_Col_Num;

    @FXML
    private TableColumn<AbonneData, String> AddClient_Col_Mail;

    @FXML
    private TableColumn<AbonneData, String> AddClient_Col_Pass;

    @FXML
    private TextField AddReservation_IDSubscriber;

    @FXML
    private TextField AddClient_Fname;

    @FXML
    private TextField AddClient_ID;

    @FXML
    private TextField AddClient_Lname;

    @FXML
    private TextField AddClient_Mail;

    @FXML
    private TextField AddClient_Num;

    @FXML
    private TextField AddClient_Password;

    @FXML
    private JFXButton AddClient_btn;

    @FXML
    private TableView<ReservationData> AddReservation_tableview;

    @FXML
    private TableColumn<ReservationData, Integer> AddReservation_Col_ID;

    @FXML
    private TableColumn<ReservationData, Integer> AddReservation_Col_IDBook;

    @FXML
    private TableColumn<ReservationData, Integer> AddReservation_Col_IDSubscriber;

    @FXML
    private TableColumn<ReservationData, String> AddReservation_Col_PrevueRDate;

    @FXML
    private TableColumn<ReservationData, String> AddReservation_Col_ReservationDate;

    @FXML
    private TableColumn<ReservationData, String> AddReservation_Col_RetourDate;

    @FXML
    private TableColumn<ReservationData, String> AddReservation_Col_Code;

    @FXML
    private TableColumn<ReservationData, Integer> AddReservation_Col_Statut;

    @FXML
    private DatePicker AddReservation_DateR;

    @FXML
    private DatePicker AddReservation_Dretour;

    @FXML
    private TextField AddReservation_ID;

    @FXML
    private TextField AddReservation_IDBook;

    @FXML
    private TextField AddReservation_NbDays;

    @FXML
    private TextField AddReservation_Code;

    @FXML
    private JFXButton AddReservation_btn;

    @FXML
    private JFXButton ConfirmReservation_btn;

    @FXML
    private JFXButton DeleteClient_btn;

    @FXML
    private JFXButton ClearClient_btn;

    @FXML
    private JFXButton DeleteReservation_btn;

    @FXML
    private JFXButton UpdateClient_btn;

    @FXML
    private JFXButton UpdateReservation_btn;

    @FXML
    private JFXButton add_book_btn;

    @FXML
    private AnchorPane anchor111;

    @FXML
    private JFXButton delete_book_btn;

    @FXML
    private JFXButton exit_btn;

    @FXML
    private JFXButton gerer_client_btn;

    @FXML
    private AnchorPane gerer_clients_form;

    @FXML
    private JFXButton gerer_livre_btn;

    @FXML
    private AnchorPane gerer_livre_form;

    @FXML
    private AnchorPane gerer_reservation_form;

    @FXML
    private Pane hpane;

    @FXML
    private Pane infos;

    @FXML
    private Pane infos1;

    @FXML
    private Pane infos11;

    @FXML
    private Pane infos12;

    @FXML
    private Pane infos2;

    @FXML
    private Pane infos21;

    @FXML
    private Pane infos22;

    @FXML
    private Pane innerpane;

    @FXML
    private AnchorPane leftsidepane;

    @FXML
    private ImageView logoleftpane;

    @FXML
    private AnchorPane main_form;

    @FXML
    private AnchorPane rightsidepane;

    @FXML
    private JFXButton settings_btn;

    @FXML
    private JFXButton stats_btn;

    @FXML
    private AnchorPane stats_form;

    @FXML
    private Text total_actifs_clients;

    @FXML
    private Text total_actives_reservation_number;

    @FXML
    private Text total_attente_reservation_number;

    @FXML
    private Text total_available_books;

    @FXML
    private Text total_books_number;

    @FXML
    private Text total_client_number;

    @FXML
    private Text total_emprunted_books;

    @FXML
    private Text total_reservation_number;

    @FXML
    private Text total_retard_clients;

    @FXML
    private JFXButton update_book_btn;

    @FXML
    private JFXButton upload_image_btn;

    @FXML
    private JFXButton user_profile_btn;

    @FXML
    private Text username;

    @FXML
    private JFXButton voir_reservation_btn;

    //--------------MANAGEMNT------------------------------
    private Connection connect;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;

    private double x = 0;
    private double y = 0;

    public void signout() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to sign out?");
        Optional<ButtonType> option = alert.showAndWait();

        if (option.isPresent() && option.get() == ButtonType.OK) {
            try {
                // Load the FXML file
                Parent root = FXMLLoader.load(getClass().getResource("Sign_in_page.fxml"));
                Stage stage = (Stage) main_form.getScene().getWindow(); // Get the current stage
                Scene scene = new Scene(root);

                // Set mouse event handlers for dragging the window
                root.setOnMousePressed(event -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged(event -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);
                    stage.setOpacity(0.8);
                });

                root.setOnMouseReleased(event -> {
                    stage.setOpacity(1);
                });

                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void exit() {
        System.exit(0);
    }

    //-------------CLIENT---------------------
    public ObservableList<AbonneData> addAbonneListData() {
        ObservableList<AbonneData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM abonné";

        // Establish connection
        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            AbonneData AbonneD;
            while (result.next()) {
                AbonneD = new AbonneData(
                        result.getInt("id_abonné"),
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getString("adresse"),
                        result.getInt("numero"),
                        result.getString("adresse_mail"),
                        result.getString("mot_de_passe")
                );
                listData.add(AbonneD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listData;
    }
    private ObservableList<AbonneData> addAbonneList;

    public void addAbonneShowListData() {
        addAbonneList = addAbonneListData();

        AddClient_Col_ID.setCellValueFactory(new PropertyValueFactory<>("idAbonne"));
        AddClient_Col_Fname.setCellValueFactory(new PropertyValueFactory<>("nom"));
        AddClient_Col_Lname.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        AddClient_Col_Ady.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        AddClient_Col_Num.setCellValueFactory(new PropertyValueFactory<>("numero"));
        AddClient_Col_Mail.setCellValueFactory(new PropertyValueFactory<>("adresseMail"));
        AddClient_Col_Pass.setCellValueFactory(new PropertyValueFactory<>("password"));

        AddClient_tableview.setItems(addAbonneList);
    }

    public void AddAbonneSelect() {
        AbonneData abonneData = AddClient_tableview.getSelectionModel().getSelectedItem();

        if (abonneData != null) {
            AddClient_ID.setText(String.valueOf(abonneData.getIdAbonne()));
            AddClient_Fname.setText(abonneData.getNom());
            AddClient_Lname.setText(abonneData.getPrenom());
            AddClient_Ady.setText(abonneData.getAdresse());
            AddClient_Num.setText(String.valueOf(abonneData.getNumero()));
            AddClient_Mail.setText(abonneData.getAdresseMail());
            AddClient_Password.setText(abonneData.getPassword());
        }
    }

    public void display_username() {
        username.setText(getData.username);
        //Dans le login = getData.username = username.getText();
    }

    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }

    public void switchForm(ActionEvent event) {
        if (event.getSource() == gerer_livre_btn) {
            gerer_livre_form.setVisible(true);

            gerer_reservation_form.setVisible(false);
            gerer_clients_form.setVisible(false);
            stats_form.setVisible(false);
            gerer_livre_btn.setStyle("-fx-background-color: red;");
            voir_reservation_btn.setStyle("-fx-background-color: transparent");
            gerer_client_btn.setStyle("-fx-background-color: transparent");
            stats_btn.setStyle("-fx-background-color: transparent");

            TotalBooks();
            TotalAvailableBooks();
            TotalEmpruntedBooks();
            addBookGenreList();
        } else if (event.getSource() == voir_reservation_btn) {
            gerer_livre_form.setVisible(false);
            gerer_reservation_form.setVisible(true);
            gerer_clients_form.setVisible(false);
            stats_form.setVisible(false);
            gerer_livre_btn.setStyle("-fx-background-color: transparent");
            voir_reservation_btn.setStyle("-fx-background-color: red");
            gerer_client_btn.setStyle("-fx-background-color: transparent");
            stats_btn.setStyle("-fx-background-color: transparent");

            TotalReservation();
            TotalActifReservations();
            TotalAttentReservations();
        } else if (event.getSource() == gerer_client_btn) {
            gerer_livre_form.setVisible(false);
            gerer_reservation_form.setVisible(false);
            gerer_clients_form.setVisible(true);
            stats_form.setVisible(false);
            gerer_livre_btn.setStyle("-fx-background-color: transparent");
            voir_reservation_btn.setStyle("-fx-background-color: transparent");
            gerer_client_btn.setStyle("-fx-background-color: red;");
            stats_btn.setStyle("-fx-background-color: transparent");

            TotalClients();
            TotalActifClients();
            TotalLateReturns();   
        } else if (event.getSource() == stats_btn) {
            gerer_livre_form.setVisible(false);
            gerer_reservation_form.setVisible(false);
            gerer_clients_form.setVisible(false);
            stats_form.setVisible(true);
            gerer_livre_btn.setStyle("-fx-background-color: transparent");
            voir_reservation_btn.setStyle("-fx-background-color: transparent");
            gerer_client_btn.setStyle("-fx-background-color: transparent");
            stats_btn.setStyle("-fx-background-color: red;");
        }
    }

    public void addAbonneAdd() {
        if (AddClient_Fname.getText().isEmpty() || AddClient_Lname.getText().isEmpty() || AddClient_Ady.getText().isEmpty()
                || AddClient_Num.getText().isEmpty() || AddClient_Mail.getText().isEmpty()
                || AddClient_Password.getText().isEmpty()) {
            // Display an alert if any field is empty
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        String sql = "INSERT INTO abonné (nom, prenom, adresse, numero, adresse_mail, mot_de_passe) VALUES (?, ?, ?, ?, ?, ?)";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, AddClient_Fname.getText());
            prepare.setString(2, AddClient_Lname.getText());
            prepare.setString(3, AddClient_Ady.getText());
            prepare.setString(4, AddClient_Num.getText());
            prepare.setString(5, AddClient_Mail.getText());
            prepare.setString(6, AddClient_Password.getText());
            prepare.executeUpdate();

            // Display success message
            Alert successAlert = new Alert(AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Client added successfully.");
            successAlert.showAndWait();

            // Clear input fields after successful insertion
            AddClient_ID.clear();
            AddClient_Fname.clear();
            AddClient_Lname.clear();
            AddClient_Ady.clear();
            AddClient_Num.clear();
            AddClient_Mail.clear();
            AddClient_Password.clear();

            // Refresh client table view
            addAbonneShowListData();
        } catch (SQLException e) {
            // Display error message if insertion fails
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Failed to add client. Please try again.");
            errorAlert.showAndWait();
            e.printStackTrace(); // Print stack trace for debugging purposes
        } finally {
            try {
                // Close resources
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

    public void modifyAbonne() {
        // Check if a row is selected
        AbonneData selectedAbonne = AddClient_tableview.getSelectionModel().getSelectedItem();
        if (selectedAbonne == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a client to modify.");
            alert.showAndWait();
            return;
        }

        // Get values from input fields
        String nom = AddClient_Fname.getText();
        String prenom = AddClient_Lname.getText();
        String adresse = AddClient_Ady.getText();
        String numero = AddClient_Num.getText();
        String adresseMail = AddClient_Mail.getText();
        String motDePasse = AddClient_Password.getText();

        // Ensure all fields are filled
        if (nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || numero.isEmpty() || adresseMail.isEmpty() || motDePasse.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        // Prepare SQL update statement
        String sql = "UPDATE abonné SET nom=?, prenom=?, adresse=?, numero=?, adresse_mail=?, mot_de_passe=? WHERE id_abonné=?";

        // Establish database connection
        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, nom);
            prepare.setString(2, prenom);
            prepare.setString(3, adresse);
            prepare.setString(4, numero);
            prepare.setString(5, adresseMail);
            prepare.setString(6, motDePasse);
            prepare.setInt(7, selectedAbonne.getIdAbonne()); // Set id of selected user
            prepare.executeUpdate();

            // Display success message
            Alert successAlert = new Alert(AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Client modified successfully.");
            successAlert.showAndWait();

            // Clear input fields after successful modification
            clearClientFields();

            // Refresh client table view
            addAbonneShowListData();
        } catch (SQLException e) {
            // Display error message if modification fails
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Failed to modify client. Please try again.");
            errorAlert.showAndWait();
            e.printStackTrace(); // Print stack trace for debugging purposes
        } finally {
            try {
                // Close resources
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

    public void deleteAbonne() {
        // Check if a row is selected
        AbonneData selectedAbonne = AddClient_tableview.getSelectionModel().getSelectedItem();
        if (selectedAbonne == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a client to delete.");
            alert.showAndWait();
            return;
        }

        // Prepare SQL delete statement
        String sql = "DELETE FROM abonné WHERE id_abonné=?";

        // Establish database connection
        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setInt(1, selectedAbonne.getIdAbonne()); // Set id of selected user
            prepare.executeUpdate();

            // Display success message
            Alert successAlert = new Alert(AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Client deleted successfully.");
            successAlert.showAndWait();

            // Clear input fields after successful deletion
            clearClientFields();

            // Refresh client table view
            addAbonneShowListData();
        } catch (SQLException e) {
            // Display error message if deletion fails
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Failed to delete client. Please try again.");
            errorAlert.showAndWait();
            e.printStackTrace(); // Print stack trace for debugging purposes
        } finally {
            try {
                // Close resources
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

    public void clearClientFields() {
        // Clear input fields
        AddClient_ID.clear();
        AddClient_Fname.clear();
        AddClient_Lname.clear();
        AddClient_Ady.clear();
        AddClient_Num.clear();
        AddClient_Mail.clear();
        AddClient_Password.clear();
    }

    public void TotalClients() {

        String sql = "SELECT COUNT(id_abonné) FROM abonné";

        connect = database.connectDb();
        int countData = 0;
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                countData = result.getInt("COUNT(id_abonné)");
            }

            total_client_number.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void TotalActifClients() {
        String sql = "SELECT COUNT(id_livre) FROM reservation WHERE statut = 1";

        connect = database.connectDb();
        int countData = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                countData = result.getInt(1);
            }

            // Afficher le nombre total de réservations actives
            total_actifs_clients.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void TotalLateReturns() {
        String sql = "SELECT COUNT(id_livre) FROM reservation WHERE statut = 1 AND date_retour_reel > date_retour_prevue";

        connect = database.connectDb();
        int countLateReturns = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                countLateReturns = result.getInt(1);
            }

            // Afficher le nombre total de retours en retard
            total_retard_clients.setText(String.valueOf(countLateReturns));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //---------------BOOK------------------------------
    private String[] listGenre = {"Roman", "Science-fiction", "Fantaisie", "Mystère", "Policier", "Thriller", "Horreur", "Romance", "Historique", "Aventure", "Dystopie", "Réalisme magique", "Contemporain", "Jeunesse", "Nouvelle", "Biographie", "Autobiographie", "Science", "Philosophie", "Poésie"};

    public void addBookGenreList() {
        List<String> listG = new ArrayList<>();

        for (String data : listGenre) {
            listG.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listG);
        AddBook_Genre.setItems(listData);
    }

    public ObservableList<BookData> addBookListData() {

        ObservableList<BookData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM livre";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            BookData BookD;

            while (result.next()) {
                BookD = new BookData(
                        result.getInt("id_livre"),
                        result.getString("titre"),
                        result.getInt("id_auteur"),
                        result.getString("genre"),
                        result.getInt("nb-copie"),
                        result.getString("image"),
                        result.getString("description"),
                        result.getInt("prix")
                );
                listData.add(BookD);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<BookData> bookList;

    public void showBookListData() {
        bookList = addBookListData();

        AddBook_Col_ID.setCellValueFactory(new PropertyValueFactory<>("idLivre"));
        AddBook_Col_Titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        AddBook_Col_IDAuth.setCellValueFactory(new PropertyValueFactory<>("idAuteur"));
        AddBook_Col_Genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        AddBook_Col_NbCopie.setCellValueFactory(new PropertyValueFactory<>("nbCopies"));
        AddBook_Col_Desc.setCellValueFactory(new PropertyValueFactory<>("description"));
        AddBook_Col_Price.setCellValueFactory(new PropertyValueFactory<>("price"));

        AddBook_tableview.setItems(bookList);
    }

    private Image image;

    public void AddBookInsertImage() {
        FileChooser open = new FileChooser();
        File file = open.showOpenDialog((Stage) main_form.getScene().getWindow());

        if (file != null) {
            getData.path = file.getAbsolutePath();

            try {
                // Load the image file
                FileInputStream inputStream = new FileInputStream(file);
                image = new Image(inputStream);
                AddBook_image.setImage(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void AddBookSelect() {
        BookData bookData = AddBook_tableview.getSelectionModel().getSelectedItem();

        if (bookData != null) {
            AddBook_ID.setText(String.valueOf(bookData.getIdLivre()));
            AddBook_Titre.setText(bookData.getTitre());
            AddBook_Auth.setText(String.valueOf(bookData.getIdAuteur()));
            AddBook_NbCopie.setText(String.valueOf(bookData.getNbCopies()));
            AddBook_Price.setText(String.valueOf(bookData.getPrice()));
            AddBook_Desc.setText(String.valueOf(bookData.getDescription()));
        }
    }

    public void addBookAdd() {
        String sql = "INSERT INTO livre "
                + "(titre, id_auteur, genre, `nb-copie`, image, description, prix) "
                + "VALUES(?,?,?,?,?,?,?)";

        connect = database.connectDb();

        try {
            Alert alert;
            if (AddBook_Titre.getText().isEmpty()
                    || AddBook_Auth.getText().isEmpty()
                    || AddBook_Genre.getSelectionModel().isEmpty()
                    || AddBook_NbCopie.getText().isEmpty()
                    || AddBook_Desc.getText().isEmpty()
                    || AddBook_Price.getText().isEmpty()
                    || getData.path == null || getData.path.isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                String check = "SELECT id_livre FROM livre WHERE id_livre = ?";
                prepare = connect.prepareStatement(check);
                prepare.setString(1, AddBook_ID.getText());
                result = prepare.executeQuery();

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Book ID: " + AddBook_ID.getText() + " already exists");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, AddBook_Titre.getText());
                    prepare.setString(2, AddBook_Auth.getText());
                    prepare.setString(3, AddBook_Genre.getSelectionModel().getSelectedItem().toString());
                    prepare.setString(4, AddBook_NbCopie.getText());
                    prepare.setString(5, getData.path.replace("\\", "\\\\"));
                    prepare.setString(6, AddBook_Desc.getText());
                    prepare.setString(7, AddBook_Price.getText());
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    showBookListData();
                    clearBookFields();
                }
            }
        } catch (Exception e) {
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

    public void modifyBook() {
        BookData selectedBook = AddBook_tableview.getSelectionModel().getSelectedItem();
        if (selectedBook == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a book to modify.");
            alert.showAndWait();
            return;
        }

        String titre = AddBook_Titre.getText();
        String auteurId = AddBook_Auth.getText();
        String genre = AddBook_Genre.getValue() == null ? "" : AddBook_Genre.getValue().toString();
        String nbCopie = AddBook_NbCopie.getText();
        String prix = AddBook_Price.getText(); // Ajout de la récupération du prix

        if (titre.isEmpty() || auteurId.isEmpty() || genre.isEmpty() || nbCopie.isEmpty() || prix.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        String sql = "UPDATE livre SET titre=?, id_auteur=?, genre=?, `nb-copie`=?, prix=? WHERE id_livre=?";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, titre);
            prepare.setString(2, auteurId);
            prepare.setString(3, genre);
            prepare.setString(4, nbCopie);
            prepare.setString(5, prix); // Définition du prix dans la requête SQL
            prepare.setInt(6, selectedBook.getIdLivre());
            prepare.executeUpdate();

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Book modified successfully.");
            successAlert.showAndWait();

            clearBookFields();
            showBookListData();
        } catch (SQLException e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Failed to modify book. Please try again.");
            errorAlert.showAndWait();
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

    public void deleteBook() {
        BookData selectedBook = AddBook_tableview.getSelectionModel().getSelectedItem();
        if (selectedBook == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a book to delete.");
            alert.showAndWait();
            return;
        }

        String sql = "DELETE FROM livre WHERE id_livre=?";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setInt(1, selectedBook.getIdLivre());
            prepare.executeUpdate();

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Book deleted successfully.");
            successAlert.showAndWait();

            clearBookFields();
            showBookListData();
        } catch (SQLException e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Failed to delete book. Please try again.");
            errorAlert.showAndWait();
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

    private void clearBookFields() {
        // Clear input fields after successful deletion
        AddBook_ID.clear();
        AddBook_Titre.clear();
        AddBook_Auth.clear();
        AddBook_NbCopie.clear();
        AddBook_Price.clear();
        AddBook_Desc.clear();
    }

    public void TotalBooks() {
        String sql = "SELECT SUM(`nb-copie`) AS total_copies FROM livre";

        connect = database.connectDb();
        int totalCopies = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                totalCopies = result.getInt("total_copies");
            }

            // Afficher le nombre total de copies de livres
            total_books_number.setText(String.valueOf(totalCopies));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void TotalAvailableBooks() {
        String sqlTotalBooks = "SELECT SUM(`nb-copie`) AS total_copies FROM livre";
        String sqlReservations = "SELECT COUNT(id_res) FROM reservation WHERE statut = 1";

        connect = database.connectDb();
        int totalBooks = 0;
        int totalReservations = 0;
        try {
            // Obtenir le total des livres
            prepare = connect.prepareStatement(sqlTotalBooks);
            result = prepare.executeQuery();

            while (result.next()) {
                totalBooks = result.getInt("total_copies");
            }

            // Obtenir le total des réservations avec statut = 0
            prepare = connect.prepareStatement(sqlReservations);
            result = prepare.executeQuery();

            while (result.next()) {
                totalReservations = result.getInt(1);
            }

            // Calculer le total des livres disponibles
            int totalAvailableBooks = totalBooks - totalReservations;

            // Afficher le nombre total de livres disponibles
            total_available_books.setText(String.valueOf(totalAvailableBooks));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void TotalEmpruntedBooks() {
        String sql = "SELECT COUNT(id_livre) FROM reservation WHERE statut = 1";

        connect = database.connectDb();
        int countData = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                countData = result.getInt(1);
            }

            // Afficher le nombre total de réservations en attente
            total_emprunted_books.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //---------------RESERVATION---------------
    public class RandomGenerator {
        // Function to generate a random 12-character string of uppercase letters

        public static String generateRandomMAJ() {
            // Define the characters allowed in the random string
            String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            // Initialize a Random object
            Random random = new Random();

            // Initialize a StringBuilder to store the random string
            StringBuilder sb = new StringBuilder();

            // Generate 12 random characters
            for (int i = 0; i < 12; i++) {
                // Generate a random index within the range of allowedChars
                int randomIndex = random.nextInt(allowedChars.length());

                // Append the character at the random index to the StringBuilder
                sb.append(allowedChars.charAt(randomIndex));
            }

            // Return the generated random string
            return sb.toString();
        }
    }

    public ObservableList<ReservationData> addReservationListData() {

        ObservableList<ReservationData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM reservation";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            ReservationData ReservationD;

            while (result.next()) {
                ReservationD = new ReservationData(
                        result.getInt("id_res"),
                        result.getInt("id_livre"),
                        result.getInt("id_abonné"),
                        result.getDate("date_res"),
                        result.getDate("date_retour_prevue"),
                        result.getDate("date_retour_reel"),
                        result.getString("code"),
                        result.getInt("statut")
                );
                listData.add(ReservationD);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<ReservationData> reservationList;

    public void showReservationListData() {
        reservationList = addReservationListData();

        AddReservation_Col_ID.setCellValueFactory(new PropertyValueFactory<>("idRes"));
        AddReservation_Col_IDBook.setCellValueFactory(new PropertyValueFactory<>("idLivre"));
        AddReservation_Col_IDSubscriber.setCellValueFactory(new PropertyValueFactory<>("idAbonne"));
        AddReservation_Col_ReservationDate.setCellValueFactory(new PropertyValueFactory<>("dateRes"));
        AddReservation_Col_PrevueRDate.setCellValueFactory(new PropertyValueFactory<>("dateRetourPrevue"));
        AddReservation_Col_RetourDate.setCellValueFactory(new PropertyValueFactory<>("dateRetourReel"));
        AddReservation_Col_Code.setCellValueFactory(new PropertyValueFactory<>("code"));
        AddReservation_Col_Statut.setCellValueFactory(new PropertyValueFactory<>("status"));

        AddReservation_tableview.setItems(reservationList);
    }

    public void AddReservationSelect() {
        ReservationData reservationData = AddReservation_tableview.getSelectionModel().getSelectedItem();

        if (reservationData != null) {
            AddReservation_ID.setText(String.valueOf(reservationData.getIdRes()));
            AddReservation_IDBook.setText(String.valueOf(reservationData.getIdLivre()));
            AddReservation_IDSubscriber.setText(String.valueOf(reservationData.getIdAbonne()));
            AddReservation_Code.setText(reservationData.getCode());
        }
    }

    public void addReservationAdd() {
        String code = generateRandomMAJ();
        // Retrieve the number of days from the text field
        int nbJours;
        try {
            nbJours = Integer.parseInt(AddReservation_NbDays.getText());
        } catch (NumberFormatException e) {
            // Handle invalid input for number of days
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid number of days.");
            alert.showAndWait();
            return;
        }

        // Parse the reservation date from the DatePicker
        LocalDate dateRes = AddReservation_DateR.getValue();
        if (dateRes == null) {
            // Handle missing reservation date
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select a reservation date.");
            alert.showAndWait();
            return;
        }

        // Calculate the expected return date
        LocalDate dateRetourPrevue = dateRes.plusDays(nbJours);

        // Calculate the actual return date (let's assume it's set to the reservation date initially)
        LocalDate dateRetourReel = dateRes;

        // Convert LocalDate to SQL Date
        java.sql.Date sqlDateRes = java.sql.Date.valueOf(dateRes);
        java.sql.Date sqlDateRetourPrevue = java.sql.Date.valueOf(dateRetourPrevue);
        java.sql.Date sqlDateRetourReel = java.sql.Date.valueOf(dateRetourReel);

        // Continue with the database insertion
        String sql = "INSERT INTO reservation "
                + "(id_livre, id_abonné, date_res, date_retour_prevue, date_retour_reel, code, statut) "
                + "VALUES(?,?,?,?,?,?,?)";

        connect = database.connectDb();
        try {
            Alert alert;
            prepare = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prepare.setString(1, AddReservation_IDBook.getText());
            prepare.setString(2, AddReservation_IDSubscriber.getText());
            prepare.setDate(3, sqlDateRes);
            prepare.setDate(4, sqlDateRetourPrevue);
            prepare.setDate(5, sqlDateRetourReel);
            prepare.setString(6, code);
            prepare.setString(7, "1");
            prepare.executeUpdate();

            ResultSet generatedKeys = prepare.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idReservation = generatedKeys.getInt(1);
                // Now you have the ID of the newly inserted reservation
                System.out.println("New Reservation ID: " + idReservation);
            }

            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Added!");
            alert.showAndWait();

            showReservationListData();
        } catch (Exception e) {
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

    public void modifyReservation() {
        // Check if a reservation is selected
        ReservationData selectedReservation = AddReservation_tableview.getSelectionModel().getSelectedItem();
        if (selectedReservation == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a reservation to modify.");
            alert.showAndWait();
            return;
        }

        // Retrieve the new values from the input fields
        // Assuming AddReservation_IDBook, AddReservation_IDSubscriber are TextFields
        String newIdBook = AddReservation_IDBook.getText();
        String newIdSubscriber = AddReservation_IDSubscriber.getText();

        // Parse the new reservation date from the DatePicker
        LocalDate newDateRes = AddReservation_DateR.getValue();
        if (newDateRes == null) {
            // Handle missing reservation date
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select a reservation date.");
            alert.showAndWait();
            return;
        }

        // Calculate the new expected return date
        int nbDays = Integer.parseInt(AddReservation_NbDays.getText());
        LocalDate newDateRetourPrevue = newDateRes.plusDays(nbDays);

        // Prepare the SQL update statement
        String sql = "UPDATE reservation SET id_livre=?, id_abonné=?, date_res=?, date_retour_prevue=? WHERE id_res=?";

        connect = database.connectDb();
        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, newIdBook);
            prepare.setString(2, newIdSubscriber);
            prepare.setDate(3, java.sql.Date.valueOf(newDateRes));
            prepare.setDate(4, java.sql.Date.valueOf(newDateRetourPrevue));
            prepare.setInt(5, selectedReservation.getIdRes());
            prepare.executeUpdate();

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Reservation modified successfully.");
            successAlert.showAndWait();

            showReservationListData();
        } catch (SQLException e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Failed to modify reservation. Please try again.");
            errorAlert.showAndWait();
            e.printStackTrace();
        } finally {
            try {
                // Close resources
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

    public void deleteReservation() {
        // Check if a reservation is selected
        ReservationData selectedReservation = AddReservation_tableview.getSelectionModel().getSelectedItem();
        if (selectedReservation == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a reservation to delete.");
            alert.showAndWait();
            return;
        }

        // Prepare the SQL delete statement
        String sql = "DELETE FROM reservation WHERE id_res=?";

        connect = database.connectDb();
        try {
            prepare = connect.prepareStatement(sql);
            prepare.setInt(1, selectedReservation.getIdRes());
            prepare.executeUpdate();

            // Display success message
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Reservation deleted successfully.");
            successAlert.showAndWait();

            // Refresh reservation table view
            showReservationListData();
        } catch (SQLException e) {
            // Display error message if deletion fails
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Failed to delete reservation. Please try again.");
            errorAlert.showAndWait();
            e.printStackTrace(); // Print stack trace for debugging purposes
        } finally {
            try {
                // Close resources
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

    public void confirmReservation() {
        // Get the code inputted in AddReservation_Code
        String code = AddReservation_Code.getText();

        // Check if the code is empty
        if (code.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a code.");
            alert.showAndWait();
            return;
        }

        // Query to update the status from 0 to 1 for the reservation with the given code
        String sql = "UPDATE reservation SET statut = 1 WHERE code = ?";

        connect = database.connectDb();
        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, code);
            int rowsAffected = prepare.executeUpdate();

            if (rowsAffected > 0) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Reservation confirmer avec succées.");
                alert.showAndWait();

                // Optionally, you can refresh the reservation list data after confirmation
                showReservationListData();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("No reservation found with the provided code.");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while confirming the reservation.");
            alert.showAndWait();
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

    public void TotalReservation() {

        String sql = "SELECT COUNT(id_res) FROM reservation";

        connect = database.connectDb();
        int countData = 0;
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                countData = result.getInt("COUNT(id_res)");
            }

            total_reservation_number.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void TotalActifReservations() {
        String sql = "SELECT COUNT(id_res) FROM reservation WHERE statut = 1";

        connect = database.connectDb();
        int countData = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                countData = result.getInt(1);
            }

            // Afficher le nombre total de réservations actives
            total_actives_reservation_number.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void TotalAttentReservations() {
        String sql = "SELECT COUNT(id_res) FROM reservation WHERE statut = 0";

        connect = database.connectDb();
        int countData = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                countData = result.getInt(1);
            }

            // Afficher le nombre total de réservations en attente
            total_attente_reservation_number.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //---------------MAIN----------------------
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addAbonneShowListData();
        showBookListData();
        showReservationListData();
        //Charge the combolist items 
        addBookGenreList();

        //Inner - Stats
        TotalReservation();
        TotalActifReservations();
        TotalAttentReservations();

        TotalBooks();
        TotalAvailableBooks();
        TotalEmpruntedBooks();

        TotalClients();
        TotalActifClients();
        TotalLateReturns();

    }

}
