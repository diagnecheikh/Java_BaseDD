package org.example;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EleveDao {

    public List<Eleve> getEleves(){
        List<Eleve> eleves = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/diagne37u_Java", "diagne37u_appli", "32216625");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from televe");
            while(rs.next()){
                eleves.add(new Eleve(rs.getString(1), rs.getString(2)));
            }
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return eleves;
    }

    public void ajouterEleve(Eleve eleve) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/diagne37u_Java", "diagne37u_appli", "32216625");

            PreparedStatement statement = con.prepareStatement("INSERT INTO televe(nom, prenom) VALUES (?, ?);");
            statement.setString(1, eleve.getNom());
            statement.setString(2, eleve.getPrenom());

            statement.executeUpdate();

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void supprimerEleve(Eleve eleve) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/diagne37u_Java", "diagne37u_appli", "32216625");

            PreparedStatement statement = con.prepareStatement("DELETE FROM televe WHERE nom = ? AND prenom = ?;");
            statement.setString(1, "cartonalo");
            statement.setString(2, "fabio");
            statement.executeUpdate();

            con.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void modifierEleve(Eleve eleve) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/diagne37u_Java", "diagne37u_appli", "32216625");

            PreparedStatement statement = con.prepareStatement("UPDATE televe SET nom = ?, prenom = ? WHERE nom = ? AND prenom = ?;");
            statement.setString(1, "diagne");
            statement.setString(2, "mamadou");
            statement.setString(3, "cartonalo");
            statement.setString(4, "fabio");
            statement.executeUpdate();

            con.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
