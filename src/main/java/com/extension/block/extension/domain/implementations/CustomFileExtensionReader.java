package com.extension.block.extension.domain.implementations;

import com.extension.block.extension.domain.entity.CustomFileExtension;
import com.extension.block.extension.repository.CustomFileExtensionRepository;
import com.extension.block.extension.repository.dto.MembersCustomFileExtensionData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomFileExtensionReader {

    private final CustomFileExtensionRepository customFileExtensionRepository;

    public List<MembersCustomFileExtensionData> readListByMemberId(Long memberId) {
        return customFileExtensionRepository.findCustomFileExtensionListByMemberId(memberId);
    }
}
