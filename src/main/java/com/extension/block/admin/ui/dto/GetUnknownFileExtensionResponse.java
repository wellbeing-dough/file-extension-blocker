package com.extension.block.admin.ui.dto;

import com.extension.block.extension.repository.dto.UnknownFileExtensionData;
import lombok.Getter;

import java.util.List;

@Getter
public class GetUnknownFileExtensionResponse {

    private final List<UnknownFileExtensionData> data;

    public GetUnknownFileExtensionResponse(List<UnknownFileExtensionData> data) {
        this.data = data;
    }
}
