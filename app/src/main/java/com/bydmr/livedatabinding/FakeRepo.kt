package com.bydmr.livedatabinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*
import kotlin.collections.ArrayList

object FakeRepo {

    // Database
    private val meyveler = arrayListOf<Meyve>(Meyve("Erik", "Yeşil"),
            Meyve("Karpuz", "Kırmızı"), Meyve("Kiraz", "Bordo"))

    // Değiştirilebilir dosya olduğundan dışardan erişimi kapat
    private val _suankiRandomGelenMeyve = MutableLiveData<Meyve>()

    // Dışarıdan isteyen buna erişsin zaten set metotu yok
    val suankiRandomGelenMeyve: LiveData<Meyve>
    get() = _suankiRandomGelenMeyve

    init {
        _suankiRandomGelenMeyve.value = meyveler.first()
    }

    fun randomMeyveUret(): Meyve {
        val random = Random()
        return meyveler[random.nextInt(meyveler.size)]
    }

    fun suankiMeyveyiDegistir() {
        _suankiRandomGelenMeyve.value = randomMeyveUret()
    }
}