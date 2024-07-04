package com.extension.block.extension.domain.entity;

import com.extension.block.extension.domain.enums.ExtensionSafetyStatus;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "extension")
@Where(clause = "deleted_at IS NULL")
public class Extension extends BaseEntity{

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
