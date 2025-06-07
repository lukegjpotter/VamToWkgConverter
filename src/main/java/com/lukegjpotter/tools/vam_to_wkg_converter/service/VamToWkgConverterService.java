package com.lukegjpotter.tools.vam_to_wkg_converter.service;


import com.lukegjpotter.tools.vam_to_wkg_converter.dto.VamRequestRecord;
import com.lukegjpotter.tools.vam_to_wkg_converter.dto.WkgResponseRecord;
import org.springframework.stereotype.Service;

@Service
public class VamToWkgConverterService {

    public WkgResponseRecord convertVamToWkg(VamRequestRecord vamRequestRecord) throws IllegalArgumentException {

        double riderWeight = (vamRequestRecord.riderWeight() == null) ? 0.0 : vamRequestRecord.riderWeight();

        if (vamRequestRecord.verticalAscentMeters() == null || vamRequestRecord.gradient() == null || vamRequestRecord.verticalAscentMeters() <= 0 || vamRequestRecord.gradient() <= 0 || riderWeight < 0)
            throw new IllegalArgumentException("verticalAscentMeters and gradient must be positive numbers. riderWeight is optional, but must be positive if provided.");


        double wattsPerKilo = vamRequestRecord.verticalAscentMeters() / ((2 + vamRequestRecord.gradient() / 10) * 100);

        Integer rawWatts = null;
        if (riderWeight > 0.0)
            rawWatts = (int) (wattsPerKilo * riderWeight);

        return new WkgResponseRecord(
                Double.parseDouble(String.format("%.2f", wattsPerKilo)),
                rawWatts,
                "");
    }
}
