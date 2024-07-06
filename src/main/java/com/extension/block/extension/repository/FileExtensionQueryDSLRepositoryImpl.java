package com.extension.block.extension.repository;

import com.extension.block.extension.domain.enums.ExtensionStatus;
import com.extension.block.extension.repository.dto.BlockFixedFileExtensionData;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.extension.block.extension.domain.entity.QFileExtension.fileExtension;

@Repository
@RequiredArgsConstructor
public class FileExtensionQueryDSLRepositoryImpl implements FileExtensionQueryDSLRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<BlockFixedFileExtensionData> findAllFixedExtensions() {
        JPAQuery<BlockFixedFileExtensionData> query = jpaQueryFactory
                .select(Projections.constructor(
                        BlockFixedFileExtensionData.class,
                        fileExtension.id.as("blockFixedFileExtensionId"),
                        fileExtension.extensionName
                ))
                .from(fileExtension)
                .where(fileExtension.extensionStatus.eq(ExtensionStatus.BLOCK_FIXED));
        return query.fetch();
    }

}
