package com.exemple.com.DPT;

public class BibliothequeService {
    private Bibliotheque bibliotheque;

    public BibliothequeService(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

    public String ajouterLivreEtRetournerMessage(Livre livre) {
        Livre existing = bibliotheque.chercherLivre(livre.getIsbn());
        if (existing == null) {
            bibliotheque.ajouterLivre(livre);
            return "Livre ajouté avec succès";
        } else {
            return "Livre déjà existant";
        }
    }

    public String supprimerLivreEtRetournerMessage(String isbn) {
        Livre existing = bibliotheque.chercherLivre(isbn);
        if (existing != null) {
            bibliotheque.supprimerLivre(isbn);
            return "Livre supprimé";
        } else {
            return "Livre introuvable";
        }
    }
}
