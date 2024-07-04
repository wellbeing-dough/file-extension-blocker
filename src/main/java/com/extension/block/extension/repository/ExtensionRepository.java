package com.extension.block.extension.repository;

import com.extension.block.extension.domain.entity.Extension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtensionRepository extends JpaRepository<Extension, Long> {
}
