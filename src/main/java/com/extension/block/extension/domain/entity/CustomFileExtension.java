package com.extension.block.extension.domain.entity;

import com.extension.block.common.domain.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "custom_file_extension")
@Where(clause = "deleted_at IS NULL")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomFileExtension extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;

    private String extensionName;

    private String description;

    private LocalDateTime deletedAt;

    @Builder
    public CustomFileExtension(Long memberId, String extensionName, String description) {
        this.memberId = memberId;
        this.extensionName = extensionName;
        this.description = description;
    }

    public boolean isMembersExtension(Long memberId) {
        return this.memberId.equals(memberId);
    }

    public void delete() {
        this.deletedAt = LocalDateTime.now();
    }
}