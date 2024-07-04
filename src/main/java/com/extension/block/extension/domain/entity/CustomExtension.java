package com.extension.block.extension.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "custom_extension")
@Where(clause = "deleted_at IS NULL")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomExtension extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String extensionName;

    private String description;

    private LocalDateTime deletedAt;

    @Builder
    public CustomExtension(String extensionName, String description) {
        this.extensionName = extensionName;
        this.description = description;
    }
}
