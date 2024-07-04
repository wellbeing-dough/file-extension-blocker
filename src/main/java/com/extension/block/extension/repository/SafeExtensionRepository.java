package com.extension.block.extension.repository;

import com.extension.block.extension.domain.entity.SafeExtension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SafeExtensionRepository extends JpaRepository<SafeExtension, Long> {
}
