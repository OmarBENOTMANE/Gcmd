package org.backend.gcmd.service;


import org.backend.gcmd.dto.NavireDTO;
import org.backend.gcmd.exceptions.technical.IllegalNullParamException;
import org.backend.gcmd.exceptions.technical.ObjectNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "classpath:/fixtures/clear.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:/fixtures/navire.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class NavireServiceTest {


    @Autowired
    NavireService navireService;

    @Test
    void serviceInjection() {
        assertNotNull(navireService);
    }

    //findById
    @Test
    void findById_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    navireService.findById(null);
                });
    }

    @Test
    void findById_OK_ID_Found() {
        NavireDTO ndto = navireService.findById(1L);
        assertNotNull(ndto);
        assertEquals(1L, ndto.getId());

    }

    @Test
    void findById_KO_ID_Not_Found() {
        assertThrows(ObjectNotFoundException.class,
                () -> {
                    navireService.findById(999999L);
                });
    }

    //save
    @Test
    void save_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    navireService.save(null);
                });
    }

    @Test
    void save_OK() {
        //given
        NavireDTO ndto = NavireDTO.builder()
                .id(null).consignataire("cons").dateNavire(LocalDate.now()).etat("facturé").name("bateau").numeroEscale(10)
                .build();
        //when
        NavireDTO result = navireService.save(ndto);
        //then
        assertNotNull(result.getId());
    }

    //update
    @Test
    void update_Ok_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    navireService.update(null);
                });
    }

    @Test
    void update_KO_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    navireService.update(null);
                });
    }

    @Test
    void update_Ok() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    navireService.update(null);
                });
        //given
        NavireDTO ndto = NavireDTO.builder()
                .id(1L).consignataire("cons").dateNavire(LocalDate.now()).etat("facturé").name("bateau").numeroEscale(10)
                .build();
        //when
        NavireDTO result = navireService.update(ndto);
        //then
        assertNotNull(result.getId());
    }
    
}
