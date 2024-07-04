package com.extension.block.extension.domain.entity;

import com.extension.block.common.domain.entity.BaseEntity;
import com.extension.block.extension.domain.enums.ExtensionSafetyStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "file_extension")
@Where(clause = "deleted_at IS NULL AND safety_status = 'DANGER'")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DangerFileExtension extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String extensionName;

    private String description;

    @Enumerated(EnumType.STRING)
    private ExtensionSafetyStatus safetyStatus;

    private String dangerReason;

    private Long addCount;

    private LocalDateTime deletedAt;

}
