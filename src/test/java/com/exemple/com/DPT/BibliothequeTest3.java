package com.exemple.com.DPT;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

@Tag("bibliotheque")
class BibliothequeTest3 {

    private Bibliotheque bibliotheque;
    private Livre livre1, livre2;

    @BeforeEach
    void setUp() {
        bibliotheque = new Bibliotheque();
        livre1 = new Livre("1984", "George Orwell", "123456");
        livre2 = new Livre("Animal Farm", "George Orwell", "654321");
    }

    @Nested
    @Tag("ajout")
    class AjoutTests {
        @Test
        void testAjouterUnLivre() {
            bibliotheque.ajouterLivre(livre1);
            assertEquals(1, bibliotheque.listerLivres().size());
        }

        @Test
        void testAjouterLivreDuplique() {
            bibliotheque.ajouterLivre(livre1);
            bibliotheque.ajouterLivre(livre1); // même livre
            assertEquals(1, bibliotheque.listerLivres().size());
        }

        @RepeatedTest(3)
        void testAjouterRepetition() {
            bibliotheque.ajouterLivre(livre1);
            assertNotNull(bibliotheque.chercherLivre("123456"));
            // On ne veut toujours qu’un seul livre même après plusieurs tentatives
            bibliotheque.ajouterLivre(livre1);
            assertEquals(1, bibliotheque.listerLivres().size());
        }
    }

    @Nested
    @Tag("recherche")
    class RechercheTests {
        @Test
        void testChercherLivreExistant() {
            bibliotheque.ajouterLivre(livre1);
            Livre livreTrouve = bibliotheque.chercherLivre("123456");
            assertNotNull(livreTrouve);
            assertEquals("1984", livreTrouve.getTitre());
        }

        @Test
        void testChercherLivreInexistant() {
            Livre livreTrouve = bibliotheque.chercherLivre("000000");
            assertNull(livreTrouve);
        }
    }

    @Nested
    @Tag("suppression")
    class SuppressionTests {
    	
        @Test
        void testSupprimerLivre() {
            bibliotheque.ajouterLivre(livre1);
            bibliotheque.supprimerLivre("123456");
            assertTrue(bibliotheque.listerLivres().isEmpty());
        }
    }
}
