package com.extension.block.extension.application;

import com.extension.block.extension.domain.component.ExtensionName;
import com.extension.block.extension.domain.entity.CustomBlockFileExtension;
import com.extension.block.extension.domain.entity.FileExtension;
import com.extension.block.extension.domain.implementations.*;
import com.extension.block.extension.repository.dto.CustomFileExtensionData;
import com.extension.block.extension.repository.dto.FixedFileExtensionData;
import com.extension.block.extension.ui.dto.response.BlockFixedFileExtensionResponse;
import com.extension.block.extension.ui.dto.response.CustomFileExtensionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileExtensionService {

    private final FileExtensionReader fileExtensionReader;
    private final CustomFileExtensionReader customFileExtensionReader;
    private final CustomBlockFileExtensionValidator customBlockFileExtensionValidator;
    private final CustomBlockFileExtensionWriter customBlockFileExtensionWriter;
    private final CustomBlockFileExtensionReader customBlockFileExtensionReader;

    public CustomFileExtensionResponse getBlockedExtensions() {
        List<CustomFileExtensionData> customFileExtensionData = customFileExtensionReader.readCustomBlockExtension();
        List<FixedFileExtensionData> fixedFileExtensionData = customFileExtensionReader.readFixedBlockExtension();
        return new CustomFileExtensionResponse(customFileExtensionData, fixedFileExtensionData);
    }

    public void addCustomExtension(ExtensionName extensionName) {
        customBlockFileExtensionValidator.validIsCountOver();
        FileExtension fileExtension = fileExtensionReader.readByExtensionName(extensionName);
        customBlockFileExtensionValidator.validAlreadyExistsBlockedFileExtension(fileExtension);
        CustomBlockFileExtension customBlockFileExtension = new CustomBlockFileExtension(fileExtension.getId());
        customBlockFileExtensionWriter.write(customBlockFileExtension);
    }

    public void deleteCustomExtension(Long customBlockExtensionId) {
        CustomBlockFileExtension customBlockFileExtension = customBlockFileExtensionReader.readById(customBlockExtensionId);
        customBlockFileExtensionWriter.delete(customBlockFileExtension);
    }

    public BlockFixedFileExtensionResponse getBlockFixedExtensions() {
        return new BlockFixedFileExtensionResponse(fileExtensionReader.readListByFixedExtensions());
    }
}
