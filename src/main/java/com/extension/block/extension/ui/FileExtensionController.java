package com.extension.block.extension.ui;

import com.extension.block.extension.application.FileExtensionService;
import com.extension.block.extension.domain.component.ExtensionName;
import com.extension.block.extension.domain.implementations.FileExtensionsCrawler;
import com.extension.block.extension.ui.dto.request.BlockExtensionRequest;
import com.extension.block.extension.ui.dto.response.BlockFileExtensionResponse;
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

    @Operation(summary = "차단 확장자들 조회")
    @GetMapping("/v1/file/block-extension")
    public ResponseEntity<BlockFileExtensionResponse> getBlockedExtensions() {
        return ResponseEntity.ok().body(fileExtensionService.getBlockedExtensions());
    }

    @Operation(summary = "차단 확장자 추가")
    @PostMapping("/v1/file/block-extension")
    public ResponseEntity<HttpStatus> blockExtension(@RequestBody @Valid BlockExtensionRequest request) {
        fileExtensionService.blockExtension(new ExtensionName(request.getExtensionName()));
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "차단 확장자 삭제")
    @DeleteMapping("/v1/file/{extension-id}/block-extension")
    public ResponseEntity<HttpStatus> deleteBlockedExtension(@PathVariable("extension-id") Long extensionId) {
        fileExtensionService.deleteBlockedExtension(extensionId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "고정 차단 파일 확장자 조회")
    @GetMapping("/v1/file/block-fixed-extension")
    public ResponseEntity<BlockFixedFileExtensionResponse> getBlockFixedExtensions() {
        return ResponseEntity.ok().body(fileExtensionService.getBlockFixedExtensions());
    }
}
