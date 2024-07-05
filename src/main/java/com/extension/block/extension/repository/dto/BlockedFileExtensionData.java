package com.extension.block.extension.repository.dto;

import com.extension.block.extension.domain.component.ExtensionName;
import lombok.Getter;

@Getter
public class BlockedFileExtensionData {

    private final Long blockedFileExtensionId;
    private final String extensionName;

    public BlockedFileExtensionData(Long blockedFileExtensionId, ExtensionName extensionName) {
        this.blockedFileExtensionId = blockedFileExtensionId;
        this.extensionName = extensionName.toLowerCase();
    }
}
