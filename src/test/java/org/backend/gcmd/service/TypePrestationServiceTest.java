package org.backend.gcmd.service;


import org.backend.gcmd.dto.TypePrestationDTO;
import org.backend.gcmd.exceptions.technical.IllegalNullParamException;
import org.backend.gcmd.exceptions.technical.ObjectNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "classpath:/fixtures/clear.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:/fixtures/typePrestation.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class TypePrestationServiceTest {


    @Autowired
    TypePrestationService typePrestationService;

    @Test
    void serviceInjection() {
        assertNotNull(typePrestationService);
    }

    //findById
    @Test
    void findById_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    typePrestationService.findById(null);
                });
    }

    @Test
    void findById_OK_ID_Found() {
        TypePrestationDTO tdto = typePrestationService.findById(1L);
        assertNotNull(tdto);
        assertEquals(1L, tdto.getId());
    }

    @Test
    void findById_KO_ID_Not_Found() {
        assertThrows(ObjectNotFoundException.class,
                () -> {
                    typePrestationService.findById(999999L);
                });
    }

    //save
    @Test
    void save_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    typePrestationService.save(null);
                });
    }

    @Test
    void save_OK() {
        //given
        TypePrestationDTO tpdto = TypePrestationDTO.builder()
                .id(null).name("prestation")
                .build();
        //when
        TypePrestationDTO result = typePrestationService.save(tpdto);
        //then
        assertNotNull(result.getId());
    }

    //update
    @Test
    void update_Ok_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    typePrestationService.update(null);
                });
    }

    @Test
    void update_KO_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    typePrestationService.update(null);
                });
    }

    @Test
    void update_Ok() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    typePrestationService.update(null);
                });
        //given
        TypePrestationDTO tpdto = TypePrestationDTO.builder()
                .id(1L).name("prestation modif")
                .build();
        //when
        TypePrestationDTO result = typePrestationService.update(tpdto);
        //then
        assertNotNull(result.getId());
    }

}
