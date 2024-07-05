package com.extension.block.extension.domain.implementations;

import com.extension.block.common.exception.ErrorCode;
import com.extension.block.extension.domain.component.ExtensionName;
import com.extension.block.extension.exception.DangerFileExtensionAccessException;
import com.extension.block.extension.repository.DangerFileExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DangerFileExtensionValidator {

    private final DangerFileExtensionRepository dangerFileExtensionRepository;

    public void validIsDangerFileExtension(ExtensionName extensionName) {
        if (dangerFileExtensionRepository.existsByExtensionName(extensionName)) {
            throw new DangerFileExtensionAccessException(
                    ErrorCode.DANGER_FILE_EXTENSION_ACCESS_ERROR,
                    ErrorCode.DANGER_FILE_EXTENSION_ACCESS_ERROR.getStatusMessage(),
                    extensionName.getValue()
            );
        }
    }

}
