package com.extension.block.extension.domain.implementations;

import com.extension.block.common.exception.ErrorCode;
import com.extension.block.extension.domain.component.ExtensionName;
import com.extension.block.extension.domain.entity.FileExtension;
import com.extension.block.extension.domain.entity.SafeFileExtension;
import com.extension.block.extension.exception.FileExtensionNameNotFoundException;
import com.extension.block.extension.exception.FileExtensionNotFoundException;
import com.extension.block.extension.repository.FileExtensionRepository;
import com.extension.block.extension.repository.dto.FixedFileExtensionData;
import com.extension.block.extension.repository.dto.UnknownFileExtensionData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FileExtensionReader {

    private final FileExtensionRepository fileExtensionRepository;

    public List<FixedFileExtensionData> readListByFixedExtensions() {
        return fileExtensionRepository.findAllFixedExtensions();
    }

    public List<UnknownFileExtensionData> readListByUnknownExtensions() {
        return fileExtensionRepository.findAllUnknownExtensions();
    }

    public FileExtension readById(Long extensionId) {
        return fileExtensionRepository.findById(extensionId)
                .orElseThrow(() ->
                        new FileExtensionNotFoundException(
                                ErrorCode.FILE_EXTENSION_NOT_FOUND_ERROR,
                                ErrorCode.FILE_EXTENSION_NOT_FOUND_ERROR.getStatusMessage()
                        )
                );
    }

    public FileExtension readUnDangerByExtensionName(ExtensionName extensionName) {
        return fileExtensionRepository.findUnDangerByExtensionName(extensionName)
                .orElseThrow(() ->
                        new FileExtensionNameNotFoundException(
                                ErrorCode.FILE_EXTENSION_NOT_SUPPORT_ERROR,
                                ErrorCode.FILE_EXTENSION_NOT_SUPPORT_ERROR.getStatusMessage()
                        )
                );
    }
}
