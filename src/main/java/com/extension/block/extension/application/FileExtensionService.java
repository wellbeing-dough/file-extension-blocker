package com.extension.block.extension.application;


import com.extension.block.extension.domain.implementations.FileExtensionReader;
import com.extension.block.extension.domain.implementations.FileExtensionWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileExtensionService {

    private final FileExtensionReader fileExtensionReader;

    private final FileExtensionWriter fileExtensionWriter;

}
