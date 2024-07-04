package com.extension.block.member.domain.implementations;

import com.extension.block.common.exception.ErrorCode;
import com.extension.block.member.domain.entity.Member;
import com.extension.block.member.exception.MemberNotFoundException;
import com.extension.block.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberReader {

    private final MemberRepository memberRepository;

    public Member readById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() ->
                        new MemberNotFoundException(
                                ErrorCode.MEMBER_NOT_FOUND_ERROR,
                                ErrorCode.MEMBER_NOT_FOUND_ERROR.getStatusMessage(),
                                " find id by : " + memberId
                        )
                );
    }
}
