package com.lukegjpotter.tools.vam_to_wkg_converter.dto;

import jakarta.annotation.Nullable;

public record WkgResponseRecord(
        @Nullable Double wattsPerKilo,
        @Nullable Integer rawWatts,
        String errorMessage) {
}
