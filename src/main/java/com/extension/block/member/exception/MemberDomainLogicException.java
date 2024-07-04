package com.extension.block.member.exception;

import com.extension.block.common.exception.DomainLogicException;
import com.extension.block.common.exception.ErrorCode;

public class MemberDomainLogicException extends DomainLogicException {
    public MemberDomainLogicException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

}
