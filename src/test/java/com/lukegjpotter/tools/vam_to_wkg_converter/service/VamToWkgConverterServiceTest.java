package com.lukegjpotter.tools.vam_to_wkg_converter.service;

import com.lukegjpotter.tools.vam_to_wkg_converter.dto.VamRequestRecord;
import com.lukegjpotter.tools.vam_to_wkg_converter.dto.WkgResponseRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class VamToWkgConverterServiceTest {

    @Autowired
    VamToWkgConverterService vamToWkgConverterService;

    @Test
    void convertVamToWkg_goldenPath() {
        WkgResponseRecord actual = vamToWkgConverterService.convertVamToWkg(new VamRequestRecord(1606, 8.1, Optional.of(68.0)));
        WkgResponseRecord expected = new WkgResponseRecord(5.72, 388, "");

        assertEquals(expected, actual);
    }

    @Test
    void convertVamToWkg_riderWeightZero() {
        WkgResponseRecord actual = vamToWkgConverterService.convertVamToWkg(new VamRequestRecord(1606, 8.1, Optional.of(0.0)));
        WkgResponseRecord expected = new WkgResponseRecord(5.72, 0, "");

        assertEquals(expected, actual);
    }

    @Test
    void convertVamToWkg_stravaDataKOB1() {
        WkgResponseRecord actual = vamToWkgConverterService.convertVamToWkg(new VamRequestRecord(1293, 7.1, Optional.of(62.0)));
        WkgResponseRecord expected = new WkgResponseRecord(4.77, 295, "");

        assertEquals(expected, actual);
    }

    @Test
    void convertVamToWkg_stravaData_LukeWicklowGap() {
        WkgResponseRecord actual = vamToWkgConverterService.convertVamToWkg(new VamRequestRecord(579, 5.1, Optional.of(86.0)));
        WkgResponseRecord expected = new WkgResponseRecord(2.31, 198, "");

        assertEquals(expected, actual);
    }

    @Test
    void convertVamToWkg_stravaData_LukeWicklowGap_NullWeight() {
        WkgResponseRecord actual = vamToWkgConverterService.convertVamToWkg(new VamRequestRecord(579, 5.1, Optional.empty()));
        WkgResponseRecord expected = new WkgResponseRecord(2.31, null, "");

        assertEquals(expected, actual);
    }
}