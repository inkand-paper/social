package com.example.socialmedia

data class PostModelClass(
    val userNameInPost: String?,
    val userDetailInPost: String?,
    val userPostText: String?,
    val userPostImage: Int?,
    val userNameInComment: String?,
    val userDetailInComment: String?,
    val userCommentText: String?,
    val timeStamp: Long = System.currentTimeMillis()
)
