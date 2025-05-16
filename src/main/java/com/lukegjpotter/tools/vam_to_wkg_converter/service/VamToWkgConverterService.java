package com.lukegjpotter.tools.vam_to_wkg_converter.service;


import com.lukegjpotter.tools.vam_to_wkg_converter.dto.VamRequestRecord;
import com.lukegjpotter.tools.vam_to_wkg_converter.dto.WkgResponseRecord;
import org.springframework.stereotype.Service;

@Service
public class VamToWkgConverterService {
    public WkgResponseRecord convertVamToWkg(VamRequestRecord vamRequestRecord) {
        return new WkgResponseRecord(
                5.72,
                388,
                "");
    }
}
