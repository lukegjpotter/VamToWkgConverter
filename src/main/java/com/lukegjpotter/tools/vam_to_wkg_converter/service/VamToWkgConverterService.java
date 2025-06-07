package com.lukegjpotter.tools.vam_to_wkg_converter.service;


import com.lukegjpotter.tools.vam_to_wkg_converter.dto.VamRequestRecord;
import com.lukegjpotter.tools.vam_to_wkg_converter.dto.WkgResponseRecord;
import org.springframework.stereotype.Service;

@Service
public class VamToWkgConverterService {

    public WkgResponseRecord convertVamToWkg(VamRequestRecord vamRequestRecord) {

        double wattsPerKilo = vamRequestRecord.verticalAscentMeters() / ((2 + vamRequestRecord.gradient() / 10) * 100);

        Integer rawWatts = null;
        if (vamRequestRecord.riderWeight() != null && vamRequestRecord.riderWeight() > 0.0)
            rawWatts = (int) (wattsPerKilo * vamRequestRecord.riderWeight());

        return new WkgResponseRecord(
                Double.parseDouble(String.format("%.2f", wattsPerKilo)),
                rawWatts,
                "");
    }
}
