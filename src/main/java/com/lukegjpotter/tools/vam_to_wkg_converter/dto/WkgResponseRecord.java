package com.lukegjpotter.tools.vam_to_wkg_converter.dto;

public record WkgResponseRecord(
        double wattsPerKilo,
        Integer rawWatts,
        String errorMessage) {
}
