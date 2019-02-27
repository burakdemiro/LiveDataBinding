package com.bydmr.livedatabinding

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val suankiMeyve: LiveData<Meyve>
    get() = FakeRepo.suankiRandomGelenMeyve

    fun randomMeyveUret() = FakeRepo.suankiMeyveyiDegistir()

    val editTextIcerik = MutableLiveData<String>()

    private val _gosterilenEditTextIcerik = MutableLiveData<String>()
    val gosterilenEditTextIcerik: LiveData<String>
    get() = _gosterilenEditTextIcerik

    fun editTextIceriginiGoster() {
        _gosterilenEditTextIcerik.value = editTextIcerik.value
    }

    fun editTextRasgeleMeyveUret() {
        editTextIcerik.value = FakeRepo.randomMeyveUret().isim
    }
}