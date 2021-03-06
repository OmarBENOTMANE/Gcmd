package org.backend.gcmd.service;


import org.backend.gcmd.dto.PrestationDTO;
import org.backend.gcmd.exceptions.technical.IllegalNullParamException;
import org.backend.gcmd.exceptions.technical.ObjectNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "classpath:/fixtures/clear.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:/fixtures/prestation.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class PrestationServiceTest {


    @Autowired
    PrestationService prestationService;

    @Test
    void serviceInjection() {
        assertNotNull(prestationService);
    }

    //findById
    @Test
    void findById_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    prestationService.findById(null);
                });
    }

    @Test
    void findById_OK_ID_Found() {
        PrestationDTO pdto = prestationService.findById(1L);
        assertNotNull(pdto);
        assertEquals(1L, pdto.getId());
    }

    @Test
    void findById_KO_ID_Not_Found() {
        assertThrows(ObjectNotFoundException.class,
                () -> {
                    prestationService.findById(999999L);
                });
    }

    //save
    @Test
    void save_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    prestationService.save(null);
                });
    }

    @Test
    void save_OK() {
        //given
        PrestationDTO pdto = PrestationDTO.builder()
                .id(null).designation("des").soustypeprestationId(1L).typePrestation("type").typeTarif("tarif")
                .build();
        //when
        PrestationDTO result = prestationService.save(pdto);
        //then
        assertNotNull(result.getId());
    }

    //update
    @Test
    void update_Ok_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    prestationService.update(null);
                });
    }

    @Test
    void update_KO_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    prestationService.update(null);
                });
    }

    @Test
    void update_Ok() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    prestationService.update(null);
                });
        //given
        PrestationDTO pdto = PrestationDTO.builder()
                .id(1L).designation("des").soustypeprestationId(1L).typePrestation("type modif").typeTarif("tarif")
                .build();
        //when
        PrestationDTO result = prestationService.update(pdto);
        //then
        assertNotNull(result.getId());
    }
    
}
