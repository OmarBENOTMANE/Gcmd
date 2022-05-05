package org.backend.gcmd.service;


import org.backend.gcmd.dto.TypePrestationDTO;
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
                .id(null).name("prestation").uniteorganisationelId(1l)
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
                .id(1L).name("prestation modif").uniteorganisationelId(1l)
                .build();
        //when
        TypePrestationDTO result = typePrestationService.update(tpdto);
        //then
        assertNotNull(result.getId());
    }

    //delete
    @Test
    void delete_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    typePrestationService.delete(null);
                });
    }

    @Test
    void delete_ok() {
        typePrestationService.delete(1L);
        //then
        Exception exception =
                Assertions.assertThrows(ObjectNotFoundException.class, () -> typePrestationService.findById(1L),
                        "Expected findById() to throw ObjectNotFoundException, but it didn't");
        String expectedMessage = "TypePrestationDTO not found";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    // findAll
    @Test
    void findAll() {
        Page<TypePrestationDTO> page = typePrestationService.findAll(PageRequest.of(0, 10));
        assertNotNull(page);
        assertEquals(1, page.getContent().size());
        TypePrestationDTO uDTO = page.getContent().get(0);
        assertEquals(1L, uDTO.getId());

    }

}
