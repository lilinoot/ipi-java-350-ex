package com.ipiecoles.java.java350.model;

import com.ipiecoles.java.java350.repository.EmployeRepository;
import com.ipiecoles.java.java350.service.EmployeService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


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
        Assertions.assertThat(nbAnnee).isEqualTo(0); // Pour quelqu'un qui est embauché maintenant, on doit donc avoir 0 année d'ancienneté
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

    @ParameterizedTest
    @CsvSource({
           "1, 'M12345', 0, 1.0, 1700.0",
            "1, 'M12345', 1, 1.0, 1800.0",
            "1, 'T12345', 2, 1.0, 1200.0", // Cas d'un employé non manager en performance de base
            "1, 'T12345', 2, 0.5, 600.0",
            "2, 'T12345', 0, 1.0, 2300.0", // Cas d'un manager avec une performance différente
            "2, 'T12345', 3, 1.0, 2600.0"
    })

    public void getPrimeAnnuelle (Integer performance, String matricule, Long nbYearsAnciennete,
                                        Double tempsPartiel, Double primeAnnuelle) {
        // Given
        Employe e = new Employe();
        e.setPerformance(performance);
        e.setMatricule(matricule);
        e.setTempsPartiel(tempsPartiel);
        e.setDateEmbauche(LocalDate.now().minusYears(nbYearsAnciennete));
        // When
        Double prime = e.getPrimeAnnuelle();

        // Then
        Assertions.assertThat(prime).isEqualTo(primeAnnuelle);
    }

}
