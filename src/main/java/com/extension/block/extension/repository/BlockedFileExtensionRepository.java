package com.extension.block.extension.repository;

import com.extension.block.extension.domain.entity.BlockedFileExtension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockedFileExtensionRepository extends JpaRepository<BlockedFileExtension, Long>, BlockedFileExtensionQueryDSLRepository {
}
