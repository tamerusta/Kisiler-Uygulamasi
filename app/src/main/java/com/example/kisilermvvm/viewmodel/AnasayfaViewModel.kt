package com.example.kisilermvvm.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kisilermvvm.data.entity.Kisiler
import com.example.kisilermvvm.data.repo.KisilerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor (var krepo : KisilerDaoRepository) : ViewModel() {
    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    init {
        kisileriYukle()
        kisilerListesi = krepo.kisileriGetir()
    }

    fun ara(aramaKelimesi:String){
        krepo.kisiAra(aramaKelimesi)
    }

    fun sil(kisi_id:Int){
        krepo.kisiSil(kisi_id)
    }

    fun kisileriYukle(){
        krepo.tumKisileriAl()
    }
}
