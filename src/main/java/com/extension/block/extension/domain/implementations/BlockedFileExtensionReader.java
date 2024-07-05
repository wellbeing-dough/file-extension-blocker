package com.extension.block.extension.domain.implementations;

import com.extension.block.common.exception.ErrorCode;
import com.extension.block.extension.domain.entity.BlockedFileExtension;
import com.extension.block.extension.exception.BlockedFileExtensionNotFoundException;
import com.extension.block.extension.repository.BlockedFileExtensionRepository;
import com.extension.block.extension.repository.dto.BlockedFileExtensionData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BlockedFileExtensionReader {

    private final BlockedFileExtensionRepository blockedFileExtensionRepository;


    public List<BlockedFileExtensionData> readAllExtension() {
        return blockedFileExtensionRepository.findAllBlockedFileExtension();
    }


    public BlockedFileExtension readById(Long customExtensionId) {
        return blockedFileExtensionRepository.findById(customExtensionId)
                .orElseThrow( () ->
                        new BlockedFileExtensionNotFoundException(
                                ErrorCode.BLOCKED_FILE_EXTENSION_NOT_FOUND_ERROR,
                                ErrorCode.BLOCKED_FILE_EXTENSION_NOT_FOUND_ERROR.getStatusMessage()
                        )
                );
    }
}
