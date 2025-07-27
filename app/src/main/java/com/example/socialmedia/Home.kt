package com.example.socialmedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.socialmedia.databinding.FragmentHomeBinding

class Home : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = listOf(
            PostModelClass(
                "Tahsin Abir",
                "Developer",
                "Hello everyone",
                null,
                null,
                null,
                null,
                System.currentTimeMillis()
            ),
            PostModelClass(
                "Tahsin Abir",
                "Developer",
                null,
                R.drawable.profile_image,
                null,
                null,
                null,
                System.currentTimeMillis()
            ),
            PostModelClass(
                "Tahsin Abir",
                "Developer",
                "Hello everyone",
                null,
                null,
                null,
                null,
                System.currentTimeMillis()
            ),
            PostModelClass(
                "Tahsin Abir",
                "Developer",
                null,
                R.drawable.profile_image,
                null,
                null,
                null,
                System.currentTimeMillis()
            ),

            )

        val adapter = PostAdapter(list)

        binding.PostRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.PostRecyclerView.adapter = adapter
    }


}