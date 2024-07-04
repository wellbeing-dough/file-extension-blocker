package com.extension.block.extension.domain.enums;

import lombok.Getter;

@Getter
public enum ExtensionSafetyStatus {


    SAFE("안전"),
    DANGER("위험"),
    UNKNOWN("알 수 없음");

    private final String value;

    ExtensionSafetyStatus(String value) {
        this.value = value;
    }
}
