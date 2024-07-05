package com.extension.block.extension.repository;

import com.extension.block.extension.domain.entity.SafeFileExtension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SafeFileExtensionRepository extends JpaRepository<SafeFileExtension, Long> {

}
