package com.extension.block.extension.repository;

import com.extension.block.extension.repository.dto.MembersCustomFileExtensionData;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.extension.block.extension.domain.entity.QCustomFileExtension.customFileExtension;

@Repository
@RequiredArgsConstructor
public class CustomFileExtensionQueryDSLRepositoryImpl implements CustomFileExtensionQueryDSLRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<MembersCustomFileExtensionData> findCustomFileExtensionListByMemberId(Long memberId) {
        JPAQuery<MembersCustomFileExtensionData> query = jpaQueryFactory
                .select(Projections.constructor(
                        MembersCustomFileExtensionData.class,
                        customFileExtension.id.as("customFileExtensionId"),
                        customFileExtension.extensionName.as("extensionName")
                ))
                .from(customFileExtension)
                .where(customFileExtension.memberId.eq(memberId))
                .orderBy(customFileExtension.createdDate.desc());
        return query.fetch();
    }
}
