package com.extension.block.extension.repository;

import com.extension.block.extension.domain.component.ExtensionName;
import com.extension.block.extension.domain.entity.FileExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileExtensionRepository extends JpaRepository<FileExtension, Long>, FileExtensionQueryDSLRepository {
    Optional<FileExtension> findByExtensionName(ExtensionName extensionName);
}
