package com.extension.block.admin.ui.dto;

import com.extension.block.extension.domain.enums.ExtensionSafetyStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UpdateUnknownFileExtensionRequest {

    private Long extensionId;
    private ExtensionSafetyStatus status;

}
