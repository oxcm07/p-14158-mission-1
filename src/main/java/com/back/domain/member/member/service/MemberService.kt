package com.back.domain.member.member.service

import com.back.domain.member.member.entity.Member
import com.back.domain.member.member.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {
    fun count(): Long = memberRepository.count()

    @Transactional
    fun join(username: String, password: String, nickname: String): Member {
        val newMember = Member(
            username = username,
            password = password,
            nickname = nickname
        )
        return memberRepository.save(newMember)
    }
}