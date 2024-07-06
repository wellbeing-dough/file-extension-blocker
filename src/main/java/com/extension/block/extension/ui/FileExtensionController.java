package com.extension.block.extension.ui;

import com.extension.block.extension.application.FileExtensionService;
import com.extension.block.extension.domain.component.ExtensionName;
import com.extension.block.extension.domain.implementations.FileExtensionsCrawler;
import com.extension.block.extension.ui.dto.request.CustomBlockExtensionRequest;
import com.extension.block.extension.ui.dto.response.CustomFileExtensionResponse;
import com.extension.block.extension.ui.dto.response.BlockFixedFileExtensionResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FileExtensionController {

    private final FileExtensionsCrawler fileExtensionsCrawler;
    private final FileExtensionService fileExtensionService;

    @PostMapping("/v1/crawling")
    public ResponseEntity<HttpStatus> crawling() throws IOException {
        fileExtensionsCrawler.crawlAndSave();
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "전체 차단 확장자들 조회")
    @GetMapping("/v1/file/all/block-extensions")
    public ResponseEntity<CustomFileExtensionResponse> getBlockedExtensions() {
        return ResponseEntity.ok().body(fileExtensionService.getBlockedExtensions());
    }

    @Operation(summary = "커스텀 차단 확장자 추가")
    @PostMapping("/v1/file/custom/block-extensions")
    public ResponseEntity<HttpStatus> addCustomExtension(@RequestBody @Valid CustomBlockExtensionRequest request) {
        fileExtensionService.addCustomExtension(new ExtensionName(request.getExtensionName()));
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "커스텀 차단 확장자 삭제")
    @DeleteMapping("/v1/file/custom/{custom-block-extension-id}/block-extensions")
    public ResponseEntity<HttpStatus> deleteCustomExtension(@PathVariable("custom-block-extension-id") Long customBlockExtensionId) {
        fileExtensionService.deleteCustomExtension(customBlockExtensionId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "고정 차단 파일 확장자 조회")
    @GetMapping("/v1/file/fixed/block-extensions")
    public ResponseEntity<BlockFixedFileExtensionResponse> getBlockFixedExtensions() {
        return ResponseEntity.ok().body(fileExtensionService.getBlockFixedExtensions());
    }
}
