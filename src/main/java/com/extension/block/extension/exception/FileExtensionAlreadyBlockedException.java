package com.extension.block.extension.exception;

import com.extension.block.common.exception.ErrorCode;

public class FileExtensionAlreadyBlockedException extends FileExtensionDomainLogicException {
    public FileExtensionAlreadyBlockedException(ErrorCode errorCode, String logMessage, String findData) {
        super(errorCode, logMessage + " " + findData);
    }
}
