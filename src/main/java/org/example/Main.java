package org.example;
import java.sql.*;
import java.util.List;

public class Main {
    public static void   main (String [] args) {
       afficherEleves();
       new EleveDao().ajouterEleve(new Eleve("Diagne","Cheikh"));
       afficherEleves();

    }

    private static void afficherEleves() {
        List<Eleve> eleves = new EleveDao().getEleves();
        eleves.stream().forEach(eleve -> System.out.println(eleve.toString()));

    }
}