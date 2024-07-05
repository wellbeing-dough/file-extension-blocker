package com.extension.block.extension.domain.entity;

import com.extension.block.common.domain.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "custom_block_file_extension")
@Where(clause = "deleted_at IS NULL")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomBlockFileExtension extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long fileExtensionId;

    private LocalDateTime deletedAt;

    public CustomBlockFileExtension(Long fileExtensionId) {
        this.fileExtensionId = fileExtensionId;
    }

    public void delete() {
        this.deletedAt = LocalDateTime.now();
    }
}
