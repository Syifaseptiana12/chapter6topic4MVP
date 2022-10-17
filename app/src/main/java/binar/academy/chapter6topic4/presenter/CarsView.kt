package binar.academy.chapter6topic4.presenter

import binar.academy.chapter6topic4.model.getAllCarsItem

interface CarsView {

    fun onSuccess(pesan: String, cars: List<getAllCarsItem>)
    fun onError(pesan: String)
}