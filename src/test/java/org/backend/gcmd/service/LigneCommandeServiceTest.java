package org.backend.gcmd.service;


import org.backend.gcmd.dto.LigneCommandeDTO;
import org.backend.gcmd.enums.SenstraficEnum;
import org.backend.gcmd.exceptions.technical.IllegalNullParamException;
import org.backend.gcmd.exceptions.technical.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "classpath:/fixtures/clear.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:/fixtures/ligneCommande.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class LigneCommandeServiceTest {


    @Autowired
    LigneCommandeService ligneCommandeService;

    @Test
    void serviceInjection() {
        assertNotNull(ligneCommandeService);
    }

    //findById
    @Test
    void findById_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    ligneCommandeService.findById(null);
                });
    }

    @Test
    void findById_OK_ID_Found() {
        LigneCommandeDTO lcdto = ligneCommandeService.findById(1L);
        assertNotNull(lcdto);
        assertEquals(1L, lcdto.getId());
    }

    @Test
    void findById_KO_ID_Not_Found() {
        assertThrows(ObjectNotFoundException.class,
                () -> {
                    ligneCommandeService.findById(999999L);
                });
    }

    //save
    @Test
    void save_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    ligneCommandeService.save(null);
                });
    }

    @Test
    void save_OK() {
        //given
        LigneCommandeDTO lcdto = LigneCommandeDTO.builder()
                .id(1L).commandeId(1L).date(LocalDate.ofEpochDay(2022 - 04 - 27)).heure(LocalTime.parse("09:00:00")).nombre(2).prestationId(1L).produit("produit").sensTrafic(SenstraficEnum.valueOf("EXPORT")).tarifUnifie(true).tcConv(false).tcSuppl("tc sup").tonnageMinimum(33).tonnageReel(44)
                .build();
        //when
        LigneCommandeDTO result = ligneCommandeService.save(lcdto);
        //then
        assertNotNull(result.getId());
    }

    //update
    @Test
    void update_Ok_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    ligneCommandeService.update(null);
                });
    }

    @Test
    void update_KO_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    ligneCommandeService.update(null);
                });
    }

    @Test
    void update_Ok() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    ligneCommandeService.update(null);
                });
        //given
        LigneCommandeDTO lcdto = LigneCommandeDTO.builder()
                .id(1L).commandeId(1L).date(LocalDate.ofEpochDay(2022 - 04 - 27)).heure(LocalTime.parse("09:00:00")).nombre(2).prestationId(1L).produit("produit modif").sensTrafic(SenstraficEnum.valueOf("EXPORT")).tarifUnifie(true).tcConv(false).tcSuppl("tc sup").tonnageMinimum(33).tonnageReel(44)
                .build();
        //when
        LigneCommandeDTO result = ligneCommandeService.update(lcdto);
        //then
        assertNotNull(result.getId());
    }

    //delete
    @Test
    void delete_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    ligneCommandeService.delete(null);
                });
    }

    @Test
    void delete_ok() {
        ligneCommandeService.delete(1L);
        //then
        Exception exception =
                Assertions.assertThrows(ObjectNotFoundException.class, () -> ligneCommandeService.findById(1L),
                        "Expected findById() to throw ObjectNotFoundException, but it didn't");
        String expectedMessage = "LigneCommandeDTO not found";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    // findAll
    @Test
    void findAll() {
        Page<LigneCommandeDTO> page = ligneCommandeService.findAll(PageRequest.of(0, 10));
        assertNotNull(page);
        assertEquals(1, page.getContent().size());
        LigneCommandeDTO lcdto = page.getContent().get(0);
        assertEquals(1L, lcdto.getId());
    }

}
