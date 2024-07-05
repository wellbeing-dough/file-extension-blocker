package com.extension.block.extension.domain.implementations;

import com.extension.block.extension.domain.entity.CustomBlockFileExtension;
import com.extension.block.extension.repository.CustomBlockFileExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class CustomBlockFileExtensionWriter {

    private final CustomBlockFileExtensionRepository customBlockFileExtensionRepository;


    public void write(CustomBlockFileExtension customBlockFileExtension) {
        customBlockFileExtensionRepository.save(customBlockFileExtension);
    }

    public void delete(CustomBlockFileExtension customBlockFileExtension) {
        customBlockFileExtension.delete();
        customBlockFileExtensionRepository.save(customBlockFileExtension);
    }
}
