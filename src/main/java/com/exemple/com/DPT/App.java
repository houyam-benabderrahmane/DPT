package com.exemple.com.DPT;

public class App {
    public static void main(String[] args) {
        Bibliotheque bibliotheque = new Bibliotheque();

        Livre livre1 = new Livre("1984", "George Orwell", "123456");
        Livre livre2 = new Livre("Animal Farm", "George Orwell", "654321");

        // Ajouter des livres
        bibliotheque.ajouterLivre(livre1);
        bibliotheque.ajouterLivre(livre2);

        // Afficher tous les livres
        System.out.println(" Liste des livres :");
        for (Livre livre : bibliotheque.listerLivres()) {
            System.out.println(livre);
        }

        // Recherche d'un livre
        Livre livreCherche = bibliotheque.chercherLivre("123456");
        System.out.println("\n Livre trouve : " + (livreCherche != null ? livreCherche.getTitre() : "Aucun"));

        // Suppression d'un livre
        bibliotheque.supprimerLivre("123456");

        // Afficher la liste après suppression
        System.out.println("\n Liste apres suppression :");
        for (Livre livre : bibliotheque.listerLivres()) {
            System.out.println(livre);
        }
    }
}
