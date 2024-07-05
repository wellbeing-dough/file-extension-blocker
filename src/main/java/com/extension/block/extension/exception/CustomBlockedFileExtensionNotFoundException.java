package com.extension.block.extension.exception;

import com.extension.block.common.exception.ErrorCode;

public class CustomBlockedFileExtensionNotFoundException extends FileExtensionDomainLogicException {
    public CustomBlockedFileExtensionNotFoundException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
