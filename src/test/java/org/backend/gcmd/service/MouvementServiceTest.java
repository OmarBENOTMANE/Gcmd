package org.backend.gcmd.service;


import org.backend.gcmd.dto.MouvementDTO;
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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "classpath:/fixtures/clear.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:/fixtures/mouvement.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class MouvementServiceTest {


    @Autowired
    MouvementService mouvementService;

    @Test
    void serviceInjection() {
        assertNotNull(mouvementService);
    }

    //findById
    @Test
    void findById_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    mouvementService.findById(null);
                });
    }

    @Test
    void findById_OK_ID_Found() {
        MouvementDTO mdto = mouvementService.findById(1L);
        assertNotNull(mdto);
        assertEquals(1L, mdto.getId());

    }

    @Test
    void findById_KO_ID_Not_Found() {
        assertThrows(ObjectNotFoundException.class,
                () -> {
                    mouvementService.findById(999999L);
                });
    }

    //save
    @Test
    void save_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    mouvementService.save(null);
                });
    }

    @Test
    void save_OK() {
        //given
        MouvementDTO bpdto = MouvementDTO.builder()
                .id(1L).dateMouvement(LocalDate.now()).description("des").navirId(1L)
                .build();
        //when
        MouvementDTO result = mouvementService.save(bpdto);
        //then
        assertNotNull(result.getId());
    }

    //update
    @Test
    void update_Ok_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    mouvementService.update(null);
                });
    }

    @Test
    void update_KO_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    mouvementService.update(null);
                });
    }

    @Test
    void update_Ok() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    mouvementService.update(null);
                });
        //given
        MouvementDTO mdto = MouvementDTO.builder()
                .id(1L).dateMouvement(LocalDate.now()).description("des").navirId(1L)
                .build();
        //when
        MouvementDTO result = mouvementService.update(mdto);
        //then
        assertNotNull(result.getId());
    }

    //delete
//    @Test
//    void delete_KO_nullId() {
//        assertThrows(IllegalNullParamException.class,
//                () -> {
//                    mouvementService.delete(null);
//                });
//    }
//
//    @Test
//    void delete_ok() {
//        mouvementService.delete(1L);
//        //then
//        Exception exception =
//                Assertions.assertThrows(ObjectNotFoundException.class, () -> mouvementService.findById(1L),
//                        "Expected findById() to throw ObjectNotFoundException, but it didn't");
//        String expectedMessage = "MouvementDTO not found";
//        assertTrue(exception.getMessage().contains(expectedMessage));
//    }

    // findAll
    @Test
    void findAll() {
        Page<MouvementDTO> page = mouvementService.findAll(PageRequest.of(0, 10));
        assertNotNull(page);
        assertEquals(1, page.getContent().size());
        MouvementDTO bpDTO = page.getContent().get(0);
        assertEquals(1L, bpDTO.getId());

    }

}
