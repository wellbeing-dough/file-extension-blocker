package com.extension.block.extension.domain.enums;

import lombok.Getter;

@Getter
public enum ExtensionStatus {


    BLOCKED("차단"),
    SAFE("안전"),
    BLOCK_FIXED("고정 차단");
    private final String value;

    ExtensionStatus(String value) {
        this.value = value;
    }
}
