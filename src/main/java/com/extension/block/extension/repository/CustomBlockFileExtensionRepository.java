package com.extension.block.extension.repository;

import com.extension.block.extension.domain.entity.CustomBlockFileExtension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomBlockFileExtensionRepository extends JpaRepository<CustomBlockFileExtension, Long>, CustomBlockFileExtensionQueryDSLRepository {
    boolean existsByFileExtensionId(Long fileExtensionId);
}
