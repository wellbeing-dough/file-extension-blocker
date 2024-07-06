package com.extension.block.extension.repository;

import com.extension.block.extension.domain.entity.CustomBlockFileExtension;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomBlockFileExtensionRepository extends JpaRepository<CustomBlockFileExtension, Long>, CustomBlockFileExtensionQueryDSLRepository {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT EXISTS (SELECT 1 FROM CustomBlockFileExtension f WHERE f.fileExtensionId = :fileExtensionId)")
    boolean existsByFileExtensionIdWithPessimisticLock(Long fileExtensionId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT f FROM CustomBlockFileExtension f WHERE f.id = :customBlockExtensionId")
    Optional<CustomBlockFileExtension> findByIdWithPessimisticLock(Long customBlockExtensionId);
}
