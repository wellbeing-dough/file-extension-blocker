package com.extension.block.extension.domain.implementations;

import com.extension.block.common.exception.ErrorCode;
import com.extension.block.extension.domain.entity.CustomBlockFileExtension;
import com.extension.block.extension.exception.CustomBlockedFileExtensionNotFoundException;
import com.extension.block.extension.repository.CustomBlockFileExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomBlockFileExtensionReader {

    private final CustomBlockFileExtensionRepository customBlockFileExtensionRepository;

    public CustomBlockFileExtension readById(Long customBlockExtensionId) {
        return customBlockFileExtensionRepository.findById(customBlockExtensionId)
                .orElseThrow( () ->
                        new CustomBlockedFileExtensionNotFoundException(
                                ErrorCode.CUSTOM_BLOCKED_FILE_EXTENSION_NOT_FOUND_ERROR,
                                ErrorCode.CUSTOM_BLOCKED_FILE_EXTENSION_NOT_FOUND_ERROR.getStatusMessage()
                        )
                );
    }
}
