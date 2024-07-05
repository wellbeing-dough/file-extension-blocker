package com.extension.block.extension.domain.implementations;

import com.extension.block.common.exception.ErrorCode;
import com.extension.block.extension.domain.component.ExtensionName;
import com.extension.block.extension.domain.entity.SafeFileExtension;
import com.extension.block.extension.exception.FileExtensionNameNotFoundException;
import com.extension.block.extension.repository.SafeFileExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SafeFileExtensionReader {

    private final SafeFileExtensionRepository safeFileExtensionRepository;

    public SafeFileExtension readByExtensionName(ExtensionName extensionName) {
        return safeFileExtensionRepository.findByExtensionName(extensionName)
                .orElseThrow(() ->
                        new FileExtensionNameNotFoundException(
                                ErrorCode.FILE_EXTENSION_NOT_SUPPORT_ERROR,
                                ErrorCode.FILE_EXTENSION_NOT_SUPPORT_ERROR.getStatusMessage()
                        )
                );
    }

}
