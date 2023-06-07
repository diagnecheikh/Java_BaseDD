package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteDao {
    public List<Note> getNotesByEleveId(int eleveId) {
        List<Note> notes = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/diagne37u_Java", "diagne37u_appli", "32216625");

            PreparedStatement statement = con.prepareStatement("SELECT * FROM notes WHERE eleve_id = ?");
            statement.setInt(1, eleveId);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String matiereStr = rs.getString("matiere");
                Matiere matiere = Matiere.valueOf(matiereStr);
                double valeur = rs.getDouble("valeur");
                int eleveIdFromDb = rs.getInt("eleve_id");
                Note note = new Note(id, matiere, valeur, eleveIdFromDb);
                notes.add(note);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return notes;
    }

    public void ajouterNoteEleve(Note note) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/diagne37u_Java", "diagne37u_appli", "32216625");

            PreparedStatement statement = con.prepareStatement("INSERT INTO notes(matiere, valeur, eleve_id) VALUES (?, ?, ?)");
            statement.setString(1, note.getMatiere().toString());
            statement.setDouble(2, note.getValeur());
            statement.setInt(3, note.getEleveId());

            statement.executeUpdate();

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void afficherNoteEleveId(int eleveId) {
        List<Note> notes = getNotesByEleveId(eleveId);
        notes.stream().forEach(note -> System.out.println(note.toString()));
    }


}

