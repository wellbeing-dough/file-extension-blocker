package com.extension.block.extension.domain.implementations;

import com.extension.block.common.exception.ErrorCode;
import com.extension.block.extension.domain.entity.CustomFileExtension;
import com.extension.block.member.exception.MemberAccessRightException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomFileExtensionValidator {

    public void validateIsMembersCustomFileExtension(CustomFileExtension customFileExtension, Long memberId) {
        if (!customFileExtension.isMembersExtension(memberId)) {
            throw new MemberAccessRightException(
                    ErrorCode.MEMBER_ACCESS_RIGHT_ERROR,
                    ErrorCode.MEMBER_ACCESS_RIGHT_ERROR.getStatusMessage()
            );
        }
    }
}
