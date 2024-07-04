package com.extension.block.member.exception;

import com.extension.block.common.exception.ErrorCode;

public class MemberAccessRightException extends MemberDomainLogicException {
    public MemberAccessRightException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}
