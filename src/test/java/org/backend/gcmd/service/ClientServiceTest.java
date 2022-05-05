package org.backend.gcmd.service;


import org.backend.gcmd.dto.ClientDTO;
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
@Sql(scripts = "classpath:/fixtures/client.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class ClientServiceTest {


    @Autowired
    ClientService clientService;

    @Test
    void serviceInjection() {
        assertNotNull(clientService);
    }

    //findById
    @Test
    void findById_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    clientService.findById(null);
                });
    }

    @Test
    void findById_OK_ID_Found() {
        ClientDTO cdto = clientService.findById(1L);
        assertNotNull(cdto);
        assertEquals(1L, cdto.getId());
    }

    @Test
    void findById_KO_ID_Not_Found() {
        assertThrows(ObjectNotFoundException.class,
                () -> {
                    clientService.findById(999999L);
                });
    }

    //save
    @Test
    void save_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    clientService.save(null);
                });
    }

    @Test
    void save_OK() {
        //given
        ClientDTO cdto = ClientDTO.builder()
                .id(null).email("client2@mail.com").name("client2").phone("0626262626").typeClientId(1L)
                .build();
        //when
        ClientDTO result = clientService.save(cdto);
        //then
        assertNotNull(result.getId());
    }

    //update
    @Test
    void update_Ok_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    clientService.update(null);
                });
    }

    @Test
    void update_KO_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    clientService.update(null);
                });
    }

    @Test
    void update_Ok() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    clientService.update(null);
                });
        //given
        ClientDTO cdto = ClientDTO.builder()
                .id(1L).email("client1@modif.com").name("modif1").phone("0606060620").typeClientId(1L)
                .build();
        //when
        ClientDTO result = clientService.update(cdto);
        //then
        assertNotNull(result.getId());
    }

    //delete
    @Test
    void delete_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    clientService.delete(null);
                });
    }

    @Test
    void delete_ok() {
        clientService.delete(1L);
        //then
        Exception exception =
                Assertions.assertThrows(ObjectNotFoundException.class, () -> clientService.findById(1L),
                        "Expected findById() to throw ObjectNotFoundException, but it didn't");
        String expectedMessage = "ClientDTO not found";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    // findAll
    @Test
    void findAll() {
        Page<ClientDTO> page = clientService.findAll(PageRequest.of(0, 10));
        assertNotNull(page);
        assertEquals(1, page.getContent().size());
        ClientDTO cDTO = page.getContent().get(0);
        assertEquals(1L, cDTO.getId());
    }

}
