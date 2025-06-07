package com.lukegjpotter.tools.vam_to_wkg_converter.controller;

import com.lukegjpotter.tools.vam_to_wkg_converter.dto.VamRequestRecord;
import com.lukegjpotter.tools.vam_to_wkg_converter.dto.WkgResponseRecord;
import com.lukegjpotter.tools.vam_to_wkg_converter.service.VamToWkgConverterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VamToWkgConverterController {

    private final Logger logger = LoggerFactory.getLogger(VamToWkgConverterController.class);
    private final VamToWkgConverterService vamToWkgConverterService;

    public VamToWkgConverterController(VamToWkgConverterService vamToWkgConverterService) {
        this.vamToWkgConverterService = vamToWkgConverterService;
    }

    @PostMapping("/convert")
    public ResponseEntity<WkgResponseRecord> convert(@RequestBody VamRequestRecord vamRequestRecord) {
        logger.trace("Endpoint Convert called with {}", vamRequestRecord);

        try {
            WkgResponseRecord wkgResponseRecord = vamToWkgConverterService.convertVamToWkg(vamRequestRecord);

            if (wkgResponseRecord.errorMessage().isEmpty()) return ResponseEntity.ok(wkgResponseRecord);
            else return ResponseEntity.badRequest().body(wkgResponseRecord);
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(new WkgResponseRecord(
                    null,
                    null,
                    exception.getMessage()));
        }
    }

    @GetMapping("/test")
    public ResponseEntity<WkgResponseRecord> test() {
        logger.trace("Endpoint Test called");

        return ResponseEntity.ok(new WkgResponseRecord(
                6.8,
                440,
                ""));
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        logger.trace("Endpoint Health called");
        return ResponseEntity.ok("OK");
    }
}