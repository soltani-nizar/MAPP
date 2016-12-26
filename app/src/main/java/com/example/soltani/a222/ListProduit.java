package com.example.soltani.a222;


public class ListProduit {
    String prix;
    String description;
    String qte;

    String libelle;

    public ListProduit(String libelle,String prix,String qte, String description) {
        this.prix = prix;
        this.description = description;
        this.qte = qte;

        this.libelle = libelle;
    }
}
