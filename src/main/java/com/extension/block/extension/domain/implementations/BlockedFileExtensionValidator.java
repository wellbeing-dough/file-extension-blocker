package com.extension.block.extension.domain.implementations;

import com.extension.block.common.exception.ErrorCode;
import com.extension.block.extension.domain.entity.FileExtension;
import com.extension.block.extension.domain.enums.ExtensionStatus;
import com.extension.block.extension.exception.BlockedFileExtensionCountOverException;
import com.extension.block.extension.exception.FileExtensionAlreadyBlockedException;
import com.extension.block.extension.repository.BlockedFileExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BlockedFileExtensionValidator {

    private static final int BLOCKED_FILE_EXTENSION_COUNT_MAX = 200;

    private final BlockedFileExtensionRepository blockedFileExtensionRepository;

    public void validIsCountOver() {
        long extensionCount = blockedFileExtensionRepository.count();
        if (BLOCKED_FILE_EXTENSION_COUNT_MAX <= extensionCount) {
            throw new BlockedFileExtensionCountOverException(
                    ErrorCode.BLOCKED_FILE_EXTENSION_COUNT_EXCEEDS_ERROR,
                    ErrorCode.BLOCKED_FILE_EXTENSION_COUNT_EXCEEDS_ERROR.getStatusMessage(),
                    BLOCKED_FILE_EXTENSION_COUNT_MAX
            );
        }
    }

    public void validAlreadyExistsBlockedFileExtension(FileExtension fileExtension) {
        if (fileExtension.getExtensionStatus() == ExtensionStatus.BLOCKED) {
            throw new FileExtensionAlreadyBlockedException(
                    ErrorCode.FILE_EXTENSION_ALREADY_BLOCKED_ERROR,
                    ErrorCode.FILE_EXTENSION_ALREADY_BLOCKED_ERROR.getStatusMessage(),
                    fileExtension.getExtensionName().getValue()
            );
        }
    }

}
