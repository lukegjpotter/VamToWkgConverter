package com.lukegjpotter.tools.vam_to_wkg_converter.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

public record VamRequestRecord(
        @NotNull double verticalAscentMeters,
        @NotNull double gradient,
        @Nullable Double riderWeight) {
}
