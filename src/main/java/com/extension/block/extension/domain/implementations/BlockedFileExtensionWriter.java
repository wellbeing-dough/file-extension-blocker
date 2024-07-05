package com.extension.block.extension.domain.implementations;

import com.extension.block.extension.domain.entity.BlockedFileExtension;
import com.extension.block.extension.domain.entity.FileExtension;
import com.extension.block.extension.domain.enums.ExtensionStatus;
import com.extension.block.extension.repository.BlockedFileExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class BlockedFileExtensionWriter {

    private final BlockedFileExtensionRepository blockedFileExtensionRepository;

    public void updateExtensionStatus(BlockedFileExtension blockedFileExtension, ExtensionStatus status) {
        blockedFileExtension.updateSafetyStatus(status);
        blockedFileExtensionRepository.save(blockedFileExtension);
    }
}
