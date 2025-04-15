package com.exemple.com.DPT;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LivreTest {

	  @Test
	    void testCreationLivre() {
	        Livre livre = new Livre("1984", "George Orwell", "123456");
	        assertNotNull(livre); // Vérifie que l'objet est bien créé
	        assertEquals("1984", livre.getTitre());
	        assertEquals("George Orwell", livre.getAuteur());
	        assertEquals("123456", livre.getIsbn());
	    }

	    @Test
	    void testEgaliteLivresMemeISBN() {
	        Livre livre1 = new Livre("1984", "George Orwell", "123456");
	        Livre livre2 = new Livre("Animal Farm", "George Orwell", "123456"); // Même ISBN, titre différent

	        assertEquals(livre1, livre2); // Devrait être vrai car ISBN identique
	    }

}
