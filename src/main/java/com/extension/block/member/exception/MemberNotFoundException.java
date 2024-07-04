package com.extension.block.member.exception;

import com.extension.block.common.exception.ErrorCode;

public class MemberNotFoundException extends MemberDomainLogicException {
    public MemberNotFoundException(ErrorCode errorCode, String message, String findData) {
        super(errorCode, message + findData);
    }
}
