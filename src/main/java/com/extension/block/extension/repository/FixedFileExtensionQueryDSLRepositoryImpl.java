package com.extension.block.extension.repository;

import com.extension.block.extension.domain.enums.ExtensionSafetyStatus;
import com.extension.block.extension.repository.dto.FixedFileExtensionData;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.extension.block.extension.domain.entity.QFixedFileExtension.fixedFileExtension;

@Repository
@RequiredArgsConstructor
public class FixedFileExtensionQueryDSLRepositoryImpl implements FixedFileExtensionQueryDSLRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<FixedFileExtensionData> findAllFixedExtensions() {
        JPAQuery<FixedFileExtensionData> query = jpaQueryFactory
                .select(Projections.constructor(
                        FixedFileExtensionData.class,
                        fixedFileExtension.id.as("fixedFileExtensionId"),
                        fixedFileExtension.extensionName
                ))
                .from(fixedFileExtension)
                .where(fixedFileExtension.safetyStatus.eq(ExtensionSafetyStatus.FIXED));
        return query.fetch();
    }
}
