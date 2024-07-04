package com.extension.block.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    MEMBER_NOT_FOUND_ERROR(404, "0100", "해당 식별자를 갖는 유저가 존재하지 않습니다."),
    MEMBER_ACCESS_RIGHT_ERROR(412, "0101", "점근 권한이 없는 유저입니다"),

    DANGER_FILE_EXTENSION_ACCESS_ERROR(404, "0201", "해당 확장자는 보안상 위험한 확장자 입니다."),
    FILE_EXTENSION_NOT_FOUND_ERROR(404, "0202", "해당 확장자는 지원하지 않습니다 '문의하기' 로 문의해 주세요."),
    CUSTOM_FILE_EXTENSION_NOT_FOUND_ERROR(404, "0203", "해당 식별자를 갖는 확장자가 없습니다.");

    private final int status;
    private final String code;
    private final String statusMessage;

    ErrorCode(int status, String code, String statusMessage) {
        this.status = status;
        this.code = code;
        this.statusMessage = statusMessage;
    }
}
