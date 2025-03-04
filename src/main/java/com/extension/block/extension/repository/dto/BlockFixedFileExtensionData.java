package com.extension.block.extension.repository.dto;

import com.extension.block.extension.domain.component.ExtensionName;
import lombok.Getter;

@Getter
public class BlockFixedFileExtensionData {

    private final Long blockFixedFileExtensionId;
    private final String extensionName;

    public BlockFixedFileExtensionData(Long blockFixedFileExtensionId, ExtensionName extensionName) {
        this.blockFixedFileExtensionId = blockFixedFileExtensionId;
        this.extensionName = extensionName.toLowerCase();
    }
}
