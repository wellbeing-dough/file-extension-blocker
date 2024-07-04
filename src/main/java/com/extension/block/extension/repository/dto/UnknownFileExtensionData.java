package com.extension.block.extension.repository.dto;

import lombok.Getter;

@Getter
public class UnknownFileExtensionData {

    private final Long unknownFileExtensionId;
    private final String extensionName;
    private final String description;

    public UnknownFileExtensionData(Long unknownFileExtensionId, String extensionName, String description) {
        this.unknownFileExtensionId = unknownFileExtensionId;
        this.extensionName = extensionName;
        this.description = description;
    }
}
