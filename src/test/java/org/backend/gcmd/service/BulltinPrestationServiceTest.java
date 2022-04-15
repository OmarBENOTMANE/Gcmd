package org.backend.gcmd.service;


import org.backend.gcmd.dto.BulltinPrestationDTO;
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
        assertEquals("description2", bpdto.getDescription());
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
                .description("tddfh")
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
                .id(1L)
                .build();
        //when
        BulltinPrestationDTO result = bulltinPrestationService.update(bpdto);
        //then
        assertNotNull(result.getId());
    }

    //delete
    @Test
    void delete_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    bulltinPrestationService.delete(null);
                });
    }

    @Test
    void delete_ok() {
        bulltinPrestationService.delete(1L);
        //then
        Exception exception =
                Assertions.assertThrows(ObjectNotFoundException.class, () -> bulltinPrestationService.findById(1L),
                        "Expected findById() to throw ObjectNotFoundException, but it didn't");
        String expectedMessage = "BulltinPrestationDTO not found";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    // findAll
    @Test
    void findAll() {
        Page<BulltinPrestationDTO> page = bulltinPrestationService.findAll(PageRequest.of(0, 10));
        assertNotNull(page);
        assertEquals(1, page.getContent().size());
        BulltinPrestationDTO bpDTO = page.getContent().get(0);
        assertEquals(1L, bpDTO.getId());
        assertEquals("description2", bpDTO.getDescription());
    }

}
