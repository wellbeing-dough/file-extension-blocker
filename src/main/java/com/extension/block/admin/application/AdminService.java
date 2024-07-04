package com.extension.block.admin.application;

import com.extension.block.admin.ui.dto.GetUnknownFileExtensionResponse;
import com.extension.block.extension.domain.entity.FileExtension;
import com.extension.block.extension.domain.enums.ExtensionSafetyStatus;
import com.extension.block.extension.domain.implementations.FileExtensionReader;
import com.extension.block.extension.domain.implementations.FileExtensionWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final FileExtensionReader fileExtensionReader;
    private final FileExtensionWriter fileExtensionWriter;


    public GetUnknownFileExtensionResponse getUnknownFileExtensions() {
        return new GetUnknownFileExtensionResponse(fileExtensionReader.readListByUnknownExtensions());
    }

    public void updateUnknownFileExtensions(Long extensionId, ExtensionSafetyStatus status) {
        FileExtension fileExtension = fileExtensionReader.readById(extensionId);
        fileExtensionWriter.updateSafetyStatus(fileExtension, status);
    }
}
