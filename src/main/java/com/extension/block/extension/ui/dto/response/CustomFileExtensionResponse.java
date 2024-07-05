package com.extension.block.extension.ui.dto.response;

import com.extension.block.extension.repository.dto.CustomFileExtensionData;
import lombok.Getter;

import java.util.List;

@Getter
public class CustomFileExtensionResponse {

    private final List<CustomFileExtensionData> data;

    public CustomFileExtensionResponse(List<CustomFileExtensionData> data) {
        this.data = data;
    }
}
