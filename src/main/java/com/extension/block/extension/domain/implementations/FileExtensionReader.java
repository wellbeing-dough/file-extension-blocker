package com.extension.block.extension.domain.implementations;

import com.extension.block.common.exception.ErrorCode;
import com.extension.block.extension.domain.component.ExtensionName;
import com.extension.block.extension.domain.entity.FileExtension;
import com.extension.block.extension.exception.CustomBlockedFileExtensionNotFoundException;
import com.extension.block.extension.repository.FileExtensionRepository;
import com.extension.block.extension.repository.dto.BlockFixedFileExtensionData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FileExtensionReader {

    private final FileExtensionRepository fileExtensionRepository;

    public List<BlockFixedFileExtensionData> readListByFixedExtensions() {
        return fileExtensionRepository.findAllFixedExtensions();
    }

    //todo 지원하는 확장자가 없을 경우 이메일 전송 로직 추가
    public FileExtension readByExtensionName(ExtensionName extensionName) {
        return fileExtensionRepository.findByExtensionName(extensionName)
                .orElseThrow(() ->
                        new CustomBlockedFileExtensionNotFoundException(
                                ErrorCode.FILE_EXTENSION_NOT_SUPPORT_ERROR,
                                ErrorCode.FILE_EXTENSION_NOT_SUPPORT_ERROR.getStatusMessage()
                        )
                );
    }
}
