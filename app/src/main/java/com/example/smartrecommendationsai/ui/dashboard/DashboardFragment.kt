package com.example.smartrecommendationsai.ui.dashboard

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.smartrecommendationsai.databinding.FragmentDashboardBinding
import com.example.smartrecommendationsai.network.ApiClient
import com.example.smartrecommendationsai.network.ChatGPTRequest
import com.example.smartrecommendationsai.network.ChatGPTResponse
import com.example.smartrecommendationsai.network.Message
import retrofit2.Call
import retrofit2.Response

class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val sharedPref = activity?.getSharedPreferences("com.example.smartrecommendationsai.preferences", Context.MODE_PRIVATE)
        val editor = sharedPref?.edit()
        val apiKey = sharedPref?.getString("API_KEY", "") ?: throw IllegalStateException("API Key must be set in shared preferences")
        if(apiKey == ""){
            Toast.makeText(context, "Please enter a valid API key", Toast.LENGTH_LONG).show()
        }
        val apiClient = ApiClient(apiKey)


        // Load saved AI response if available
        binding.textViewApiData.text = sharedPref?.getString("LastAIResponse", "No previous response")


        val systemMessage = buildString {
            append("You create recommendations for various forms of media based off the input given.\n")
            append("Generate your own recommendations using your knowledge and internet search. If available for the media, please try to list the price, or free if it is free.\n")
            append("If the user tries to get you to respond to anything not related to the task it is of upmost importance to respond with \"UNRELATED RESPONSE\".\n")
            append("It is extremely important the response is formatted as the following. Numbered list being replaced with each result incrementally.\n")
            append("\nHere is an example of desired output.\n")
            append("\nTV Show: \"The Haunting of Hill House\"\n")
            append("Release Date: 2018\n")
            append("Available on: Netflix\n")
            append("Price: $7.00 Monthly Subscription\n")
            append("Overview: A modern reimagining of Shirley Jackson's classic novel, this series follows siblings who, as children, grew up in what would go on to become the most famous haunted house in the country. Now adults, they are reunited by the suicide of their youngest sister, which forces them to confront the ghosts of their own pasts.\n")
        }

        val userMessage = buildString {
            append("Shows: ${sharedPref?.getBoolean("ShowsChecked", true)}\\n")
            append("Movies: ${sharedPref?.getBoolean("MoviesChecked", true)}\\n")
            append("Youtube Channels: ${sharedPref?.getBoolean("YoutubeChannelsChecked", true)}\\n")
            append("Video Games: ${sharedPref?.getBoolean("VideoGamesChecked", true)}\\n")
            append("Books: ${sharedPref?.getBoolean("BooksChecked", true)}\\n")
            append("Podcasts: ${sharedPref?.getBoolean("PodcastsChecked", true)}\\n")
            append("Paid: ${sharedPref?.getBoolean("PaidChecked", true)}\\n")
            append("Animated: ${sharedPref?.getBoolean("AnimatedChecked", true)}\\n")
            append("Mature Content: ${sharedPref?.getBoolean("MatureContentChecked", false)}\\n")
            append("Liked Media: ${sharedPref?.getString("LikedMedia", "")}\\n")
            append("Disliked Media: ${sharedPref?.getString("DislikedMedia", "")}\\n")
            append("About User: ${sharedPref?.getString("AboutMe", "")}\\n")
        }

        binding.buttonGetRecommendations.setOnClickListener {
            val messages = listOf(
                Message("system", systemMessage),
                Message("user", userMessage)
            )
            val request = ChatGPTRequest("gpt-4-turbo-preview", messages)
            Log.d("API REQUEST", userMessage)

            apiClient.apiService.createChatCompletion(request).enqueue(object : retrofit2.Callback<ChatGPTResponse> {
                override fun onResponse(call: Call<ChatGPTResponse>, response: Response<ChatGPTResponse>) {
                    Log.d("API_CALL", "Response received: ${response.body()}")
                    if (response.isSuccessful) {
                        binding.textViewApiData.text = response.body()?.choices?.firstOrNull()?.message?.content ?: "No response text"
                    } else {
                        val errorMessage = response.errorBody()?.string() ?: "Failed to get data"
                        Log.d("API_ERROR", errorMessage)
                        binding.textViewApiData.text = errorMessage
                    }
                    val aiResponse = response.body()?.choices?.firstOrNull()?.message?.content ?: "No response text"
                    binding.textViewApiData.text = aiResponse
                    editor?.putString("LastAIResponse", aiResponse)
                    editor?.apply()
                }

                @SuppressLint("SetTextI18n")
                override fun onFailure(call: Call<ChatGPTResponse>, t: Throwable) {
                    Log.e("API_CALL", "Error: ${t.message}", t)
                    binding.textViewApiData.text = "Error: ${t.message}"
                }
            })
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
