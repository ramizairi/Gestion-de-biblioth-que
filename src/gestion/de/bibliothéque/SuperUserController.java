package gestion.de.bibliothéque;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Optional;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class SuperUserController implements Initializable {

    @FXML
    private TableColumn<HistoryData, String> History_Col_ID;

    @FXML
    private TableColumn<HistoryData, String> History_Col_date;

    @FXML
    private TableColumn<HistoryData, String> History_Col_description;

    @FXML
    private TableColumn<HistoryData, String> History_Col_id_manager;

    @FXML
    private TableColumn<HistoryData, String> History_Col_operation;

    @FXML
    private TableView<HistoryData> History_tableview;

    @FXML
    private TextField history_filter_text_field;

    @FXML
    private AnchorPane history_form;

    @FXML
    private TableView<ManagerData> AddManager_tableview;

    @FXML
    private TextField AddManager_Ady;

    @FXML
    private TableColumn<ManagerData, String> AddManager_Col_Ady;

    @FXML
    private TableColumn<ManagerData, String> AddManager_Col_Fname;

    @FXML
    private TableColumn<ManagerData, String> AddManager_Col_ID;

    @FXML
    private TableColumn<ManagerData, String> AddManager_Col_Lname;

    @FXML
    private TableColumn<ManagerData, String> AddManager_Col_Mail;

    @FXML
    private TableColumn<ManagerData, String> AddManager_Col_Num;

    @FXML
    private TableColumn<ManagerData, String> AddManager_Col_Pass;

    @FXML
    private TextField AddManager_Fname;

    @FXML
    private TextField AddManager_ID;

    @FXML
    private TextField AddManager_Lname;

    @FXML
    private TextField AddManager_Mail;

    @FXML
    private TextField AddManager_Num;

    @FXML
    private TextField AddManager_Password;

    @FXML
    private JFXButton AddManager_btn;

    @FXML
    private JFXButton ClearManager_btn;

    @FXML
    private JFXButton history_btn;

    @FXML
    private JFXButton DeleteManager_btn;

    @FXML
    private JFXButton UpdateManager_btn;

    @FXML
    private LineChart<?, ?> actif_managers_linechart;

    @FXML
    private AnchorPane anchor111;

    @FXML
    private PieChart book_per_genre_piechart;

    @FXML
    private BarChart<?, ?> book_value_bar;

    @FXML
    private TextField cherche_manager_text_field;

    @FXML
    private JFXButton exit_btn;

    @FXML
    private JFXButton gerer_manager_btn;

    @FXML
    private AnchorPane gerer_managers_form;

    @FXML
    private Pane hpane;

    @FXML
    private AnchorPane leftsidepane;

    @FXML
    private BarChart<?, ?> livres_par_auteur_bar;

    @FXML
    private ImageView logoleftpane;

    @FXML
    private JFXButton man_stats_btn;

    @FXML
    private BarChart<?, ?> prop_per_book_bar;

    @FXML
    private LineChart<?, ?> reservation_per_genre_linechart;

    @FXML
    private AnchorPane rightsidepane;

    @FXML
    private JFXButton settings_btn;

    @FXML
    private JFXButton stats_btn;

    @FXML
    private AnchorPane stats_form;

    @FXML
    private AnchorPane stats_managers_form;

    @FXML
    private AnchorPane super_user_form;

    @FXML
    private Text time_now_txt;

    @FXML
    private Pane top_pane;

    @FXML
    private Text total_actifs_managers;

    @FXML
    private Text total_manager_number;

    // ----------------------------------------------------------------
    private Connection connect;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;

    private double x = 0;
    private double y = 0;

    private Label time;
    private volatile boolean stop = false;

    public void exit() {
        System.exit(0);
    }

    public void minimize() {
        Stage stage = (Stage) super_user_form.getScene().getWindow();
        stage.setIconified(true);
    }

    public void signout() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to sign out?");
        Optional<ButtonType> option = alert.showAndWait();

        if (option.isPresent() && option.get() == ButtonType.OK) {
            try {
                // Load the FXML file
                Parent root = FXMLLoader.load(getClass().getResource("Sign_in_page.fxml"));
                Stage stage = (Stage) super_user_form.getScene().getWindow();
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

    public void switchForm(ActionEvent event) {
        if (event.getSource() == gerer_manager_btn) {
            gerer_managers_form.setVisible(true);
            history_form.setVisible(false);
            stats_form.setVisible(false);
            stats_managers_form.setVisible(false);
            cherche_manager_text_field.setVisible(true);
            history_filter_text_field.setVisible(false);
            gerer_manager_btn.setStyle("-fx-background-color: red;");
            history_btn.setStyle("-fx-background-color: transparent");
            stats_btn.setStyle("-fx-background-color: transparent");
            man_stats_btn.setStyle("-fx-background-color: transparent");

        } else if (event.getSource() == history_btn) {
            gerer_managers_form.setVisible(false);
            history_form.setVisible(true);
            stats_form.setVisible(false);
            stats_managers_form.setVisible(false);
            cherche_manager_text_field.setVisible(false);
            history_filter_text_field.setVisible(true);
            gerer_manager_btn.setStyle("-fx-background-color: transparent");
            history_btn.setStyle("-fx-background-color: red");
            stats_btn.setStyle("-fx-background-color: transparent");
            man_stats_btn.setStyle("-fx-background-color: transparent;");
        } else if (event.getSource() == stats_btn) {
            gerer_managers_form.setVisible(false);
            history_form.setVisible(false);
            stats_form.setVisible(true);
            stats_managers_form.setVisible(false);
            gerer_manager_btn.setStyle("-fx-background-color: transparent");
            history_btn.setStyle("-fx-background-color: transparent");
            stats_btn.setStyle("-fx-background-color: red");
            man_stats_btn.setStyle("-fx-background-color: transparent");

        } else if (event.getSource() == man_stats_btn) {
            gerer_managers_form.setVisible(false);
            history_form.setVisible(false);
            stats_form.setVisible(false);
            stats_managers_form.setVisible(true);
            gerer_manager_btn.setStyle("-fx-background-color: transparent");
            history_btn.setStyle("-fx-background-color: transparent");
            stats_btn.setStyle("-fx-background-color: transparent");
            man_stats_btn.setStyle("-fx-background-color: red;");
        }
    }

    private void Timenow() {
        Thread thread = new Thread(() -> {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            while (!stop) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LocalDateTime now = LocalDateTime.now();
                final String timenow = sdf.format(java.sql.Timestamp.valueOf(now));
                Platform.runLater(() -> {
                    time_now_txt.setText(timenow); // This is the label
                });
            }
        });
        thread.start();
    }

    /// -----------------------------------------------------------------
    private void searchManager() {
        FilteredList<ManagerData> filteredData = new FilteredList<>(addmanagerList, p -> true);

        cherche_manager_text_field.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(managerData -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (managerData.getNom().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (managerData.getPrenom().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(managerData.getIdManager()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (managerData.getAdresseMail().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(managerData.getNumero()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (managerData.getAdresse().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<ManagerData> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(AddManager_tableview.comparatorProperty());

        AddManager_tableview.setItems(sortedData);
    }

    public ObservableList<ManagerData> addmanagerListData() {
        ObservableList<ManagerData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM manager";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            ManagerData managerD;
            while (result.next()) {
                managerD = new ManagerData(
                        result.getInt("id_manager"),
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getInt("numero"),
                        result.getString("adresse"),
                        result.getString("adresse_mail"),
                        result.getString("mot_de_passe"));
                listData.add(managerD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<ManagerData> addmanagerList;

    public void addmanagerShowListData() {
        addmanagerList = addmanagerListData();

        AddManager_Col_ID.setCellValueFactory(new PropertyValueFactory<>("idManager"));
        AddManager_Col_Fname.setCellValueFactory(new PropertyValueFactory<>("nom"));
        AddManager_Col_Lname.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        AddManager_Col_Ady.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        AddManager_Col_Num.setCellValueFactory(new PropertyValueFactory<>("numero"));
        AddManager_Col_Mail.setCellValueFactory(new PropertyValueFactory<>("adresseMail"));
        AddManager_Col_Pass.setCellValueFactory(new PropertyValueFactory<>("password"));

        AddManager_tableview.setItems(addmanagerList);
    }

    public void AddmanagerSelect() {
        ManagerData ManagerData = AddManager_tableview.getSelectionModel().getSelectedItem();

        if (ManagerData != null) {
            AddManager_ID.setText(String.valueOf(ManagerData.getIdManager()));
            AddManager_Fname.setText(ManagerData.getNom());
            AddManager_Lname.setText(ManagerData.getPrenom());
            AddManager_Ady.setText(ManagerData.getAdresse());
            AddManager_Num.setText(String.valueOf(ManagerData.getNumero()));
            AddManager_Mail.setText(ManagerData.getAdresseMail());
            AddManager_Password.setText(ManagerData.getPassword());
        }
    }

    public void addmanagerAdd() {
        if (AddManager_Fname.getText().isEmpty() || AddManager_Lname.getText().isEmpty()
                || AddManager_Ady.getText().isEmpty()
                || AddManager_Num.getText().isEmpty() || AddManager_Mail.getText().isEmpty()
                || AddManager_Password.getText().isEmpty()) {
            // Display an alert if any field is empty
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        String sql = "INSERT INTO manager (nom, prenom, adresse, numero, adresse_mail, mot_de_passe) VALUES (?, ?, ?, ?, ?, ?)";

        connect = database.connectDb();

        try {
            // Generate salt
            String salt = BCrypt.gensalt();

            // Hash password
            String hashedPassword = BCrypt.hashpw(AddManager_Password.getText(), salt);

            prepare = connect.prepareStatement(sql);
            prepare.setString(1, AddManager_Fname.getText());
            prepare.setString(2, AddManager_Lname.getText());
            prepare.setString(3, AddManager_Ady.getText());
            prepare.setString(4, AddManager_Num.getText());
            prepare.setString(5, AddManager_Mail.getText());
            prepare.setString(6, hashedPassword);
            prepare.executeUpdate();

            // Display success message
            Alert successAlert = new Alert(AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Manager added successfully.");
            successAlert.showAndWait();

            // Clear input fields after successful insertion
            AddManager_ID.clear();
            AddManager_Fname.clear();
            AddManager_Lname.clear();
            AddManager_Ady.clear();
            AddManager_Num.clear();
            AddManager_Mail.clear();
            AddManager_Password.clear();

            // Refresh Manager table view
            addmanagerShowListData();
        } catch (SQLException e) {
            // Display error message if insertion fails
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Failed to add Manager. Please try again.");
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

    public void modifymanager() {
        // Check if a row is selected
        ManagerData selectedmanager = AddManager_tableview.getSelectionModel().getSelectedItem();
        if (selectedmanager == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a Manager to modify.");
            alert.showAndWait();
            return;
        }

        // Get values from input fields
        String nom = AddManager_Fname.getText();
        String prenom = AddManager_Lname.getText();
        String adresse = AddManager_Ady.getText();
        String numero = AddManager_Num.getText();
        String adresseMail = AddManager_Mail.getText();
        // Ensure all fields are filled
        if (nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || numero.isEmpty() || adresseMail.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        // Prepare SQL update statement
        String sql = "UPDATE manager SET nom=?, prenom=?, adresse=?, numero=?, adresse_mail=? WHERE id_manager=?";

        // Establish database connection
        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, nom);
            prepare.setString(2, prenom);
            prepare.setString(3, adresse);
            prepare.setString(4, numero);
            prepare.setString(5, adresseMail);
            prepare.setInt(6, selectedmanager.getIdManager()); // Set id of selected user
            prepare.executeUpdate();

            // Display success message
            Alert successAlert = new Alert(AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Manager modified successfully.");
            successAlert.showAndWait();

            // Clear input fields after successful modification
            clearManagerFields();

            // Refresh Manager table view
            addmanagerShowListData();
        } catch (SQLException e) {
            // Display error message if modification fails
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Failed to modify Manager. Please try again.");
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

    public void deletemanager() {
        // Check if a row is selected
        ManagerData selectedmanager = AddManager_tableview.getSelectionModel().getSelectedItem();
        if (selectedmanager == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a Manager to delete.");
            alert.showAndWait();
            return;
        }

        String sql = "DELETE FROM manager WHERE id_manager=?";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setInt(1, selectedmanager.getIdManager());
            prepare.executeUpdate();

            // Display success message
            Alert successAlert = new Alert(AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Manager deleted successfully.");
            successAlert.showAndWait();

            // Clear input fields after successful deletion
            clearManagerFields();

            // Refresh Manager table view
            addmanagerShowListData();
        } catch (SQLException e) {
            // Display error message if deletion fails
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Failed to delete Manager. Please try again.");
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

    public void clearManagerFields() {
        // Clear input fields
        AddManager_ID.clear();
        AddManager_Fname.clear();
        AddManager_Lname.clear();
        AddManager_Ady.clear();
        AddManager_Num.clear();
        AddManager_Mail.clear();
        AddManager_Password.clear();
    }

    public void TotalManagers() {

        String sql = "SELECT COUNT(id_manager) FROM manager";

        connect = database.connectDb();
        int countData = 0;
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                countData = result.getInt("COUNT(id_manager)");
            }

            total_manager_number.setText(String.valueOf(countData));
            total_actifs_managers.setText(String.valueOf(countData));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // -----------------------------------------------------------------
    public void book_per_auth() {
        String book_per_authSql = "SELECT a.nom, COUNT(b.id_livre) AS num_livres "
                + "FROM auteur a INNER JOIN livre b "
                + "ON a.id_auteur = b.id_auteur GROUP BY a.nom";

        Connection connect = database.connectDb();
        try {
            XYChart.Series ChartData = new XYChart.Series<>();
            PreparedStatement prepare = connect.prepareStatement(book_per_authSql);
            ResultSet result = prepare.executeQuery();

            while (result.next()) {
                String authorName = result.getString(1);
                int numBooks = result.getInt(2);
                ChartData.getData().add(new XYChart.Data<>(authorName, numBooks));
            }

            livres_par_auteur_bar.getData().add(ChartData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reservation_per_genre() {

        String sql = "SELECT b.genre, COUNT(r.id_res) AS num_reservations "
                + "FROM reservation r INNER JOIN livre b "
                + "ON r.id_livre = b.id_livre GROUP BY b.genre; ";

        connect = database.connectDb();

        try {
            XYChart.Series chart = new XYChart.Series<>();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data<>(result.getString(1), result.getInt(2)));
            }

            reservation_per_genre_linechart.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void book_per_genre() {
        String sql = "SELECT genre, COUNT(id_livre) AS num_livre FROM livre GROUP BY genre";

        connect = database.connectDb();

        try {
            PreparedStatement prepare = connect.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();

            /*
            ObservableList<PieChart.Data> pieChartData = observableArrayList(
                    new PieChart.Data("Roman", 13),
                    new PieChart.Data("Fantaisie", 25),
                    new PieChart.Data("Mystère", 10),
                    new PieChart.Data("Policier", 43),
                    new PieChart.Data("Thriller", 25),
                    new PieChart.Data("Horreur", 22),
                    new PieChart.Data("Romance", 12),
                    new PieChart.Data("Historique", 82),
                    new PieChart.Data("Jeunesse", 22));
            book_per_genre_piechart.setData(pieChartData);
             */
            result = prepare.executeQuery();

            while (result.next()) {
                String genre = result.getString("genre");
                int numBooks = result.getInt("num_livre");
                PieChart.Data data = new PieChart.Data(genre, numBooks);
                book_per_genre_piechart.getData().add(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void prop_per_book() {
        String book_per_authSql = "SELECT a.nom AS subscriber_name, COUNT(p.id_prop) AS num_propositions "
                + "FROM proposition p INNER JOIN abonne a "
                + "ON p.id_abonne = a.id_abonne "
                + "GROUP BY p.id_abonne, a.nom";

        Connection connect = database.connectDb();
        try {
            XYChart.Series ChartData = new XYChart.Series<>();
            PreparedStatement prepare = connect.prepareStatement(book_per_authSql);
            ResultSet result = prepare.executeQuery();

            while (result.next()) {
                String authorName = result.getString(1);
                int numBooks = result.getInt(2);
                ChartData.getData().add(new XYChart.Data<>(authorName, numBooks));
            }

            prop_per_book_bar.getData().add(ChartData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //---------------------------------------------------------------------
    public void most_actif_manager() {

        String sql = "SELECT m.nom AS manager_name, COUNT(h.type_operation) AS num_connections "
                + "FROM historique h INNER JOIN manager m "
                + "ON h.id_manager = m.id_manager "
                + "WHERE h.type_operation = 'Connexion' "
                + "GROUP BY m.nom "
                + "ORDER BY num_connections ";

        connect = database.connectDb();

        try {
            XYChart.Series chart = new XYChart.Series<>();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data<>(result.getString(1), result.getInt(2)));
            }

            book_value_bar.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void book_value_per_genre() {

        String sql = "SELECT genre, SUM(prix) AS total_value FROM livre GROUP BY genre;  ";

        connect = database.connectDb();

        try {
            XYChart.Series chart = new XYChart.Series<>();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data<>(result.getString(1), result.getInt(2)));
            }

            actif_managers_linechart.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //---------------------------------------------------------------------

    public ObservableList<HistoryData> addHistoryListData() {
        ObservableList<HistoryData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM historique";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            HistoryData HistoryD;
            while (result.next()) {
                HistoryD = new HistoryData(
                        result.getInt("id_historique"),
                        result.getInt("id_manager"),
                        result.getString("type_operation"),
                        result.getString("desc_operation"),
                        result.getDate("date")
                );
                listData.add(HistoryD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listData;
    }
    private ObservableList<HistoryData> addHistoryList;

    public void HistoryShowListData() {
        addHistoryList = addHistoryListData();

        History_Col_ID.setCellValueFactory(new PropertyValueFactory<>("id_history"));
        History_Col_id_manager.setCellValueFactory(new PropertyValueFactory<>("id_manager"));
        History_Col_operation.setCellValueFactory(new PropertyValueFactory<>("operation_type"));
        History_Col_description.setCellValueFactory(new PropertyValueFactory<>("operation"));
        History_Col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        History_tableview.setItems(addHistoryList);
    }

    private void searchHistory() {
        FilteredList<HistoryData> filteredData = new FilteredList<>(addHistoryList, p -> true);
    
        cherche_manager_text_field.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(historyData -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
    
                String lowerCaseFilter = newValue.toLowerCase();
    
                if (String.valueOf(historyData.getId_manager()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (historyData.getOperation_type().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (historyData.getOperation().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });
    
        SortedList<HistoryData> sortedData = new SortedList<>(filteredData);
    
        sortedData.comparatorProperty().bind(History_tableview.comparatorProperty());
    
        History_tableview.setItems(sortedData);
    }
    
        
    //---------------------------------------------------------------------
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Timenow();
        TotalManagers();
        addmanagerShowListData();
        prop_per_book();
        book_per_auth();
        reservation_per_genre();
        book_per_genre();
        most_actif_manager();
        book_value_per_genre();
        searchManager();
        HistoryShowListData();
        searchHistory();
    }

}
