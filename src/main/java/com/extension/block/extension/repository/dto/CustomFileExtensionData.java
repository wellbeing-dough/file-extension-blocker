package com.extension.block.extension.repository.dto;

import com.extension.block.extension.domain.component.ExtensionName;
import lombok.Getter;

@Getter
public class CustomFileExtensionData {

    private final Long customFileExtensionId;
    private final String extensionName;

    public CustomFileExtensionData(Long customFileExtensionId, ExtensionName extensionName) {
        this.customFileExtensionId = customFileExtensionId;
        this.extensionName = extensionName.toLowerCase();
    }
}
