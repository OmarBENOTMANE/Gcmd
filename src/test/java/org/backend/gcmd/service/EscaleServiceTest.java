package org.backend.gcmd.service;


import org.backend.gcmd.dto.EscaleDTO;
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
@Sql(scripts = "classpath:/fixtures/escale.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class EscaleServiceTest {


    @Autowired
    EscaleService escaleService;

    @Test
    void serviceInjection() {
        assertNotNull(escaleService);
    }

    //findById
    @Test
    void findById_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    escaleService.findById(null);
                });
    }

    @Test
    void findById_OK_ID_Found() {
        EscaleDTO edto = escaleService.findById(1L);
        assertNotNull(edto);
        assertEquals(1L, edto.getId());
    }

    @Test
    void findById_KO_ID_Not_Found() {
        assertThrows(ObjectNotFoundException.class,
                () -> {
                    escaleService.findById(999999L);
                });
    }

    //save
    @Test
    void save_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    escaleService.save(null);
                });
    }

    @Test
    void save_OK() {
        //given
        EscaleDTO edto = EscaleDTO.builder()
                .id(null).navireId(1L).numeroEscale(22)
                .build();
        //when
        EscaleDTO result = escaleService.save(edto);
        //then
        assertNotNull(result.getId());
    }

    //update
    @Test
    void update_Ok_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    escaleService.update(null);
                });
    }

    @Test
    void update_KO_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    escaleService.update(null);
                });
    }

    @Test
    void update_Ok() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    escaleService.update(null);
                });
        //given
        EscaleDTO edto = EscaleDTO.builder()
                .id(1L).navireId(1L).numeroEscale(23)
                .build();
        //when
        EscaleDTO result = escaleService.update(edto);
        //then
        assertNotNull(result.getId());
    }

    //delete
//    @Test
//    void delete_KO_nullId() {
//        assertThrows(IllegalNullParamException.class,
//                () -> {
//                    escaleService.delete(null);
//                });
//    }
//
//    @Test
//    void delete_ok() {
//        escaleService.delete(1L);
//        //then
//        Exception exception =
//                Assertions.assertThrows(ObjectNotFoundException.class, () -> escaleService.findById(1L),
//                        "Expected findById() to throw ObjectNotFoundException, but it didn't");
//        String expectedMessage = "EscaleDTO not found";
//        assertTrue(exception.getMessage().contains(expectedMessage));
//    }

    // findAll
    @Test
    void findAll() {
        Page<EscaleDTO> page = escaleService.findAll(PageRequest.of(0, 10));
        assertNotNull(page);
        assertEquals(1, page.getContent().size());
        EscaleDTO cDTO = page.getContent().get(0);
        assertEquals(1L, cDTO.getId());
    }

}
