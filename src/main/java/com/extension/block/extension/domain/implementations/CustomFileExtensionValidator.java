package com.extension.block.extension.domain.implementations;

import com.extension.block.common.exception.ErrorCode;
import com.extension.block.extension.domain.entity.CustomFileExtension;
import com.extension.block.extension.exception.CustomFileExtensionCountOverException;
import com.extension.block.member.exception.MemberAccessRightException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomFileExtensionValidator {

    private static final int CUSTOM_FILE_EXTENSION_COUNT_MAX = 200;
    private final CustomFileExtensionReader customFileExtensionReader;

    public void validIsMembersCustomFileExtension(CustomFileExtension customFileExtension, Long memberId) {
        if (!customFileExtension.isMembersExtension(memberId)) {
            throw new MemberAccessRightException(
                    ErrorCode.MEMBER_ACCESS_RIGHT_ERROR,
                    ErrorCode.MEMBER_ACCESS_RIGHT_ERROR.getStatusMessage()
            );
        }
    }

    public void validIsCustomFileExtensionCountOver(Long memberId) {
        long extensionCount = customFileExtensionReader.readCountByMemberId(memberId);
        if (CUSTOM_FILE_EXTENSION_COUNT_MAX <= extensionCount) {
            throw new CustomFileExtensionCountOverException(
                    ErrorCode.CUSTOM_FILE_EXTENSION_COUNT_EXCEEDS_ERROR,
                    ErrorCode.CUSTOM_FILE_EXTENSION_COUNT_EXCEEDS_ERROR.getStatusMessage(),
                    CUSTOM_FILE_EXTENSION_COUNT_MAX
            );
        }
    }
}
