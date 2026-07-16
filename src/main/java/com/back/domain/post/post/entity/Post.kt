package com.back.domain.post.post.entity

import com.back.domain.member.member.entity.Member
import com.back.global.jpa.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne

@Entity
class Post(// Post 가 많고(Many) Member 가 적다(One) // N:1 관계
    // 필드명 : AUTHOR_ID, 설명 : MEMBER 테이블의 ID값이 저장
    @field:ManyToOne private val author: Member?, private val title: String?, @field:Column(
        columnDefinition = "TEXT"
    ) private var content: String?
) : BaseEntity() 