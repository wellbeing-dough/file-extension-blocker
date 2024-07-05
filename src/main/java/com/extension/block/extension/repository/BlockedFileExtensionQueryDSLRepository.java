package com.extension.block.extension.repository;

import com.extension.block.extension.repository.dto.BlockedFileExtensionData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockedFileExtensionQueryDSLRepository {
    List<BlockedFileExtensionData> findAllBlockedFileExtension();
}
