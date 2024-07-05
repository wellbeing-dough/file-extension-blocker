package com.extension.block.extension.repository;

import com.extension.block.extension.domain.component.ExtensionName;
import com.extension.block.extension.domain.entity.CustomFileExtension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomFileExtensionRepository extends JpaRepository<CustomFileExtension, Long>, CustomFileExtensionQueryDSLRepository{
    long countByMemberId(Long memberId);

    boolean existsByExtensionNameAndMemberId(ExtensionName extensionName, Long memberId);
}
