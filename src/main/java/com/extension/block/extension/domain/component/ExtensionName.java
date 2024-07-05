package com.extension.block.extension.domain.component;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Embeddable
@NoArgsConstructor
@Getter
public class ExtensionName {

    private String value;

    public ExtensionName(String value) {
        this.value = value;
    }

    //생성자에 예외처리
    // queryDSL에 조회할떄 수정


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
