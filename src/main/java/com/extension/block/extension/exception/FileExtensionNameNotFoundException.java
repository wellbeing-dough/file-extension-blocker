package com.extension.block.extension.exception;

import com.extension.block.common.exception.ErrorCode;

public class FileExtensionNameNotFoundException extends FileExtensionDomainLogicException {
    public FileExtensionNameNotFoundException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
