package com.extension.block.extension.domain.implementations;

import com.extension.block.common.exception.ErrorCode;
import com.extension.block.extension.domain.entity.CustomFileExtension;
import com.extension.block.extension.exception.CustomFileExtensionNotFoundException;
import com.extension.block.extension.repository.CustomFileExtensionRepository;
import com.extension.block.extension.repository.dto.MembersCustomFileExtensionData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomFileExtensionReader {

    private final CustomFileExtensionRepository customFileExtensionRepository;

    public List<MembersCustomFileExtensionData> readListByMemberId(Long memberId) {
        return customFileExtensionRepository.findCustomFileExtensionListByMemberId(memberId);
    }

    public CustomFileExtension readById(Long customExtensionId) {
        return customFileExtensionRepository.findById(customExtensionId)
                .orElseThrow(() ->
                        new CustomFileExtensionNotFoundException(
                                ErrorCode.CUSTOM_FILE_EXTENSION_NOT_FOUND_ERROR,
                                ErrorCode.CUSTOM_FILE_EXTENSION_NOT_FOUND_ERROR.getStatusMessage()
                        )
                );
    }

}
