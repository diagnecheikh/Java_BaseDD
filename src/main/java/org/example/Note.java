package org.example;

public class Note {
    // id, matiere, valeur, eleveid
    private int id;
    private String matiere;
    private int valeur;
    private int eleveid;

    public Note (int id, String matiere, int valeur, int eleveid){
        this.id = id;
        this.matiere = matiere;
        this.valeur = valeur;
        this.eleveid = eleveid;
    }

    public Note (String matiere, int valeur, int eleveid){
        this.matiere = matiere;
        this.valeur = valeur;
        this.eleveid = eleveid;
    }

    public int getId() {
        return id;
    }

    public String getMatiere() {
        return matiere;
    }

    public int getValeur() {
        return valeur;
    }

    public int getEleveid() {
        return eleveid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public void setEleveid(int eleveid) {
        this.eleveid = eleveid;
    }
     public enum Matiere {
        MATHS,
        FRANCAIS,
        ANGLAIS,
         INFORMATIQUE;
     }

}
