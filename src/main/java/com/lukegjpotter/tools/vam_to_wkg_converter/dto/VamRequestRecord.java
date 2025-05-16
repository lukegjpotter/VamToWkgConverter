package com.lukegjpotter.tools.vam_to_wkg_converter.dto;

public record VamRequestRecord(
        double verticalAscentMeters,
        double gradient,
        double riderWeight) {
}
