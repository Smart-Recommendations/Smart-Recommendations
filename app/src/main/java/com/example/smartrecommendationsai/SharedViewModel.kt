package com.example.smartrecommendationsai.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _showsChecked = MutableLiveData<Boolean>(true)
    val showsChecked: LiveData<Boolean> = _showsChecked

    private val _moviesChecked = MutableLiveData<Boolean>(true)
    val moviesChecked: LiveData<Boolean> = _moviesChecked

    private val _youtubeChannelsChecked = MutableLiveData<Boolean>(true)
    val youtubeChannelsChecked: LiveData<Boolean> = _youtubeChannelsChecked

    private val _videoGamesChecked = MutableLiveData<Boolean>(true)
    val videoGamesChecked: LiveData<Boolean> = _videoGamesChecked

    private val _booksChecked = MutableLiveData<Boolean>(true)
    val booksChecked: LiveData<Boolean> = _booksChecked

    private val _podcastsChecked = MutableLiveData<Boolean>(true)
    val podcastsChecked: LiveData<Boolean> = _podcastsChecked

    private val _paidChecked = MutableLiveData<Boolean>(true)
    val paidChecked: LiveData<Boolean> = _paidChecked

    private val _animatedChecked = MutableLiveData<Boolean>(true)
    val animatedChecked: LiveData<Boolean> = _animatedChecked

    private val _matureContentChecked = MutableLiveData<Boolean>(false)
    val matureContentChecked: LiveData<Boolean> = _matureContentChecked

    private val _likedMedia = MutableLiveData<String>("Default")
    val likedMedia: LiveData<String> = _likedMedia

    private val _dislikedMedia = MutableLiveData<String>("Default")
    val dislikedMedia: LiveData<String> = _dislikedMedia

    private val _aboutMe = MutableLiveData<String>("Default")
    val aboutMe: LiveData<String> = _aboutMe



    // Methods to update the boolean values
    fun setShowsChecked(isChecked: Boolean) {
        _showsChecked.value = isChecked
    }

    fun setMoviesChecked(isChecked: Boolean) {
        _moviesChecked.value = isChecked
    }

    fun setYoutubeChannelsChecked(isChecked: Boolean) {
        _youtubeChannelsChecked.value = isChecked
    }

    fun setVideoGamesChecked(isChecked: Boolean) {
        _videoGamesChecked.value = isChecked
    }

    fun setBooksChecked(isChecked: Boolean) {
        _booksChecked.value = isChecked
    }

    fun setPodcastsChecked(isChecked: Boolean) {
        _podcastsChecked.value = isChecked
    }

    fun setPaidChecked(isChecked: Boolean) {
        _paidChecked.value = isChecked
    }

    fun setAnimatedChecked(isChecked: Boolean) {
        _animatedChecked.value = isChecked
    }

    fun setMatureContentChecked(isChecked: Boolean) {
        _matureContentChecked.value = isChecked
    }

    fun updateLikedMedia(text: String) {
        _likedMedia.value = text
    }

    fun updateDislikedMedia(text: String) {
        _dislikedMedia.value = text
    }

    fun updateAboutMe(text: String) {
        _aboutMe.value = text
    }
    private val _apiKey = MutableLiveData<String>("default")
    val apiKey: LiveData<String> = _apiKey


    fun updateApiKey(key: String) {
        _apiKey.value = key
        // Note: To persist the API key, add code to save it to SharedPreferences here
    }
}