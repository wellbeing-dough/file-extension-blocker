package com.extension.block.extension.domain.implementations;

import com.extension.block.extension.repository.FileExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class FileExtensionWriter {

    private final FileExtensionRepository fileExtensionRepository;


}
