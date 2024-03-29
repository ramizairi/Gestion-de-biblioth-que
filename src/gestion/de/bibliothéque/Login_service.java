package gestion.de.bibliothéque;

import java.sql.*;
import org.mindrot.jbcrypt.BCrypt;

public class Login_service implements Login_Interface {

    private int loggedId; 

    @Override
    public int login(String username, String password) {
        int ok = 0;
        try (Connection connection = database.connectDb(); 
                PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM abonne WHERE adresse_mail = ?"); 
                PreparedStatement statement2 = connection.prepareStatement("SELECT * FROM manager WHERE adresse_mail = ?"); 
                PreparedStatement statement3 = connection.prepareStatement("SELECT * FROM super_utilisateur WHERE adresse_mail = ?")) {

            // Vérifier si l'utilisateur est un abonné
            statement1.setString(1, username);
            ResultSet resultSet1 = statement1.executeQuery();
            if (resultSet1.next()) {
                String hashedPassword = resultSet1.getString("mot_de_passe");
                if (BCrypt.checkpw(password, hashedPassword)) {
                    ok = 1;
                    loggedId = resultSet1.getInt("id_abonne"); // Save abonne_id to loggedId
                }
            } else {
                // Vérifier si l'utilisateur est un manager
                statement2.setString(1, username);
                ResultSet resultSet2 = statement2.executeQuery();
                if (resultSet2.next()) {
                    String hashedPassword = resultSet2.getString("mot_de_passe");
                    if (BCrypt.checkpw(password, hashedPassword)) {
                        loggedId = resultSet2.getInt("id_manager"); // Save manager_id to loggedId
                        getData.id = loggedId;
                        getData.fname = resultSet2.getString("nom");
                        getData.lname = resultSet2.getString("prenom");
                        getData.ady = resultSet2.getString("adresse");
                        getData.phone_number = resultSet2.getInt("numero");
                        getData.email = resultSet2.getString("adresse_mail");
                        getData.image = resultSet2.getString("image");

                        System.out.println("Manager logged id is : " + loggedId);
                        return ok = 2;

                    }
                } else {
                    // Vérifier si l'utilisateur est un super utilisateur
                    statement3.setString(1, username);
                    ResultSet resultSet3 = statement3.executeQuery();
                    if (resultSet3.next()) {
                        String hashedPassword = resultSet3.getString("mot_de_passe");
                        if (BCrypt.checkpw(password, hashedPassword)) {
                            loggedId = resultSet3.getInt("id_super"); // Save manager_id to loggedId
                            return ok = 3;

                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ok;
    }

    public int getLoggedId() {
        return loggedId;
    }
}
