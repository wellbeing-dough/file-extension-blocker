package com.extension.block.extension.domain.entity;

import com.extension.block.common.domain.entity.BaseEntity;
import com.extension.block.extension.domain.component.ExtensionName;
import com.extension.block.extension.domain.enums.ExtensionStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "file_extension")
@Where(clause = "deleted_at IS NULL")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FileExtension extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "extension_name"))
    private ExtensionName extensionName;

    private String description;

    @Enumerated(EnumType.STRING)
    private ExtensionStatus extensionStatus;

    private Long blockedCount;

    private LocalDateTime deletedAt;

    @Builder
    public FileExtension(ExtensionName extensionName, String description) {
        this.extensionName = extensionName;
        this.description = description;
        this.extensionStatus = ExtensionStatus.SAFE;
        this.blockedCount = 0L;
    }

    public void updateSafetyStatus(ExtensionStatus status) {
        this.extensionStatus = status;
    }
}
