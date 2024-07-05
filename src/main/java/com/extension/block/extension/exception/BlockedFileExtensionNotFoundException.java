package com.extension.block.extension.exception;

import com.extension.block.common.exception.ErrorCode;

public class BlockedFileExtensionNotFoundException extends FileExtensionDomainLogicException {
    public BlockedFileExtensionNotFoundException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
