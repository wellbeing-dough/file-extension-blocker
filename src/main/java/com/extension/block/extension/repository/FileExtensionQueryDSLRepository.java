package com.extension.block.extension.repository;

import com.extension.block.extension.domain.component.ExtensionName;
import com.extension.block.extension.domain.entity.FileExtension;
import com.extension.block.extension.repository.dto.FixedFileExtensionData;
import com.extension.block.extension.repository.dto.UnknownFileExtensionData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileExtensionQueryDSLRepository {
    List<FixedFileExtensionData> findAllFixedExtensions();

    List<UnknownFileExtensionData> findAllUnknownExtensions();

    Optional<FileExtension> findUnDangerByExtensionName(ExtensionName extensionName);
}
