
package com.example.smartrecommendationsai.ui.notifications

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.smartrecommendationsai.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val sharedPref = activity?.getSharedPreferences("com.example.smartrecommendationsai.preferences", Context.MODE_PRIVATE)

        // Loading checkbox states from SharedPreferences with default values
        binding.checkboxShows.isChecked = sharedPref?.getBoolean("ShowsChecked", true) ?: true
        binding.checkboxMovies.isChecked = sharedPref?.getBoolean("MoviesChecked", true) ?: true
        binding.checkboxYoutubeChannels.isChecked = sharedPref?.getBoolean("YoutubeChannelsChecked", true) ?: true
        binding.checkboxVideoGames.isChecked = sharedPref?.getBoolean("VideoGamesChecked", true) ?: true
        binding.checkboxBooks.isChecked = sharedPref?.getBoolean("BooksChecked", true) ?: true
        binding.checkboxPodcasts.isChecked = sharedPref?.getBoolean("PodcastsChecked", true) ?: true
        binding.checkboxPaid.isChecked = sharedPref?.getBoolean("PaidChecked", true) ?: true
        binding.checkboxAnimated.isChecked = sharedPref?.getBoolean("AnimatedChecked", true) ?: true
        binding.checkboxMatureContent.isChecked = sharedPref?.getBoolean("MatureContentChecked", false) ?: false

        binding.edittextGptApiToken.setText(sharedPref?.getString("API_KEY", ""))

        val editor = sharedPref?.edit()

        binding.edittextGptApiToken.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    editor?.putString("API_KEY", it.toString())
                    editor?.apply()
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        binding.checkboxShows.setOnCheckedChangeListener { _, isChecked ->
            editor?.putBoolean("ShowsChecked", isChecked)
            editor?.apply()
        }
        binding.checkboxMovies.setOnCheckedChangeListener { _, isChecked ->
            editor?.putBoolean("MoviesChecked", isChecked)
            editor?.apply()
        }
        binding.checkboxYoutubeChannels.setOnCheckedChangeListener { _, isChecked ->
            editor?.putBoolean("YoutubeChannelsChecked", isChecked)
            editor?.apply()
        }
        binding.checkboxVideoGames.setOnCheckedChangeListener { _, isChecked ->
            editor?.putBoolean("VideoGamesChecked", isChecked)
            editor?.apply()
        }
        binding.checkboxBooks.setOnCheckedChangeListener { _, isChecked ->
            editor?.putBoolean("BooksChecked", isChecked)
            editor?.apply()
        }
        binding.checkboxPodcasts.setOnCheckedChangeListener { _, isChecked ->
            editor?.putBoolean("PodcastsChecked", isChecked)
            editor?.apply()
        }
        binding.checkboxPaid.setOnCheckedChangeListener { _, isChecked ->
            editor?.putBoolean("PaidChecked", isChecked)
            editor?.apply()
        }
        binding.checkboxAnimated.setOnCheckedChangeListener { _, isChecked ->
            editor?.putBoolean("AnimatedChecked", isChecked)
            editor?.apply()
        }
        binding.checkboxMatureContent.setOnCheckedChangeListener { _, isChecked ->
            editor?.putBoolean("MatureContentChecked", isChecked)
            editor?.apply()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
