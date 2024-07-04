package com.extension.block.extension.domain.implementations;

import com.extension.block.extension.repository.FixedFileExtensionRepository;
import com.extension.block.extension.repository.dto.FixedFileExtensionData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FixedFileExtensionReader {

    private final FixedFileExtensionRepository fileExtensionRepository;

    public List<FixedFileExtensionData> readListByFixedExtensions() {
        return fileExtensionRepository.findAllFixedExtensions();
    }
}
