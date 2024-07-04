package com.extension.block.extension.ui;

import com.extension.block.extension.application.FileExtensionService;
import com.extension.block.extension.ui.dto.request.AddCustomExtensionRequest;
import com.extension.block.extension.ui.dto.response.CustomFileExtensionResponse;
import com.extension.block.extension.ui.dto.response.FixedFileExtensionResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FileExtensionController {

    private final FileExtensionService fileExtensionService;

    @Operation(summary = "커스텀 확장자들 조회")
    @GetMapping("/v1/file/custom-extension/{member-id}")
    public ResponseEntity<CustomFileExtensionResponse> getCustomExtensions(@PathVariable("member-id") Long memberId) {
        return ResponseEntity.ok().body(fileExtensionService.getCustomExtensions(memberId));
    }

    @Operation(summary = "커스텀 확장자 추가")
    @PostMapping("/v1/file/custom-extension/{member-id}")
    public ResponseEntity<HttpStatus> addCustomExtension(@RequestBody @Valid AddCustomExtensionRequest request,
                                                         @PathVariable("member-id") Long memberId) {
        fileExtensionService.addCustomExtension(request.getExtensionName(), memberId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "커스텀 확장자 삭제")
    @DeleteMapping("/v1/file/custom-extension/{extension-id}/{member-id}")
    public ResponseEntity<HttpStatus> deleteCustomExtension(@PathVariable("extension-id") Long extensionId, @PathVariable("member-id") Long memberId) {
        fileExtensionService.deleteCustomExtension(extensionId, memberId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "고정 파일 확장자 조회")
    @GetMapping("/v1/file/fixed-extension")
    public ResponseEntity<FixedFileExtensionResponse> getFixedExtensions() {
        return ResponseEntity.ok().body(fileExtensionService.getFixedExtensions());
    }
}
