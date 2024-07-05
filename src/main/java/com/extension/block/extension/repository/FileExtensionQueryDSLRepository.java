package com.extension.block.extension.repository;

import com.extension.block.extension.repository.dto.BlockFixedFileExtensionData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileExtensionQueryDSLRepository {
    List<BlockFixedFileExtensionData> findAllFixedExtensions();

}
