package org.backend.gdc.controller.info;

//import org.backend.gdc.dto.AboutDTO;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//public class ApiInfoController {
//
//    @Value("${project.version:V1.0.0}")
//    private String version;
//
//    @Value("${spring.application.name::Application name}")
//    private String name;
//
//    @Value("${server.port:8080}")
//    private String port;
//
//    @Value("${project.description:no description}")
//    private String description;
//
//
//
//
//    @GetMapping(value = "/about",name = "Application infos")
//    public AboutDTO about() {
//        AboutDTO about =new AboutDTO();
//        about.setName(name);
//        about.setPort(port);
//        about.setVersion(version);
//        about.setDescription(description);
//        return about;
//
//    }
//}