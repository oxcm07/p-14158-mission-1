package com.back.domain.post.post.service

import com.back.domain.member.member.entity.Member
import com.back.domain.post.post.entity.Post
import com.back.domain.post.post.repository.PostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class PostService(
    private val postRepository: PostRepository
) {
    fun count(): Long = postRepository.count()

    fun findById(id: Int): Post? {
        return postRepository.findByIdOrNull(id)
    }

    @Transactional
    fun modify(post: Post, title: String, content: String) {
        post.update(title, content)
    }

    @Transactional
    fun write(author: Member, title: String, content: String): Post {
        val post = Post(
            author = author,
            title = title,
            content = content
        )
        return postRepository.save(post)
    }
}