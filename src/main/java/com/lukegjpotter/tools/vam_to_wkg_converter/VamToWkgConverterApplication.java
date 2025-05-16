package com.lukegjpotter.tools.vam_to_wkg_converter;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "VAM to WKG Converter", version = "0.0.1",
        description = "A RESTful Service take takes some parameters and then generates the WKG from the supplied VAM."))
public class VamToWkgConverterApplication {

    private static final Logger logger = LoggerFactory.getLogger(VamToWkgConverterApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(VamToWkgConverterApplication.class, args);

        logger.info("Application Started");
    }
}
