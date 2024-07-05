package com.extension.block.extension.repository;

import com.extension.block.extension.domain.component.ExtensionName;
import com.extension.block.extension.domain.entity.FileExtension;
import com.extension.block.extension.domain.enums.ExtensionSafetyStatus;
import com.extension.block.extension.repository.dto.FixedFileExtensionData;
import com.extension.block.extension.repository.dto.UnknownFileExtensionData;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.extension.block.extension.domain.entity.QFileExtension.fileExtension;

@Repository
@RequiredArgsConstructor
public class FileExtensionQueryDSLRepositoryImpl implements FileExtensionQueryDSLRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<FixedFileExtensionData> findAllFixedExtensions() {
        JPAQuery<FixedFileExtensionData> query = jpaQueryFactory
                .select(Projections.constructor(
                        FixedFileExtensionData.class,
                        fileExtension.id.as("fixedFileExtensionId"),
                        fileExtension.extensionName.value.as("extensionName")
                ))
                .from(fileExtension)
                .where(fileExtension.safetyStatus.eq(ExtensionSafetyStatus.FIXED));
        return query.fetch();
    }

    @Override
    public List<UnknownFileExtensionData> findAllUnknownExtensions() {
        JPAQuery<UnknownFileExtensionData> query = jpaQueryFactory
                .select(Projections.constructor(
                        UnknownFileExtensionData.class,
                        fileExtension.id.as("unknownFileExtensionId"),
                        fileExtension.extensionName.value.as("extensionName"),
                        fileExtension.description
                ))
                .from(fileExtension)
                .where(fileExtension.safetyStatus.eq(ExtensionSafetyStatus.UNKNOWN));
        return query.fetch();
    }

    @Override
    public Optional<FileExtension> findUnDangerByExtensionName(ExtensionName extensionName) {
        JPAQuery<FileExtension> query = jpaQueryFactory
                .select(fileExtension)
                .from(fileExtension)
                .where(
                        fileExtension.safetyStatus.notIn(ExtensionSafetyStatus.DANGER)
                                .and(fileExtension.extensionName.eq(extensionName))
                );
        return Optional.ofNullable(query.fetchOne());
    }
}
