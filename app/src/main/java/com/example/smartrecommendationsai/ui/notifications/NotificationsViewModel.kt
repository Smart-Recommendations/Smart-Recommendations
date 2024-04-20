package com.example.smartrecommendationsai.ui.notifications

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
//Deprecated for shared view
class NotificationsViewModel(application: Application) : AndroidViewModel(application) {
    private val sharedPreferences = application.getSharedPreferences("NotificationPrefs", Context.MODE_PRIVATE)

    private val _showsChecked = MutableLiveData<Boolean>()
    val showsChecked: LiveData<Boolean> = _showsChecked

    private val _moviesChecked = MutableLiveData<Boolean>()
    val moviesChecked: LiveData<Boolean> = _moviesChecked

    private val _youtubeChannelsChecked = MutableLiveData<Boolean>()
    val youtubeChannelsChecked: LiveData<Boolean> = _youtubeChannelsChecked

    private val _videoGamesChecked = MutableLiveData<Boolean>()
    val videoGamesChecked: LiveData<Boolean> = _videoGamesChecked

    private val _booksChecked = MutableLiveData<Boolean>()
    val booksChecked: LiveData<Boolean> = _booksChecked

    private val _podcastsChecked = MutableLiveData<Boolean>()
    val podcastsChecked: LiveData<Boolean> = _podcastsChecked

    private val _paidChecked = MutableLiveData<Boolean>()
    val paidChecked: LiveData<Boolean> = _paidChecked

    private val _animatedChecked = MutableLiveData<Boolean>()
    val animatedChecked: LiveData<Boolean> = _animatedChecked

    private val _matureContentChecked = MutableLiveData<Boolean>()
    val matureContentChecked: LiveData<Boolean> = _matureContentChecked

    private val _apiKey = MutableLiveData<String>()
    val apiKey: LiveData<String> = _apiKey

    fun updateApiKey(key: String) {
        _apiKey.value = key
        sharedPreferences.edit().putString("api_key", key).apply()
    }

    init {
        _showsChecked.value = sharedPreferences.getBoolean("shows", true)
        _moviesChecked.value = sharedPreferences.getBoolean("movies", true)
        _youtubeChannelsChecked.value = sharedPreferences.getBoolean("youtube_channels", true)
        _videoGamesChecked.value = sharedPreferences.getBoolean("video_games", true)
        _booksChecked.value = sharedPreferences.getBoolean("books", true)
        _podcastsChecked.value = sharedPreferences.getBoolean("podcasts", true)
        _paidChecked.value = sharedPreferences.getBoolean("paid", true)
        _animatedChecked.value = sharedPreferences.getBoolean("animated", true)
        _matureContentChecked.value = sharedPreferences.getBoolean("mature_content", false)
    }

    fun setShowsChecked(isChecked: Boolean) {
        _showsChecked.value = isChecked
        sharedPreferences.edit().putBoolean("shows", isChecked).apply()
    }

    fun setMoviesChecked(isChecked: Boolean) {
        _moviesChecked.value = isChecked
        sharedPreferences.edit().putBoolean("movies", isChecked).apply()
    }

    fun setYoutubeChannelsChecked(isChecked: Boolean) {
        _youtubeChannelsChecked.value = isChecked
        sharedPreferences.edit().putBoolean("youtube_channels", isChecked).apply()
    }

    fun setVideoGamesChecked(isChecked: Boolean) {
        _videoGamesChecked.value = isChecked
        sharedPreferences.edit().putBoolean("video_games", isChecked).apply()
    }

    fun setBooksChecked(isChecked: Boolean) {
        _booksChecked.value = isChecked
        sharedPreferences.edit().putBoolean("books", isChecked).apply()
    }

    fun setPodcastsChecked(isChecked: Boolean) {
        _podcastsChecked.value = isChecked
        sharedPreferences.edit().putBoolean("podcasts", isChecked).apply()
    }

    fun setPaidChecked(isChecked: Boolean) {
        _paidChecked.value = isChecked
        sharedPreferences.edit().putBoolean("paid", isChecked).apply()
    }

    fun setAnimatedChecked(isChecked: Boolean) {
        _animatedChecked.value = isChecked
        sharedPreferences.edit().putBoolean("animated", isChecked).apply()
    }

    fun setMatureContentChecked(isChecked: Boolean) {
        _matureContentChecked.value = isChecked
        sharedPreferences.edit().putBoolean("mature_content", isChecked).apply()
    }
}
