package com.extension.block.extension.repository;

import com.extension.block.extension.domain.enums.ExtensionStatus;
import com.extension.block.extension.repository.dto.BlockedFileExtensionData;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.extension.block.extension.domain.entity.QFileExtension.fileExtension;

@Repository
@RequiredArgsConstructor
public class BlockedFileExtensionQueryDSLRepositoryImpl implements BlockedFileExtensionQueryDSLRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<BlockedFileExtensionData> findAllBlockedFileExtension() {
        JPAQuery<BlockedFileExtensionData> query = jpaQueryFactory
                .select(Projections.constructor(
                        BlockedFileExtensionData.class,
                        fileExtension.id.as("blockedFileExtensionId"),
                        fileExtension.extensionName
                ))
                .from(fileExtension)
                .where(fileExtension.extensionStatus.eq(ExtensionStatus.BLOCKED));
        return query.fetch();
    }
}
