package com.extension.block.extension.ui;

import com.extension.block.extension.domain.component.ExtensionsCrawler;
import com.extension.block.extension.ui.dto.response.CustomExtensionResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FileExtensionController {

    private final ExtensionsCrawler extensionsCrawler;

    @PostMapping("/v1/crawling")
    public ResponseEntity<HttpStatus> crawling() throws IOException {
        extensionsCrawler.crawlAndSave();
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "커스텀 확장자들 조회")
    @GetMapping("/v1/file-extension/{member-id}")
    public ResponseEntity<CustomExtensionResponse> getCustomExtensions(@PathVariable("member-id") String memberId) {
    }

    @Operation(summary = "커스텀 확장자 추가")
    @PostMapping("/v1/file-extension/{member-id}")
    public ResponseEntity<CustomExtensionResponse> addCustomExtensions(@PathVariable("member-id") String memberId) {

    }

    @Operation(summary = "커스텀 확장자 삭제")
    @DeleteMapping("/v1/file-extension/{member-id}")
    public ResponseEntity<HttpStatus> deleteCustomExtensions(@PathVariable("member-id") String memberId) {

    }
}
