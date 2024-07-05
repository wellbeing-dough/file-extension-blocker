package com.extension.block.extension.repository;

import com.extension.block.extension.repository.dto.CustomFileExtensionData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomBlockFileExtensionQueryDSLRepository {
    List<CustomFileExtensionData> findCustomBlockExtension();
}
