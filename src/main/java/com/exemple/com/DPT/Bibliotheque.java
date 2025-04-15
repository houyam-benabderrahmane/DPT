package com.exemple.com.DPT;

import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {
    private List<Livre> livres;

    public Bibliotheque() {
        this.livres = new ArrayList<>();
    }

    // Ajouter un livre à la bibliothèque
    public void ajouterLivre(Livre livre) {
        if (!livres.contains(livre)) { // Évite d'ajouter des doublons
            livres.add(livre);
            System.out.println("Livre ajouté : " + livre.getTitre());
        } else {
            System.out.println("Ce livre existe déjà.");
        }
    }

    // Supprimer un livre par ISBN
    public void supprimerLivre(String isbn) {
        livres.removeIf(livre -> livre.getIsbn().equals(isbn));
        System.out.println("Livre avec ISBN " + isbn + " supprimé.");
    }

    // Chercher un livre par ISBN
    public Livre chercherLivre(String isbn) {
        for (Livre livre : livres) {
            if (livre.getIsbn().equals(isbn)) {
                return livre;
            }
        }
        return null; // Livre non trouvé
    }

    // Lister tous les livres
    public List<Livre> listerLivres() {
        return new ArrayList<>(livres); // Retourne une copie de la liste
    }
}
