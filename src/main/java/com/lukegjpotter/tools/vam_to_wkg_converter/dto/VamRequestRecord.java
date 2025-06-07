package com.lukegjpotter.tools.vam_to_wkg_converter.dto;

import java.util.Optional;

public record VamRequestRecord(
        double verticalAscentMeters,
        double gradient,
        Optional<Double> riderWeight) {
}
