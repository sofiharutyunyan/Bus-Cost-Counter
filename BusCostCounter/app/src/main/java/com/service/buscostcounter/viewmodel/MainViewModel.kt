package com.service.buscostcounter.viewmodel

import com.service.buscostcounter.model.bus.BusTypes
import com.service.buscostcounter.model.bus.Electrical
import com.service.buscostcounter.model.bus.LiquidGas
import com.service.buscostcounter.model.bus.Petrol
import com.service.buscostcounter.model.result.Cleanest
import com.service.buscostcounter.model.result.Fastest
import com.service.buscostcounter.model.result.Favorable
import com.service.buscostcounter.viewmodel.base.BaseViewModel
import java.util.*

class MainViewModel : BaseViewModel() {

    var fastest: Fastest = Fastest()
    var favorable: Favorable = Favorable()
    var cleanest: Cleanest = Cleanest()

    var electricalBus = Electrical()
    var petrolBus = Petrol()
    var liquidGasBus = LiquidGas()

    val fuelCostArr = arrayListOf<Int>()
    val airPollutionVolumeArr = arrayListOf<Int>()
    val spentTimeArr = arrayListOf<Int>()

    fun collectArrayForChargeTime() {
        spentTimeArr.add(electricalBus.getChargeTotalTime())
        spentTimeArr.add(petrolBus.getChargeTotalTime())
        spentTimeArr.add(liquidGasBus.getChargeTotalTime())
    }

    fun collectArrayForFuelCost() {
        fuelCostArr.add(electricalBus.getTotalFuelCost().toInt())
        fuelCostArr.add(petrolBus.getTotalFuelCost().toInt())
        fuelCostArr.add(liquidGasBus.getTotalFuelCost().toInt())
    }

    fun collectArrayAirPollution() {
        airPollutionVolumeArr.add(electricalBus.getTotalAirPollutionVolume())
        airPollutionVolumeArr.add(petrolBus.getTotalAirPollutionVolume())
        airPollutionVolumeArr.add(liquidGasBus.getTotalAirPollutionVolume())
    }

    fun getTheTypeOfTargetWay(costArr: ArrayList<Int>): BusTypes {
        val index = costArr.indexOf(costArr.min())
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