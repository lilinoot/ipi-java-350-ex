package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;

public class EmployeTest {
    @Test

    public void testGetNombreAnneeAncienneteNow() {
        // Given
        Employe employe = new Employe(); // J'initialise un employé
        LocalDate dateEmbauche = LocalDate.now(); // Je déclare la date d'embauche à maintenant
        employe.setDateEmbauche(dateEmbauche); // Je dois stocker cette date dans employé

        // When
        Integer nbAnnee = employe.getNombreAnneeAnciennete(); // Je récupère le nombre d'années dans une variable avec la méthode. Cette méthode repose sur une instance donc on doit instancier employé dans les données d'entrée

        // Then
        Assertions.assertThat(nbAnnee).isEqualTo(0); // Quelqu'un qui est embauché maintenant, on doit donc avoir 0
    }

    public void testGetNombreAnneeAncienneteIsNull() {
        // Given
        Employe e = new Employe();
        e.setDateEmbauche(null);

        // When
        Integer nbAnnee = e.getNombreAnneeAnciennete();

        // Then
        Assertions.assertThat(nbAnnee).isEqualTo(0);
    }

    public void testGetNombreAnneeAncienneteNMoins2() {
        // Given
        Employe e = new Employe();
        e.setDateEmbauche(LocalDate.now().minusYears(2));

        // When
        Integer nbAnnee = e.getNombreAnneeAnciennete();

        // Then
        Assertions.assertThat(nbAnnee).isEqualTo(2);
    }

    public void testGetNombreAnneeAncienneteNPlus2() {
        // Given
        Employe e = new Employe();
        e.setDateEmbauche(LocalDate.now().plusYears(2));

        // When
        Integer nbAnnee = e.getNombreAnneeAnciennete();

        // Then
        Assertions.assertThat(nbAnnee).isEqualTo(0);
    }
}
