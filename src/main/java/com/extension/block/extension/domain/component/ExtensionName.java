package com.extension.block.extension.domain.component;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

}
