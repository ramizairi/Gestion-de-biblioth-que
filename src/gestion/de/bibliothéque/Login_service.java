
package gestion.de.bibliothéque;

import java.sql.*;
import org.mindrot.jbcrypt.BCrypt;

public class Login_service implements Login_Interface {

    @Override
   public int login(String username, String password) {
    int ok = 0;
    try (Connection connection = database.connectDb();
         PreparedStatement statement1 = connection.prepareStatement("SELECT mot_de_passe FROM abonne WHERE adresse_mail = ?");
         PreparedStatement statement2 = connection.prepareStatement("SELECT mot_de_passe FROM manager WHERE adresse_mail = ?");
         PreparedStatement statement3 = connection.prepareStatement("SELECT mot_de_passe FROM super_utilisateur WHERE adresse_mail = ?")) {

        // Vérifier si l'utilisateur est un abonné
        statement1.setString(1, username);
        ResultSet resultSet1 = statement1.executeQuery();
        if (resultSet1.next()) {
            String hashedPassword = resultSet1.getString("mot_de_passe");
            if (BCrypt.checkpw(password, hashedPassword)) {
                ok = 1;
            }
        } else {
            // Vérifier si l'utilisateur est un manager
            statement2.setString(1, username);
            ResultSet resultSet2 = statement2.executeQuery();
            if (resultSet2.next()) {
                String hashedPassword = resultSet2.getString("mot_de_passe");
                if (BCrypt.checkpw(password, hashedPassword)) {
                    ok = 2;
                }
            } else {
                // Vérifier si l'utilisateur est un super utilisateur
                statement3.setString(1, username);
                ResultSet resultSet3 = statement3.executeQuery();
                if (resultSet3.next()) {
                    String hashedPassword = resultSet3.getString("mot_de_passe");
                    if (BCrypt.checkpw(password, hashedPassword)) {
                        ok = 3;
                    }
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return ok;
}

    
}
