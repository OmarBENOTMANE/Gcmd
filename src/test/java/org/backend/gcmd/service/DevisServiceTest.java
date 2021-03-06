package org.backend.gcmd.service;


import org.backend.gcmd.dto.DevisDTO;
import org.backend.gcmd.enums.ImportExportEnum;
import org.backend.gcmd.exceptions.technical.IllegalNullParamException;
import org.backend.gcmd.exceptions.technical.ObjectNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;

import static org.backend.gcmd.enums.EnginsColisEnum.COLIS;
import static org.backend.gcmd.enums.MmMcEnum.MM;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "classpath:/fixtures/clear.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:/fixtures/devis.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class DevisServiceTest {


    @Autowired
    DevisService devisService;

    @Test
    void serviceInjection() {
        assertNotNull(devisService);
    }

    //findById
    @Test
    void findById_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    devisService.findById(null);
                });
    }

    @Test
    void findById_OK_ID_Found() {
        DevisDTO ddto = devisService.findById(1L);
        assertNotNull(ddto);
        assertEquals(1L, ddto.getId());
    }

    @Test
    void findById_KO_ID_Not_Found() {
        assertThrows(ObjectNotFoundException.class,
                () -> {
                    devisService.findById(999999L);
                });
    }

    //save
    @Test
    void save_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    devisService.save(null);
                });
    }

    @Test
    void save_OK() {
        //given
        DevisDTO ddto = DevisDTO.builder()
                .id(null).mmMc(MM).bl(22).clientId(1L).date(LocalDate.now()).dateFacturation(LocalDate.now()).dateSortie(LocalDate.now()).designation("design").enginsColis(COLIS).escaleId(1L).importExport(ImportExportEnum.IMPORT).nomClient("client").nomNavire("navire").nombreColis(2).numeroCommande(3).numeroMafi(4).poids(5.6)
                .build();
        //when
        DevisDTO result = devisService.save(ddto);
        //then
        assertNotNull(result.getId());
    }

    //update
    @Test
    void update_Ok_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    devisService.update(null);
                });
    }

    @Test
    void update_KO_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    devisService.update(null);
                });
    }

    @Test
    void update_Ok() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    devisService.update(null);
                });
        //given
        DevisDTO ddto = DevisDTO.builder()
                .id(1L).mmMc(MM).bl(22).clientId(1L).date(LocalDate.now()).dateFacturation(LocalDate.now()).dateSortie(LocalDate.now()).designation("desi modof").enginsColis(COLIS).escaleId(1L).importExport(ImportExportEnum.IMPORT).nomClient("modif nc").nomNavire("navire").nombreColis(2).numeroCommande(3).numeroMafi(4).poids(5.6)

                .build();
        //when
        DevisDTO result = devisService.update(ddto);
        //then
        assertNotNull(result.getId());
    }

}
