package com.extension.block.extension.exception;

import com.extension.block.common.exception.ErrorCode;

public class AlreadyExistCustomFileExtensionException extends FileExtensionDomainLogicException {
    public AlreadyExistCustomFileExtensionException(ErrorCode errorCode, String logMessage, String findData) {
        super(errorCode, logMessage + " " + findData);
    }
}
