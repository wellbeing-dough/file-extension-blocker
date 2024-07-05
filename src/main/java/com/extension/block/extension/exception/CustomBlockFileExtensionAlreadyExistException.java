package com.extension.block.extension.exception;

import com.extension.block.common.exception.ErrorCode;

public class CustomBlockFileExtensionAlreadyExistException extends FileExtensionDomainLogicException {
    public CustomBlockFileExtensionAlreadyExistException(ErrorCode errorCode, String logMessage, String findData) {
        super(errorCode, logMessage + " " + findData);
    }
}
