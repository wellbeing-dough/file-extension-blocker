package com.extension.block.extension.exception;

import com.extension.block.common.exception.DomainLogicException;
import com.extension.block.common.exception.ErrorCode;

public class FileExtensionDomainLogicException extends DomainLogicException {
    public FileExtensionDomainLogicException(ErrorCode errorCode, String logMessage) {
        super(errorCode, logMessage);
    }
}
