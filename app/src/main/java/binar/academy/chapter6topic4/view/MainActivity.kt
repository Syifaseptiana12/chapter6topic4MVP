package binar.academy.chapter6topic4.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import binar.academy.chapter6topic4.R
import binar.academy.chapter6topic4.model.getAllCarsItem
import binar.academy.chapter6topic4.presenter.CarsPresenter
import binar.academy.chapter6topic4.presenter.CarsView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CarsView {

    private lateinit var presentercars: CarsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presentercars = CarsPresenter(this)
        presentercars.getDataCars()
    }

    override fun onSuccess(pesan: String, cars: List<getAllCarsItem>) {
        rvCar.layoutManager = LinearLayoutManager(this)
        rvCar.adapter = AdapterCars(cars)
    }

    override fun onError(pesan: String) {
        Toast.makeText(this, pesan, Toast.LENGTH_LONG).show()
    }
}