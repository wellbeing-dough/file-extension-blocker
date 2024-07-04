package com.extension.block.extension.ui.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AddCustomExtensionRequest {

    @Schema(description = "추가할 확장자 명", example = "jpg")
    @NotBlank(message = "값은 필수 입니다")
    @Size(max = 20, message = "확장자 명은 최대 20글자 입니다")
    private String extensionName;

}
