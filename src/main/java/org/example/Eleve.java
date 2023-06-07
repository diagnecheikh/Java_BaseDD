package org.example;
import java.sql.*;
public class Eleve {
    private String nom;
    private String prenom;
    private int id;

    public Eleve (String nom, String prenom, int id){
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
    }

    public Eleve(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getId() {
        return id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setId(int id) {
        this.id = id;
    }
}

