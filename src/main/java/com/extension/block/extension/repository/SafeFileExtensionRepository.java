package com.extension.block.extension.repository;

import com.extension.block.extension.domain.component.ExtensionName;
import com.extension.block.extension.domain.entity.SafeFileExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SafeFileExtensionRepository extends JpaRepository<SafeFileExtension, Long> {

    Optional<SafeFileExtension> findByExtensionName(ExtensionName extensionName);
}
