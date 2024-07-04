package com.extension.block.extension.repository.dto;

import lombok.Getter;

@Getter
public class MembersCustomFileExtensionData {

    private final Long customFileExtensionId;
    private final String extensionName;

    public MembersCustomFileExtensionData(Long customFileExtensionId, String extensionName) {
        this.customFileExtensionId = customFileExtensionId;
        this.extensionName = extensionName;
    }
}
