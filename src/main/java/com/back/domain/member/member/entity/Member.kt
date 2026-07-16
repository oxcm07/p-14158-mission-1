package com.back.domain.member.member.entity

import com.back.global.jpa.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class Member(
    @Column(unique = true, nullable = false)
    val username: String,

    @Column(nullable = false)
    var password: String,

    @Column(nullable = false)
    var nickname: String
) : BaseEntity() {

    fun updateNickname(newNickname: String) {
        require(newNickname.isNotBlank()) { "닉네임은 빈 값일 수 없습니다." }
        this.nickname = newNickname
    }

    fun changePassword(newPassword: String) {
        this.password = newPassword
    }
}