package com.extension.block.extension.exception;

import com.extension.block.common.exception.ErrorCode;

public class CustomFileExtensionCountOverException extends FileExtensionDomainLogicException {
    public CustomFileExtensionCountOverException(ErrorCode errorCode, String logMessage, int findData) {
        super(errorCode, logMessage + "최대: " + findData);
    }
}
