package com.extension.block.extension.repository.dto;

import lombok.Getter;

@Getter
public class BlockFixedFileExtensionData {

    private final Long blockFixedFileExtensionId;
    private final String extensionName;

    public BlockFixedFileExtensionData(Long blockFixedFileExtensionId, String extensionName) {
        this.blockFixedFileExtensionId = blockFixedFileExtensionId;
        this.extensionName = extensionName;
    }
}
