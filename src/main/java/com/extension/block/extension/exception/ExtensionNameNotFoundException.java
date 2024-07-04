package com.extension.block.extension.exception;

import com.extension.block.common.exception.ErrorCode;

public class ExtensionNameNotFoundException extends FileExtensionDomainLogicException {
    public ExtensionNameNotFoundException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
