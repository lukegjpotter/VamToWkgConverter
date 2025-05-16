package com.lukegjpotter.tools.vam_to_wkg_converter.service;

import com.lukegjpotter.tools.vam_to_wkg_converter.dto.VamRequestRecord;
import com.lukegjpotter.tools.vam_to_wkg_converter.dto.WkgResponseRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class VamToWkgConverterServiceTest {

    @Autowired
    VamToWkgConverterService vamToWkgConverterService;

    @Test
    void convertVamToWkg_goldenPath() {
        WkgResponseRecord actual = vamToWkgConverterService.convertVamToWkg(new VamRequestRecord(1606, 8.1, 68));
        WkgResponseRecord expected = new WkgResponseRecord(5.72, 388, "");

        assertEquals(expected, actual);
    }
}