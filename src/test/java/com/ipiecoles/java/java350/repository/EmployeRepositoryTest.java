package com.ipiecoles.java.java350.repository;


import com.ipiecoles.java.java350.model.Employe;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class EmployeRepositoryTest {

    @Autowired
    private EmployeRepository employeRepository;

    @Test

    public void testFindLastMatriculeEmpty () {
        // Given
        // Il est vide car je vérifie une base vide

        // When
        String lastMatricule = employeRepository.findLastMatricule();

        // Then
        Assertions.assertThat(lastMatricule).isNull();
    }

    // Trois choses à tester


}
