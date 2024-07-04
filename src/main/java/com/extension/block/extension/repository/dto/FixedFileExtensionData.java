package com.extension.block.extension.repository.dto;

import lombok.Getter;

@Getter
public class FixedFileExtensionData {

    private final Long fixedFileExtensionId;
    private final String extensionName;

    public FixedFileExtensionData(Long fixedFileExtensionId, String extensionName) {
        this.fixedFileExtensionId = fixedFileExtensionId;
        this.extensionName = extensionName;
    }
}
