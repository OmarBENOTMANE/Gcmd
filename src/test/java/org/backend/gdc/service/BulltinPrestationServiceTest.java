package org.backend.gdc.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql(scripts = "classpath:/fixtures/clear.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:/fixtures/bulltinPrestation.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class BulltinPrestationServiceTest {

    @Autowired
    BulltinPrestationService bulltinPrestationService;

    @Test
    void setUp(){
        Assertions.assertNotNull(bulltinPrestationService);
    }




}
