package com.extension.block.extension.repository;

import com.extension.block.extension.domain.entity.CustomExtension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomExtensionRepository extends JpaRepository<CustomExtension, Long> {
}
