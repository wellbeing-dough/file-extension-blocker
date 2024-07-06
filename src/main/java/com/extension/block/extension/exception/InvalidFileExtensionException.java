package com.extension.block.extension.exception;

import com.extension.block.common.exception.ErrorCode;

public class InvalidFileExtensionException extends FileExtensionDomainLogicException {
    public InvalidFileExtensionException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
