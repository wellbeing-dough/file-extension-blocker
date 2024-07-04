package com.extension.block.extension.repository;

import com.extension.block.extension.domain.entity.DangerExtension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DangerExtensionRepository extends JpaRepository<DangerExtension, Long> {
}
