package com.extension.block.extension.application;

import com.extension.block.extension.domain.component.ExtensionName;
import com.extension.block.extension.domain.entity.BlockedFileExtension;
import com.extension.block.extension.domain.entity.FileExtension;
import com.extension.block.extension.domain.enums.ExtensionStatus;
import com.extension.block.extension.domain.implementations.*;
import com.extension.block.extension.ui.dto.response.BlockFileExtensionResponse;
import com.extension.block.extension.ui.dto.response.BlockFixedFileExtensionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileExtensionService {

    private final BlockedFileExtensionValidator blockedFileExtensionValidator;
    private final BlockedFileExtensionReader blockedFileExtensionReader;
    private final FileExtensionReader fileExtensionReader;
    private final FileExtensionWriter fileExtensionWriter;
    private final BlockedFileExtensionWriter blockedFileExtensionWriter;

    public BlockFileExtensionResponse getBlockedExtensions() {
        return new BlockFileExtensionResponse(blockedFileExtensionReader.readAllExtension());
    }

    public void blockExtension(ExtensionName extensionName) {
        blockedFileExtensionValidator.validIsCountOver();
        FileExtension fileExtension = fileExtensionReader.readByExtensionName(extensionName);
        blockedFileExtensionValidator.validAlreadyExistsBlockedFileExtension(fileExtension);
        fileExtensionWriter.updateExtensionStatus(fileExtension, ExtensionStatus.BLOCKED);
    }

    public void deleteBlockedExtension(Long extensionId) {
        BlockedFileExtension blockedFileExtension = blockedFileExtensionReader.readById(extensionId);
        blockedFileExtensionWriter.updateExtensionStatus(blockedFileExtension, ExtensionStatus.SAFE);
    }

    public BlockFixedFileExtensionResponse getBlockFixedExtensions() {
        return new BlockFixedFileExtensionResponse(fileExtensionReader.readListByFixedExtensions());
    }
}
