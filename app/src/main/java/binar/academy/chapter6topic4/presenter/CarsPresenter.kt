package binar.academy.chapter6topic4.presenter

import binar.academy.chapter6topic4.model.getAllCarsItem
import binar.academy.chapter6topic4.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarsPresenter(val viewcars: CarsView) {

    fun getDataCars() {
        ApiClient.instance.getAllCar()
            .enqueue(object : Callback<List<getAllCarsItem>> {
                override fun onResponse(
                    call: Call<List<getAllCarsItem>>,
                    response: Response<List<getAllCarsItem>>,
                ) {
                    if (response.isSuccessful) {
                        viewcars.onSuccess(response.message(), response.body()!!)
                    } else {
                        viewcars.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<List<getAllCarsItem>>, t: Throwable) {
                    viewcars.onError(t.message!!)
                }

            })
    }
}