package com.extension.block.extension.repository;

import com.extension.block.extension.repository.dto.FixedFileExtensionData;
import com.extension.block.extension.repository.dto.UnknownFileExtensionData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileExtensionQueryDSLRepository {
    List<FixedFileExtensionData> findAllFixedExtensions();

    List<UnknownFileExtensionData> findAllUnknownExtensions();
}
