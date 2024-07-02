package com.extension.block.extension.ui;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequiredArgsConstructor
public class FileExtensionController {

    @Value("${swagger.url}")
    private String swaggerUrl;

    @Operation(summary = "선택 인증 여부 조회")
    @PostMapping("/v1/hello")
    public ResponseEntity<HttpStatus> priorityChoiceRecommendUser() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    public RedirectView redirectToSwagger() {
        return new RedirectView(swaggerUrl);
    }

}
