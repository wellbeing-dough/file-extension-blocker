package com.extension.block.extension.domain.component;

import com.extension.block.common.exception.ErrorCode;
import com.extension.block.extension.exception.InvalidFileExtensionException;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.regex.Pattern;

@Embeddable
@NoArgsConstructor
@Getter
public class ExtensionName {

    private String value;
    // 정규 표현식: 시작에 선택적으로 마침표, 느낌표, 언더스코어 중 하나가 올 수 있고, 중간에는 알파벳 대문자, 숫자, 하이픈, 언더스코어, 끝에는 선택적으로 마침표, 하이픈, 언더스코어, 느낌표 중 하나가 올 수 있다
    private static final Pattern EXTENSION_PATTERN = Pattern.compile("^[\\.!_]?([A-Z0-9_-]+)[\\.!_\\-]?$");

    public ExtensionName(String value) {
        value = value.toUpperCase();
        value = removeLeadingDot(value);
        isValidExtensionPattern(value);
        this.value = value;
    }

    private String removeLeadingDot(String value) {
        if (value.startsWith(".")) {
            return value.substring(1);
        }
        return value;
    }

    public void isValidExtensionPattern(String value) {
        if (!EXTENSION_PATTERN.matcher(value).matches()) {
            throw new InvalidFileExtensionException(
                    ErrorCode.INVALID_FILE_EXTENSION_ERROR,
                    ErrorCode.INVALID_FILE_EXTENSION_ERROR.getStatusMessage()
            );
        }
    }

    public String toLowerCase() {
        return value.toLowerCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtensionName that = (ExtensionName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
