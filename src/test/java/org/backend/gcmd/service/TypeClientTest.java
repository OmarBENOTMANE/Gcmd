package org.backend.gcmd.service;


import org.backend.gcmd.dto.TypeClientDTO;
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
@Sql(scripts = "classpath:/fixtures/typeClient.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class TypeClientTest {


    @Autowired
    TypeClientService typeClientService;

    @Test
    void serviceInjection() {
        assertNotNull(typeClientService);
    }

    //findById
    @Test
    void findById_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    typeClientService.findById(null);
                });
    }

    @Test
    void findById_OK_ID_Found() {
        TypeClientDTO tdto = typeClientService.findById(1L);
        assertNotNull(tdto);
        assertEquals(1L, tdto.getId());
    }

    @Test
    void findById_KO_ID_Not_Found() {
        assertThrows(ObjectNotFoundException.class,
                () -> {
                    typeClientService.findById(999999L);
                });
    }

    //save
    @Test
    void save_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    typeClientService.save(null);
                });
    }

    @Test
    void save_OK() {
        //given
        TypeClientDTO tdto = TypeClientDTO.builder()
                .id(null).name("client")
                .build();
        //when
        TypeClientDTO result = typeClientService.save(tdto);
        //then
        assertNotNull(result.getId());
    }

    //update
    @Test
    void update_Ok_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    typeClientService.update(null);
                });
    }

    @Test
    void update_KO_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    typeClientService.update(null);
                });
    }

    @Test
    void update_Ok() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    typeClientService.update(null);
                });
        //given
        TypeClientDTO tdto = TypeClientDTO.builder()
                .id(1L).name("client")
                .build();
        //when
        TypeClientDTO result = typeClientService.update(tdto);
        //then
        assertNotNull(result.getId());
    }

    //delete
//    @Test
//    void delete_KO_nullId() {
//        assertThrows(IllegalNullParamException.class,
//                () -> {
//                    typeClientService.delete(null);
//                });
//    }
//
//    @Test
//    void delete_ok() {
//        typeClientService.delete(1L);
//        //then
//        Exception exception =
//                Assertions.assertThrows(ObjectNotFoundException.class, () -> typeClientService.findById(1L),
//                        "Expected findById() to throw ObjectNotFoundException, but it didn't");
//        String expectedMessage = "TypeClientDTO not found";
//        assertTrue(exception.getMessage().contains(expectedMessage));
//    }

    // findAll
    @Test
    void findAll() {
        Page<TypeClientDTO> page = typeClientService.findAll(PageRequest.of(0, 10));
        assertNotNull(page);
        assertEquals(1, page.getContent().size());
        TypeClientDTO DTO = page.getContent().get(0);
        assertEquals(1L, DTO.getId());

    }

}
