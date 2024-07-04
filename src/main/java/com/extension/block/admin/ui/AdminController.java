package com.extension.block.admin.ui;

import com.extension.block.admin.application.AdminService;
import com.extension.block.admin.ui.dto.GetUnknownFileExtensionResponse;
import com.extension.block.admin.ui.dto.UpdateUnknownFileExtensionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AdminController {
    
    private final AdminService adminService;
    
    @GetMapping("/v1/admin/inspection-extension")
    public ResponseEntity<GetUnknownFileExtensionResponse> getUnknownFileExtensions() {
        return ResponseEntity.ok().body(adminService.getUnknownFileExtensions());
    }

    @PutMapping("/v1/admin/inspection-extension")
    public ResponseEntity<HttpStatus> updateUnknownFileExtensions(@RequestBody UpdateUnknownFileExtensionRequest request) {
        adminService.updateUnknownFileExtensions(request.getExtensionId(), request.getStatus());
        return ResponseEntity.ok().build();
    }
}
