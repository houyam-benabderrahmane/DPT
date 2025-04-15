package com.exemple.com.DPT;

import java.util.Objects;

public class Livre {
	private String titre;
	private String auteur;
	private String isbn;
	public Livre(String titre,String auteur,String isbn) {
		this.titre=titre;
		this.auteur=auteur;
		this.isbn=isbn;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
  
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Same reference
        if (obj == null || getClass() != obj.getClass()) return false; // Check type
        Livre livre = (Livre) obj;
        return this.isbn.equals(livre.isbn); // Compare content, not reference
    }
    @Override
    public int hashCode() {
        return Objects.hash(isbn); // it gives the same hash code for equals
    }
    @Override
    public String toString() {
        return "Livre{" +
               "titre='" + titre + '\'' +
               ", auteur='" + auteur + '\'' +
               ", isbn='" + isbn + '\'' +
               '}';
    }



}
