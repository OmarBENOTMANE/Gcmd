package org.backend.gcmd.service;


import org.backend.gcmd.dto.LigneBpDTO;
import org.backend.gcmd.enums.SenstraficEnum;
import org.backend.gcmd.exceptions.technical.IllegalNullParamException;
import org.backend.gcmd.exceptions.technical.ObjectNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "classpath:/fixtures/clear.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:/fixtures/ligneBp.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class LigneBpServiceTest {


    @Autowired
    LigneBpService ligneBpService;

    @Test
    void serviceInjection() {
        assertNotNull(ligneBpService);
    }

    //findById
    @Test
    void findById_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    ligneBpService.findById(null);
                });
    }

    @Test
    void findById_OK_ID_Found() {
        LigneBpDTO ddto = ligneBpService.findById(1L);
        assertNotNull(ddto);
        assertEquals(1L, ddto.getId());
    }

    @Test
    void findById_KO_ID_Not_Found() {
        assertThrows(ObjectNotFoundException.class,
                () -> {
                    ligneBpService.findById(999999L);
                });
    }

    //save
    @Test
    void save_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    ligneBpService.save(null);
                });
    }

    @Test
    void save_OK() {
        //given
        LigneBpDTO ddto = LigneBpDTO.builder()
                .id(null).date(LocalDate.parse("2022-04-27")).heure(LocalTime.parse("09:00:00")).nombre(2).prestations("prestation").produit("produit").sensTrafic(SenstraficEnum.valueOf("IMPORT")).tarifUnifie(true).tcConv(false).tcSuppl("tc sup").tonnageMinimum(33).tonnageReel(44).bulltinPrestationId(1L)
                .build();
        //when
        LigneBpDTO result = ligneBpService.save(ddto);
        //then
        assertNotNull(result.getId());
    }

    //update
    @Test
    void update_Ok_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    ligneBpService.update(null);
                });
    }

    @Test
    void update_KO_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    ligneBpService.update(null);
                });
    }

    @Test
    void update_Ok() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    ligneBpService.update(null);
                });
        //given
        LigneBpDTO ddto = LigneBpDTO.builder()
                .id(1L).date(LocalDate.parse("2022-04-27")).heure(LocalTime.parse("09:00:00")).nombre(2).prestations("prestation").produit("produit").sensTrafic(SenstraficEnum.valueOf("IMPORT")).tarifUnifie(true).tcConv(false).tcSuppl("tc sup").tonnageMinimum(33).tonnageReel(44).bulltinPrestationId(1L)
                .build();
        //when
        LigneBpDTO result = ligneBpService.update(ddto);
        //then
        assertNotNull(result.getId());
    }


}
