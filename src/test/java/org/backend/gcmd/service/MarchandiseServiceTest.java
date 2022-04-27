package org.backend.gcmd.service;


import org.backend.gcmd.dto.MarchandiseDTO;
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
@Sql(scripts = "classpath:/fixtures/marchandise.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class MarchandiseServiceTest {


    @Autowired
    MarchandiseService marchandiseService;

    @Test
    void serviceInjection() {
        assertNotNull(marchandiseService);
    }

    //findById
    @Test
    void findById_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    marchandiseService.findById(null);
                });
    }

    @Test
    void findById_OK_ID_Found() {
        MarchandiseDTO mdto = marchandiseService.findById(1L);
        assertNotNull(mdto);
        assertEquals(1L, mdto.getId());
    }

    @Test
    void findById_KO_ID_Not_Found() {
        assertThrows(ObjectNotFoundException.class,
                () -> {
                    marchandiseService.findById(999999L);
                });
    }

    //save
    @Test
    void save_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    marchandiseService.save(null);
                });
    }

    @Test
    void save_OK() {
        //given
        MarchandiseDTO mdto = MarchandiseDTO.builder()
                .id(null).designation("desi").escaleId(1L).quantite(3.2).reference("ref")
                .build();
        //when
        MarchandiseDTO result = marchandiseService.save(mdto);
        //then
        assertNotNull(result.getId());
    }

    //update
    @Test
    void update_Ok_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    marchandiseService.update(null);
                });
    }

    @Test
    void update_KO_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    marchandiseService.update(null);
                });
    }

    @Test
    void update_Ok() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    marchandiseService.update(null);
                });
        //given
        MarchandiseDTO mdto = MarchandiseDTO.builder()
                .id(1L).designation("desi modif").escaleId(1L).quantite(3.2).reference("ref modif")
                .build();
        //when
        MarchandiseDTO result = marchandiseService.update(mdto);
        //then
        assertNotNull(result.getId());
    }

    //delete
    @Test
    void delete_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    marchandiseService.delete(null);
                });
    }

    @Test
    void delete_ok() {
        marchandiseService.delete(1L);
        //then
        Exception exception =
                Assertions.assertThrows(ObjectNotFoundException.class, () -> marchandiseService.findById(1L),
                        "Expected findById() to throw ObjectNotFoundException, but it didn't");
        String expectedMessage = "MarchandiseDTO not found";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    // findAll
    @Test
    void findAll() {
        Page<MarchandiseDTO> page = marchandiseService.findAll(PageRequest.of(0, 10));
        assertNotNull(page);
        assertEquals(1, page.getContent().size());
        MarchandiseDTO cDTO = page.getContent().get(0);
        assertEquals(1L, cDTO.getId());
    }

}
