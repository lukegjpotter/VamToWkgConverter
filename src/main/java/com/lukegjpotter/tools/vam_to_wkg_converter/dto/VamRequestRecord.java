package com.lukegjpotter.tools.vam_to_wkg_converter.dto;

import jakarta.annotation.Nullable;

public record VamRequestRecord(
        Integer verticalAscentMeters,
        Double gradient,
        @Nullable Double riderWeight) {
}
