package com.extension.block.extension.domain.implementations;

import com.extension.block.extension.repository.CustomBlockFileExtensionRepository;
import com.extension.block.extension.repository.dto.CustomFileExtensionData;
import com.extension.block.extension.repository.dto.FixedFileExtensionData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomFileExtensionReader {

    private final CustomBlockFileExtensionRepository customFileExtensionRepository;


    public List<CustomFileExtensionData> readCustomBlockExtension() {
        return customFileExtensionRepository.findCustomBlockExtension();
    }

    public List<FixedFileExtensionData> readFixedBlockExtension() {
        return customFileExtensionRepository.findFixedBlockExtension();
    }
}
