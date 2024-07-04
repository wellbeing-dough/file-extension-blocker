package com.extension.block.extension.domain.implementations;

import com.extension.block.extension.domain.entity.FileExtension;
import com.extension.block.extension.domain.enums.ExtensionSafetyStatus;
import com.extension.block.extension.repository.FileExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class FileExtensionWriter {

    private final FileExtensionRepository fileExtensionRepository;

    public void updateSafetyStatus(FileExtension fileExtension, ExtensionSafetyStatus status) {
        fileExtension.updateSafetyStatus(status);
        fileExtensionRepository.save(fileExtension);
    }
}
