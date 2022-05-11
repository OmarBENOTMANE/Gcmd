package org.backend.gcmd.service;


import org.backend.gcmd.dto.CommandeDTO;
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
@Sql(scripts = "classpath:/fixtures/commande.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class CommandeServiceTest {


    @Autowired
    CommandeService commandeService;

    @Test
    void serviceInjection() {
        assertNotNull(commandeService);
    }

    //findById
    @Test
    void findById_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    commandeService.findById(null);
                });
    }

    @Test
    void findById_OK_ID_Found() {
        CommandeDTO cdto = commandeService.findById(1L);
        assertNotNull(cdto);
        assertEquals(1L, cdto.getId());
    }

    @Test
    void findById_KO_ID_Not_Found() {
        assertThrows(ObjectNotFoundException.class,
                () -> {
                    commandeService.findById(999999L);
                });
    }

    //save
    @Test
    void save_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    commandeService.save(null);
                });
    }

    @Test
    void save_OK() {
        //given
        CommandeDTO cdto = CommandeDTO.builder()
                .bulletinReception(1).bulltinPrestationId(1L).capitaine("capi").connaissement(2).consignataire("consi").dateAmarage(LocalDate.now()).dateDesamarage(LocalDate.now()).devisId(1L).escaleId(1L).jaugeBrute(2.0).lht(3).mumeroCommande(4).mumeroCredit(5).navire("navi2").numeroBc(6).numeroEscale(7).poste("poste")
                .build();
        //when
        CommandeDTO result = commandeService.save(cdto);
        //then
        assertNotNull(result.getId());
    }

    //update
    @Test
    void update_Ok_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    commandeService.update(null);
                });
    }

    @Test
    void update_KO_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    commandeService.update(null);
                });
    }

    @Test
    void update_Ok() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    commandeService.update(null);
                });
        //given
        CommandeDTO cdto = CommandeDTO.builder()
                .id(1L).bulletinReception(1).bulltinPrestationId(1L).capitaine("capi modif").connaissement(2).consignataire("consi").dateAmarage(LocalDate.now()).dateDesamarage(LocalDate.now()).devisId(1L).escaleId(1L).jaugeBrute(2.0).lht(3).mumeroCommande(4).mumeroCredit(5).navire("navi2").numeroBc(6).numeroEscale(7).poste("poste")
                .build();
        //when
        CommandeDTO result = commandeService.update(cdto);
        //then
        assertNotNull(result.getId());
    }
    
}
