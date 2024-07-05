package com.extension.block.extension.domain.implementations;

import com.extension.block.common.exception.ErrorCode;
import com.extension.block.extension.domain.entity.FileExtension;
import com.extension.block.extension.exception.CustomBlockFileExtensionCountOverException;
import com.extension.block.extension.exception.CustomBlockFileExtensionAlreadyExistException;
import com.extension.block.extension.repository.CustomBlockFileExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomBlockFileExtensionValidator {

    private static final int CUSTOM_BLOCK_FILE_EXTENSION_COUNT_MAX = 200;

    private final CustomBlockFileExtensionRepository customBlockFileExtensionRepository;

    public void validIsCountOver() {
        long extensionCount = customBlockFileExtensionRepository.count();
        if (CUSTOM_BLOCK_FILE_EXTENSION_COUNT_MAX <= extensionCount) {
            throw new CustomBlockFileExtensionCountOverException(
                    ErrorCode.CUSTOM_BLOCKED_FILE_EXTENSION_COUNT_EXCEEDS_ERROR,
                    ErrorCode.CUSTOM_BLOCKED_FILE_EXTENSION_COUNT_EXCEEDS_ERROR.getStatusMessage(),
                    CUSTOM_BLOCK_FILE_EXTENSION_COUNT_MAX
            );
        }
    }

    public void validAlreadyExistsBlockedFileExtension(FileExtension fileExtension) {
        if (customBlockFileExtensionRepository.existsByFileExtensionId(fileExtension.getId())) {
            throw new CustomBlockFileExtensionAlreadyExistException(
                    ErrorCode.CUSTOM_BLOCK_FILE_EXTENSION_ALREADY_EXIST_ERROR,
                    ErrorCode.CUSTOM_BLOCK_FILE_EXTENSION_ALREADY_EXIST_ERROR.getStatusMessage(),
                    fileExtension.getExtensionName().getValue()
            );
        }
    }
}
