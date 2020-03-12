package com.service.buscostcounter.viewmodel

import com.service.buscostcounter.model.bus.BusTypes
import com.service.buscostcounter.model.bus.Electrical
import com.service.buscostcounter.model.result.Cleanest
import com.service.buscostcounter.model.result.Fastest
import com.service.buscostcounter.model.result.Favorable
import com.service.buscostcounter.viewmodel.base.BaseViewModel

class MainViewModel : BaseViewModel(){

    var fastest : Fastest = Fastest()

    var favorable : Favorable = Favorable()

    var cleanest : Cleanest = Cleanest()

    val fuelCostArr = arrayListOf<Float>()

    fun getTheFavourableWay() : Float? {
        return fuelCostArr.min()
    }

    fun getTheTypeOfFavourable() : BusTypes {
        val index = fuelCostArr.indexOf(getTheFavourableWay())
        return when (index) {
            0 -> {
                BusTypes.ELECTRICAL
            }
            1 -> {
                BusTypes.PETROL
            }
            else -> {
                BusTypes.LIQUID_GAS
            }
        }
    }
}