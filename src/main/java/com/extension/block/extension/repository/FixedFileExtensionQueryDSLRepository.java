package com.extension.block.extension.repository;

import com.extension.block.extension.repository.dto.FixedFileExtensionData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FixedFileExtensionQueryDSLRepository {
    List<FixedFileExtensionData> findAllFixedExtensions();

}
