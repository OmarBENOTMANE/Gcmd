package org.backend.gcmd.service;


import org.backend.gcmd.dto.TarifDTO;
import org.backend.gcmd.exceptions.technical.IllegalNullParamException;
import org.backend.gcmd.exceptions.technical.ObjectNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "classpath:/fixtures/clear.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:/fixtures/tarif.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class TarifServiceTest {


    @Autowired
    TarifService tarifService;

    @Test
    void serviceInjection() {
        assertNotNull(tarifService);
    }

    //findById
    @Test
    void findById_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    tarifService.findById(null);
                });
    }

    @Test
    void findById_OK_ID_Found() {
        TarifDTO udto = tarifService.findById(1L);
        assertNotNull(udto);
        assertEquals(1L, udto.getId());
    }

    @Test
    void findById_KO_ID_Not_Found() {
        assertThrows(ObjectNotFoundException.class,
                () -> {
                    tarifService.findById(999999L);
                });
    }

    //save
    @Test
    void save_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    tarifService.save(null);
                });
    }

    @Test
    void save_OK() {
        //given
        TarifDTO udto = TarifDTO.builder()
                .id(null).tarifHt(100.4).tarifTtc(120.4)
                .build();
        //when
        TarifDTO result = tarifService.save(udto);
        //then
        assertNotNull(result.getId());
    }

    //update
    @Test
    void update_Ok_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    tarifService.update(null);
                });
    }

    @Test
    void update_KO_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    tarifService.update(null);
                });
    }

    @Test
    void update_Ok() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    tarifService.update(null);
                });
        //given
        TarifDTO udto = TarifDTO.builder()
                .id(1l).tarifHt(100.4).tarifTtc(120.4)
                .build();
        //when
        TarifDTO result = tarifService.update(udto);
        //then
        assertNotNull(result.getId());
    }


}
