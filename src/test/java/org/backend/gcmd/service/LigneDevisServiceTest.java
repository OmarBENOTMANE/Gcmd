package org.backend.gcmd.service;


import org.backend.gcmd.dto.LigneDevisDTO;
import org.backend.gcmd.exceptions.technical.IllegalNullParamException;
import org.backend.gcmd.exceptions.technical.ObjectNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "classpath:/fixtures/clear.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:/fixtures/ligneDevis.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class LigneDevisServiceTest {


    @Autowired
    LigneDevisService ligneDevisService;

    @Test
    void serviceInjection() {
        assertNotNull(ligneDevisService);
    }

    //findById
    @Test
    void findById_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    ligneDevisService.findById(null);
                });
    }

    @Test
    void findById_OK_ID_Found() {
        LigneDevisDTO lddto = ligneDevisService.findById(1L);
        assertNotNull(lddto);
        assertEquals(1L, lddto.getId());
    }

    @Test
    void findById_KO_ID_Not_Found() {
        assertThrows(ObjectNotFoundException.class,
                () -> {
                    ligneDevisService.findById(999999L);
                });
    }

    //save
    @Test
    void save_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    ligneDevisService.save(null);
                });
    }

    @Test
    void save_OK() {
        //given
        LigneDevisDTO lddto = LigneDevisDTO.builder()
                .id(null).designation("desi").devisId(1L).nombreUnite(5.4).prestationId(1L).quantite(2).total(3.4)
                .build();
        //when
        LigneDevisDTO result = ligneDevisService.save(lddto);
        //then
        assertNotNull(result.getId());
    }

    //update
    @Test
    void update_Ok_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    ligneDevisService.update(null);
                });
    }

    @Test
    void update_KO_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    ligneDevisService.update(null);
                });
    }

    @Test
    void update_Ok() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    ligneDevisService.update(null);
                });
        //given
        LigneDevisDTO lddto = LigneDevisDTO.builder()
                .id(1L).designation("desi").devisId(1L).nombreUnite(5.4).prestationId(1L).quantite(2).total(3.4)
                .build();
        //when
        LigneDevisDTO result = ligneDevisService.update(lddto);
        //then
        assertNotNull(result.getId());
    }



}
