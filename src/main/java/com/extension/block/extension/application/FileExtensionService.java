package com.extension.block.extension.application;

import com.extension.block.extension.domain.entity.CustomFileExtension;
import com.extension.block.extension.domain.entity.SafeFileExtension;
import com.extension.block.extension.domain.implementations.CustomFileExtensionReader;
import com.extension.block.extension.domain.implementations.CustomFileExtensionWriter;
import com.extension.block.extension.domain.implementations.DangerFileExtensionValidator;
import com.extension.block.extension.domain.implementations.SafeFileExtensionReader;
import com.extension.block.extension.ui.dto.response.CustomFileExtensionResponse;
import com.extension.block.member.domain.entity.Member;
import com.extension.block.member.domain.implementations.MemberReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileExtensionService {

    private final CustomFileExtensionReader customFileExtensionReader;
    private final CustomFileExtensionWriter customFileExtensionWriter;
    private final MemberReader memberReader;
    private final SafeFileExtensionReader safeFileExtensionReader;
    private final DangerFileExtensionValidator dangerFileExtensionValidator;

    public CustomFileExtensionResponse getCustomExtensions(Long memberId) {
        Member findMember = memberReader.readById(memberId);
        return new CustomFileExtensionResponse(customFileExtensionReader.readListByMemberId(findMember.getId()));
    }

    public CustomFileExtensionResponse addCustomExtension(String extensionName, Long memberId) {
        Member findMember = memberReader.readById(memberId);
        dangerFileExtensionValidator.validIsDangerFileExtension(extensionName);
        SafeFileExtension safeFileExtension = safeFileExtensionReader.readByExtensionName(extensionName);
        CustomFileExtension customFileExtension = new CustomFileExtension(memberId, safeFileExtension.getExtensionName(),
                safeFileExtension.getDescription());
        customFileExtensionWriter.write(customFileExtension);
    }
}
