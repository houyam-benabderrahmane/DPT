package com.exemple.com.DPT;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class BibliothequeTest {
    private Bibliotheque bibliotheque;
    private Livre livre1, livre2;

    @BeforeEach
    void setUp() {
        bibliotheque = new Bibliotheque();
        livre1 = new Livre("1984", "George Orwell", "123456");
        livre2 = new Livre("Animal Farm", "George Orwell", "654321");
    }

    @Test
    void testAjouterLivre() {
        bibliotheque.ajouterLivre(livre1);
        assertEquals(1, bibliotheque.listerLivres().size());
    }

    @Test
    void testSupprimerLivre() {
        bibliotheque.ajouterLivre(livre1);
        bibliotheque.supprimerLivre("123456");
        assertTrue(bibliotheque.listerLivres().isEmpty());
    }

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
















//
//
//import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//import java.util.List;
//
//class BibliothequeTest {
//    private Bibliotheque bibliotheque;
//    private Livre livre1, livre2;
//
//    @BeforeEach
//    void setUp() {
//        bibliotheque = new Bibliotheque();
//        livre1 = new Livre("1984", "George Orwell", "123456");
//        livre2 = new Livre("Animal Farm", "George Orwell", "654321");
//    }
//
//    @Nested
//    class AjouterLivreTests {
//        @Test
//        void testAjouterUnLivre() {
//            bibliotheque.ajouterLivre(livre1);
//            assertEquals(1, bibliotheque.listerLivres().size());
//        }
//
//        @Test
//        void testAjouterLivreDuplique() {
//            bibliotheque.ajouterLivre(livre1);
//            bibliotheque.ajouterLivre(livre1); // même livre
//            assertEquals(1, bibliotheque.listerLivres().size());
//        }
//    }
//
//    @Nested
//    class SupprimerLivreTests {
//        @Test
//        void testSupprimerLivre() {
//            bibliotheque.ajouterLivre(livre1);
//            bibliotheque.supprimerLivre("123456");
//            assertTrue(bibliotheque.listerLivres().isEmpty());
//        }
//    }
//
//    @Nested
//    class ChercherLivreTests {
//        @Test
//        void testChercherLivreExistant() {
//            bibliotheque.ajouterLivre(livre1);
//            Livre livreTrouve = bibliotheque.chercherLivre("123456");
//            assertNotNull(livreTrouve);
//            assertEquals("1984", livreTrouve.getTitre());
//        }
//
//        @Test
//        void testChercherLivreInexistant() {
//            Livre livreTrouve = bibliotheque.chercherLivre("000000");
//            assertNull(livreTrouve);
//        }
//    }
//}
//
