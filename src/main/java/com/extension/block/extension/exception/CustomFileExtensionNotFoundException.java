package com.extension.block.extension.exception;

import com.extension.block.common.exception.ErrorCode;

public class CustomFileExtensionNotFoundException extends FileExtensionDomainLogicException {
    public CustomFileExtensionNotFoundException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
