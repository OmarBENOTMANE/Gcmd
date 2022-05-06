package org.backend.gcmd.service;


import org.backend.gcmd.dto.SousTypePrestationDTO;
import org.backend.gcmd.exceptions.technical.IllegalNullParamException;
import org.backend.gcmd.exceptions.technical.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "classpath:/fixtures/clear.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:/fixtures/sousTypePrestation.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class SousTypePrestationTest {


    @Autowired
    SousTypePrestationService sousTypePrestationService;

    @Test
    void serviceInjection() {
        assertNotNull(sousTypePrestationService);
    }

    //findById
    @Test
    void findById_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    sousTypePrestationService.findById(null);
                });
    }

    @Test
    void findById_OK_ID_Found() {
        SousTypePrestationDTO tpdto = sousTypePrestationService.findById(1L);
        assertNotNull(tpdto);
        assertEquals(1L, tpdto.getId());
    }

    @Test
    void findById_KO_ID_Not_Found() {
        assertThrows(ObjectNotFoundException.class,
                () -> {
                    sousTypePrestationService.findById(999999L);
                });
    }

    //save
    @Test
    void save_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    sousTypePrestationService.save(null);
                });
    }

    @Test
    void save_OK() {
        //given
        SousTypePrestationDTO udto = SousTypePrestationDTO.builder()
                .id(1L).name("soustype").typeprestationId(1L)
                .build();
        //when
        SousTypePrestationDTO result = sousTypePrestationService.save(udto);
        //then
        assertNotNull(result.getId());
    }

    //update
    @Test
    void update_Ok_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    sousTypePrestationService.update(null);
                });
    }

    @Test
    void update_KO_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    sousTypePrestationService.update(null);
                });
    }

    @Test
    void update_Ok() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    sousTypePrestationService.update(null);
                });
        //given
        SousTypePrestationDTO stdto = SousTypePrestationDTO.builder()
                .id(1L).name("soustype").typeprestationId(1L)
                .build();
        //when
        SousTypePrestationDTO result = sousTypePrestationService.update(stdto);
        //then
        assertNotNull(result.getId());
    }

    //delete
//    @Test
//    void delete_KO_nullId() {
//        assertThrows(IllegalNullParamException.class,
//                () -> {
//                    sousTypePrestationService.delete(null);
//                });
//    }
//
//    @Test
//    void delete_ok() {
//        sousTypePrestationService.delete(1L);
//        //then
//        Exception exception =
//                Assertions.assertThrows(ObjectNotFoundException.class, () -> sousTypePrestationService.findById(1L),
//                        "Expected findById() to throw ObjectNotFoundException, but it didn't");
//        String expectedMessage = "SousTypePrestationDTO not found";
//        assertTrue(exception.getMessage().contains(expectedMessage));
//    }

    // findAll
    @Test
    void findAll() {
        Page<SousTypePrestationDTO> page = sousTypePrestationService.findAll(PageRequest.of(0, 10));
        assertNotNull(page);
        assertEquals(1, page.getContent().size());
        SousTypePrestationDTO uDTO = page.getContent().get(0);
        assertEquals(1L, uDTO.getId());

    }

}
