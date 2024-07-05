package com.extension.block.extension.application;

import com.extension.block.extension.domain.component.ExtensionName;
import com.extension.block.extension.domain.entity.CustomFileExtension;
import com.extension.block.extension.domain.entity.SafeFileExtension;
import com.extension.block.extension.domain.implementations.*;
import com.extension.block.extension.ui.dto.response.CustomFileExtensionResponse;
import com.extension.block.extension.ui.dto.response.FixedFileExtensionResponse;
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
    private final CustomFileExtensionValidator customFileExtensionValidator;
    private final FileExtensionReader fileExtensionReader;

    public CustomFileExtensionResponse getCustomExtensions(Long memberId) {
        Member findMember = memberReader.readById(memberId);
        return new CustomFileExtensionResponse(customFileExtensionReader.readListByMemberId(findMember.getId()));
    }

    public void addCustomExtension(String extensionName, Long memberId) {
        Member findMember = memberReader.readById(memberId);
        dangerFileExtensionValidator.validIsDangerFileExtension(new ExtensionName(extensionName));
        customFileExtensionValidator.validIsCustomFileExtensionCountOver(findMember.getId());
        SafeFileExtension safeFileExtension = safeFileExtensionReader.readByExtensionName(new ExtensionName(extensionName));
        CustomFileExtension customFileExtension = new CustomFileExtension(findMember.getId(), safeFileExtension.getExtensionName(),
                safeFileExtension.getDescription());
        customFileExtensionWriter.write(customFileExtension);
    }

    public void deleteCustomExtension(Long customExtensionId, Long memberId) {
        CustomFileExtension customFileExtension = customFileExtensionReader.readById(customExtensionId);
        customFileExtensionValidator.validIsMembersCustomFileExtension(customFileExtension, memberId);
        customFileExtensionWriter.delete(customFileExtension);
    }

    public FixedFileExtensionResponse getFixedExtensions() {
        return new FixedFileExtensionResponse(fileExtensionReader.readListByFixedExtensions());
    }
}
