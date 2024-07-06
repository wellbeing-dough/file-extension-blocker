package com.extension.block.extension.ui.dto.response;

import com.extension.block.extension.repository.dto.CustomFileExtensionData;
import com.extension.block.extension.repository.dto.FixedFileExtensionData;
import lombok.Getter;

import java.util.List;

@Getter
public class CustomFileExtensionResponse {

    private final List<CustomFileExtensionData> customFileExtensions;
    private final List<FixedFileExtensionData> fixedFileExtensions;

    public CustomFileExtensionResponse(List<CustomFileExtensionData> customFileExtensions, List<FixedFileExtensionData> fixedFileExtensions) {
        this.customFileExtensions = customFileExtensions;
        this.fixedFileExtensions = fixedFileExtensions;
    }
}
