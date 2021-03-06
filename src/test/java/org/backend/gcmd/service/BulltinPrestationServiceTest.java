package org.backend.gcmd.service;


import org.backend.gcmd.dto.BulltinPrestationDTO;
import org.backend.gcmd.enums.TypePaiementEnum;
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
@Sql(scripts = "classpath:/fixtures/bulltinPrestation.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class BulltinPrestationServiceTest {


    @Autowired
    BulltinPrestationService bulltinPrestationService;

    @Test
    void serviceInjection() {
        assertNotNull(bulltinPrestationService);
    }

    //findById
    @Test
    void findById_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    bulltinPrestationService.findById(null);
                });
    }

    @Test
    void findById_OK_ID_Found() {
        BulltinPrestationDTO bpdto = bulltinPrestationService.findById(1L);
        assertNotNull(bpdto);
        assertEquals(1L, bpdto.getId());
        assertEquals("blabla", bpdto.getDescription());
    }

    @Test
    void findById_KO_ID_Not_Found() {
        assertThrows(ObjectNotFoundException.class,
                () -> {
                    bulltinPrestationService.findById(999999L);
                });
    }

    //save
    @Test
    void save_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    bulltinPrestationService.save(null);
                });
    }

    @Test
    void save_OK() {
        //given
        BulltinPrestationDTO bpdto = BulltinPrestationDTO.builder()
                .codeClient(4).codeNature(44).date(LocalDate.now()).dateDepot(LocalDate.now()).dateProbableExecution(LocalDate.now()).description("new4").moyenOdepClient(true).nomClient("clinet4").numeroCmd(444).numeroDossierPrestation(4444).numeroEscale(404).preValidation(false).text("blabla").typePaiement(TypePaiementEnum.COMPTANT)
                .build();
        //when
        BulltinPrestationDTO result = bulltinPrestationService.save(bpdto);
        //then
        assertNotNull(result.getId());
    }

    //update
    @Test
    void update_Ok_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    bulltinPrestationService.update(null);
                });
    }

    @Test
    void update_KO_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    bulltinPrestationService.update(null);
                });
    }

    @Test
    void update_Ok() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    bulltinPrestationService.update(null);
                });
        //given
        BulltinPrestationDTO bpdto = BulltinPrestationDTO.builder()
                .id(1L).description("bla").moyenOdepClient(false).preValidation(false)
                .build();
        //when
        BulltinPrestationDTO result = bulltinPrestationService.update(bpdto);
        //then
        assertNotNull(result.getId());
    }


}
