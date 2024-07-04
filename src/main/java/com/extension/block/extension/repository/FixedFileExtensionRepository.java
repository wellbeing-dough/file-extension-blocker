package com.extension.block.extension.repository;

import com.extension.block.extension.domain.entity.FixedFileExtension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixedFileExtensionRepository extends JpaRepository<FixedFileExtension, Long>, FixedFileExtensionQueryDSLRepository {

}
