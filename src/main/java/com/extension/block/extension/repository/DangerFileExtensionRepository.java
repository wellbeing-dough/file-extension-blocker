package com.extension.block.extension.repository;

import com.extension.block.extension.domain.component.ExtensionName;
import com.extension.block.extension.domain.entity.DangerFileExtension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DangerFileExtensionRepository extends JpaRepository<DangerFileExtension, Long> {
    boolean existsByExtensionName(ExtensionName extensionName);
}
