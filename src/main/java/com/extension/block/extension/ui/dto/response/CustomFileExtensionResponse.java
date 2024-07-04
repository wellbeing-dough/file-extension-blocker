package com.extension.block.extension.ui.dto.response;

import com.extension.block.extension.repository.dto.MembersCustomFileExtensionData;

import java.util.List;

public class CustomFileExtensionResponse {

    private final List<MembersCustomFileExtensionData> data;

    public CustomFileExtensionResponse(List<MembersCustomFileExtensionData> data) {
        this.data = data;
    }
}
