package com.back.domain.post.post.entity

import com.back.domain.member.member.entity.Member
import com.back.global.jpa.entity.BaseEntity
import jakarta.persistence.*

@Entity
class Post(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    val author: Member,

    @Column(nullable = false)
    var title: String,

    @Column(columnDefinition = "TEXT", nullable = false)
    var content: String
) : BaseEntity() {

    fun update(newTitle: String, newContent: String) {
        require(newTitle.isNotBlank()) { "제목은 비어있을 수 없습니다." }
        require(newContent.isNotBlank()) { "본문은 비어있을 수 없습니다." }

        this.title = newTitle
        this.content = newContent
    }
}