package org.backend.gcmd.service;


import org.backend.gcmd.dto.UniteOrganisationelDTO;
import org.backend.gcmd.exceptions.technical.IllegalNullParamException;
import org.backend.gcmd.exceptions.technical.ObjectNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "classpath:/fixtures/clear.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:/fixtures/uniteOrganisationel.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class UniteOrganisationelServiceTest {


    @Autowired
    UniteOrganisationelService uniteOrganisationelService;

    @Test
    void serviceInjection() {
        assertNotNull(uniteOrganisationelService);
    }

    //findById
    @Test
    void findById_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    uniteOrganisationelService.findById(null);
                });
    }

    @Test
    void findById_OK_ID_Found() {
        UniteOrganisationelDTO udto = uniteOrganisationelService.findById(1L);
        assertNotNull(udto);
        assertEquals(1L, udto.getId());
    }

    @Test
    void findById_KO_ID_Not_Found() {
        assertThrows(ObjectNotFoundException.class,
                () -> {
                    uniteOrganisationelService.findById(999999L);
                });
    }

    //save
    @Test
    void save_KO_nullId() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    uniteOrganisationelService.save(null);
                });
    }

    @Test
    void save_OK() {
        //given
        UniteOrganisationelDTO udto = UniteOrganisationelDTO.builder()
                .id(null).label("label").type("type").description("desciption").uniteOrganisationelId(1L)
                .build();
        //when
        UniteOrganisationelDTO result = uniteOrganisationelService.save(udto);
        //then
        assertNotNull(result.getId());
    }

    //update
    @Test
    void update_Ok_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    uniteOrganisationelService.update(null);
                });
    }

    @Test
    void update_KO_dtoNull() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    uniteOrganisationelService.update(null);
                });
    }

    @Test
    void update_Ok() {
        assertThrows(IllegalNullParamException.class,
                () -> {
                    uniteOrganisationelService.update(null);
                });
        //given
        UniteOrganisationelDTO udto = UniteOrganisationelDTO.builder()
                .id(1L).label("label").type("type").description("desciption").uniteOrganisationelId(1L)
                .build();
        //when
        UniteOrganisationelDTO result = uniteOrganisationelService.update(udto);
        //then
        assertNotNull(result.getId());
    }

    //delete
//    @Test
//    void delete_KO_nullId() {
//        assertThrows(IllegalNullParamException.class,
//                () -> {
//                    uniteOrganisationelService.delete(null);
//                });
//    }
//
//    @Test
//    void delete_ok() {
//        uniteOrganisationelService.delete(1L);
//        //then
//        Exception exception =
//                Assertions.assertThrows(ObjectNotFoundException.class, () -> uniteOrganisationelService.findById(1L),
//                        "Expected findById() to throw ObjectNotFoundException, but it didn't");
//        String expectedMessage = "UniteOrganisationelDTO not found";
//        assertTrue(exception.getMessage().contains(expectedMessage));
//    }

    // findAll
   // @Test
  //  void findAll() {
     //   Page<UniteOrganisationelDTO> page = uniteOrganisationelService.findAll(PageRequest.of(0, 10));
       // assertNotNull(page);
       // assertEquals(1, page.getContent().size());
       // UniteOrganisationelDTO uDTO = page.getContent().get(0);
       // assertEquals(1L, uDTO.getId());

}
