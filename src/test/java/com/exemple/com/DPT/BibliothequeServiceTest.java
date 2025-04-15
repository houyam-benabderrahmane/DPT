package com.exemple.com.DPT;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BibliothequeServiceTest {

    @Mock
    Bibliotheque bibliothequeMock;

    @InjectMocks
    BibliothequeService service;

    @Test
    void testAjouterLivre_Succes() {
        Livre livre = new Livre("1984", "Orwell", "123");
        when(bibliothequeMock.chercherLivre("123")).thenReturn(null);

        String result = service.ajouterLivreEtRetournerMessage(livre);

        assertEquals("Livre ajouté avec succès", result);
        verify(bibliothequeMock).ajouterLivre(livre);
    }

    @Test
    
    void testAjouterLivre_DejaExistant() {
        Livre livre = new Livre("1984", "Orwell", "123");
        when(bibliothequeMock.chercherLivre("123")).thenReturn(livre);

        String result = service.ajouterLivreEtRetournerMessage(livre);

        assertEquals("Livre déjà existant", result);
        verify(bibliothequeMock, never()).ajouterLivre(any());
    }

    @Test
    void testSupprimerLivre_Succes() {
        Livre livre = new Livre("1984", "Orwell", "123");
        when(bibliothequeMock.chercherLivre("123")).thenReturn(livre);

        String result = service.supprimerLivreEtRetournerMessage("123");

        assertEquals("Livre supprimé", result);
        verify(bibliothequeMock).supprimerLivre("123");
    }

    @Test
    void testSupprimerLivre_Inexistant() {
        when(bibliothequeMock.chercherLivre("123")).thenReturn(null);

        String result = service.supprimerLivreEtRetournerMessage("123");

        assertEquals("Livre introuvable", result);
        verify(bibliothequeMock, never()).supprimerLivre(any());
    }
}
