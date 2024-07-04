package com.extension.block.extension.exception;

import com.extension.block.common.exception.ErrorCode;

public class FileExtensionNotFoundException extends FileExtensionDomainLogicException {
    public FileExtensionNotFoundException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
