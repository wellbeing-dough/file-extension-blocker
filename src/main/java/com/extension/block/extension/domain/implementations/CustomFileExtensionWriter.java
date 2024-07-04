package com.extension.block.extension.domain.implementations;

import com.extension.block.extension.domain.entity.CustomFileExtension;
import com.extension.block.extension.repository.CustomFileExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class CustomFileExtensionWriter {

    private final CustomFileExtensionRepository customFileExtensionRepository;


    public void write(CustomFileExtension customFileExtension) {
        customFileExtensionRepository.save(customFileExtension);
    }
}
