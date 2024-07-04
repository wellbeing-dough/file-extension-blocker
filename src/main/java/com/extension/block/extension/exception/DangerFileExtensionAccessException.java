package com.extension.block.extension.exception;

import com.extension.block.common.exception.DomainLogicException;
import com.extension.block.common.exception.ErrorCode;

public class DangerFileExtensionAccessException extends DomainLogicException {
    public DangerFileExtensionAccessException(ErrorCode errorCode, String logMessage, String findData) {
        super(errorCode, logMessage + findData);
    }
}
