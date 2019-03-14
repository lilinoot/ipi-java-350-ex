package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;

public class EmployeTest {
    @Test

    public void testGetNombreAnneeAncienneteNow () {
        // Given
        Employe employe = new Employe(); // J'initialise un employé
        LocalDate dateEmbauche = LocalDate.now(); // Je déclare la date d'embauche à maintenant
        employe.setDateEmbauche(dateEmbauche); // Je dois stocker cette date dans employé

        // When
        Integer nbAnnee = employe.getNombreAnneeAnciennete(); // Je récupère le nombre d'années dans une variable avec la méthode. Cette méthode repose sur une instance donc on doit instancier employé dans les données d'entrée

        // Then
        Assertions.assertThat(nbAnnee).isEqualTo(0); // Je vérifie que cette date soit égale à la valeur attendue
    }
}
