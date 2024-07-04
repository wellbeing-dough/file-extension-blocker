package com.extension.block.extension.repository;

import com.extension.block.extension.domain.entity.FileExtension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileExtensionRepository extends JpaRepository<FileExtension, Long> {
}
