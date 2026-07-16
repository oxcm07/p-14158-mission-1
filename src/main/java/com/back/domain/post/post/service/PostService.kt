package com.back.domain.post.post.service

import com.back.domain.member.member.entity.Member
import com.back.domain.post.post.entity.Post
import com.back.domain.post.post.repository.PostRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PostService {
    private val postRepository: PostRepository? = null

    fun count(): Long {
        return postRepository!!.count()
    }

    fun findById(id: Int): Optional<Post?> {
        return postRepository!!.findById(id)
    }

    fun modify(post: Post, title: String?, content: String?) {
        post.setTitle(title)
        post.setContent(content)
    }

    fun write(author: Member?, title: String?, content: String?): Post {
        val post = Post(author, title, content)
        postRepository!!.save<Post?>(post)

        return post
    }
}