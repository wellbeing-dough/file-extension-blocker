package com.extension.block.extension.repository;

import com.extension.block.extension.domain.entity.CustomFileExtension;
import com.extension.block.extension.repository.dto.MembersCustomFileExtensionData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomFileExtensionQueryDSLRepository {
    List<MembersCustomFileExtensionData> findCustomFileExtensionListByMemberId(Long memberId);
}
