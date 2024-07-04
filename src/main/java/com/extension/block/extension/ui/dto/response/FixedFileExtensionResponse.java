package com.extension.block.extension.ui.dto.response;

import com.extension.block.extension.repository.dto.FixedFileExtensionData;
import lombok.Getter;

import java.util.List;

@Getter
public class FixedFileExtensionResponse {

    private final List<FixedFileExtensionData> data;

    public FixedFileExtensionResponse(List<FixedFileExtensionData> data) {
        this.data = data;
    }
}
