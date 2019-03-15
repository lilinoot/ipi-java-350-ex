package com.ipiecoles.java.java350.repository;


import com.ipiecoles.java.java350.model.Employe;
import com.ipiecoles.java.java350.model.Entreprise;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest

public class EmployeRepositoryTest {

    @Autowired
    private EmployeRepository employeRepository;

    @BeforeEach
    @AfterEach

    public void setup() {
        employeRepository.deleteAll();
    }

    @Test
    public void testFindLastMatriculeEmpty () {
        // Given ne contient aucune donnée car je vérifie une base vide

        // When
        String lastMatricule = employeRepository.findLastMatricule();

        // Then
        Assertions.assertThat(lastMatricule).isNull();
    }

    public void testFindLastMatriculeSingle () {
        // Given
        employeRepository.save(new Employe("Harris", "Xander", "T88888", LocalDate.now(), Entreprise.SALAIRE_BASE, 1, 1.0));

        // When
        String lastMatricule = employeRepository.findLastMatricule();

        // Then
        Assertions.assertThat(lastMatricule).isEqualTo("88888");

    }

    public void testFindLastMatriculeMultiple () {
        // Given
        employeRepository.save(new Employe("Harris", "Xander", "T12345", LocalDate.now(), Entreprise.SALAIRE_BASE, 1, 1.0));
        employeRepository.save(new Employe("Harris", "Willow", "M40325", LocalDate.now(), Entreprise.SALAIRE_BASE, 1, 1.0));
        employeRepository.save(new Employe("Harris", "Giles", "C06432", LocalDate.now(), Entreprise.SALAIRE_BASE, 1, 1.0));

        // When
        String lastMatricule = employeRepository.findLastMatricule();

        // Then
        Assertions.assertThat(lastMatricule).isEqualTo("88888");

    }

}
