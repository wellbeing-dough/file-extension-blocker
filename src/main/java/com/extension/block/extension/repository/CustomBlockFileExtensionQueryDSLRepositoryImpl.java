package com.extension.block.extension.repository;

import com.extension.block.extension.domain.enums.ExtensionStatus;
import com.extension.block.extension.repository.dto.CustomFileExtensionData;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.extension.block.extension.domain.entity.QCustomBlockFileExtension.customBlockFileExtension;
import static com.extension.block.extension.domain.entity.QFileExtension.fileExtension;

@Repository
@RequiredArgsConstructor
public class CustomBlockFileExtensionQueryDSLRepositoryImpl implements CustomBlockFileExtensionQueryDSLRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<CustomFileExtensionData> findCustomBlockExtension() {
        JPAQuery<CustomFileExtensionData> query = jpaQueryFactory
                .select(Projections.constructor(
                        CustomFileExtensionData.class,
                        customBlockFileExtension.id.as("customFileExtensionId"),
                        fileExtension.extensionName
                ))
                .from(customBlockFileExtension)
                .innerJoin(fileExtension).on(customBlockFileExtension.fileExtensionId.eq(fileExtension.id))
                .where(fileExtension.extensionStatus.notIn(ExtensionStatus.BLOCK_FIXED));
        return query.fetch();
    }
}
