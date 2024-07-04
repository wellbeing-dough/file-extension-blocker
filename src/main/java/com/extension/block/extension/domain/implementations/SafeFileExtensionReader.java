package com.extension.block.extension.domain.implementations;

import com.extension.block.common.exception.ErrorCode;
import com.extension.block.extension.domain.entity.SafeFileExtension;
import com.extension.block.extension.exception.FileExtensionNameNotFoundException;
import com.extension.block.extension.repository.SafeFileExtensionRepository;
import com.extension.block.extension.repository.dto.FixedFileExtensionData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SafeFileExtensionReader {

    private final SafeFileExtensionRepository safeFileExtensionRepository;

    public List<FixedFileExtensionData> readListByFixedExtensions() {
        return safeFileExtensionRepository.findAllFixedExtensions();
    }

    public SafeFileExtension readByExtensionName(String extensionName) {
        return safeFileExtensionRepository.findByExtensionName(extensionName)
                .orElseThrow(() ->
                        new FileExtensionNameNotFoundException(
                                ErrorCode.FILE_EXTENSION_NOT_FOUND_ERROR,
                                ErrorCode.FILE_EXTENSION_NOT_FOUND_ERROR.getStatusMessage()
                        )
                );
    }

}
