package com.example.socialmedia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.socialmedia.databinding.ItemListFeedBinding

class PostAdapter(private val postList: List<PostModelClass>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    class PostViewHolder(val binding: ItemListFeedBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding =
            ItemListFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val singleData = postList[position]
        holder.binding.apply {
            NameInPost.text = singleData.userNameInPost
            DetailsInPost.text = singleData.userDetailInPost
            TimeInPost.text = singleData.timeStamp.toString()

            Comment.text = singleData.userCommentText

            if (singleData.userPostText!= null){
                Post.text = singleData.userPostText
            }
            else{
                Post.visibility = View.GONE
            }

            if (singleData.userCommentText != null) {
                Comment.text = singleData.userCommentText
            } else {
                CommentCardView.visibility = View.GONE
            }

            if (singleData.userNameInComment != null) {
                NameInComment.text = singleData.userNameInComment
            }
            if (singleData.userDetailInComment != null){
                DetailsInComment.text = singleData.userDetailInComment
            }
            if (singleData.userPostImage != null) {
                postImage.setImageResource(singleData.userPostImage)
                postImage.visibility = View.VISIBLE
            } else {
                postImage.visibility = View.GONE
            }
        }
    }
}