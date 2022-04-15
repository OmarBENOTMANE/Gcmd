package org.backend.gcmd.config;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class PropertiesConfigurationGuard implements InitializingBean {
//    Logger LOGGER = LoggerFactory.getLogger(PropertiesConfigurationGuard.class);
//
//    @Value("${project.version}")
//    private String version;
//
//    @Value("${spring.application.name}")
//    private String name;
//
//    @Value("${server.port}")
//    private String port;
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//
//        if (this.version == null || this.version.equals("${project.version}")) {
//            //throw new IllegalArgumentException("${project.version} must be configured");
//            LOGGER.error("${project.version} must be configured");
//        }
//
//        if (this.version == null || this.version.equals("${spring.application.name}")) {
//            LOGGER.error("${spring.application.name} must be configured");
//            //throw new IllegalArgumentException("${spring.application.name} must be configured");
//        }
//
//        if (this.version == null || this.version.equals("${server.port}")) {
//            LOGGER.error("${server.port} must be configured");
//            //throw new IllegalArgumentException("${server.port} must be configured");
//        }
//
//    }
//}
