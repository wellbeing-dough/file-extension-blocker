package com.extension.block.extension.domain.entity;

import com.extension.block.extension.domain.enums.ExtensionSafetyStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "extension")
@Where(clause = "deleted_at IS NULL")
public class FileExtension extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String extensionName;

    private String description;

    @Enumerated(EnumType.STRING)
    private ExtensionSafetyStatus safetyStatus;

    private Long addCount;

    private LocalDateTime deletedAt;

    @Builder
    public FileExtension(String extensionName, String description) {
        this.extensionName = extensionName;
        this.description = description;
        this.safetyStatus = ExtensionSafetyStatus.UNKNOWN;
        this.addCount = 0L;
    }
}
