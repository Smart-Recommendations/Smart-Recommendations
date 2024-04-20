
package com.example.smartrecommendationsai.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
//Deprecated for shared view
class HomeViewModel : ViewModel() {

    private val _likedMedia = MutableLiveData<String>()
    val likedMedia: LiveData<String> = _likedMedia

    private val _dislikedMedia = MutableLiveData<String>()
    val dislikedMedia: LiveData<String> = _dislikedMedia

    private val _aboutMe = MutableLiveData<String>()
    val aboutMe: LiveData<String> = _aboutMe

    fun updateLikedMedia(text: String) {
        _likedMedia.value = text
    }

    fun updateDislikedMedia(text: String) {
        _dislikedMedia.value = text
    }

    fun updateAboutMe(text: String) {
        _aboutMe.value = text
    }
}
